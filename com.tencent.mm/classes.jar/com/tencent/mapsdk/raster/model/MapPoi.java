package com.tencent.mapsdk.raster.model;

public class MapPoi
{
  private String mName;
  private LatLng mPosition;
  
  public MapPoi(String paramString, LatLng paramLatLng)
  {
    this.mName = paramString;
    this.mPosition = paramLatLng;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public LatLng getPosition()
  {
    return this.mPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.MapPoi
 * JD-Core Version:    0.7.0.1
 */