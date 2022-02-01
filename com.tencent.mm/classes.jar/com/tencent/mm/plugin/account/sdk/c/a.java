package com.tencent.mm.plugin.account.sdk.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public final class a
{
  public static boolean T(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155385);
    if (paramString.length() > 16)
    {
      a(paramContext, a.pXH);
      AppMethodBeat.o(155385);
      return false;
    }
    if (Util.isChinese(paramString))
    {
      k.s(paramContext, a.e.regbyfacebook_reg_setpwd_alert_using_chinese, a.e.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155385);
      return false;
    }
    if (!Util.isValidPassword(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16)) {
        a(paramContext, a.pXJ);
      }
      for (;;)
      {
        AppMethodBeat.o(155385);
        return false;
        a(paramContext, a.pXI);
      }
    }
    AppMethodBeat.o(155385);
    return true;
  }
  
  private static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(155386);
    switch (1.pXF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155386);
      return;
      k.s(paramContext, a.e.regbymobile_reg_setpwd_alert_diff, a.e.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155386);
      return;
      k.s(paramContext, a.e.regbymobile_reg_setpwd_alert_more_byte, a.e.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155386);
      return;
      k.s(paramContext, a.e.verify_password_all_num_tip, a.e.app_err_reg_title);
      AppMethodBeat.o(155386);
      return;
      k.s(paramContext, a.e.verify_password_tip, a.e.app_err_reg_title);
    }
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(155384);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    if (!paramBoolean) {
      bool = true;
    }
    localIntent.putExtra("neverGetA8Key", bool);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    if (paramInt > 0)
    {
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent, paramInt);
      AppMethodBeat.o(155384);
      return;
    }
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(155384);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(155383);
      pXG = new a("TwoPasswordsNotMatch", 0);
      pXH = new a("BeyondMaximumLength", 1);
      pXI = new a("NotReachMinimumLength", 2);
      pXJ = new a("DisallowShortNumericPassword", 3);
      pXK = new a[] { pXG, pXH, pXI, pXJ };
      AppMethodBeat.o(155383);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */