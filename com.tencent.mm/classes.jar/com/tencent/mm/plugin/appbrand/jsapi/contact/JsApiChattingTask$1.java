package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiChattingTask$1
  implements i.a
{
  JsApiChattingTask$1(JsApiChattingTask paramJsApiChattingTask) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(130982);
    if (paramWxaAttributes == null) {
      ab.w("MicroMsg.JsApiChattingTask", "info is null, err");
    }
    JsApiChattingTask.a(this.hKm);
    AppMethodBeat.o(130982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask.1
 * JD-Core Version:    0.7.0.1
 */