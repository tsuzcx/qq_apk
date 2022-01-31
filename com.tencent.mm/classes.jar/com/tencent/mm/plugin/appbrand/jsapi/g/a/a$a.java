package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class a$a
  implements TencentMap.InfoWindowAdapter
{
  public a$a(a parama) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    if (bk.bl((String)paramMarker.getTag()))
    {
      y.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
      return null;
    }
    if (((String)paramMarker.getTag()).endsWith("#label")) {
      return null;
    }
    paramMarker = (a.d)this.gtW.ug((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
      return null;
    }
    if (paramMarker.gux == null)
    {
      y.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
      return null;
    }
    b.p.a locala = paramMarker.gux.guA;
    if (locala == null) {
      return null;
    }
    a locala1 = this.gtW;
    c localc = i.ajs();
    paramMarker = localc;
    if (localc == null) {
      paramMarker = new c(locala1.context);
    }
    paramMarker.setText("");
    paramMarker.setTextSize(12);
    paramMarker.setTextColor(c.hzp);
    paramMarker.setTitlePadding(0);
    paramMarker.setGravity("center");
    paramMarker.p(0, 0, c.hzq, c.hzq);
    paramMarker.setText(locala.content);
    paramMarker.setTextSize(locala.guC);
    paramMarker.setTextColor(locala.color);
    paramMarker.setTitlePadding(locala.padding);
    paramMarker.setGravity(locala.fMb);
    paramMarker.p(locala.guD, locala.borderWidth, locala.guu, locala.bgColor);
    return paramMarker;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView)
  {
    if ((paramView instanceof c))
    {
      y.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
      i.a((c)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */