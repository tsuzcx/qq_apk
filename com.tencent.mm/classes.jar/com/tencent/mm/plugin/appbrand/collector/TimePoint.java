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
  final AtomicInteger hgG;
  final AtomicLong hgH;
  final AtomicReference<TimePoint> hgI;
  String name;
  
  static
  {
    AppMethodBeat.i(57064);
    CREATOR = new TimePoint.1();
    AppMethodBeat.o(57064);
  }
  
  TimePoint()
  {
    AppMethodBeat.i(57061);
    this.hgG = new AtomicInteger();
    this.hgH = new AtomicLong();
    this.hgI = new AtomicReference();
    this.name = "";
    AppMethodBeat.o(57061);
  }
  
  public TimePoint(String paramString, long paramLong)
  {
    AppMethodBeat.i(57062);
    this.hgG = new AtomicInteger();
    this.hgH = new AtomicLong();
    this.hgI = new AtomicReference();
    this.name = paramString;
    this.hgH.set(paramLong);
    AppMethodBeat.o(57062);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(57063);
    paramParcel.writeString(this.name);
    paramParcel.writeLong(this.hgH.get());
    paramParcel.writeInt(this.hgG.get());
    paramParcel.writeParcelable((Parcelable)this.hgI.get(), paramInt);
    AppMethodBeat.o(57063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.TimePoint
 * JD-Core Version:    0.7.0.1
 */