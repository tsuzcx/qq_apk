package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class ScatterLatLng
  implements Parcelable
{
  public static final Parcelable.Creator<ScatterLatLng> CREATOR;
  private static final double DEFAULT_INTENSITY = 1.0D;
  private static final int DEFAULT_TYPE = 0;
  private double mIntensity;
  private LatLng mPoint;
  private int mType;
  
  static
  {
    AppMethodBeat.i(211150);
    CREATOR = new Parcelable.Creator()
    {
      private static ScatterLatLng a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(211117);
        paramAnonymousParcel = new ScatterLatLng(paramAnonymousParcel);
        AppMethodBeat.o(211117);
        return paramAnonymousParcel;
      }
      
      private static ScatterLatLng[] a(int paramAnonymousInt)
      {
        return new ScatterLatLng[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(211150);
  }
  
  protected ScatterLatLng(Parcel paramParcel)
  {
    AppMethodBeat.i(211112);
    this.mPoint = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.mType = paramParcel.readInt();
    this.mIntensity = paramParcel.readDouble();
    AppMethodBeat.o(211112);
  }
  
  public ScatterLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 0, 1.0D);
  }
  
  public ScatterLatLng(LatLng paramLatLng, double paramDouble)
  {
    AppMethodBeat.i(211128);
    setPoint(paramLatLng);
    setType(0);
    setIntensity(paramDouble);
    AppMethodBeat.o(211128);
  }
  
  public ScatterLatLng(LatLng paramLatLng, int paramInt)
  {
    AppMethodBeat.i(211120);
    setPoint(paramLatLng);
    setType(paramInt);
    setIntensity(1.0D);
    AppMethodBeat.o(211120);
  }
  
  public ScatterLatLng(LatLng paramLatLng, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(211135);
    setPoint(paramLatLng);
    setType(paramInt);
    setIntensity(paramDouble);
    AppMethodBeat.o(211135);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211199);
    if (!(paramObject instanceof ScatterLatLng))
    {
      AppMethodBeat.o(211199);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(211199);
      return true;
    }
    if (this.mPoint != null)
    {
      if ((this.mPoint.equals(((ScatterLatLng)paramObject).mPoint)) && (this.mType == ((ScatterLatLng)paramObject).mType) && (this.mIntensity == ((ScatterLatLng)paramObject).mIntensity))
      {
        AppMethodBeat.o(211199);
        return true;
      }
      AppMethodBeat.o(211199);
      return false;
    }
    if (((ScatterLatLng)paramObject).mPoint != null)
    {
      AppMethodBeat.o(211199);
      return false;
    }
    if ((this.mType == ((ScatterLatLng)paramObject).mType) && (this.mIntensity == ((ScatterLatLng)paramObject).mIntensity))
    {
      AppMethodBeat.o(211199);
      return true;
    }
    AppMethodBeat.o(211199);
    return false;
  }
  
  public double getIntensity()
  {
    return this.mIntensity;
  }
  
  public LatLng getPoint()
  {
    return this.mPoint;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(211206);
    if (this.mPoint != null)
    {
      i = this.mPoint.hashCode();
      j = (int)(this.mType * 1000000.0D);
      int k = (int)(this.mIntensity * 1000000.0D);
      AppMethodBeat.o(211206);
      return i + j + k;
    }
    int i = (int)(this.mType * 1000000.0D);
    int j = (int)(this.mIntensity * 1000000.0D);
    AppMethodBeat.o(211206);
    return i + j;
  }
  
  public void setIntensity(double paramDouble)
  {
    this.mIntensity = paramDouble;
  }
  
  public void setPoint(LatLng paramLatLng)
  {
    this.mPoint = paramLatLng;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211161);
    paramParcel.writeParcelable(this.mPoint, paramInt);
    paramParcel.writeInt(this.mType);
    paramParcel.writeDouble(this.mIntensity);
    AppMethodBeat.o(211161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng
 * JD-Core Version:    0.7.0.1
 */