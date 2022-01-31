package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class AppBrandPreloadProfiler
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR = new AppBrandPreloadProfiler.1();
  public long endTime = 9223372036854775807L;
  public long hbd = 9223372036854775807L;
  public long hbe = 9223372036854775807L;
  public long hbf = 9223372036854775807L;
  public long startTime = 9223372036854775807L;
  
  public AppBrandPreloadProfiler() {}
  
  protected AppBrandPreloadProfiler(Parcel paramParcel)
  {
    this.hbd = paramParcel.readLong();
    this.hbe = paramParcel.readLong();
    this.startTime = paramParcel.readLong();
    this.endTime = paramParcel.readLong();
    this.hbf = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    if ((this.hbd == 9223372036854775807L) || (this.hbe == 9223372036854775807L) || (this.startTime == 9223372036854775807L) || (this.endTime == 9223372036854775807L)) {
      return bk.q("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", new Object[] { Long.valueOf(this.hbd), Long.valueOf(this.hbe), Long.valueOf(this.startTime), Long.valueOf(this.endTime) });
    }
    return bk.q("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", new Object[] { Long.valueOf(this.hbe - this.hbd), Long.valueOf(this.startTime - this.hbe), Long.valueOf(this.endTime - this.startTime) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.hbd);
    paramParcel.writeLong(this.hbe);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.endTime);
    paramParcel.writeLong(this.hbf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler
 * JD-Core Version:    0.7.0.1
 */