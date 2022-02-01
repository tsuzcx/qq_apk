package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.a;
import d.z;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public int level;
  public long mCg;
  public int mCh;
  public long mCi;
  public long mCj;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.mCg = 9223372036854775807L;
    this.mCh = 0;
    this.mCi = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.mCj = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.mCg = 9223372036854775807L;
    this.mCh = 0;
    this.mCi = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.mCj = 9223372036854775807L;
    this.mCg = paramParcel.readLong();
    this.mCi = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.mCj = paramParcel.readLong();
    AppMethodBeat.o(48365);
  }
  
  static void w(a<z> parama)
  {
    AppMethodBeat.i(222979);
    parama.invoke();
    AppMethodBeat.o(222979);
  }
  
  public final long bzi()
  {
    AppMethodBeat.i(222978);
    long l = SystemClock.elapsedRealtime();
    this.mCg = l;
    AppMethodBeat.o(222978);
    return l;
  }
  
  public final long bzj()
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
    if ((this.mCg == 9223372036854775807L) || (this.mCi == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = bu.x("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.mCg), Long.valueOf(this.mCi), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = bu.x("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.mCi - this.mCg), Long.valueOf(this.startTime - this.mCi), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.mCg);
    paramParcel.writeLong(this.mCi);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.mCj);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */