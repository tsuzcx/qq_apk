package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CircleOptions
{
  private DashPathEffect dashPathEffect;
  private int fillColor;
  private int iLevel;
  private String id;
  private boolean isVisible;
  private LatLng point;
  private double radius;
  private int strokeColor;
  private boolean strokeDash;
  private float strokeWidth;
  private float zIndex;
  
  public CircleOptions()
  {
    AppMethodBeat.i(87551);
    this.strokeColor = -16777216;
    this.strokeWidth = 10.0F;
    this.isVisible = true;
    this.radius = 0.0D;
    this.zIndex = 0.0F;
    this.point = new LatLng(39.908287999999999D, 116.397572D);
    this.fillColor = 0;
    this.strokeDash = false;
    this.dashPathEffect = null;
    this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
    AppMethodBeat.o(87551);
  }
  
  public final CircleOptions center(LatLng paramLatLng)
  {
    this.point = paramLatLng;
    return this;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final CircleOptions fillColor(int paramInt)
  {
    this.fillColor = paramInt;
    return this;
  }
  
  public final LatLng getCenter()
  {
    return this.point;
  }
  
  public final int getFillColor()
  {
    return this.fillColor;
  }
  
  public final int getLevel()
  {
    return this.iLevel;
  }
  
  public final double getRadius()
  {
    return this.radius;
  }
  
  public final int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  public final boolean getStrokeDash()
  {
    return this.strokeDash;
  }
  
  public final DashPathEffect getStrokeDashPathEffect()
  {
    return this.dashPathEffect;
  }
  
  public final float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final CircleOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public final CircleOptions radius(double paramDouble)
  {
    this.radius = paramDouble;
    return this;
  }
  
  public final CircleOptions strokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    return this;
  }
  
  public final CircleOptions strokeDash(boolean paramBoolean)
  {
    this.strokeDash = paramBoolean;
    return this;
  }
  
  public final CircleOptions strokeDashPathEffect(DashPathEffect paramDashPathEffect)
  {
    this.dashPathEffect = paramDashPathEffect;
    return this;
  }
  
  public final CircleOptions strokeWidth(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.strokeWidth = f;
    return this;
  }
  
  public final CircleOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87552);
    Bundle localBundle = new Bundle();
    if (this.point != null)
    {
      localBundle.putDouble("lat", this.point.getLatitude());
      localBundle.putDouble("lng", this.point.getLongitude());
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeDouble(this.radius);
    paramParcel.writeFloat(this.strokeWidth);
    paramParcel.writeInt(this.strokeColor);
    paramParcel.writeInt(this.fillColor);
    paramParcel.writeFloat(this.zIndex);
    if (this.isVisible) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.id);
      AppMethodBeat.o(87552);
      return;
    }
  }
  
  public final CircleOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CircleOptions
 * JD-Core Version:    0.7.0.1
 */