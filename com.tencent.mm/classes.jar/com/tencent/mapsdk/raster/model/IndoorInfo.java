package com.tencent.mapsdk.raster.model;

public class IndoorInfo
{
  private String buildingId;
  private String floorName;
  
  public IndoorInfo(String paramString1, String paramString2)
  {
    this.buildingId = paramString1;
    this.floorName = paramString2;
  }
  
  public String getBuildingId()
  {
    return this.buildingId;
  }
  
  public String getFloorName()
  {
    return this.floorName;
  }
  
  public String toString()
  {
    return this.buildingId + "_" + this.floorName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.IndoorInfo
 * JD-Core Version:    0.7.0.1
 */