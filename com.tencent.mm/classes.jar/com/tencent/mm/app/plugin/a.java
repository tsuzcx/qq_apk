package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.il;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;

public final class a
  implements com.tencent.mm.pluginsdk.r
{
  private boolean a(Context paramContext, String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15613);
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
      AppMethodBeat.o(15613);
      return false;
    }
    if (paramString == null)
    {
      ab.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
      AppMethodBeat.o(15613);
      return false;
    }
    if (paramString.startsWith("weixin://openSpecificView/"))
    {
      paramBoolean = b(paramContext, paramString, new Object[0]);
      AppMethodBeat.o(15613);
      return paramBoolean;
    }
    paramBoolean = e.Ce().b(paramContext, paramString, paramBoolean, paramv, paramBundle);
    AppMethodBeat.o(15613);
    return paramBoolean;
  }
  
  private static void w(Context paramContext, String paramString)
  {
    AppMethodBeat.i(15614);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      paramContext.startActivity(paramString);
      AppMethodBeat.o(15614);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(15614);
    }
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15609);
    paramBoolean = a(paramContext, paramString, paramBoolean, null);
    AppMethodBeat.o(15609);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(15611);
    paramBoolean = a(paramContext, paramString, paramBoolean, null, paramBundle);
    AppMethodBeat.o(15611);
    return paramBoolean;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, v paramv)
  {
    AppMethodBeat.i(15610);
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
      AppMethodBeat.o(15610);
      return false;
    }
    if (paramString.startsWith("http"))
    {
      w(paramContext, paramString);
      AppMethodBeat.o(15610);
      return true;
    }
    if (!b(paramContext, paramString, paramBoolean, paramv))
    {
      ab.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[] { paramString });
      AppMethodBeat.o(15610);
      return false;
    }
    AppMethodBeat.o(15610);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, v paramv)
  {
    AppMethodBeat.i(15612);
    paramBoolean = a(paramContext, paramString, paramBoolean, paramv, null);
    AppMethodBeat.o(15612);
    return paramBoolean;
  }
  
  public final boolean b(Context paramContext, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(15615);
    if (paramString == null)
    {
      ab.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
      AppMethodBeat.o(15615);
      return false;
    }
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
      AppMethodBeat.o(15615);
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
      paramContext.startActivity(localIntent.setClass(paramContext, LauncherUI.class));
    }
    for (;;)
    {
      AppMethodBeat.o(15615);
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
        paramContext.startActivity(localIntent.setClass(paramContext, LauncherUI.class));
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
        MMWizardActivity.J(paramContext, localIntent.setClass(paramContext, BindMContactIntroUI.class));
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
        VoipAddressUI.iq(paramContext);
      }
    }
    if (str2.equalsIgnoreCase("expose")) {
      if (paramString == null) {
        break label811;
      }
    }
    label791:
    label805:
    label811:
    for (paramString = paramString.getString("url");; paramString = "")
    {
      localIntent.putExtra("k_expose_url", paramString);
      localIntent.putExtra("k_username", com.tencent.mm.model.r.Zn());
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(34) }));
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      break;
      if (str2.equalsIgnoreCase("shakecard")) {
        if (paramString == null) {
          break label805;
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
          ab.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
          paramString = new il();
          paramString.cxQ.context = paramContext;
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
          break;
        }
        if (str2.equalsIgnoreCase("uploadlog"))
        {
          str1 = com.tencent.mm.model.r.Zn();
          paramVarArgs = str1;
          if (bo.isNullOrNil(str1)) {
            paramVarArgs = "weixin";
          }
          if (paramString != null) {}
          for (;;)
          {
            try
            {
              i = bo.getInt(paramString.getString("extinfo"), 0);
              if ((!aw.RG()) || (aw.QP())) {
                break label791;
              }
              bool = true;
              ab.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
              paramString = new Intent(paramContext, JSAPIUploadLogHelperUI.class);
              paramString.putExtra("key_user", paramVarArgs);
              paramString.putExtra("key_time", i);
              paramContext.startActivity(paramString);
            }
            catch (Exception paramString) {}
            int i = 0;
            continue;
            boolean bool = false;
          }
        }
        AppMethodBeat.o(15615);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a
 * JD-Core Version:    0.7.0.1
 */