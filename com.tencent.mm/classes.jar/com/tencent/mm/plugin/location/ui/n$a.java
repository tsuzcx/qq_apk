package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class n$a
  implements TencentMap.InfoWindowAdapter
{
  private n$a(n paramn) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(113586);
    ab.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(this.ofg.ofc.getVisibility()) });
    if ("info_window_tag".equals(paramMarker.getTag()))
    {
      paramMarker = this.ofg.ofc;
      AppMethodBeat.o(113586);
      return paramMarker;
    }
    AppMethodBeat.o(113586);
    return null;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.n.a
 * JD-Core Version:    0.7.0.1
 */