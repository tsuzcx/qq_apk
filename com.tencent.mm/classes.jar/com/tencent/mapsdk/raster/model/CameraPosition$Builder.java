package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraPosition$Builder
{
  private float bearing;
  private float skew;
  private LatLng target;
  private float zoom;
  
  public CameraPosition$Builder()
  {
    this.zoom = -1.0F;
    this.skew = 0.0F;
    this.bearing = 0.0F;
  }
  
  public CameraPosition$Builder(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(101164);
    this.zoom = -1.0F;
    this.skew = 0.0F;
    this.bearing = 0.0F;
    target(paramCameraPosition.getTarget()).zoom(paramCameraPosition.getZoom());
    AppMethodBeat.o(101164);
  }
  
  public final Builder bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public final CameraPosition build()
  {
    AppMethodBeat.i(101165);
    CameraPosition localCameraPosition = new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
    AppMethodBeat.o(101165);
    return localCameraPosition;
  }
  
  public final Builder skew(float paramFloat)
  {
    this.skew = paramFloat;
    return this;
  }
  
  public final Builder target(LatLng paramLatLng)
  {
    this.target = paramLatLng;
    return this;
  }
  
  public final Builder zoom(float paramFloat)
  {
    this.zoom = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CameraPosition.Builder
 * JD-Core Version:    0.7.0.1
 */