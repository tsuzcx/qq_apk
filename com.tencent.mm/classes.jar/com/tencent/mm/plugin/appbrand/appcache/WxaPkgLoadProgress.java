package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.pluginsdk.g.a.c.k;

public class WxaPkgLoadProgress
  extends k
  implements Parcelable, d
{
  public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR = new WxaPkgLoadProgress.1();
  public long fEj = -1L;
  public long fEk = -1L;
  public int progress = 0;
  
  public WxaPkgLoadProgress() {}
  
  public WxaPkgLoadProgress(int paramInt, long paramLong1, long paramLong2)
  {
    this.progress = paramInt;
    this.fEj = paramLong1;
    this.fEk = paramLong2;
  }
  
  protected WxaPkgLoadProgress(Parcel paramParcel)
  {
    this.progress = paramParcel.readInt();
    this.fEj = paramParcel.readLong();
    this.fEk = paramParcel.readLong();
  }
  
  public final long acl()
  {
    return this.fEj;
  }
  
  public final long acm()
  {
    return this.fEk;
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
    return "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.fEj + ", totalLength=" + this.fEk + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.progress);
    paramParcel.writeLong(this.fEj);
    paramParcel.writeLong(this.fEk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress
 * JD-Core Version:    0.7.0.1
 */