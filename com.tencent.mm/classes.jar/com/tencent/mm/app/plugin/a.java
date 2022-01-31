package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements p
{
  private boolean a(Context paramContext, String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
      return false;
    }
    if (paramString == null)
    {
      y.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
      return false;
    }
    if (paramString.startsWith("weixin://openSpecificView/")) {
      return c(paramContext, paramString, new Object[0]);
    }
    d locald = d.tz();
    if (params == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(locald.byh.size()), Integer.valueOf(locald.byi.size()), Integer.valueOf(locald.byj.size()) });
      if (paramContext != null) {
        break;
      }
      y.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      locald.byg.mContext = null;
      return false;
    }
    locald.mContext = paramContext;
    locald.byg.mContext = locald.mContext;
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      locald.mContext = null;
      locald.byg.mContext = null;
      return false;
    }
    paramContext = locald.byh.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, params, paramBundle))
      {
        y.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locald.mContext = null;
        locald.byg.mContext = null;
        return true;
      }
    }
    paramContext = locald.byi.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, params, paramBundle))
      {
        y.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locald.mContext = null;
        locald.byg.mContext = null;
        return true;
      }
    }
    paramContext = locald.byj.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, params, paramBundle))
      {
        y.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        locald.mContext = null;
        locald.byg.mContext = null;
        return true;
      }
    }
    locald.mContext = null;
    locald.byg.mContext = null;
    y.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    return false;
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext, paramString, paramBoolean, null);
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    return a(paramContext, paramString, paramBoolean, null, paramBundle);
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean, s params)
  {
    if (paramContext == null) {
      y.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
    }
    do
    {
      return false;
      if (paramString.startsWith("http"))
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.addFlags(268435456);
        try
        {
          paramContext.startActivity(paramString);
          return true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            y.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[] { paramContext.getMessage() });
          }
        }
      }
    } while (b(paramContext, paramString, paramBoolean, params));
    y.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[] { paramString });
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, s params)
  {
    return a(paramContext, paramString, paramBoolean, params, null);
  }
  
  public final boolean c(Context paramContext, String paramString, Object... paramVarArgs)
  {
    if (paramString == null)
    {
      y.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
      return false;
    }
    if (paramContext == null)
    {
      y.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
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
      label117:
      return true;
      if (str2.equalsIgnoreCase("newfriend"))
      {
        com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.friend.FMessageConversationUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("addfriend"))
      {
        com.tencent.mm.br.d.b(paramContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("searchbrand"))
      {
        paramString = new Intent();
        paramString.putExtra("Contact_Scene", 39);
        com.tencent.mm.br.d.b(paramContext, "brandservice", ".ui.SearchOrRecommendBizUI", paramString);
      }
      else if (str2.equalsIgnoreCase("discover"))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("preferred_tab", 1);
        paramContext.startActivity(localIntent.setClass(paramContext, LauncherUI.class));
      }
      else if (str2.equalsIgnoreCase("timeline"))
      {
        com.tencent.mm.br.d.b(paramContext, "sns", ".ui.SnsTimeLineUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("scan"))
      {
        com.tencent.mm.br.d.b(paramContext, "scanner", ".ui.BaseScanUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myprofile"))
      {
        com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("myaccount"))
      {
        com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SettingsAccountInfoUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("bindphone"))
      {
        MMWizardActivity.C(paramContext, localIntent.setClass(paramContext, BindMContactIntroUI.class));
      }
      else if (str2.equalsIgnoreCase("privacy"))
      {
        com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SettingsPrivacyUI", localIntent);
      }
      else if (str2.equalsIgnoreCase("general"))
      {
        com.tencent.mm.br.d.b(paramContext, "setting", ".ui.setting.SettingsAboutSystemUI", localIntent);
      }
      else
      {
        if (!str2.equalsIgnoreCase("invitevoip")) {
          break;
        }
        VoipAddressUI.gV(paramContext);
      }
    }
    if (str2.equalsIgnoreCase("expose")) {
      if (paramString == null) {
        break label788;
      }
    }
    label776:
    label782:
    label788:
    for (paramString = paramString.getString("url");; paramString = "")
    {
      localIntent.putExtra("k_expose_url", paramString);
      localIntent.putExtra("k_username", q.Gj());
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(34) }));
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      break label117;
      if (str2.equalsIgnoreCase("shakecard")) {
        if (paramString == null) {
          break label782;
        }
      }
      for (paramString = paramString.getString("extinfo");; paramString = "")
      {
        localIntent.putExtra("key_shake_card_from_scene", 3);
        localIntent.putExtra("shake_card", true);
        localIntent.putExtra("key_shake_card_ext_info", paramString);
        com.tencent.mm.br.d.b(paramContext, "shake", ".ui.ShakeReportUI", localIntent);
        break label117;
        if (str2.equalsIgnoreCase("cardlistview"))
        {
          y.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
          com.tencent.mm.br.d.b(paramContext, "card", ".ui.CardHomePageUI", localIntent);
          break label117;
        }
        if (!str2.equalsIgnoreCase("uploadlog")) {
          break;
        }
        str1 = q.Gj();
        paramVarArgs = str1;
        if (bk.bl(str1)) {
          paramVarArgs = "weixin";
        }
        if (paramString != null) {}
        for (;;)
        {
          try
          {
            i = bk.getInt(paramString.getString("extinfo"), 0);
            if ((!au.DK()) || (au.CW())) {
              break label776;
            }
            bool = true;
            y.i("MicroMsg.MMURIJumpHandler", "upload log from jsapi, before upload, is-login:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a
 * JD-Core Version:    0.7.0.1
 */