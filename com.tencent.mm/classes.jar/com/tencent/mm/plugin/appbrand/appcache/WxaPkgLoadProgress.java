package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.pluginsdk.h.a.c.k;

public class WxaPkgLoadProgress
  implements Parcelable, c, k
{
  public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR;
  public long jow;
  public long jox;
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
    this.jow = -1L;
    this.jox = -1L;
  }
  
  public WxaPkgLoadProgress(int paramInt, long paramLong1, long paramLong2)
  {
    this.progress = 0;
    this.jow = -1L;
    this.jox = -1L;
    this.progress = paramInt;
    this.jow = paramLong1;
    this.jox = paramLong2;
  }
  
  protected WxaPkgLoadProgress(Parcel paramParcel)
  {
    AppMethodBeat.i(90640);
    this.progress = 0;
    this.jow = -1L;
    this.jox = -1L;
    this.progress = paramParcel.readInt();
    this.jow = paramParcel.readLong();
    this.jox = paramParcel.readLong();
    AppMethodBeat.o(90640);
  }
  
  public final long aXl()
  {
    return this.jow;
  }
  
  public final long aXm()
  {
    return this.jox;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public String toString()
  {
    AppMethodBeat.i(90641);
    String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.jow + ", totalLength=" + this.jox + '}';
    AppMethodBeat.o(90641);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(90642);
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.jow);
    paramParcel.writeLong(this.jox);
    AppMethodBeat.o(90642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress
 * JD-Core Version:    0.7.0.1
 */