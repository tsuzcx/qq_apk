package com.tencent.mapsdk.raster.model;

public class IndoorMapPoi
  extends MapPoi
{
  private String buildingId;
  private String buildingName;
  private String floorName;
  
  public IndoorMapPoi(String paramString1, LatLng paramLatLng, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramLatLng);
    this.buildingId = paramString2;
    this.buildingName = paramString3;
    this.floorName = paramString4;
  }
  
  public String getBuildingId()
  {
    return this.buildingId;
  }
  
  public String getBuildingName()
  {
    return this.buildingName;
  }
  
  public String getFloorName()
  {
    return this.floorName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.IndoorMapPoi
 * JD-Core Version:    0.7.0.1
 */