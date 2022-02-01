package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.booter.notification.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.tools.b.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class ar
  implements m
{
  public final void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(19623);
    if (paramActivity != null)
    {
      int i = paramIntent.getIntExtra("CropImageMode", 0);
      if ((i != 4) && (i != 2)) {
        break label81;
      }
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startCropImageNewUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(19623);
      return;
      label81:
      paramIntent.setClass(paramActivity, ImageCropUI.class);
    }
  }
  
  public final void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, b.a parama)
  {
    AppMethodBeat.i(239243);
    if (paramActivity != null)
    {
      int i = paramIntent2.getIntExtra("CropImageMode", 0);
      if ((i != 4) && (i != 2)) {
        break label55;
      }
      paramIntent2.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.b.a(paramActivity, paramIntent1, paramIntent2, paramString, 4, parama);
      AppMethodBeat.o(239243);
      return;
      label55:
      paramIntent2.setClass(paramActivity, ImageCropUI.class);
    }
  }
  
  public final void a(final Activity paramActivity, final String paramString1, final WXMediaMessage paramWXMediaMessage, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(239233);
    String str = paramActivity.getResources().getString(R.l.app_music);
    Object localObject = paramWXMediaMessage.title;
    str = str + (String)localObject;
    localObject = new o.a(paramActivity);
    ((o.a)localObject).gA(paramString2).bra(str).awo(R.l.confirm_dialog_share);
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(19604);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(19604);
          return;
        }
        n.a(paramWXMediaMessage, paramString1, paramString3, paramString2, 3, null);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          wp localwp = new wp();
          localwp.iak.hgl = paramString2;
          localwp.iak.content = paramAnonymousString;
          localwp.iak.type = ab.IX(paramString2);
          localwp.iak.flags = 0;
          localwp.publish();
        }
        k.cZ(paramActivity, paramActivity.getResources().getString(R.l.app_shared));
        h.OAn.kvStat(10910, "2");
        AppMethodBeat.o(19604);
      }
    }.show();
    AppMethodBeat.o(239233);
  }
  
  public final void a(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(19646);
    int i = paramIntent1.getIntExtra("from_source", 1);
    if (i == 1)
    {
      paramIntent1.setClass(paramContext, LoginUI.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent1.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 2)
    {
      paramIntent1.setClass(paramContext, LoginPasswordUI.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent1.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      MMWizardActivity.aQ(paramContext, paramIntent1);
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 5)
    {
      paramIntent1.setClass(paramContext, LoginIndepPass.class);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent1.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19646);
      return;
    }
    if (i == 6)
    {
      paramIntent1.setClass(paramContext, MobileInputUI.class);
      paramIntent1.putExtra("mobile_input_purpose", 1);
      paramIntent1.putExtra("mobile_auth_type", 7);
      paramIntent1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent1.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startDispathLoginUI", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19646);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(19654);
    o.a locala = new o.a(paramContext);
    locala.gA(paramString1).brc(paramString2).I(Boolean.FALSE).awo(R.l.app_send);
    if (paramBoolean) {
      locala.bqZ(paramContext.getResources().getString(R.l.sns_emoji_reply_to));
    }
    for (;;)
    {
      locala.b(parama).pRv.show();
      AppMethodBeat.o(19654);
      return;
      locala.bqZ(paramContext.getResources().getString(R.l.sns_emoji_send_to));
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
    AppMethodBeat.i(239234);
    paramIntent.setClass(paramMMActivity, SelectConversationUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(239234);
  }
  
  public final void a(Intent paramIntent1, int paramInt, MMActivity paramMMActivity, Intent paramIntent2)
  {
    AppMethodBeat.i(19621);
    if (paramIntent1.getIntExtra("CropImageMode", 0) == 4) {
      paramIntent1.setClassName(paramMMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
    }
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.ui.tools.b.a(paramMMActivity, paramIntent2, paramIntent1, com.tencent.mm.model.c.bzL(), paramInt);
      AppMethodBeat.o(19621);
      return;
      paramIntent1.setClass(paramMMActivity, ImageCropUI.class);
    }
  }
  
  public final void a(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(19627);
    paramIntent.setClass(paramActivity, ModRemarkNameUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(2, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUIForResult", "(Landroid/content/Intent;Landroid/app/Activity;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(19627);
  }
  
  public final void a(Intent paramIntent, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(19638);
    if (paramActivity != null)
    {
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.contact.SnsAddressUI");
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsAddressUIForResult", "(Landroid/content/Intent;Landroid/app/Activity;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSayHiEditUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    MMWizardActivity.aQ(paramMMWizardActivity, paramIntent);
    AppMethodBeat.o(19644);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19640);
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (!com.tencent.mm.pluginsdk.k.b.a.a.c(paramString, paramContext, paramBoolean2))
      {
        Toast.makeText(paramContext, paramContext.getString(R.l.video_play_export_file_error), 0).show();
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
    boolean bool = r.a.XNV.b(paramContext, paramString, paramVarArgs);
    AppMethodBeat.o(19649);
    return bool;
  }
  
  public final void aDA()
  {
    AppMethodBeat.i(19651);
    MMAppMgr.aDA();
    AppMethodBeat.o(19651);
  }
  
  public final void b(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(19628);
    if (paramActivity != null)
    {
      paramIntent.setClass(paramActivity, CountryCodeUI.class);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(100, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startCountryCodeUIForResult", "(Landroid/content/Intent;Landroid/app/Activity;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
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
    com.tencent.mm.br.c.g(paramContext, ".ui.tools.MultiStageCitySelectUI", localIntent);
    AppMethodBeat.o(19606);
  }
  
  public final boolean b(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(19622);
    boolean bool = r.a.XNV.a(paramContext, paramString, false, paramBundle);
    AppMethodBeat.o(19622);
    return bool;
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
  
  public final void cH(Context paramContext)
  {
    AppMethodBeat.i(19607);
    com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.EditSignatureUI", new Intent());
    AppMethodBeat.o(19607);
  }
  
  public final com.tencent.mm.ui.widget.a.e cI(Context paramContext)
  {
    AppMethodBeat.i(19616);
    paramContext = MMAppMgr.cI(paramContext);
    AppMethodBeat.o(19616);
    return paramContext;
  }
  
  public final Intent cJ(Context paramContext)
  {
    AppMethodBeat.i(19631);
    paramContext = new Intent(paramContext, LauncherUI.class).addFlags(67108864);
    AppMethodBeat.o(19631);
    return paramContext;
  }
  
  public final void cK(Context paramContext)
  {
    AppMethodBeat.i(19632);
    com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
    AppMethodBeat.o(19632);
  }
  
  public final void cL(Context paramContext)
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
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startShowImageUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      com.tencent.mm.ui.contact.e.a(localIntent, paramIntent);
    }
    Log.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", new Object[] { paramIntent, Util.getStack().toString() });
    localIntent.setClass(paramContext, ChattingUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(19610);
      return;
    }
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startChattingUIForResult", "(Landroid/content/Intent;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startRegByMobileVoiceVerifyUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    MMWizardActivity.aQ(paramContext, paramIntent);
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
    MMWizardActivity.aQ(paramContext, paramIntent);
    AppMethodBeat.o(19612);
  }
  
  public final void h(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19648);
    paramIntent.setClassName(paramContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSelectSpecialContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19648);
  }
  
  public final void h(Intent paramIntent, Context paramContext)
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
  
  public final void i(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19615);
    w.k(paramContext, paramIntent.getBundleExtra("reportArgs"));
    AppMethodBeat.o(19615);
  }
  
  public final void iH(String paramString)
  {
    AppMethodBeat.i(19652);
    h.a.aLc();
    if (paramString != null)
    {
      int i = com.tencent.mm.booter.notification.queue.b.aLd().getId(paramString);
      Log.d("MicroMsg.Notification.Handle", "cancel : %s", new Object[] { paramString });
      com.tencent.mm.booter.notification.queue.b.aLd().cancel(i);
    }
    AppMethodBeat.o(19652);
  }
  
  public final void j(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19617);
    if (paramContext != null)
    {
      if (paramIntent.getIntExtra("Retr_Msg_Type", -1) < 0) {
        paramIntent.putExtra("Retr_Msg_Type", 4);
      }
      paramIntent.setClass(paramContext, MsgRetransmitUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startMsgRetransmitUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19617);
  }
  
  public final void k(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19625);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ContactRemarkInfoModUI.class);
      if ((paramContext instanceof Activity)) {
        paramIntent.putExtra("key_label_click_source", ((Activity)paramContext).getIntent().getIntExtra("key_label_click_source", 0));
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startContactRemarkInfoModUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19625);
  }
  
  public final void l(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19626);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ModRemarkNameUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startRemarkUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19626);
  }
  
  public final void m(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19629);
    if (paramContext != null) {
      com.tencent.mm.br.c.b(paramContext, "setting", ".ui.setting.SettingsLanguageUI", paramIntent);
    }
    AppMethodBeat.o(19629);
  }
  
  public final void n(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19630);
    if ((paramIntent != null) && (paramContext != null))
    {
      paramIntent.setClass(paramContext, LauncherUI.class).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startLauncherUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(19630);
  }
  
  public final void o(Intent paramIntent, Context paramContext)
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
  
  public final void p(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19635);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent.getExtras());
    if (paramIntent.getFlags() != 0) {
      localIntent.addFlags(paramIntent.getFlags());
    }
    g.ll(paramContext);
    AppMethodBeat.o(19635);
  }
  
  public final void q(Intent paramIntent, Context paramContext)
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
  
  public final void r(Intent paramIntent, Context paramContext)
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
  
  public final void s(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(19639);
    paramIntent.setClass(paramContext, SnsLabelContactListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/WorkerUICallbackImpl", "startSnsLabelContactUI", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(19639);
  }
  
  public final void z(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19653);
    r.a.XNV.b(paramContext, paramString, true);
    AppMethodBeat.o(19653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ar
 * JD-Core Version:    0.7.0.1
 */