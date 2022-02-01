package com.tencent.map.sdk.comps.offlinemap;

import java.util.List;

public final class OfflineProvince
  extends OfflineItem
{
  private List<OfflineCity> mCities;
  
  public final List<OfflineCity> getCities()
  {
    return this.mCities;
  }
  
  public final void setCities(List<OfflineCity> paramList)
  {
    this.mCities = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.comps.offlinemap.OfflineProvince
 * JD-Core Version:    0.7.0.1
 */