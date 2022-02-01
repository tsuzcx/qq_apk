package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaMiniProgram;

final class JsApiShareAppMessageBase$6
  implements a.b
{
  JsApiShareAppMessageBase$6(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, WWMediaMiniProgram paramWWMediaMiniProgram, c paramc, int paramInt) {}
  
  public final void O(Bitmap paramBitmap)
  {
    AppMethodBeat.i(272638);
    if (paramBitmap != null)
    {
      Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult success");
      JsApiShareAppMessageBase.a(paramBitmap, this.ppn);
    }
    try
    {
      for (;;)
      {
        WWAPIFactory.mw(this.nAX.getContext()).a(this.ppn, IWWAPI.WWAppType.ZYb);
        this.nAX.j(this.cuf, this.ppj.h("ok", null));
        AppMethodBeat.o(272638);
        return;
        Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult fail");
        this.ppn.ZYw = new byte[1];
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", paramBitmap, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.6
 * JD-Core Version:    0.7.0.1
 */