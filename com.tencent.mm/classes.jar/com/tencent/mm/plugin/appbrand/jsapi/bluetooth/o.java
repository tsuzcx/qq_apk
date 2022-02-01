package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/JsApiOpenBluetoothAdapterBackground;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiOpenBluetoothAdapter;", "()V", "overrideResultIfNeed", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "result", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends m
{
  public static final int CTRL_INDEX = 1094;
  public static final String NAME = "openBluetoothAdapterBackground";
  public static final o.a rKu;
  
  static
  {
    AppMethodBeat.i(329533);
    rKu = new o.a((byte)0);
    AppMethodBeat.o(329533);
  }
  
  public final k a(f paramf, k paramk)
  {
    AppMethodBeat.i(329546);
    s.u(paramf, "component");
    s.u(paramk, "result");
    Log.i("MicroMsg.AppBrand.JsApiOpenBluetoothAdapterBackground", s.X("overrideResultIfNeed, result: ", paramk));
    if (s.p(a.e.rVt, paramk.rKn))
    {
      paramf = a.aan(paramf.getAppId());
      if (paramf != null) {
        paramf.rJY = true;
      }
    }
    AppMethodBeat.o(329546);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o
 * JD-Core Version:    0.7.0.1
 */