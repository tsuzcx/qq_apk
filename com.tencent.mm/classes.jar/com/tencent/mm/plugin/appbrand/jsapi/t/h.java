package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import org.json.JSONObject;

public class h
  extends ab<g>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "initReady";
  
  public String a(final g paramg, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327717);
    final String str = paramg.getAppId();
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(327739);
        ad localad = dp.j(paramg);
        boolean bool2 = paramJSONObject.optBoolean("ignoreWebviewPreload", false);
        int i;
        boolean bool1;
        if (localad != null)
        {
          i = localad.getComponentId();
          if ((localad == null) || (!localad.isRunning())) {
            break label122;
          }
          bool1 = true;
          label51:
          if (localad == null) {
            break label127;
          }
        }
        label122:
        label127:
        for (String str = localad.cgR();; str = "")
        {
          Log.i("MicroMsg.JsApiInitReady", "invoke, appId:%s, webviewId:%s, isRunning:%b, ignoreWebviewPreload:%b, url:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str });
          if (bool1) {
            break label134;
          }
          AppMethodBeat.o(327739);
          return;
          i = 0;
          break;
          bool1 = false;
          break label51;
        }
        label134:
        if (!bool2) {
          localad.getRuntime().getPageContainer().i(localad);
        }
        localad.aeN("initReady");
        AppMethodBeat.o(327739);
      }
    });
    paramg = ZP("ok");
    AppMethodBeat.o(327717);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.h
 * JD-Core Version:    0.7.0.1
 */