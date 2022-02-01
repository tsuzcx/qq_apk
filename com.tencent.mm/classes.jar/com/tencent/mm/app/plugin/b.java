package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.f.f;

public final class b
  implements r
{
  private static void A(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19660);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openLinkInBrowser", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19660);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(19660);
    }
  }
  
  private boolean a(Context paramContext, String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(19659);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
      AppMethodBeat.o(19659);
      return false;
    }
    if (paramString == null)
    {
      Log.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
      AppMethodBeat.o(19659);
      return false;
    }
    if (paramString.startsWith("weixin://openSpecificView/"))
    {
      paramBoolean = b(paramContext, paramString, new Object[0]);
      AppMethodBeat.o(19659);
      return paramBoolean;
    }
    paramBoolean = f.aDP().b(paramContext, paramString, paramBoolean, paramv, paramBundle);
    AppMethodBeat.o(19659);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(19657);
    paramBoolean = a(paramContext, paramString, paramBoolean, null, paramBundle);
    AppMethodBeat.o(19657);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, v paramv)
  {
    AppMethodBeat.i(19656);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
      AppMethodBeat.o(19656);
      return false;
    }
    if (paramString.startsWith("http"))
    {
      A(paramContext, paramString);
      AppMethodBeat.o(19656);
      return true;
    }
    if (!b(paramContext, paramString, paramBoolean, paramv))
    {
      Log.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[] { paramString });
      AppMethodBeat.o(19656);
      return false;
    }
    AppMethodBeat.o(19656);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19655);
    paramBoolean = a(paramContext, paramString, paramBoolean, null);
    AppMethodBeat.o(19655);
    return paramBoolean;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, v paramv)
  {
    AppMethodBeat.i(19658);
    paramBoolean = a(paramContext, paramString, paramBoolean, paramv, null);
    AppMethodBeat.o(19658);
    return paramBoolean;
  }
  
  public final boolean b(Context paramContext, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(19661);
    if (paramString == null)
    {
      Log.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
      AppMethodBeat.o(19661);
      return false;
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(19661);
      return true;
      if (str2.equalsIgnoreCase("newfriend"))
      {
        c.b(paramContext, "subapp", ".ui.friend.FMessageConversationUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("addfriend"))
      {
        c.b(paramContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("searchbrand"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_Scene", 39);
        c.b(paramContext, "brandservice", ".ui.SearchOrRecommendBizUI", paramString);
      }
      else if (str2.equalsIgnoreCase("discover"))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("preferred_tab", 1);
        paramString = localIntent.setClass(paramContext, LauncherUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (str2.equalsIgnoreCase("timeline"))
      {
        c.b(paramContext, "sns", ".ui.SnsTimeLineUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("scan"))
      {
        c.b(paramContext, "scanner", ".ui.BaseScanUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myprofile"))
      {
        c.b(paramContext, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myaccount"))
      {
        c.b(paramContext, "setting", ".ui.setting.SettingsAccountInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("bindphone"))
      {
        MMWizardActivity.aQ(paramContext, localIntent.setClass(paramContext, BindMContactIntroUI.class));
      }
      else if (str2.equalsIgnoreCase("privacy"))
      {
        c.b(paramContext, "setting", ".ui.setting.SettingsPrivacyUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("general"))
      {
        c.b(paramContext, "setting", ".ui.setting.SettingsAboutSystemUI", localIntent);
      }
      else
      {
        if (!str2.equalsIgnoreCase("invitevoip")) {
          break;
        }
        VoipAddressUI.nr(paramContext);
      }
    }
    if (str2.equalsIgnoreCase("expose")) {
      if (paramString == null) {
        break label984;
      }
    }
    label964:
    label978:
    label984:
    for (paramString = paramString.getString("url");; paramString = "")
    {
      localIntent.putExtra("k_expose_url", paramString);
      localIntent.putExtra("k_username", z.bAM());
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(34) }));
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      break;
      if (str2.equalsIgnoreCase("shakecard")) {
        if (paramString == null) {
          break label978;
        }
      }
      for (paramString = paramString.getString("extinfo");; paramString = "")
      {
        localIntent.putExtra("key_shake_card_from_scene", 3);
        localIntent.putExtra("shake_card", true);
        localIntent.putExtra("key_shake_card_ext_info", paramString);
        c.b(paramContext, "shake", ".ui.ShakeReportUI", localIntent);
        break;
        if (str2.equalsIgnoreCase("cardlistview"))
        {
          Log.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
          paramString = new mg();
          paramString.hOp.context = paramContext;
          paramString.publish();
          break;
        }
        if (str2.equalsIgnoreCase("uploadlog"))
        {
          str1 = z.bAM();
          paramVarArgs = str1;
          if (Util.isNullOrNil(str1)) {
            paramVarArgs = "weixin";
          }
          if (paramString != null) {}
          for (;;)
          {
            try
            {
              i = Util.getInt(paramString.getString("extinfo"), 0);
              if ((!bh.baz()) || (bh.aZG())) {
                break label964;
              }
              bool = true;
              Log.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
              paramString = new Intent(paramContext, JSAPIUploadLogHelperUI.class);
              paramString.putExtra("key_user", paramVarArgs);
              paramString.putExtra("key_time", i);
              paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
              com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramContext.startActivity((Intent)paramString.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/app/plugin/MMURIJumpHandler", "openSpecificUI", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b
 * JD-Core Version:    0.7.0.1
 */