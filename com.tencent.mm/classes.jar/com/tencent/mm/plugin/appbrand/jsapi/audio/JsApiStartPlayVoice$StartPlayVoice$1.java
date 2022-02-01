package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.plugin.appbrand.c.b;

final class JsApiStartPlayVoice$StartPlayVoice$1
  implements Runnable
{
  JsApiStartPlayVoice$StartPlayVoice$1(JsApiStartPlayVoice.StartPlayVoice paramStartPlayVoice) {}
  
  public final void run()
  {
    AppMethodBeat.i(45962);
    b localb = b.lbt;
    b.a(this.lES.filePath, new k.a()new k.b
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(45960);
        JsApiStartPlayVoice.StartPlayVoice.1.this.lES.error = false;
        JsApiStartPlayVoice.StartPlayVoice.b(JsApiStartPlayVoice.StartPlayVoice.1.this.lES);
        AppMethodBeat.o(45960);
      }
    }, new k.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(45961);
        JsApiStartPlayVoice.StartPlayVoice.1.this.lES.error = true;
        JsApiStartPlayVoice.StartPlayVoice.c(JsApiStartPlayVoice.StartPlayVoice.1.this.lES);
        AppMethodBeat.o(45961);
      }
    });
    AppMethodBeat.o(45962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.1
 * JD-Core Version:    0.7.0.1
 */