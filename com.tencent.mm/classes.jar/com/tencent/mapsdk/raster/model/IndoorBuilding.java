package com.tencent.mapsdk.raster.model;

import java.util.List;

public final class IndoorBuilding
{
  private int mActiveLevelIndex;
  private String mBuidlingId;
  private String mBuildingName;
  private List<IndoorLevel> mLevels;
  
  public IndoorBuilding(String paramString1, String paramString2, List<IndoorLevel> paramList, int paramInt)
  {
    this.mBuidlingId = paramString1;
    this.mBuildingName = paramString2;
    this.mLevels = paramList;
    this.mActiveLevelIndex = paramInt;
  }
  
  public final int getActiveLevelIndex()
  {
    return this.mActiveLevelIndex;
  }
  
  public final String getBuidlingId()
  {
    return this.mBuidlingId;
  }
  
  public final String getBuildingName()
  {
    return this.mBuildingName;
  }
  
  public final List<IndoorLevel> getLevels()
  {
    return this.mLevels;
  }
  
  public final String toString()
  {
    if ((this.mBuidlingId == null) || (this.mLevels == null) || (this.mLevels.size() <= this.mActiveLevelIndex)) {
      return null;
    }
    return this.mBuidlingId + "_" + ((IndoorLevel)this.mLevels.get(this.mActiveLevelIndex)).getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.IndoorBuilding
 * JD-Core Version:    0.7.0.1
 */