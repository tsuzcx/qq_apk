package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.g.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.ui.LoginIndepPass;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.tools.a.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.widget.a.d;

public final class al
  implements com.tencent.mm.pluginsdk.m
{
  public final void Xc()
  {
    AppMethodBeat.i(19651);
    MMAppMgr.Xc();
    AppMethodBeat.o(19651);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(19623);
    if (paramActivity != null)
    {
      int i = paramIntent.getIntExtra("CropImageMode", 0);
      if ((i != 4) && (i != 2)) {
        break label52;
      }
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(19623);
      return;
      label52:
      paramIntent.setClass(paramActivity, ImageCropUI.class);
    }
  }
  
  public final void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt, a.a parama)
  {
    AppMethodBeat.i(19624);
    if (paramActivity != null)
    {
      int i = paramIntent2.getIntExtra("CropImageMode", 0);
      if ((i != 4) && (i != 2)) {
        break label58;
      }
      paramIntent2.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.a.b(paramActivity, paramIntent1, paramIntent2, paramString, paramInt, parama);
      AppMethodBeat.o(19624);
      return;
      label58:
      paramIntent2.setClass(paramActivity, ImageCropUI.class);
    }
  }
  
  public final void a(final Activity paramActivity, final String paramString1, final WXMediaMessage paramWXMediaMessage, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(231412);
    String str = paramActivity.getResources().getString(2131755905);
    Object localObject = paramWXMediaMessage.title;
    str = str + (String)localObject;
    localObject = new o.a(paramActivity);
    ((o.a)localObject).ea(paramString2).beQ(str).aii(2131757789);
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(19604);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(19604);
          return;
        }
        com.tencent.mm.pluginsdk.model.app.m.a(paramWXMediaMessage, paramString1, paramString3, paramString2, 3, null);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          tw localtw = new tw();
          localtw.eaq.dkV = paramString2;
          localtw.eaq.content = paramAnonymousString;
          localtw.eaq.type = ab.JG(paramString2);
          localtw.eaq.flags = 0;
          EventCenter.instance.publish(localtw);
        }
        com.tencent.mm.ui.base.h.cD(paramActivity, paramActivity.getResources().getString(2131755986));
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10910, "2");
        AppMethodBeat.o(19604);
      }
    }.show();
    AppMethodBeat.o(231412);
  }
  
  public final void a(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(19646);
    int i = paramIntent1.getIntExtra("from_source", 1);
    if (i == 1)
    {
      paramIntent1.setClass(paramContext, LoginUI.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent1.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 2)
    {
      paramIntent1.setClass(paramContext, LoginPasswordUI.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent1.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 3)
    {
      paramIntent1.setClass(paramContext, SimpleLoginUI.class);
      if (paramIntent2 != null)
      {
        MMWizardActivity.b(paramContext, paramIntent1, paramIntent2);
        AppMethodBeat.o(19646);
        return;
      }
      MMWizardActivity.ay(paramContext, paramIntent1);
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 5)
    {
      paramIntent1.setClass(paramContext, LoginIndepPass.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent1.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 6)
    {
      paramIntent1.setClass(paramContext, MobileInputUI.class);
      paramIntent1.putExtra("mobile_input_purpose", 1);
      paramIntent1.putExtra("mobile_auth_type", 7);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent1.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19646);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(19654);
    o.a locala = new o.a(paramContext);
    locala.ea(paramString1).beS(paramString2).p(Boolean.FALSE).aii(2131755976);
    if (paramBoolean) {
      locala.beP(paramContext.getResources().getString(2131766034));
    }
    for (;;)
    {
      locala.a(parama).kdo.show();
      AppMethodBeat.o(19654);
      return;
      locala.beP(paramContext.getResources().getString(2131766035));
    }
  }
  
  public final void a(Intent paramIntent, int paramInt, MMActivity.a parama, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(19650);
    if (paramMMActivity != null)
    {
      paramIntent.setClassName(paramMMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
      paramMMActivity.mmStartActivityForResult(parama, paramIntent, paramInt);
    }
    AppMethodBeat.o(19650);
  }
  
  public final void a(Intent paramIntent, int paramInt, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(231413);
    paramIntent.setClass(paramMMActivity, SelectConversationUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(231413);
  }
  
  public final void a(Intent paramIntent1, int paramInt, MMActivity paramMMActivity, Intent paramIntent2)
  {
    AppMethodBeat.i(19621);
    if (paramIntent1.getIntExtra("CropImageMode", 0) == 4) {
      paramIntent1.setClassName(paramMMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      bg.aVF();
      com.tencent.mm.ui.tools.a.a(paramMMActivity, paramIntent2, paramIntent1, com.tencent.mm.model.c.aSY(), paramInt);
      AppMethodBeat.o(19621);
      return;
      paramIntent1.setClass(paramMMActivity, ImageCropUI.class);
    }
  }
  
  public final void a(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(19627);
    paramIntent.setClass(paramActivity, ModRemarkNameUI.class);
    paramActivity.startActivityForResult(paramIntent, 2);
    AppMethodBeat.o(19627);
  }
  
  public final void a(Intent paramIntent, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(19638);
    if (paramActivity != null)
    {
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.contact.SnsAddressUI");
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
    AppMethodBeat.o(19638);
  }
  
  public final void a(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19605);
    if (paramContext == null)
    {
      AppMethodBeat.o(19605);
      return;
    }
    paramIntent.setClassName(paramContext, "com.tencent.mm.ui.contact.SayHiEditUI");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19605);
  }
  
  public final void a(Intent paramIntent, MMActivity.a parama, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(19633);
    if (paramMMActivity != null)
    {
      paramIntent.setClass(paramMMActivity, SelectConversationUI.class);
      paramMMActivity.mmStartActivityForResult(parama, paramIntent, 0);
    }
    AppMethodBeat.o(19633);
  }
  
  public final void a(MMWizardActivity paramMMWizardActivity, Intent paramIntent)
  {
    AppMethodBeat.i(19644);
    if (paramMMWizardActivity == null)
    {
      AppMethodBeat.o(19644);
      return;
    }
    paramIntent.setClass(paramMMWizardActivity, MobileInputUI.class);
    MMWizardActivity.ay(paramMMWizardActivity, paramIntent);
    AppMethodBeat.o(19644);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19640);
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (!com.tencent.mm.pluginsdk.k.b.a.a.b(paramString, paramContext, paramBoolean2))
      {
        Toast.makeText(paramContext, paramContext.getString(2131767098), 0).show();
        AppMethodBeat.o(19640);
      }
    }
    else
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("VideoPlayer_File_nam", paramString);
      localIntent.putExtra("VideoRecorder_VideoLength", paramInt1);
      localIntent.putExtra("VideoRecorder_VideoSize", paramInt2);
      com.tencent.mm.br.c.b(paramContext, "subapp", ".ui.video.VideoPlayerUI", localIntent);
    }
    AppMethodBeat.o(19640);
  }
  
  public final boolean a(Context paramContext, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(19649);
    boolean bool = q.a.JSZ.b(paramContext, paramString, paramVarArgs);
    AppMethodBeat.o(19649);
    return bool;
  }
  
  public final void b(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(19628);
    if (paramActivity != null)
    {
      paramIntent.setClass(paramActivity, CountryCodeUI.class);
      paramActivity.startActivityForResult(paramIntent, 100);
    }
    AppMethodBeat.o(19628);
  }
  
  public final void b(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19606);
    if (paramContext == null)
    {
      AppMethodBeat.o(19606);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.c.f(paramContext, ".ui.tools.MultiStageCitySelectUI", localIntent);
    AppMethodBeat.o(19606);
  }
  
  public final boolean b(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(19622);
    boolean bool = q.a.JSZ.a(paramContext, paramString, false, paramBundle);
    AppMethodBeat.o(19622);
    return bool;
  }
  
  public final void bX(Context paramContext)
  {
    AppMethodBeat.i(19607);
    com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.EditSignatureUI", new Intent());
    AppMethodBeat.o(19607);
  }
  
  public final d bY(Context paramContext)
  {
    AppMethodBeat.i(19616);
    paramContext = MMAppMgr.bY(paramContext);
    AppMethodBeat.o(19616);
    return paramContext;
  }
  
  public final Intent bZ(Context paramContext)
  {
    AppMethodBeat.i(19631);
    paramContext = new Intent(paramContext, LauncherUI.class).addFlags(67108864);
    AppMethodBeat.o(19631);
    return paramContext;
  }
  
  public final void c(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19608);
    if (paramContext == null)
    {
      AppMethodBeat.o(19608);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(19608);
  }
  
  public final void ca(Context paramContext)
  {
    AppMethodBeat.i(19632);
    com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
    AppMethodBeat.o(19632);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19652);
    g.a.ali();
    if (paramString != null)
    {
      int i = b.alj().getId(paramString);
      Log.d("MicroMsg.Notification.Handle", "cancel : %s", new Object[] { paramString });
      b.alj().cancel(i);
    }
    AppMethodBeat.o(19652);
  }
  
  public final void cb(Context paramContext)
  {
    AppMethodBeat.i(19641);
    com.tencent.mm.br.c.b(paramContext, "subapp", ".ui.openapi.AddAppUI", new Intent());
    AppMethodBeat.o(19641);
  }
  
  public final void d(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19642);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ShowImageUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19642);
  }
  
  public final void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19609);
    if (paramContext == null)
    {
      AppMethodBeat.o(19609);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = localIntent.getStringExtra("Contact_User");
    if (paramIntent != null) {
      e.a(localIntent, paramIntent);
    }
    Log.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", new Object[] { paramIntent, Util.getStack().toString() });
    localIntent.setClass(paramContext, ChattingUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19609);
  }
  
  public final void e(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19643);
    if (paramContext == null)
    {
      AppMethodBeat.o(19643);
      return;
    }
    com.tencent.mm.br.c.b(paramContext, "account", ".security.ui.MySafeDeviceListUI", paramIntent);
    AppMethodBeat.o(19643);
  }
  
  public final void e(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19610);
    if (paramContext == null)
    {
      AppMethodBeat.o(19610);
      return;
    }
    Log.i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", new Object[] { Util.getStack().toString() });
    paramIntent.setClass(paramContext, ChattingUI.class);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 1);
      AppMethodBeat.o(19610);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19610);
  }
  
  public final void f(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19645);
    if (paramContext == null)
    {
      AppMethodBeat.o(19645);
      return;
    }
    paramIntent.setClass(paramContext, RegByMobileVoiceVerifyUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19645);
  }
  
  public final void f(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19611);
    if (paramContext == null)
    {
      AppMethodBeat.o(19611);
      return;
    }
    paramIntent.setClass(paramContext, BindMContactIntroUI.class);
    MMWizardActivity.ay(paramContext, paramIntent);
    AppMethodBeat.o(19611);
  }
  
  public final void g(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19647);
    if (paramContext == null)
    {
      AppMethodBeat.o(19647);
      return;
    }
    com.tencent.mm.br.c.a(paramContext, "account", ".security.ui.SecurityAccountIntroUI", paramIntent);
    AppMethodBeat.o(19647);
  }
  
  public final void g(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19612);
    if (paramContext == null)
    {
      AppMethodBeat.o(19612);
      return;
    }
    paramIntent.setClass(paramContext, BindQQUI.class);
    MMWizardActivity.ay(paramContext, paramIntent);
    AppMethodBeat.o(19612);
  }
  
  public final void h(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19648);
    paramIntent.setClassName(paramContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19648);
  }
  
  public final void h(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19613);
    paramIntent.setClass(paramContext, LauncherUI.class).addFlags(67108864);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startMainUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startMainUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19613);
  }
  
  public final void i(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19614);
    if (paramContext == null)
    {
      AppMethodBeat.o(19614);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(19614);
  }
  
  public final void j(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19615);
    s.i(paramContext, paramIntent.getBundleExtra("reportArgs"));
    AppMethodBeat.o(19615);
  }
  
  public final void k(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19617);
    if (paramContext != null)
    {
      if (paramIntent.getIntExtra("Retr_Msg_Type", -1) < 0) {
        paramIntent.putExtra("Retr_Msg_Type", 4);
      }
      paramIntent.setClass(paramContext, MsgRetransmitUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19617);
  }
  
  public final void l(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19625);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ContactRemarkInfoModUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19625);
  }
  
  public final void m(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19626);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ModRemarkNameUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19626);
  }
  
  public final void n(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19629);
    if (paramContext != null) {
      com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.SettingsLanguageUI", paramIntent);
    }
    AppMethodBeat.o(19629);
  }
  
  public final void o(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19630);
    if ((paramIntent != null) && (paramContext != null))
    {
      paramIntent.setClass(paramContext, LauncherUI.class).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19630);
  }
  
  public final void p(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19634);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent.getExtras());
    if (paramIntent.getFlags() != 0) {
      localIntent.addFlags(paramIntent.getFlags());
    }
    com.tencent.mm.br.c.b(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
    AppMethodBeat.o(19634);
  }
  
  public final void q(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19635);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent.getExtras());
    if (paramIntent.getFlags() != 0) {
      localIntent.addFlags(paramIntent.getFlags());
    }
    g.il(paramContext);
    AppMethodBeat.o(19635);
  }
  
  public final void r(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19636);
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent.getExtras());
      if (paramIntent.getFlags() != 0) {
        localIntent.addFlags(paramIntent.getFlags());
      }
      com.tencent.mm.br.c.b(paramContext, "subapp", ".ui.pluginapp.ContactSearchUI", localIntent);
    }
    AppMethodBeat.o(19636);
  }
  
  public final void s(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19637);
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent.getExtras());
      if (paramIntent.getFlags() != 0) {
        localIntent.addFlags(paramIntent.getFlags());
      }
      com.tencent.mm.br.c.b(paramContext, "subapp", ".ui.pluginapp.ContactSearchResultUI", localIntent);
    }
    AppMethodBeat.o(19637);
  }
  
  public final void t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19653);
    q.a.JSZ.a(paramContext, paramString, true);
    AppMethodBeat.o(19653);
  }
  
  public final void t(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19639);
    paramIntent.setClass(paramContext, SnsLabelContactListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.al
 * JD-Core Version:    0.7.0.1
 */