package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class nh
  extends MarkerInfo
  implements mo
{
  public nh(double paramDouble1, double paramDouble2, String paramString)
  {
    super(paramDouble1, paramDouble2, paramString);
  }
  
  public nh(LatLng paramLatLng, String paramString)
  {
    super(paramLatLng.getLatitude(), paramLatLng.getLongitude(), paramString);
    AppMethodBeat.i(221644);
    AppMethodBeat.o(221644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nh
 * JD-Core Version:    0.7.0.1
 */