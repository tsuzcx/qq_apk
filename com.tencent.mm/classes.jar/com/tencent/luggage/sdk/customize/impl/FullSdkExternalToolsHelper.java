package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.protocal.protobuf.ccw;

public final class FullSdkExternalToolsHelper
  implements x
{
  public final void a(Context paramContext, String paramString, ccw paramccw)
  {
    AppMethodBeat.i(101630);
    d.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", new Object[] { paramString });
    paramccw = new Intent(paramContext, FullSdkExternalToolsHelper.SimpleWebViewActivity.class);
    paramccw.putExtra("_url_", paramString);
    if (!(paramContext instanceof Activity)) {
      paramccw.addFlags(268435456);
    }
    paramContext.startActivity(paramccw);
    AppMethodBeat.o(101630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper
 * JD-Core Version:    0.7.0.1
 */