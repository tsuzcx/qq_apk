package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, h paramh, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(140838);
    this.hTd.getRuntime().a(MiniProgramNavigationBackResult.a(this.hTe, this.hTf));
    this.hTd.h(this.bAX, this.hTg.j("ok", null));
    AppMethodBeat.o(140838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.1
 * JD-Core Version:    0.7.0.1
 */