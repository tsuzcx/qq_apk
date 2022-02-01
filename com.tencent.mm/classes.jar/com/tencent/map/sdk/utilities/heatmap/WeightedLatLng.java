package com.tencent.map.sdk.utilities.heatmap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WeightedLatLng
{
  private static final double DEFAULT_INTENSITY = 1.0D;
  private double mIntensity;
  private LatLng mPoint;
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    AppMethodBeat.i(172903);
    setPoint(paramLatLng);
    setIntensity(paramDouble);
    AppMethodBeat.o(172903);
  }
  
  public double getIntensity()
  {
    return this.mIntensity;
  }
  
  public LatLng getPoint()
  {
    return this.mPoint;
  }
  
  public void setIntensity(double paramDouble)
  {
    if (paramDouble >= 0.0D)
    {
      this.mIntensity = paramDouble;
      return;
    }
    this.mIntensity = 1.0D;
  }
  
  public void setPoint(LatLng paramLatLng)
  {
    this.mPoint = paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.WeightedLatLng
 * JD-Core Version:    0.7.0.1
 */