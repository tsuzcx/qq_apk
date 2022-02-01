package com.tencent.mm.plugin.account.sdk.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean T(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155385);
    if (paramString.length() > 16)
    {
      a(paramContext, a.naz);
      AppMethodBeat.o(155385);
      return false;
    }
    if (Util.isChinese(paramString))
    {
      h.p(paramContext, a.c.regbyfacebook_reg_setpwd_alert_using_chinese, a.c.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155385);
      return false;
    }
    if (!Util.isValidPassword(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16)) {
        a(paramContext, a.naB);
      }
      for (;;)
      {
        AppMethodBeat.o(155385);
        return false;
        a(paramContext, a.naA);
      }
    }
    AppMethodBeat.o(155385);
    return true;
  }
  
  private static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(155386);
    switch (1.nax[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155386);
      return;
      h.p(paramContext, a.c.regbymobile_reg_setpwd_alert_diff, a.c.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155386);
      return;
      h.p(paramContext, a.c.regbymobile_reg_setpwd_alert_more_byte, a.c.regbymobile_reg_setpwd_alert_title);
      AppMethodBeat.o(155386);
      return;
      h.p(paramContext, a.c.verify_password_all_num_tip, a.c.app_err_reg_title);
      AppMethodBeat.o(155386);
      return;
      h.p(paramContext, a.c.verify_password_tip, a.c.app_err_reg_title);
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
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
      nay = new a("TwoPasswordsNotMatch", 0);
      naz = new a("BeyondMaximumLength", 1);
      naA = new a("NotReachMinimumLength", 2);
      naB = new a("DisallowShortNumericPassword", 3);
      naC = new a[] { nay, naz, naA, naB };
      AppMethodBeat.o(155383);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */