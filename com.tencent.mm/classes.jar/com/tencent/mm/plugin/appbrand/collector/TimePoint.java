package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint
  implements Parcelable
{
  public static final Parcelable.Creator<TimePoint> CREATOR;
  final AtomicInteger nVx;
  final AtomicLong nVy;
  final AtomicReference<TimePoint> nVz;
  String name;
  
  static
  {
    AppMethodBeat.i(146129);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146129);
  }
  
  TimePoint()
  {
    AppMethodBeat.i(146126);
    this.nVx = new AtomicInteger();
    this.nVy = new AtomicLong();
    this.nVz = new AtomicReference();
    this.name = "";
    AppMethodBeat.o(146126);
  }
  
  public TimePoint(String paramString, long paramLong)
  {
    AppMethodBeat.i(146127);
    this.nVx = new AtomicInteger();
    this.nVy = new AtomicLong();
    this.nVz = new AtomicReference();
    this.name = paramString;
    this.nVy.set(paramLong);
    AppMethodBeat.o(146127);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146128);
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.nVy.get());
    paramParcel.writeInt(this.nVx.get());
    paramParcel.writeParcelable((Parcelable)this.nVz.get(), paramInt);
    AppMethodBeat.o(146128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.TimePoint
 * JD-Core Version:    0.7.0.1
 */