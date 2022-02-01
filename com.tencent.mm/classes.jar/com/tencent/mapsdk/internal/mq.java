package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlay;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;

public class mq
  extends mm<mr>
  implements AggregationOverlay, VectorHeatOverlay
{
  mq(ms paramms, mr parammr)
  {
    super(paramms, parammr);
  }
  
  public VectorHeatAggregationUnit getUnit(LatLng paramLatLng)
  {
    AppMethodBeat.i(222966);
    if ((this.c == null) || (this.b == 0L))
    {
      AppMethodBeat.o(222966);
      return null;
    }
    paramLatLng = ((ms)this.c).a(this.b, paramLatLng);
    AppMethodBeat.o(222966);
    return paramLatLng;
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(222959);
    if (((mr)this.d).a != null) {
      ((mr)this.d).a.displayLevel(paramInt);
    }
    ((mr)this.d).setDisplayLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(222959);
  }
  
  public void setOpacity(float paramFloat)
  {
    AppMethodBeat.i(222933);
    if (((mr)this.d).a != null) {
      ((mr)this.d).a.opacity(paramFloat);
    }
    ((mr)this.d).setOpacity(paramFloat);
    a(this.d);
    AppMethodBeat.o(222933);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(222944);
    if (((mr)this.d).a != null) {
      ((mr)this.d).a.visibility(paramBoolean);
    }
    ((mr)this.d).setVisibility(paramBoolean);
    a(this.d);
    AppMethodBeat.o(222944);
  }
  
  public void setZIndex(int paramInt)
  {
    AppMethodBeat.i(222952);
    if (((mr)this.d).a != null) {
      ((mr)this.d).a.zIndex(paramInt);
    }
    ((mr)this.d).setZIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(222952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mq
 * JD-Core Version:    0.7.0.1
 */