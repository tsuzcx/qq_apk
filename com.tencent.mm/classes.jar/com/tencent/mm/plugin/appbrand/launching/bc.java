package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

final class bc
{
  final String appId;
  
  bc(String paramString)
  {
    this.appId = paramString;
  }
  
  final boolean bsk()
  {
    AppMethodBeat.i(47307);
    if (g.acL().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ae.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { this.appId });
      Intent localIntent = new Intent().putExtra("rawUrl", v.Lh(this.appId)).putExtra("forceHideShare", true);
      Context localContext = ak.getContext();
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(47307);
      return true;
    }
    AppMethodBeat.o(47307);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bc
 * JD-Core Version:    0.7.0.1
 */