package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.x;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR;
  public long endTime;
  public int level;
  public long qRk;
  public int qRl;
  public String qRm;
  public String qRn;
  public long qRo;
  public long qRp;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.qRk = 9223372036854775807L;
    this.qRl = 0;
    this.qRo = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.qRp = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.qRk = 9223372036854775807L;
    this.qRl = 0;
    this.qRo = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.qRp = 9223372036854775807L;
    this.qRk = paramParcel.readLong();
    this.qRo = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.qRp = paramParcel.readLong();
    this.qRm = paramParcel.readString();
    this.qRn = paramParcel.readString();
    AppMethodBeat.o(48365);
  }
  
  static void y(a<x> parama)
  {
    AppMethodBeat.i(275435);
    parama.invoke();
    AppMethodBeat.o(275435);
  }
  
  public final long ciU()
  {
    AppMethodBeat.i(275432);
    long l = SystemClock.elapsedRealtime();
    this.qRk = l;
    AppMethodBeat.o(275432);
    return l;
  }
  
  public final long ciV()
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
    if ((this.qRk == 9223372036854775807L) || (this.qRo == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = Util.safeFormatString("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.qRk), Long.valueOf(this.qRo), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = Util.safeFormatString("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.qRo - this.qRk), Long.valueOf(this.startTime - this.qRo), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.qRk);
    paramParcel.writeLong(this.qRo);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.qRp);
    paramParcel.writeString(this.qRm);
    paramParcel.writeString(this.qRn);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */