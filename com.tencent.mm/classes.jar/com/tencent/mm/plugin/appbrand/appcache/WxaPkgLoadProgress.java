package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.pluginsdk.j.a.c.k;

public class WxaPkgLoadProgress
  implements Parcelable, c, k
{
  public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR;
  public long kNs;
  public long kNt;
  public int progress;
  
  static
  {
    AppMethodBeat.i(90643);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(90643);
  }
  
  public WxaPkgLoadProgress()
  {
    this.progress = 0;
    this.kNs = -1L;
    this.kNt = -1L;
  }
  
  public WxaPkgLoadProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230564);
    this.progress = 0;
    this.kNs = -1L;
    this.kNt = -1L;
    this.progress = paramInt;
    this.kNs = paramLong1;
    this.kNt = paramLong2;
    if ((this.progress <= 0) && (this.kNs > 0L) && (this.kNt > 0L)) {
      this.progress = Math.max(Math.round((float)this.kNs / (float)this.kNt * 100.0F), 0);
    }
    AppMethodBeat.o(230564);
  }
  
  protected WxaPkgLoadProgress(Parcel paramParcel)
  {
    AppMethodBeat.i(90640);
    this.progress = 0;
    this.kNs = -1L;
    this.kNt = -1L;
    this.progress = paramParcel.readInt();
    this.kNs = paramParcel.readLong();
    this.kNt = paramParcel.readLong();
    AppMethodBeat.o(90640);
  }
  
  public final long bww()
  {
    return this.kNs;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final long getTotalLength()
  {
    return this.kNt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(90641);
    String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.kNs + ", totalLength=" + this.kNt + '}';
    AppMethodBeat.o(90641);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(90642);
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.kNs);
    paramParcel.writeLong(this.kNt);
    AppMethodBeat.o(90642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress
 * JD-Core Version:    0.7.0.1
 */