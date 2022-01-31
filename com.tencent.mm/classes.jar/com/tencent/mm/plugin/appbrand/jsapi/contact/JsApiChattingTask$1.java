package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiChattingTask$1
  implements c.a
{
  JsApiChattingTask$1(JsApiChattingTask paramJsApiChattingTask) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    if (paramWxaAttributes == null) {
      y.w("MicroMsg.JsApiChattingTask", "info is null, err");
    }
    JsApiChattingTask.a(this.gpG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask.1
 * JD-Core Version:    0.7.0.1
 */