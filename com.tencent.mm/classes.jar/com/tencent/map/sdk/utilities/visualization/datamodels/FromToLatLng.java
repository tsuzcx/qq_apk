package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class FromToLatLng
  implements Parcelable
{
  public static final Parcelable.Creator<FromToLatLng> CREATOR;
  private static final double DEFAULT_ARC = 45.0D;
  private double mArc;
  private LatLng mEndPoint;
  private LatLng mStartPoint;
  
  static
  {
    AppMethodBeat.i(211168);
    CREATOR = new Parcelable.Creator()
    {
      private static FromToLatLng a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(211127);
        paramAnonymousParcel = new FromToLatLng(paramAnonymousParcel);
        AppMethodBeat.o(211127);
        return paramAnonymousParcel;
      }
      
      private static FromToLatLng[] a(int paramAnonymousInt)
      {
        return new FromToLatLng[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(211168);
  }
  
  protected FromToLatLng(Parcel paramParcel)
  {
    AppMethodBeat.i(211133);
    this.mStartPoint = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.mEndPoint = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.mArc = paramParcel.readDouble();
    AppMethodBeat.o(211133);
  }
  
  public FromToLatLng(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(paramLatLng1, paramLatLng2, 45.0D);
  }
  
  private FromToLatLng(LatLng paramLatLng1, LatLng paramLatLng2, double paramDouble)
  {
    AppMethodBeat.i(211143);
    setPoint(paramLatLng1, paramLatLng2);
    setArc(paramDouble);
    AppMethodBeat.o(211143);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211232);
    if (!(paramObject instanceof FromToLatLng))
    {
      AppMethodBeat.o(211232);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(211232);
      return true;
    }
    if ((this.mStartPoint != null) && (this.mEndPoint != null))
    {
      if ((this.mStartPoint.equals(((FromToLatLng)paramObject).mStartPoint)) && (this.mEndPoint.equals(((FromToLatLng)paramObject).mEndPoint)) && (this.mArc == ((FromToLatLng)paramObject).mArc))
      {
        AppMethodBeat.o(211232);
        return true;
      }
      AppMethodBeat.o(211232);
      return false;
    }
    if (((FromToLatLng)paramObject).mStartPoint != null)
    {
      AppMethodBeat.o(211232);
      return false;
    }
    if (this.mArc == ((FromToLatLng)paramObject).mArc)
    {
      AppMethodBeat.o(211232);
      return true;
    }
    AppMethodBeat.o(211232);
    return false;
  }
  
  public double getArc()
  {
    return this.mArc;
  }
  
  public LatLng getEndPoint()
  {
    return this.mEndPoint;
  }
  
  public LatLng getStartPoint()
  {
    return this.mStartPoint;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(211238);
    if ((this.mStartPoint != null) && (this.mEndPoint != null))
    {
      i = this.mStartPoint.hashCode();
      int j = this.mEndPoint.hashCode();
      int k = (int)(this.mArc * 1000000.0D);
      AppMethodBeat.o(211238);
      return i + j + k;
    }
    int i = (int)(this.mArc * 1000000.0D);
    AppMethodBeat.o(211238);
    return i;
  }
  
  public void setArc(double paramDouble)
  {
    if ((paramDouble > 0.0D) && (paramDouble <= 90.0D))
    {
      this.mArc = paramDouble;
      return;
    }
    this.mArc = 45.0D;
  }
  
  public void setPoint(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.mStartPoint = paramLatLng1;
    this.mEndPoint = paramLatLng2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211185);
    paramParcel.writeParcelable(this.mStartPoint, paramInt);
    paramParcel.writeParcelable(this.mEndPoint, paramInt);
    paramParcel.writeDouble(this.mArc);
    AppMethodBeat.o(211185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng
 * JD-Core Version:    0.7.0.1
 */