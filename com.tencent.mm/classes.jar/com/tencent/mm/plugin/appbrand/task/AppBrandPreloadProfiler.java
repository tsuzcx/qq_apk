package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.y;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public int level;
  public long lvA;
  public int lvB;
  public long lvC;
  public long lvD;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.lvA = 9223372036854775807L;
    this.lvB = 0;
    this.lvC = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.lvD = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.lvA = 9223372036854775807L;
    this.lvB = 0;
    this.lvC = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.lvD = 9223372036854775807L;
    this.lvA = paramParcel.readLong();
    this.lvC = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.lvD = paramParcel.readLong();
    AppMethodBeat.o(48365);
  }
  
  static void p(a<y> parama)
  {
    AppMethodBeat.i(196113);
    parama.invoke();
    AppMethodBeat.o(196113);
  }
  
  public final long bno()
  {
    AppMethodBeat.i(196112);
    long l = SystemClock.elapsedRealtime();
    this.lvA = l;
    AppMethodBeat.o(196112);
    return l;
  }
  
  public final long bnp()
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
    if ((this.lvA == 9223372036854775807L) || (this.lvC == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = bt.u("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.lvA), Long.valueOf(this.lvC), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = bt.u("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.lvC - this.lvA), Long.valueOf(this.startTime - this.lvC), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.lvA);
    paramParcel.writeLong(this.lvC);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.lvD);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */