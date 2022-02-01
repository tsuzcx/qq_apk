package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class l$a
  implements TencentMap.InfoWindowAdapter
{
  private l$a(l paraml) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(55992);
    Log.i("ZItemOverlay", "get info window: %s", new Object[] { Integer.valueOf(this.EoJ.EoG.getVisibility()) });
    if ("info_window_tag".equals(paramMarker.getTag()))
    {
      paramMarker = this.EoJ.EoG;
      AppMethodBeat.o(55992);
      return paramMarker;
    }
    AppMethodBeat.o(55992);
    return null;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.l.a
 * JD-Core Version:    0.7.0.1
 */