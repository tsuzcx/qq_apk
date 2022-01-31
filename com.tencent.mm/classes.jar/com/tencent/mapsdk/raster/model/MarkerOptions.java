package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public final class MarkerOptions
{
  private float alpha = 1.0F;
  private int anchorOffsetX;
  private int anchorOffsetY;
  private float anchorU = 0.5F;
  private float anchorV = 1.0F;
  private BitmapDescriptor bitmapDescriptor;
  private String contentDescription;
  private Animation hidingAnination;
  private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
  protected String id;
  private Animation infoWindowHideAnimation;
  private Animation infoWindowShowAnimation;
  private boolean isClockwise = true;
  private boolean isDraggable = false;
  private boolean isFlat = false;
  private boolean isGps = false;
  private boolean isVisible = true;
  private LatLng latLng;
  private IndoorInfo mIndoorInfo;
  private View markerView;
  private float rotation = 0.0F;
  private Animation showingAnination;
  private String snippet;
  private Object tag;
  private String title;
  private int zIndex;
  
  public final MarkerOptions alpha(float paramFloat)
  {
    this.alpha = paramFloat;
    return this;
  }
  
  public final MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    return this;
  }
  
  public final MarkerOptions clockwise(boolean paramBoolean)
  {
    this.isClockwise = paramBoolean;
    return this;
  }
  
  public final MarkerOptions contentDescription(String paramString)
  {
    this.contentDescription = paramString;
    return this;
  }
  
  public final MarkerOptions draggable(boolean paramBoolean)
  {
    this.isDraggable = paramBoolean;
    return this;
  }
  
  public final MarkerOptions flat(boolean paramBoolean)
  {
    this.isFlat = paramBoolean;
    return this;
  }
  
  public final float getAlpha()
  {
    return this.alpha;
  }
  
  public final float getAnchorU()
  {
    return this.anchorU;
  }
  
  public final float getAnchorV()
  {
    return this.anchorV;
  }
  
  public final String getContentDescription()
  {
    return this.contentDescription;
  }
  
  public final Animation getHidingAnination()
  {
    return this.hidingAnination;
  }
  
  public final BitmapDescriptor getIcon()
  {
    return this.bitmapDescriptor;
  }
  
  public final IndoorInfo getIndoorInfo()
  {
    return this.mIndoorInfo;
  }
  
  public final Animation getInfoWindowHideAnimation()
  {
    return this.infoWindowHideAnimation;
  }
  
  public final int getInfoWindowOffsetX()
  {
    return this.anchorOffsetX;
  }
  
  public final Animation getInfoWindowShowAnimation()
  {
    return this.infoWindowShowAnimation;
  }
  
  public final int getInfowindowOffsetY()
  {
    return this.anchorOffsetY;
  }
  
  public final int getLevel()
  {
    return this.iLevel;
  }
  
  public final View getMarkerView()
  {
    return this.markerView;
  }
  
  public final LatLng getPosition()
  {
    return this.latLng;
  }
  
  public final float getRotation()
  {
    return this.rotation;
  }
  
  public final Animation getShowingAnination()
  {
    return this.showingAnination;
  }
  
  public final String getSnippet()
  {
    return this.snippet;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final int getZIndex()
  {
    return this.zIndex;
  }
  
  public final MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDescriptor = paramBitmapDescriptor;
    return this;
  }
  
  public final MarkerOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    this.mIndoorInfo = paramIndoorInfo;
    return this;
  }
  
  public final MarkerOptions infoWindowHideAnimation(Animation paramAnimation)
  {
    this.infoWindowHideAnimation = paramAnimation;
    return this;
  }
  
  public final MarkerOptions infoWindowOffset(int paramInt1, int paramInt2)
  {
    this.anchorOffsetX = paramInt1;
    this.anchorOffsetY = paramInt2;
    return this;
  }
  
  public final MarkerOptions infoWindowShowAnimation(Animation paramAnimation)
  {
    this.infoWindowShowAnimation = paramAnimation;
    return this;
  }
  
  public final boolean isClockwise()
  {
    return this.isClockwise;
  }
  
  public final boolean isDraggable()
  {
    return this.isDraggable;
  }
  
  public final boolean isFlat()
  {
    return this.isFlat;
  }
  
  public final boolean isGps()
  {
    return this.isGps;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final MarkerOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public final MarkerOptions markerView(View paramView)
  {
    this.markerView = paramView;
    return this;
  }
  
  public final MarkerOptions position(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
    return this;
  }
  
  public final MarkerOptions rotation(float paramFloat)
  {
    this.rotation = paramFloat;
    return this;
  }
  
  public final MarkerOptions setHidingAnination(Animation paramAnimation)
  {
    this.hidingAnination = paramAnimation;
    return this;
  }
  
  public final MarkerOptions setShowingAnination(Animation paramAnimation)
  {
    this.showingAnination = paramAnimation;
    return this;
  }
  
  public final MarkerOptions snippet(String paramString)
  {
    this.snippet = paramString;
    return this;
  }
  
  public final MarkerOptions tag(Object paramObject)
  {
    this.tag = paramObject;
    return this;
  }
  
  public final MarkerOptions title(String paramString)
  {
    this.title = paramString;
    return this;
  }
  
  public final MarkerOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final MarkerOptions zIndex(int paramInt)
  {
    this.zIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.MarkerOptions
 * JD-Core Version:    0.7.0.1
 */