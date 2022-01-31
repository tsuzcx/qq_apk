package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d.b;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "getKey", "", "run", "", "plugin-appbrand-integration_release"})
public final class a$c
  implements b
{
  a$c(h paramh, f paramf, JSONObject paramJSONObject, int paramInt, String paramString) {}
  
  public final String getKey()
  {
    return this.hDi;
  }
  
  public final void run()
  {
    AppMethodBeat.i(134649);
    if (this.hDf.isRunning())
    {
      this.hDg.a(this.hDf, this.hDh, this.hAB, (d)new a.c.a(this));
      AppMethodBeat.o(134649);
      return;
    }
    a.a(this.hDe);
    AppMethodBeat.o(134649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a.c
 * JD-Core Version:    0.7.0.1
 */