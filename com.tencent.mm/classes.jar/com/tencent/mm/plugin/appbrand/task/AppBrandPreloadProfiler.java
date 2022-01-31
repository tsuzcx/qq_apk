package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public long iJW;
  public long iJX;
  public long iJY;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(132787);
    CREATOR = new AppBrandPreloadProfiler.1();
    AppMethodBeat.o(132787);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.iJW = 9223372036854775807L;
    this.iJX = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.iJY = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(132786);
    this.iJW = 9223372036854775807L;
    this.iJX = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.iJY = 9223372036854775807L;
    this.iJW = paramParcel.readLong();
    this.iJX = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.iJY = paramParcel.readLong();
    AppMethodBeat.o(132786);
  }
  
  public final long aLG()
  {
    AppMethodBeat.i(132783);
    long l = SystemClock.elapsedRealtime();
    this.endTime = l;
    AppMethodBeat.o(132783);
    return l;
  }
  
  public final long aLH()
  {
    if ((this.iJY == 9223372036854775807L) || (this.endTime == 9223372036854775807L)) {
      return 0L;
    }
    return this.endTime - this.iJY;
  }
  
  public final long aLI()
  {
    if ((this.endTime == 9223372036854775807L) || (this.iJW == 9223372036854775807L)) {
      return 0L;
    }
    return this.endTime - this.iJW;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(132784);
    if ((this.iJW == 9223372036854775807L) || (this.iJX == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = bo.p("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.iJW), Long.valueOf(this.iJX), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(132784);
      return str;
    }
    String str = bo.p("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.iJX - this.iJW), Long.valueOf(this.startTime - this.iJX), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(132784);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132785);
    paramParcel.writeLong(this.iJW);
    paramParcel.writeLong(this.iJX);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.iJY);
    AppMethodBeat.o(132785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */