package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tencentmap.mapsdk.a.h;

public final class CameraPosition
  implements Parcelable
{
  public static final Parcelable.Creator<CameraPosition> CREATOR = new CameraPosition.1();
  private static final int EMPTY_ZOOMLEVEL = -1;
  private float bearing = 0.0F;
  private float skew = 0.0F;
  private final LatLng target;
  private float zoom = -1.0F;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat)
  {
    this(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.skew = paramFloat2;
    this.bearing = paramFloat3;
  }
  
  public static CameraPosition.Builder builder()
  {
    return new CameraPosition.Builder();
  }
  
  public static CameraPosition.Builder builder(CameraPosition paramCameraPosition)
  {
    return new CameraPosition.Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((getTarget().equals(paramObject.getTarget())) && (Float.floatToIntBits(getZoom()) == Float.floatToIntBits(paramObject.getZoom())));
    return false;
  }
  
  public final float getBearing()
  {
    return this.bearing;
  }
  
  public final float getSkew()
  {
    return this.skew;
  }
  
  public final LatLng getTarget()
  {
    return this.target;
  }
  
  public final float getZoom()
  {
    return this.zoom;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final String toString()
  {
    return h.a(new String[] { h.a("target", getTarget()), h.a("zoom", Float.valueOf(getZoom())) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat((float)this.target.getLatitude());
    paramParcel.writeFloat((float)this.target.getLongitude());
    paramParcel.writeFloat(this.zoom);
    paramParcel.writeFloat(this.skew);
    paramParcel.writeFloat(this.bearing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */