package com.tencent.mapsdk.raster.model;

import java.util.List;

public abstract interface Polyline
  extends IOverlay
{
  public abstract boolean equals(Object paramObject);
  
  public abstract void eraseTo(int paramInt, LatLng paramLatLng);
  
  public abstract int getColor();
  
  public abstract String getId();
  
  public abstract int getLevel();
  
  public abstract List<LatLng> getPoints();
  
  public abstract float getWidth();
  
  public abstract float getZIndex();
  
  public abstract int hashCode();
  
  public abstract boolean isDottedLine();
  
  public abstract boolean isGeodesic();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setColor(int paramInt);
  
  public abstract void setColorTexture(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setDottedLine(boolean paramBoolean);
  
  public abstract void setEraseable(boolean paramBoolean);
  
  public abstract void setGeodesic(boolean paramBoolean);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setPoints(List<LatLng> paramList);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Polyline
 * JD-Core Version:    0.7.0.1
 */