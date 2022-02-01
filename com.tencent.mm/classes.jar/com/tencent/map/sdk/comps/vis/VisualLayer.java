package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;

public abstract interface VisualLayer
  extends Alphable, Levelable, Removable, Visible, IOverlay
{
  public abstract void addLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener paramOnLayerStatusChangedListener);
  
  public abstract void clearCache();
  
  public abstract void removeLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener paramOnLayerStatusChangedListener);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setTimeInterval(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.sdk.comps.vis.VisualLayer
 * JD-Core Version:    0.7.0.1
 */