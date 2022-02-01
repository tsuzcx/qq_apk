package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public abstract interface Marker
  extends IOverlay
{
  public abstract boolean equals(Object paramObject);
  
  public abstract float getAlpha();
  
  public abstract String getContentDescription();
  
  public abstract String getId();
  
  public abstract int getLevel();
  
  public abstract View getMarkerView();
  
  public abstract LatLng getPosition();
  
  public abstract float getRotation();
  
  public abstract String getSnippet();
  
  public abstract Object getTag();
  
  public abstract String getTitle();
  
  public abstract float getZIndex();
  
  public abstract int hashCode();
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isDraggable();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean isVisible();
  
  public abstract void refreshInfoWindow();
  
  public abstract void remove();
  
  public abstract void set2Top();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setContentDescription(String paramString);
  
  public abstract void setDraggable(boolean paramBoolean);
  
  public abstract void setIcon(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setInfoWindowHideAnimation(Animation paramAnimation);
  
  public abstract void setInfoWindowShowAnimation(Animation paramAnimation);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setMarkerView(View paramView);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setRotation(float paramFloat);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
  
  public abstract void showInfoWindow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Marker
 * JD-Core Version:    0.7.0.1
 */