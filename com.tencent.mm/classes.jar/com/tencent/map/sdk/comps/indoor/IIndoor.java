package com.tencent.map.sdk.comps.indoor;

import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public abstract interface IIndoor
{
  @Deprecated
  public abstract String getActivedIndoorBuilding(LatLng paramLatLng);
  
  public abstract String[] getActivedIndoorFloorNames();
  
  public abstract int getIndoorFloorId();
  
  public abstract void setIndoorEnabled(boolean paramBoolean);
  
  public abstract void setIndoorFloor(int paramInt);
  
  public abstract void setIndoorFloor(String paramString1, String paramString2);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.sdk.comps.indoor.IIndoor
 * JD-Core Version:    0.7.0.1
 */