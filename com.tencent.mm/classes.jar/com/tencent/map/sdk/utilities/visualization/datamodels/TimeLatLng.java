package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class TimeLatLng
  implements Parcelable
{
  public static final Parcelable.Creator<TimeLatLng> CREATOR;
  private static final int DEFAULT_TIME = 0;
  private LatLng mPoint;
  private int mTime;
  
  static
  {
    AppMethodBeat.i(211134);
    CREATOR = new Parcelable.Creator()
    {
      private static TimeLatLng a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(211132);
        paramAnonymousParcel = new TimeLatLng(paramAnonymousParcel);
        AppMethodBeat.o(211132);
        return paramAnonymousParcel;
      }
      
      private static TimeLatLng[] a(int paramAnonymousInt)
      {
        return new TimeLatLng[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(211134);
  }
  
  protected TimeLatLng(Parcel paramParcel)
  {
    AppMethodBeat.i(211114);
    this.mPoint = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.mTime = paramParcel.readInt();
    AppMethodBeat.o(211114);
  }
  
  public TimeLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 0);
  }
  
  public TimeLatLng(LatLng paramLatLng, int paramInt)
  {
    AppMethodBeat.i(211121);
    setPoint(paramLatLng);
    setTime(paramInt);
    AppMethodBeat.o(211121);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211174);
    if (!(paramObject instanceof TimeLatLng))
    {
      AppMethodBeat.o(211174);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(211174);
      return true;
    }
    if (this.mPoint != null)
    {
      if ((this.mPoint.equals(((TimeLatLng)paramObject).mPoint)) && (this.mTime == ((TimeLatLng)paramObject).mTime))
      {
        AppMethodBeat.o(211174);
        return true;
      }
      AppMethodBeat.o(211174);
      return false;
    }
    if (((TimeLatLng)paramObject).mPoint != null)
    {
      AppMethodBeat.o(211174);
      return false;
    }
    if (this.mTime == ((TimeLatLng)paramObject).mTime)
    {
      AppMethodBeat.o(211174);
      return true;
    }
    AppMethodBeat.o(211174);
    return false;
  }
  
  public LatLng getPoint()
  {
    return this.mPoint;
  }
  
  public int getTime()
  {
    return this.mTime;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(211179);
    if (this.mPoint != null)
    {
      i = this.mPoint.hashCode();
      int j = (int)(this.mTime * 1000000.0D);
      AppMethodBeat.o(211179);
      return i + j;
    }
    int i = (int)(this.mTime * 1000000.0D);
    AppMethodBeat.o(211179);
    return i;
  }
  
  public void setPoint(LatLng paramLatLng)
  {
    this.mPoint = paramLatLng;
  }
  
  public void setTime(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.mTime = paramInt;
      return;
    }
    this.mTime = 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211145);
    paramParcel.writeParcelable(this.mPoint, paramInt);
    paramParcel.writeInt(this.mTime);
    AppMethodBeat.o(211145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.visualization.datamodels.TimeLatLng
 * JD-Core Version:    0.7.0.1
 */