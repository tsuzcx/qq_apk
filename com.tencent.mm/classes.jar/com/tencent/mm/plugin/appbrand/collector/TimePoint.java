package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint
  implements Parcelable
{
  public static final Parcelable.Creator<TimePoint> CREATOR = new TimePoint.1();
  final AtomicInteger fNw = new AtomicInteger();
  final AtomicLong fNx = new AtomicLong();
  final AtomicReference<TimePoint> fNy = new AtomicReference();
  String name;
  
  TimePoint()
  {
    this.name = "";
  }
  
  public TimePoint(String paramString, long paramLong)
  {
    this.name = paramString;
    this.fNx.set(paramLong);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.fNx.get());
    paramParcel.writeInt(this.fNw.get());
    paramParcel.writeParcelable((Parcelable)this.fNy.get(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.TimePoint
 * JD-Core Version:    0.7.0.1
 */