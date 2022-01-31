package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.ui.LoginIndepPass;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.pluginsdk.ui.d.q;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class v
  implements m
{
  public final void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramActivity != null)
    {
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public final void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt, a.a parama)
  {
    if (paramActivity != null)
    {
      paramIntent2.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      com.tencent.mm.ui.tools.a.b(paramActivity, paramIntent1, paramIntent2, paramString, paramInt, parama);
    }
  }
  
  public final void a(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      return;
      i = paramIntent1.getIntExtra("from_source", 1);
      if (i == 1)
      {
        paramIntent1.setClass(paramContext, LoginUI.class);
        paramContext.startActivity(paramIntent1);
        return;
      }
      if (i == 2)
      {
        paramIntent1.setClass(paramContext, LoginPasswordUI.class);
        paramContext.startActivity(paramIntent1);
        return;
      }
      if (i == 3)
      {
        paramIntent1.setClass(paramContext, SimpleLoginUI.class);
        if (paramIntent2 != null)
        {
          MMWizardActivity.b(paramContext, paramIntent1, paramIntent2);
          return;
        }
        MMWizardActivity.C(paramContext, paramIntent1);
        return;
      }
      if (i == 5)
      {
        paramIntent1.setClass(paramContext, LoginIndepPass.class);
        paramContext.startActivity(paramIntent1);
        return;
      }
    } while (i != 6);
    paramIntent1.setClass(paramContext, MobileInputUI.class);
    paramIntent1.putExtra("mobile_input_purpose", 1);
    paramIntent1.putExtra("mobile_auth_type", 7);
    paramContext.startActivity(paramIntent1);
  }
  
  public final void a(Intent paramIntent1, int paramInt, MMActivity paramMMActivity, Intent paramIntent2)
  {
    if (paramMMActivity != null)
    {
      paramIntent1.setClassName(paramMMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      au.Hx();
      com.tencent.mm.ui.tools.a.a(paramMMActivity, paramIntent2, paramIntent1, com.tencent.mm.model.c.FG(), paramInt);
    }
  }
  
  public final void a(Intent paramIntent, Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramIntent.setClass(paramActivity, ModRemarkNameUI.class);
      paramActivity.startActivityForResult(paramIntent, 2);
    }
  }
  
  public final void a(Intent paramIntent, Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      paramIntent.setClassName(paramActivity, "com.tencent.mm.ui.contact.SnsAddressUI");
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public final void a(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramIntent.setClassName(paramContext, "com.tencent.mm.ui.contact.SayHiEditUI");
    paramContext.startActivity(paramIntent);
  }
  
  public final void a(Intent paramIntent, MMActivity.a parama, MMActivity paramMMActivity)
  {
    if (paramMMActivity != null)
    {
      paramIntent.setClassName(paramMMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
      paramMMActivity.b(parama, paramIntent, 8);
    }
  }
  
  public final void a(Intent paramIntent, MMActivity paramMMActivity)
  {
    paramIntent.setClass(paramMMActivity, SelectConversationUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 1);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3)
  {
    String str = paramMMActivity.getResources().getString(R.l.app_music);
    Object localObject = paramWXMediaMessage.title;
    str = str + (String)localObject;
    localObject = new g.a(paramMMActivity);
    ((g.a)localObject).bM(paramString2).WF(str).DY(R.l.confirm_dialog_share);
    ((g.a)localObject).g(Boolean.valueOf(true)).a(new v.1(this, paramWXMediaMessage, paramString1, paramString3, paramString2, paramMMActivity)).few.show();
  }
  
  public final void a(MMWizardActivity paramMMWizardActivity, Intent paramIntent)
  {
    if (paramMMWizardActivity == null) {
      return;
    }
    paramIntent.setClass(paramMMWizardActivity, MobileInputUI.class);
    MMWizardActivity.C(paramMMWizardActivity, paramIntent);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (!com.tencent.mm.pluginsdk.h.b.a.a.b(paramString, paramContext, paramBoolean2)) {
        Toast.makeText(paramContext, paramContext.getString(R.l.video_play_export_file_error), 0).show();
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("VideoPlayer_File_nam", paramString);
    localIntent.putExtra("VideoRecorder_VideoLength", paramInt1);
    localIntent.putExtra("VideoRecorder_VideoSize", paramInt2);
    com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.video.VideoPlayerUI", localIntent);
  }
  
  public final com.tencent.mm.ui.widget.a.c aM(Context paramContext)
  {
    return MMAppMgr.aM(paramContext);
  }
  
  public final Intent aN(Context paramContext)
  {
    return new Intent(paramContext, LauncherUI.class).addFlags(67108864);
  }
  
  public final void aO(Context paramContext)
  {
    com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
  }
  
  public final void aP(Context paramContext)
  {
    com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.openapi.AddAppUI", new Intent());
  }
  
  public final void b(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ShowImageUI.class);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public final void b(Intent paramIntent, Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramIntent.setClass(paramActivity, CountryCodeUI.class);
      paramActivity.startActivityForResult(paramIntent, 100);
    }
  }
  
  public final void b(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.d.e(paramContext, ".ui.tools.MultiStageCitySelectUI", localIntent);
  }
  
  public final boolean b(Context paramContext, String paramString, Bundle paramBundle)
  {
    return p.a.rSH.a(paramContext, paramString, false, paramBundle);
  }
  
  public final boolean b(Context paramContext, String paramString, Object... paramVarArgs)
  {
    return p.a.rSH.c(paramContext, paramString, paramVarArgs);
  }
  
  public final void c(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    com.tencent.mm.br.d.b(paramContext, "account", ".security.ui.MySafeDeviceListUI", paramIntent);
  }
  
  public final void c(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.EditSignatureUI", localIntent);
  }
  
  public final void cancelNotification(String paramString)
  {
    f.a.wy();
    if (paramString != null)
    {
      int i = b.wz().getId(paramString);
      y.d("MicroMsg.Notification.Handle", "cancel : %s", new Object[] { paramString });
      b.wz().cancel(i);
    }
  }
  
  public final void d(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    paramIntent.setClass(paramContext, RegByMobileVoiceVerifyUI.class);
    paramContext.startActivity(paramIntent);
  }
  
  public final void d(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
  }
  
  public final void e(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    com.tencent.mm.br.d.a(paramContext, "account", ".security.ui.SecurityAccountIntroUI", paramIntent);
  }
  
  public final void e(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
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
    y.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", new Object[] { paramIntent, bk.csb().toString() });
    localIntent.setClass(paramContext, ChattingUI.class);
    paramContext.startActivity(localIntent);
  }
  
  public final void f(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {
      return;
    }
    paramIntent.setClassName(paramContext, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
    paramContext.startActivity(paramIntent);
  }
  
  public final void f(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    y.i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", new Object[] { bk.csb().toString() });
    paramIntent.setClass(paramContext, ChattingUI.class);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 1);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public final void g(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramIntent.setClass(paramContext, BindMContactIntroUI.class);
    MMWizardActivity.C(paramContext, paramIntent);
  }
  
  public final void h(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, BindQQUI.class);
    MMWizardActivity.C(paramContext, localIntent);
  }
  
  public final void i(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramIntent.setClass(paramContext, LauncherUI.class).addFlags(67108864);
    paramContext.startActivity(paramIntent);
  }
  
  public final void j(Intent paramIntent, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public final void k(Intent paramIntent, Context paramContext)
  {
    q.g(paramContext, paramIntent.getBundleExtra("reportArgs"));
  }
  
  public final void l(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramIntent.getIntExtra("Retr_Msg_Type", -1) < 0) {
        paramIntent.putExtra("Retr_Msg_Type", 4);
      }
      paramIntent.setClass(paramContext, MsgRetransmitUI.class);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public final void m(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      paramIntent.putExtra("Ksnsupload_type", 2);
      com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsUploadUI", paramIntent);
    }
  }
  
  public final void n(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ContactRemarkInfoModUI.class);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public final void o(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ModRemarkNameUI.class);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public final void p(Context paramContext, String paramString)
  {
    p.a.rSH.a(paramContext, paramString, true);
  }
  
  public final void p(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null) {
      com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SettingsLanguageUI", paramIntent);
    }
  }
  
  public final void q(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramContext != null))
    {
      paramIntent.setClass(paramContext, LauncherUI.class).addFlags(67108864);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public final void r(Intent paramIntent, Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent.getExtras());
    if (paramIntent.getFlags() != 0) {
      localIntent.addFlags(paramIntent.getFlags());
    }
    com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
  }
  
  public final void s(Intent paramIntent, Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent.getExtras());
    if (paramIntent.getFlags() != 0) {
      localIntent.addFlags(paramIntent.getFlags());
    }
    com.tencent.mm.pluginsdk.d.eJ(paramContext);
  }
  
  public final void t(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent.getExtras());
      if (paramIntent.getFlags() != 0) {
        localIntent.addFlags(paramIntent.getFlags());
      }
      com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.pluginapp.ContactSearchUI", localIntent);
    }
  }
  
  public final void tn() {}
  
  public final void u(Intent paramIntent, Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent.getExtras());
      if (paramIntent.getFlags() != 0) {
        localIntent.addFlags(paramIntent.getFlags());
      }
      com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.pluginapp.ContactSearchResultUI", localIntent);
    }
  }
  
  public final void v(Intent paramIntent, Context paramContext)
  {
    paramIntent.setClass(paramContext, SnsLabelContactListUI.class);
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */