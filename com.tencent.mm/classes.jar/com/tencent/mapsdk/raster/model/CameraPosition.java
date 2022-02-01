package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(87571);
    CREATOR = new Parcelable.Creator()
    {
      public final CameraPosition createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(87546);
        float f1 = paramAnonymousParcel.readFloat();
        float f2 = paramAnonymousParcel.readFloat();
        float f3 = paramAnonymousParcel.readFloat();
        float f4 = paramAnonymousParcel.readFloat();
        float f5 = paramAnonymousParcel.readFloat();
        paramAnonymousParcel = new CameraPosition(new LatLng(f1, f2), f3, f4, f5);
        AppMethodBeat.o(87546);
        return paramAnonymousParcel;
      }
      
      public final CameraPosition[] newArray(int paramAnonymousInt)
      {
        return new CameraPosition[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(87571);
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
  
  public static Builder builder()
  {
    AppMethodBeat.i(87567);
    Builder localBuilder = new Builder();
    AppMethodBeat.o(87567);
    return localBuilder;
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(87568);
    paramCameraPosition = new Builder(paramCameraPosition);
    AppMethodBeat.o(87568);
    return paramCameraPosition;
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    AppMethodBeat.i(87566);
    paramLatLng = new CameraPosition(paramLatLng, paramFloat);
    AppMethodBeat.o(87566);
    return paramLatLng;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(87569);
    if (this == paramObject)
    {
      AppMethodBeat.o(87569);
      return true;
    }
    if (!(paramObject instanceof CameraPosition))
    {
      AppMethodBeat.o(87569);
      return false;
    }
    paramObject = (CameraPosition)paramObject;
    if ((getTarget().equals(paramObject.getTarget())) && (Float.floatToIntBits(getZoom()) == Float.floatToIntBits(paramObject.getZoom())))
    {
      AppMethodBeat.o(87569);
      return true;
    }
    AppMethodBeat.o(87569);
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
    AppMethodBeat.i(87565);
    int i = super.hashCode();
    AppMethodBeat.o(87565);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87570);
    String str = "target" + this.target + "zoom" + this.zoom;
    AppMethodBeat.o(87570);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87564);
    paramParcel.writeFloat((float)this.target.getLatitude());
    paramParcel.writeFloat((float)this.target.getLongitude());
    paramParcel.writeFloat(this.zoom);
    paramParcel.writeFloat(this.skew);
    paramParcel.writeFloat(this.bearing);
    AppMethodBeat.o(87564);
  }
  
  public static final class Builder
  {
    private float bearing;
    private float skew;
    private LatLng target;
    private float zoom;
    
    public Builder()
    {
      this.zoom = -1.0F;
      this.skew = 0.0F;
      this.bearing = 0.0F;
    }
    
    public Builder(CameraPosition paramCameraPosition)
    {
      AppMethodBeat.i(87549);
      this.zoom = -1.0F;
      this.skew = 0.0F;
      this.bearing = 0.0F;
      target(paramCameraPosition.getTarget()).zoom(paramCameraPosition.getZoom());
      AppMethodBeat.o(87549);
    }
    
    public final Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }
    
    public final CameraPosition build()
    {
      AppMethodBeat.i(87550);
      CameraPosition localCameraPosition = new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
      AppMethodBeat.o(87550);
      return localCameraPosition;
    }
    
    public final Builder skew(float paramFloat)
    {
      this.skew = paramFloat;
      return this;
    }
    
    public final Builder target(LatLng paramLatLng)
    {
      this.target = paramLatLng;
      return this;
    }
    
    public final Builder zoom(float paramFloat)
    {
      this.zoom = paramFloat;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */