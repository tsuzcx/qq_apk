package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class az
{
  final String appId;
  
  az(String paramString)
  {
    this.appId = paramString;
  }
  
  final boolean bnH()
  {
    AppMethodBeat.i(47307);
    if (g.ZY().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      ac.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { this.appId });
      Intent localIntent = new Intent().putExtra("rawUrl", u.Hv(this.appId)).putExtra("forceHideShare", true);
      Context localContext = ai.getContext();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */