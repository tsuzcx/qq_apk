package com.tencent.mapsdk.raster.model;

public final class CameraPosition$Builder
{
  private float bearing = 0.0F;
  private float skew = 0.0F;
  private LatLng target;
  private float zoom = -1.0F;
  
  public CameraPosition$Builder() {}
  
  public CameraPosition$Builder(CameraPosition paramCameraPosition)
  {
    target(paramCameraPosition.getTarget()).zoom(paramCameraPosition.getZoom());
  }
  
  public final Builder bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public final CameraPosition build()
  {
    return new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
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