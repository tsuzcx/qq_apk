package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  extends g.b
{
  d$2(d paramd) {}
  
  public final void onDestroy()
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
    HCEEventLogic.dq(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.2
 * JD-Core Version:    0.7.0.1
 */