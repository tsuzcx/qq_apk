package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.z;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public int level;
  public long mxj;
  public int mxk;
  public long mxl;
  public long mxm;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.mxj = 9223372036854775807L;
    this.mxk = 0;
    this.mxl = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.mxm = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.mxj = 9223372036854775807L;
    this.mxk = 0;
    this.mxl = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.mxm = 9223372036854775807L;
    this.mxj = paramParcel.readLong();
    this.mxl = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.mxm = paramParcel.readLong();
    AppMethodBeat.o(48365);
  }
  
  static void v(a<z> parama)
  {
    AppMethodBeat.i(188760);
    parama.invoke();
    AppMethodBeat.o(188760);
  }
  
  public final long byp()
  {
    AppMethodBeat.i(188759);
    long l = SystemClock.elapsedRealtime();
    this.mxj = l;
    AppMethodBeat.o(188759);
    return l;
  }
  
  public final long byq()
  {
    AppMethodBeat.i(48362);
    long l = SystemClock.elapsedRealtime();
    this.endTime = l;
    AppMethodBeat.o(48362);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(48363);
    if ((this.mxj == 9223372036854775807L) || (this.mxl == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = bt.x("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.mxj), Long.valueOf(this.mxl), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = bt.x("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.mxl - this.mxj), Long.valueOf(this.startTime - this.mxl), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.mxj);
    paramParcel.writeLong(this.mxl);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.mxm);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */