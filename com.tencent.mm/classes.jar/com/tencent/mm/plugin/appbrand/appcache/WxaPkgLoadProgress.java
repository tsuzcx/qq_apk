package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaPkgLoadProgress
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR;
  public long nHs;
  public long nHt;
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
    this.nHs = -1L;
    this.nHt = -1L;
  }
  
  public WxaPkgLoadProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225473);
    this.progress = 0;
    this.nHs = -1L;
    this.nHt = -1L;
    this.progress = paramInt;
    this.nHs = paramLong1;
    this.nHt = paramLong2;
    if ((this.progress <= 0) && (this.nHs > 0L) && (this.nHt > 0L)) {
      this.progress = Math.max(Math.round((float)this.nHs / (float)this.nHt * 100.0F), 0);
    }
    AppMethodBeat.o(225473);
  }
  
  protected WxaPkgLoadProgress(Parcel paramParcel)
  {
    AppMethodBeat.i(90640);
    this.progress = 0;
    this.nHs = -1L;
    this.nHt = -1L;
    this.progress = paramParcel.readInt();
    this.nHs = paramParcel.readLong();
    this.nHt = paramParcel.readLong();
    AppMethodBeat.o(90640);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(90641);
    String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.nHs + ", totalLength=" + this.nHt + '}';
    AppMethodBeat.o(90641);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(90642);
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.nHs);
    paramParcel.writeLong(this.nHt);
    AppMethodBeat.o(90642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress
 * JD-Core Version:    0.7.0.1
 */