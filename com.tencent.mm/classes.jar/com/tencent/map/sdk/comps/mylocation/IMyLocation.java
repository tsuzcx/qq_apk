package com.tencent.map.sdk.comps.mylocation;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public abstract interface IMyLocation
{
  public abstract Location getMyLocation();
  
  public abstract boolean isMyLocationEnabled();
  
  public abstract void setLocationSource(LocationSource paramLocationSource);
  
  public abstract void setMyLocationClickListener(TencentMap.OnMyLocationClickListener paramOnMyLocationClickListener);
  
  public abstract void setMyLocationEnabled(boolean paramBoolean);
  
  public abstract void setMyLocationStyle(MyLocationStyle paramMyLocationStyle);
  
  public abstract void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener paramOnMyLocationChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.comps.mylocation.IMyLocation
 * JD-Core Version:    0.7.0.1
 */