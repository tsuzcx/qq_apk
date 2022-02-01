package com.tencent.mapsdk.core;

import android.view.ViewGroup;
import com.tencent.mapsdk.internal.bt;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

public abstract interface MapDelegate<C extends TencentMapContext, M extends TencentMap, V extends bt>
  extends BaseMapView.MapViewProxy
{
  public abstract M createMap(C paramC);
  
  public abstract V createMapView(C paramC, ViewGroup paramViewGroup);
  
  public abstract C getMapContext();
  
  public abstract V getMapRenderView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.MapDelegate
 * JD-Core Version:    0.7.0.1
 */