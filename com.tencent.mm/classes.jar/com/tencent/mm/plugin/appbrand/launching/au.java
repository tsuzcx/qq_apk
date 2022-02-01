package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class au
{
  final String appId;
  
  au(String paramString)
  {
    this.appId = paramString;
  }
  
  final boolean bNK()
  {
    AppMethodBeat.i(47307);
    if (h.aqJ().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      Log.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { this.appId });
      Intent localIntent = new Intent().putExtra("rawUrl", w.Up(this.appId)).putExtra("forceHideShare", true);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */