package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class ViewManager$1
  implements TencentMap.OnInfoWindowClickListener
{
  ViewManager$1(ViewManager paramViewManager, Marker paramMarker, View.OnClickListener paramOnClickListener, View paramView) {}
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(51278);
    if (paramMarker == this.val$marker) {
      this.val$listener.onClick(this.val$view);
    }
    AppMethodBeat.o(51278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.ViewManager.1
 * JD-Core Version:    0.7.0.1
 */