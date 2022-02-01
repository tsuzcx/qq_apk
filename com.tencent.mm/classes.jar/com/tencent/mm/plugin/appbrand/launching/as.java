package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class as
{
  final String appId;
  
  as(String paramString)
  {
    this.appId = paramString;
  }
  
  final boolean cac()
  {
    AppMethodBeat.i(47307);
    if (h.axc().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { this.appId });
      Intent localIntent = new Intent().putExtra("rawUrl", z.abY(this.appId)).putExtra("forceHideShare", true);
      Context localContext = MMApplicationContext.getContext();
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(47307);
      return true;
    }
    AppMethodBeat.o(47307);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.as
 * JD-Core Version:    0.7.0.1
 */