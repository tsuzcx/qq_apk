package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;

public final class a
  implements q
{
  private boolean a(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19659);
    if (paramContext == null)
    {
      ad.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
      AppMethodBeat.o(19659);
      return false;
    }
    if (paramString == null)
    {
      ad.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
      AppMethodBeat.o(19659);
      return false;
    }
    if (paramString.startsWith("weixin://openSpecificView/"))
    {
      paramBoolean = b(paramContext, paramString, new Object[0]);
      AppMethodBeat.o(19659);
      return paramBoolean;
    }
    paramBoolean = e.Nh().b(paramContext, paramString, paramBoolean, paramu, paramBundle);
    AppMethodBeat.o(19659);
    return paramBoolean;
  }
  
  private static void u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19660);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19660);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(19660);
    }
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19655);
    paramBoolean = a(paramContext, paramString, paramBoolean, null);
    AppMethodBeat.o(19655);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(19657);
    paramBoolean = a(paramContext, paramString, paramBoolean, null, paramBundle);
    AppMethodBeat.o(19657);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu)
  {
    AppMethodBeat.i(19656);
    if (paramContext == null)
    {
      ad.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
      AppMethodBeat.o(19656);
      return false;
    }
    if (paramString.startsWith("http"))
    {
      u(paramContext, paramString);
      AppMethodBeat.o(19656);
      return true;
    }
    if (!b(paramContext, paramString, paramBoolean, paramu))
    {
      ad.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[] { paramString });
      AppMethodBeat.o(19656);
      return false;
    }
    AppMethodBeat.o(19656);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu)
  {
    AppMethodBeat.i(19658);
    paramBoolean = a(paramContext, paramString, paramBoolean, paramu, null);
    AppMethodBeat.o(19658);
    return paramBoolean;
  }
  
  public final boolean b(Context paramContext, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(19661);
    if (paramString == null)
    {
      ad.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
      AppMethodBeat.o(19661);
      return false;
    }
    if (paramContext == null)
    {
      ad.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
      AppMethodBeat.o(19661);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    String str2 = paramString.replace("weixin://openSpecificView/", "");
    String str1 = null;
    paramString = str1;
    if (paramVarArgs != null)
    {
      paramString = str1;
      if (paramVarArgs.length > 0) {
        paramString = (Bundle)paramVarArgs[0];
      }
    }
    if (str2.equalsIgnoreCase("contacts"))
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      paramString = localIntent.setClass(paramContext, LauncherUI.class);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(19661);
      return true;
      if (str2.equalsIgnoreCase("newfriend"))
      {
        d.b(paramContext, "subapp", ".ui.friend.FMessageConversationUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("addfriend"))
      {
        d.b(paramContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("searchbrand"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_Scene", 39);
        d.b(paramContext, "brandservice", ".ui.SearchOrRecommendBizUI", paramString);
      }
      else if (str2.equalsIgnoreCase("discover"))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("preferred_tab", 1);
        paramString = localIntent.setClass(paramContext, LauncherUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (str2.equalsIgnoreCase("timeline"))
      {
        d.b(paramContext, "sns", ".ui.SnsTimeLineUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("scan"))
      {
        d.b(paramContext, "scanner", ".ui.BaseScanUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myprofile"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myaccount"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsAccountInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("bindphone"))
      {
        MMWizardActivity.al(paramContext, localIntent.setClass(paramContext, BindMContactIntroUI.class));
      }
      else if (str2.equalsIgnoreCase("privacy"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsPrivacyUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("general"))
      {
        d.b(paramContext, "setting", ".ui.setting.SettingsAboutSystemUI", localIntent);
      }
      else
      {
        if (!str2.equalsIgnoreCase("invitevoip")) {
          break;
        }
        VoipAddressUI.kp(paramContext);
      }
    }
    if (str2.equalsIgnoreCase("expose")) {
      if (paramString == null) {
        break label986;
      }
    }
    label966:
    label980:
    label986:
    for (paramString = paramString.getString("url");; paramString = "")
    {
      localIntent.putExtra("k_expose_url", paramString);
      localIntent.putExtra("k_username", com.tencent.mm.model.u.aAm());
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(34) }));
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      break;
      if (str2.equalsIgnoreCase("shakecard")) {
        if (paramString == null) {
          break label980;
        }
      }
      for (paramString = paramString.getString("extinfo");; paramString = "")
      {
        localIntent.putExtra("key_shake_card_from_scene", 3);
        localIntent.putExtra("shake_card", true);
        localIntent.putExtra("key_shake_card_ext_info", paramString);
        d.b(paramContext, "shake", ".ui.ShakeReportUI", localIntent);
        break;
        if (str2.equalsIgnoreCase("cardlistview"))
        {
          ad.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
          paramString = new jv();
          paramString.dwO.context = paramContext;
          com.tencent.mm.sdk.b.a.IbL.l(paramString);
          break;
        }
        if (str2.equalsIgnoreCase("uploadlog"))
        {
          str1 = com.tencent.mm.model.u.aAm();
          paramVarArgs = str1;
          if (bt.isNullOrNil(str1)) {
            paramVarArgs = "weixin";
          }
          if (paramString != null) {}
          for (;;)
          {
            try
            {
              i = bt.getInt(paramString.getString("extinfo"), 0);
              if ((!ba.ajx()) || (ba.aiE())) {
                break label966;
              }
              bool = true;
              ad.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
              paramString = new Intent(paramContext, JSAPIUploadLogHelperUI.class);
              paramString.putExtra("key_user", paramVarArgs);
              paramString.putExtra("key_time", i);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramContext.startActivity((Intent)paramString.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            catch (Exception paramString) {}
            int i = 0;
            continue;
            boolean bool = false;
          }
        }
        AppMethodBeat.o(19661);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a
 * JD-Core Version:    0.7.0.1
 */