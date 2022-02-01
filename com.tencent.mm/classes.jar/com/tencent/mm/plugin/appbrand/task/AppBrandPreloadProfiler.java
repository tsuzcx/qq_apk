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
  public long nOC;
  public int nOD;
  public long nOE;
  public long nOF;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(48366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48366);
  }
  
  public AppBrandPreloadProfiler()
  {
    this.nOC = 9223372036854775807L;
    this.nOD = 0;
    this.nOE = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.nOF = 9223372036854775807L;
  }
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    AppMethodBeat.i(48365);
    this.nOC = 9223372036854775807L;
    this.nOD = 0;
    this.nOE = 9223372036854775807L;
    this.startTime = 9223372036854775807L;
    this.endTime = 9223372036854775807L;
    this.nOF = 9223372036854775807L;
    this.nOC = paramParcel.readLong();
    this.nOE = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.nOF = paramParcel.readLong();
    AppMethodBeat.o(48365);
  }
  
  static void A(a<x> parama)
  {
    AppMethodBeat.i(227439);
    parama.invoke();
    AppMethodBeat.o(227439);
  }
  
  public final long bVM()
  {
    AppMethodBeat.i(227438);
    long l = SystemClock.elapsedRealtime();
    this.nOC = l;
    AppMethodBeat.o(227438);
    return l;
  }
  
  public final long bVN()
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
    if ((this.nOC == 9223372036854775807L) || (this.nOE == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L))
    {
      str = Util.safeFormatString("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.nOC), Long.valueOf(this.nOE), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
      AppMethodBeat.o(48363);
      return str;
    }
    String str = Util.safeFormatString("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.nOE - this.nOC), Long.valueOf(this.startTime - this.nOE), Long.valueOf(this.endTime - this.startTime) });
    AppMethodBeat.o(48363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48364);
    paramParcel.writeLong(this.nOC);
    paramParcel.writeLong(this.nOE);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.nOF);
    AppMethodBeat.o(48364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */