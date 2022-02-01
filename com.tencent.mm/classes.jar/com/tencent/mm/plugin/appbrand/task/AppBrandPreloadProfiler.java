package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.y;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public long lXu;
  public int lXv;
  public long lXw;
  public long lXx;
  public int level;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.lXu = 9223372036854775807L;
    this.lXv = 0;
    this.lXw = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.lXx = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.lXu = 9223372036854775807L;
    this.lXv = 0;
    this.lXw = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.lXx = 9223372036854775807L;
    this.lXu = paramParcel.readLong();
    this.lXw = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.lXx = paramParcel.readLong();
    AppMethodBeat.o(48365);
  }
  
  static void t(a<y> parama)
  {
    AppMethodBeat.i(186957);
    parama.invoke();
    AppMethodBeat.o(186957);
  }
  
  public final long buk()
  {
    AppMethodBeat.i(186956);
    long l = SystemClock.elapsedRealtime();
    this.lXu = l;
    AppMethodBeat.o(186956);
    return l;
  }
  
  public final long bul()
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
    if ((this.lXu == 9223372036854775807L) || (this.lXw == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = bs.u("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.lXu), Long.valueOf(this.lXw), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = bs.u("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.lXw - this.lXu), Long.valueOf(this.startTime - this.lXw), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.lXu);
    paramParcel.writeLong(this.lXw);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.lXx);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */