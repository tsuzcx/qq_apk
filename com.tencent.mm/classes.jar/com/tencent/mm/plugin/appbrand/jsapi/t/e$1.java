package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  extends e.c
{
  e$1(e parame, c paramc, String paramString) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(145917);
    ab.i("MicroMsg.JsApiStartPlayVoice", "onPause");
    AppMethodBeat.o(145917);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(145919);
    ab.i("MicroMsg.JsApiStartPlayVoice", "onDestroy");
    com.tencent.mm.plugin.appbrand.e.b(this.val$appId, this.ifn.ifl);
    this.ifn.ifl = null;
    this.ifm.onDestroy();
    AppMethodBeat.o(145919);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145918);
    ab.i("MicroMsg.JsApiStartPlayVoice", "onResume");
    AppMethodBeat.o(145918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.1
 * JD-Core Version:    0.7.0.1
 */