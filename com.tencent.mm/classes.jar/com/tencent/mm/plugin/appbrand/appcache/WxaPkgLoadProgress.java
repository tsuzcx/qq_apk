package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.pluginsdk.g.a.c.k;

public class WxaPkgLoadProgress
  implements Parcelable, c, k
{
  public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR;
  public long gWA;
  public long gWz;
  public int progress;
  
  static
  {
    AppMethodBeat.i(59527);
    CREATOR = new WxaPkgLoadProgress.1();
    AppMethodBeat.o(59527);
  }
  
  public WxaPkgLoadProgress()
  {
    this.progress = 0;
    this.gWz = -1L;
    this.gWA = -1L;
  }
  
  public WxaPkgLoadProgress(int paramInt, long paramLong1, long paramLong2)
  {
    this.progress = 0;
    this.gWz = -1L;
    this.gWA = -1L;
    this.progress = paramInt;
    this.gWz = paramLong1;
    this.gWA = paramLong2;
  }
  
  protected WxaPkgLoadProgress(Parcel paramParcel)
  {
    AppMethodBeat.i(59524);
    this.progress = 0;
    this.gWz = -1L;
    this.gWA = -1L;
    this.progress = paramParcel.readInt();
    this.gWz = paramParcel.readLong();
    this.gWA = paramParcel.readLong();
    AppMethodBeat.o(59524);
  }
  
  public final long awb()
  {
    return this.gWz;
  }
  
  public final long awc()
  {
    return this.gWA;
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
    AppMethodBeat.i(59525);
    String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.gWz + ", totalLength=" + this.gWA + '}';
    AppMethodBeat.o(59525);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(59526);
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.gWz);
    paramParcel.writeLong(this.gWA);
    AppMethodBeat.o(59526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress
 * JD-Core Version:    0.7.0.1
 */