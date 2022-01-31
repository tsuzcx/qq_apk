package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.u.i;

public abstract class JsApiAppBrandNFCBase
  extends a
{
  JsApiAppBrandNFCBase.a gxR = null;
  
  protected final void a(JsApiAppBrandNFCBase.a parama)
  {
    this.gxR = parama;
    parama = new JsApiAppBrandNFCBase.CheckIsSupportHCETask(this);
    i.aU(parama);
    AppBrandMainProcessService.a(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */