package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean O(Context paramContext, String paramString)
  {
    AppMethodBeat.i(73684);
    if (paramString.length() > 16)
    {
      a(paramContext, a.a.gBe);
      AppMethodBeat.o(73684);
      return false;
    }
    if (bo.apE(paramString))
    {
      h.h(paramContext, 2131302412, 2131302443);
      AppMethodBeat.o(73684);
      return false;
    }
    if (!bo.apJ(paramString))
    {
      if ((paramString.length() >= 8) && (paramString.length() < 16)) {
        a(paramContext, a.a.gBg);
      }
      for (;;)
      {
        AppMethodBeat.o(73684);
        return false;
        a(paramContext, a.a.gBf);
      }
    }
    AppMethodBeat.o(73684);
    return true;
  }
  
  private static void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(73685);
    switch (a.1.gBc[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(73685);
      return;
      h.h(paramContext, 2131302441, 2131302443);
      AppMethodBeat.o(73685);
      return;
      h.h(paramContext, 2131302442, 2131302443);
      AppMethodBeat.o(73685);
      return;
      h.h(paramContext, 2131304499, 2131296924);
      AppMethodBeat.o(73685);
      return;
      h.h(paramContext, 2131304501, 2131296924);
    }
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(73683);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    if (!paramBoolean) {
      bool = true;
    }
    localIntent.putExtra("neverGetA8Key", bool);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    if (paramInt > 0)
    {
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent, paramInt);
      AppMethodBeat.o(73683);
      return;
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(73683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.b.a
 * JD-Core Version:    0.7.0.1
 */