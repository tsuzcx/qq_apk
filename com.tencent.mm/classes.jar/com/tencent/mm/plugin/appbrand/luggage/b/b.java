package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.protocal.protobuf.ccw;

public final class b
  implements x
{
  public final void a(Context paramContext, String paramString, ccw paramccw)
  {
    AppMethodBeat.i(132095);
    Intent localIntent = new Intent().putExtra("rawUrl", paramString).putExtra(AppBrandProcessProxyUI.hvW, paramString);
    localIntent.putExtra("rawUrl", paramString);
    if (paramccw != null)
    {
      localIntent.putExtra("show_native_web_view", paramccw.xNk);
      localIntent.putExtra("KRightBtn", paramccw.xNl);
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(132095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */