package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class ae
{
  final String appId;
  
  ae(String paramString)
  {
    this.appId = paramString;
  }
  
  final boolean aHd()
  {
    AppMethodBeat.i(131945);
    if (g.Nq().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ab.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { this.appId });
      Intent localIntent = new Intent().putExtra("rawUrl", v.ye(this.appId)).putExtra("forceHideShare", true);
      Context localContext = ah.getContext();
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(131945);
      return true;
    }
    AppMethodBeat.o(131945);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */