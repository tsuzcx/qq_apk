package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean V(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155385);
    if (paramString.length() > 16)
    {
      a(paramContext, a.kiJ);
      AppMethodBeat.o(155385);
      return false;
    }
    if (Util.isChinese(paramString))
    {
      h.n(paramContext, 2131764375, 2131764412);
      AppMethodBeat.o(155385);
      return false;
    }
    if (!Util.isValidPassword(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16)) {
        a(paramContext, a.kiL);
      }
      for (;;)
      {
        AppMethodBeat.o(155385);
        return false;
        a(paramContext, a.kiK);
      }
    }
    AppMethodBeat.o(155385);
    return true;
  }
  
  private static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(155386);
    switch (1.kiH[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155386);
      return;
      h.n(paramContext, 2131764410, 2131764412);
      AppMethodBeat.o(155386);
      return;
      h.n(paramContext, 2131764411, 2131764412);
      AppMethodBeat.o(155386);
      return;
      h.n(paramContext, 2131767027, 2131755802);
      AppMethodBeat.o(155386);
      return;
      h.n(paramContext, 2131767031, 2131755802);
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
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
      kiI = new a("TwoPasswordsNotMatch", 0);
      kiJ = new a("BeyondMaximumLength", 1);
      kiK = new a("NotReachMinimumLength", 2);
      kiL = new a("DisallowShortNumericPassword", 3);
      kiM = new a[] { kiI, kiJ, kiK, kiL };
      AppMethodBeat.o(155383);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.b.a
 * JD-Core Version:    0.7.0.1
 */