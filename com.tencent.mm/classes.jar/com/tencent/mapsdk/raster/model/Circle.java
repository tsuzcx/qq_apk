package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;

public abstract interface Circle
  extends IOverlay
{
  public abstract boolean contains(LatLng paramLatLng);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract LatLng getCenter();
  
  public abstract int getFillColor();
  
  public abstract String getId();
  
  public abstract int getLevel();
  
  public abstract double getRadius();
  
  public abstract int getStrokeColor();
  
  public abstract boolean getStrokeDash();
  
  public abstract DashPathEffect getStrokeDashPathEffect();
  
  public abstract float getStrokeWidth();
  
  public abstract float getZIndex();
  
  public abstract int hashCode();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setCenter(LatLng paramLatLng);
  
  public abstract void setFillColor(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setRadius(double paramDouble);
  
  public abstract void setStrokeColor(int paramInt);
  
  public abstract void setStrokeDash(boolean paramBoolean);
  
  public abstract void setStrokeWidth(float paramFloat);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
  
  public abstract void strokeDashPathEffect(DashPathEffect paramDashPathEffect);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Circle
 * JD-Core Version:    0.7.0.1
 */