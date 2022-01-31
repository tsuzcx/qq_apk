package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.g;

public final class CameraPosition
  implements Parcelable
{
  public static final Parcelable.Creator<CameraPosition> CREATOR;
  private static final int EMPTY_ZOOMLEVEL = -1;
  private float bearing = 0.0F;
  private float skew = 0.0F;
  private final LatLng target;
  private float zoom = -1.0F;
  
  static
  {
    AppMethodBeat.i(101173);
    CREATOR = new CameraPosition.1();
    AppMethodBeat.o(101173);
  }
  
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
    AppMethodBeat.i(101169);
    CameraPosition.Builder localBuilder = new CameraPosition.Builder();
    AppMethodBeat.o(101169);
    return localBuilder;
  }
  
  public static CameraPosition.Builder builder(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(101170);
    paramCameraPosition = new CameraPosition.Builder(paramCameraPosition);
    AppMethodBeat.o(101170);
    return paramCameraPosition;
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    AppMethodBeat.i(101168);
    paramLatLng = new CameraPosition(paramLatLng, paramFloat);
    AppMethodBeat.o(101168);
    return paramLatLng;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101171);
    if (this == paramObject)
    {
      AppMethodBeat.o(101171);
      return true;
    }
    if (!(paramObject instanceof CameraPosition))
    {
      AppMethodBeat.o(101171);
      return false;
    }
    paramObject = (CameraPosition)paramObject;
    if ((getTarget().equals(paramObject.getTarget())) && (Float.floatToIntBits(getZoom()) == Float.floatToIntBits(paramObject.getZoom())))
    {
      AppMethodBeat.o(101171);
      return true;
    }
    AppMethodBeat.o(101171);
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
    AppMethodBeat.i(101167);
    int i = super.hashCode();
    AppMethodBeat.o(101167);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101172);
    String str = g.a(new String[] { g.a("target", getTarget()), g.a("zoom", Float.valueOf(getZoom())) });
    AppMethodBeat.o(101172);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101166);
    paramParcel.writeFloat((float)this.target.getLatitude());
    paramParcel.writeFloat((float)this.target.getLongitude());
    paramParcel.writeFloat(this.zoom);
    paramParcel.writeFloat(this.skew);
    paramParcel.writeFloat(this.bearing);
    AppMethodBeat.o(101166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */