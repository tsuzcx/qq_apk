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
  final AtomicInteger jaR;
  final AtomicLong jaS;
  final AtomicReference<TimePoint> jaT;
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
    this.jaR = new AtomicInteger();
    this.jaS = new AtomicLong();
    this.jaT = new AtomicReference();
    this.name = "";
    AppMethodBeat.o(146126);
  }
  
  public TimePoint(String paramString, long paramLong)
  {
    AppMethodBeat.i(146127);
    this.jaR = new AtomicInteger();
    this.jaS = new AtomicLong();
    this.jaT = new AtomicReference();
    this.name = paramString;
    this.jaS.set(paramLong);
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
    paramParcel.writeLong(this.jaS.get());
    paramParcel.writeInt(this.jaR.get());
    paramParcel.writeParcelable((Parcelable)this.jaT.get(), paramInt);
    AppMethodBeat.o(146128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.TimePoint
 * JD-Core Version:    0.7.0.1
 */