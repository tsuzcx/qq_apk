package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean N(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155385);
    if (paramString.length() > 16)
    {
      a(paramContext, a.jhN);
      AppMethodBeat.o(155385);
      return false;
    }
    if (bt.aQP(paramString))
    {
      h.l(paramContext, 2131762309, 2131762346);
      AppMethodBeat.o(155385);
      return false;
    }
    if (!bt.aQU(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16)) {
        a(paramContext, a.jhP);
      }
      for (;;)
      {
        AppMethodBeat.o(155385);
        return false;
        a(paramContext, a.jhO);
      }
    }
    AppMethodBeat.o(155385);
    return true;
  }
  
  private static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(155386);
    switch (1.jhL[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155386);
      return;
      h.l(paramContext, 2131762344, 2131762346);
      AppMethodBeat.o(155386);
      return;
      h.l(paramContext, 2131762345, 2131762346);
      AppMethodBeat.o(155386);
      return;
      h.l(paramContext, 2131764656, 2131755731);
      AppMethodBeat.o(155386);
      return;
      h.l(paramContext, 2131764660, 2131755731);
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    if (paramInt > 0)
    {
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent, paramInt);
      AppMethodBeat.o(155384);
      return;
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(155384);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(155383);
      jhM = new a("TwoPasswordsNotMatch", 0);
      jhN = new a("BeyondMaximumLength", 1);
      jhO = new a("NotReachMinimumLength", 2);
      jhP = new a("DisallowShortNumericPassword", 3);
      jhQ = new a[] { jhM, jhN, jhO, jhP };
      AppMethodBeat.o(155383);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.b.a
 * JD-Core Version:    0.7.0.1
 */