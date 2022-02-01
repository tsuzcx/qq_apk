package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaMiniProgram;

final class JsApiShareAppMessageBase$6
  implements a.b
{
  JsApiShareAppMessageBase$6(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, WWMediaMiniProgram paramWWMediaMiniProgram, c paramc, int paramInt) {}
  
  public final void N(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222675);
    if (paramBitmap != null)
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult success");
      JsApiShareAppMessageBase.a(paramBitmap, this.lls);
    }
    try
    {
      for (;;)
      {
        WWAPIFactory.lz(this.kvs.getContext()).a(this.lls);
        this.kvs.h(this.cjS, this.llo.e("ok", null));
        AppMethodBeat.o(222675);
        return;
        ae.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult fail");
        this.lls.MLt = new byte[1];
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", paramBitmap, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.6
 * JD-Core Version:    0.7.0.1
 */