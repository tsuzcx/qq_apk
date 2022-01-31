package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.y;

final class HCEEventLogic$1
  extends g.b
{
  public final void a(g.c paramc)
  {
    y.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
    super.a(paramc);
    HCEEventLogic.a(HCEEventLogic.access$000(), 23, null);
  }
  
  public final void onCreate()
  {
    y.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
    super.onCreate();
    HCEEventLogic.a(HCEEventLogic.access$000(), 21, null);
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
    super.onDestroy();
    HCEEventLogic.a(HCEEventLogic.access$000(), 24, null);
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
    super.onResume();
    HCEEventLogic.a(HCEEventLogic.access$000(), 22, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.1
 * JD-Core Version:    0.7.0.1
 */