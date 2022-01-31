package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  extends e.c
{
  h$1(h paramh, e parame, String paramString) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(145959);
    ab.i("MicroMsg.JsApiStartRecordVoice", "onPause");
    this.ifU.onBackground();
    AppMethodBeat.o(145959);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(145961);
    ab.i("MicroMsg.JsApiStartRecordVoice", "onDestroy");
    com.tencent.mm.plugin.appbrand.e.b(this.val$appId, this.ifW.ifl);
    this.ifW.ifl = null;
    this.ifU.onDestroy();
    AppMethodBeat.o(145961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145960);
    ab.i("MicroMsg.JsApiStartRecordVoice", "onResume");
    this.ifU.onForeground();
    AppMethodBeat.o(145960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.h.1
 * JD-Core Version:    0.7.0.1
 */