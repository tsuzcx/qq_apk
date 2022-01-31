package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class a$a
  implements TencentMap.InfoWindowAdapter
{
  public a$a(a parama) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(51175);
    if (paramMarker == null)
    {
      AppMethodBeat.o(51175);
      return null;
    }
    if (bo.isNullOrNil((String)paramMarker.getTag()))
    {
      ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
      AppMethodBeat.o(51175);
      return null;
    }
    if (((String)paramMarker.getTag()).endsWith("#label"))
    {
      AppMethodBeat.o(51175);
      return null;
    }
    paramMarker = (a.d)this.hOM.Ch((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
      AppMethodBeat.o(51175);
      return null;
    }
    if (paramMarker.hPr == null)
    {
      ab.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
      AppMethodBeat.o(51175);
      return null;
    }
    b.r.a locala = paramMarker.hPr.hPv;
    if (locala == null)
    {
      AppMethodBeat.o(51175);
      return null;
    }
    a locala1 = this.hOM;
    b localb = i.aDI();
    paramMarker = localb;
    if (localb == null) {
      paramMarker = new b(locala1.context);
    }
    paramMarker.setText("");
    paramMarker.setTextSize(12);
    paramMarker.setTextColor(b.jrs);
    paramMarker.setTitlePadding(0);
    paramMarker.setGravity("center");
    int i = b.jrt;
    paramMarker.x(0, 0, i, i);
    paramMarker.setText(locala.content);
    paramMarker.setTextSize(locala.hPx);
    paramMarker.setTextColor(locala.color);
    paramMarker.setTitlePadding(locala.padding);
    paramMarker.setGravity(locala.hfl);
    paramMarker.x(locala.hPy, locala.borderWidth, locala.borderColor, locala.bgColor);
    AppMethodBeat.o(51175);
    return paramMarker;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView)
  {
    AppMethodBeat.i(51176);
    if ((paramView instanceof b))
    {
      ab.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
      i.a((b)paramView);
    }
    AppMethodBeat.o(51176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */