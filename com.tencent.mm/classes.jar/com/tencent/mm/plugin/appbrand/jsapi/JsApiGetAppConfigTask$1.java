package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.m.c;

final class JsApiGetAppConfigTask$1
  implements m.c
{
  JsApiGetAppConfigTask$1(JsApiGetAppConfigTask paramJsApiGetAppConfigTask) {}
  
  public final void yA(String paramString)
  {
    AppMethodBeat.i(130425);
    this.hxL.value = paramString;
    JsApiGetAppConfigTask.a(this.hxL);
    AppMethodBeat.o(130425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask.1
 * JD-Core Version:    0.7.0.1
 */