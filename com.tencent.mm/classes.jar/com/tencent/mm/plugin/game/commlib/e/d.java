package com.tencent.mm.plugin.game.commlib.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, float paramFloat, String paramString2)
  {
    AppMethodBeat.i(275351);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    localIntent.putExtra("KHalfScreenHeight", paramInt2);
    localIntent.putExtra("KHalfScreenHeightPercent", paramFloat);
    if (!Util.isNullOrNil(paramString2)) {
      localIntent.putExtra("KGamePreloadData", paramString2);
    }
    if (paramInt1 > 0)
    {
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent, paramInt1);
      AppMethodBeat.o(275351);
      return;
    }
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(275351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.d
 * JD-Core Version:    0.7.0.1
 */