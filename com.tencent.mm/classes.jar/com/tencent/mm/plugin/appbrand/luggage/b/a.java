package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.protocal.protobuf.czc;

public final class a
  implements ac
{
  public final void a(Context paramContext, String paramString, czc paramczc)
  {
    AppMethodBeat.i(47476);
    Intent localIntent = new Intent().putExtra("rawUrl", paramString).putExtra(AppBrandProcessProxyUI.jUQ, paramString);
    localIntent.putExtra("rawUrl", paramString);
    if (paramczc != null)
    {
      localIntent.putExtra("show_native_web_view", paramczc.FIi);
      localIntent.putExtra("KRightBtn", paramczc.FIj);
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(47476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */