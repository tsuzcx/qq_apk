package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  extends e.c
{
  g$1(g paramg, e parame, String paramString) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(145950);
    ab.i("MicroMsg.JsApiOperateRecorder", "onPause");
    this.ifU.onBackground();
    AppMethodBeat.o(145950);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(145952);
    ab.i("MicroMsg.JsApiOperateRecorder", "onDestroy");
    com.tencent.mm.plugin.appbrand.e.b(this.val$appId, this.ifV.ifl);
    this.ifV.ifl = null;
    this.ifU.onDestroy();
    AppMethodBeat.o(145952);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145951);
    ab.i("MicroMsg.JsApiOperateRecorder", "onResume");
    this.ifU.onForeground();
    AppMethodBeat.o(145951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.g.1
 * JD-Core Version:    0.7.0.1
 */