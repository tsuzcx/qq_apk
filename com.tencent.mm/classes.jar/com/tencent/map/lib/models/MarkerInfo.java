package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class MarkerInfo
{
  public static final int TYPE_2D_GEO_ANGLE = 0;
  public static final int TYPE_2D_SCREEN_ANGLE = 1;
  public static final int TYPE_2D_UI = 2;
  public static final int TYPE_3D = 3;
  private float alpha = 1.0F;
  private float anchorX = 0.5F;
  private float anchorY = 0.5F;
  private float angle = 0.0F;
  private boolean avoidAnnotation = false;
  private boolean avoidOtherMarker = false;
  private int displayLevel = OverlayLevel.OverlayLevelAboveRoads;
  private boolean forceLoad = true;
  private String iconName;
  private boolean interactive = true;
  private double latitude;
  private double longitude;
  private int maxScaleLevel = 30;
  private int minScaleLevel = 0;
  private int priority;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  private int type = 1;
  private boolean visibility = true;
  
  private MarkerInfo() {}
  
  public MarkerInfo(double paramDouble1, double paramDouble2, String paramString)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.iconName = paramString;
  }
  
  public MarkerInfo alpha(float paramFloat)
  {
    this.alpha = paramFloat;
    return this;
  }
  
  public MarkerInfo anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorX = paramFloat1;
    this.anchorY = paramFloat2;
    return this;
  }
  
  public MarkerInfo avoidAnnotation(boolean paramBoolean)
  {
    this.avoidAnnotation = paramBoolean;
    return this;
  }
  
  public MarkerInfo avoidOtherMarker(boolean paramBoolean)
  {
    this.avoidOtherMarker = paramBoolean;
    return this;
  }
  
  public MarkerInfo displayLevel(int paramInt)
  {
    this.displayLevel = paramInt;
    return this;
  }
  
  public MarkerInfo forceLoad(boolean paramBoolean)
  {
    this.forceLoad = paramBoolean;
    return this;
  }
  
  public MarkerInfo iconName(String paramString)
  {
    this.iconName = paramString;
    return this;
  }
  
  public MarkerInfo interactive(boolean paramBoolean)
  {
    this.interactive = paramBoolean;
    return this;
  }
  
  public MarkerInfo maxScaleLevel(int paramInt)
  {
    this.maxScaleLevel = paramInt;
    return this;
  }
  
  public MarkerInfo minScaleLevel(int paramInt)
  {
    this.minScaleLevel = paramInt;
    return this;
  }
  
  public MarkerInfo position(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    return this;
  }
  
  public MarkerInfo priority(int paramInt)
  {
    this.priority = paramInt;
    return this;
  }
  
  public MarkerInfo rotation(float paramFloat)
  {
    this.angle = paramFloat;
    return this;
  }
  
  public MarkerInfo scale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    return this;
  }
  
  public MarkerInfo type(int paramInt)
  {
    this.type = paramInt;
    return this;
  }
  
  public MarkerInfo visible(boolean paramBoolean)
  {
    this.visibility = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.models.MarkerInfo
 * JD-Core Version:    0.7.0.1
 */