package com.tencent.map.lib.models;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private int displayLevel = 0;
  private boolean forceLoad = true;
  private int iconHeight;
  private String iconName;
  private int iconWidth;
  private boolean interactive = true;
  private double latitude;
  private double longitude;
  private SubMarkerInfo mSubMarkerInfo;
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
  
  public MarkerInfo iconHeight(int paramInt)
  {
    this.iconHeight = paramInt;
    return this;
  }
  
  public MarkerInfo iconName(String paramString)
  {
    this.iconName = paramString;
    return this;
  }
  
  public MarkerInfo iconWidth(int paramInt)
  {
    this.iconWidth = paramInt;
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
  
  public MarkerInfo subMarkerInfo(SubMarkerInfo paramSubMarkerInfo)
  {
    this.mSubMarkerInfo = paramSubMarkerInfo;
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(210987);
    String str = "MarkerInfo{type=" + this.type + ", iconName='" + this.iconName + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ", angle=" + this.angle + ", alpha=" + this.alpha + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", avoidAnnotation=" + this.avoidAnnotation + ", interactive=" + this.interactive + ", displayLevel=" + this.displayLevel + ", priority=" + this.priority + ", forceLoad=" + this.forceLoad + ", minScaleLevel=" + this.minScaleLevel + ", maxScaleLevel=" + this.maxScaleLevel + ", visibility=" + this.visibility + ", avoidOtherMarker=" + this.avoidOtherMarker + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", mSubMarkerInfo=" + this.mSubMarkerInfo + '}';
    AppMethodBeat.o(210987);
    return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.lib.models.MarkerInfo
 * JD-Core Version:    0.7.0.1
 */