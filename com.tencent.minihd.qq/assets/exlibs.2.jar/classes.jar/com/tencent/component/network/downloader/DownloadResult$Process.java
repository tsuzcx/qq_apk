package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cua;

public final class DownloadResult$Process
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cua();
  public long a;
  public long b;
  public long c;
  
  DownloadResult$Process() {}
  
  public DownloadResult$Process(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.a = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
  }
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = (paramLong2 - paramLong1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Process
 * JD-Core Version:    0.7.0.1
 */