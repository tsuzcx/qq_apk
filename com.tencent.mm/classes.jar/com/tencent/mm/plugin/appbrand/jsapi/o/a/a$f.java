package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.map.sdk.comps.vis.VisualLayer.OnLayerStatusChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$f
  implements VisualLayer.OnLayerStatusChangedListener
{
  String sdF;
  
  public a$f(a parama, String paramString)
  {
    this.sdF = paramString;
  }
  
  public final void onLayerLoadFinish(int paramInt)
  {
    AppMethodBeat.i(329418);
    Log.i("MicroMsg.Map.DefaultTencentMapView", "onLayerLoadFinish status:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(329418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.f
 * JD-Core Version:    0.7.0.1
 */