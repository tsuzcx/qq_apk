package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean K(Context paramContext, String paramString)
  {
    if (paramString.length() > 16)
    {
      a(paramContext, a.a.fjN);
      return false;
    }
    if (bk.Zz(paramString))
    {
      h.h(paramContext, com.tencent.mm.plugin.account.a.a.regbyfacebook_reg_setpwd_alert_using_chinese, com.tencent.mm.plugin.account.a.a.regbymobile_reg_setpwd_alert_title);
      return false;
    }
    if (!bk.ZE(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16))
      {
        a(paramContext, a.a.fjP);
        return false;
      }
      a(paramContext, a.a.fjO);
      return false;
    }
    return true;
  }
  
  private static void a(Context paramContext, a.a parama)
  {
    switch (a.1.fjL[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      h.h(paramContext, com.tencent.mm.plugin.account.a.a.regbymobile_reg_setpwd_alert_diff, com.tencent.mm.plugin.account.a.a.regbymobile_reg_setpwd_alert_title);
      return;
    case 2: 
      h.h(paramContext, com.tencent.mm.plugin.account.a.a.regbymobile_reg_setpwd_alert_more_byte, com.tencent.mm.plugin.account.a.a.regbymobile_reg_setpwd_alert_title);
      return;
    case 3: 
      h.h(paramContext, com.tencent.mm.plugin.account.a.a.verify_password_all_num_tip, com.tencent.mm.plugin.account.a.a.app_err_reg_title);
      return;
    }
    h.h(paramContext, com.tencent.mm.plugin.account.a.a.verify_password_tip, com.tencent.mm.plugin.account.a.a.app_err_reg_title);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    if (!paramBoolean) {
      bool = true;
    }
    localIntent.putExtra("neverGetA8Key", bool);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    if (paramInt > 0)
    {
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent, paramInt);
      return;
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.b.a
 * JD-Core Version:    0.7.0.1
 */