package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.mm.sdk.platformtools.y;

final class b$b
  implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
{
  private b$b(b paramb) {}
  
  public final void onCreate()
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
    this.gyB.ajJ();
    b.b(this.gyB, true);
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
    if (b.i(this.gyB))
    {
      this.gyB.ajI();
      b.b(this.gyB, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.b
 * JD-Core Version:    0.7.0.1
 */