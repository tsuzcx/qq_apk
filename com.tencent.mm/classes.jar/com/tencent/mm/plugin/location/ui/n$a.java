package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class n$a
  implements TencentMap.InfoWindowAdapter
{
  private n$a(n paramn) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    y.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(this.lHT.lHQ.getVisibility()) });
    if ("info_window_tag".equals(paramMarker.getTag())) {
      return this.lHT.lHQ;
    }
    return null;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.n.a
 * JD-Core Version:    0.7.0.1
 */