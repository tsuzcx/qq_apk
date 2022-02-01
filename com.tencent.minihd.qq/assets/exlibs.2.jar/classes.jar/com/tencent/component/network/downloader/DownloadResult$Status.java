package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import cub;

public final class DownloadResult$Status
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cub();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public Throwable a = null;
  public int l = 2;
  public int m = 1;
  public int n = 0;
  public int o;
  
  public DownloadResult$Status() {}
  
  public DownloadResult$Status(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.n = paramParcel.readInt();
  }
  
  public int a()
  {
    if (b()) {
      return this.m;
    }
    return 0;
  }
  
  public Throwable a()
  {
    if (b()) {
      return this.a;
    }
    return null;
  }
  
  public final void a()
  {
    this.l = 2;
    this.m = 1;
    this.a = null;
    this.n = 0;
    this.o = 0;
  }
  
  public final void a(int paramInt)
  {
    this.l = 2;
    this.m = paramInt;
  }
  
  public final void a(Throwable paramThrowable)
  {
    this.l = 2;
    this.m = 4;
    this.a = paramThrowable;
    this.n = ImageDownloadReporter.a(this.a, 0);
  }
  
  public boolean a()
  {
    return this.l == 1;
  }
  
  public final void b()
  {
    this.l = 1;
  }
  
  public boolean b()
  {
    return this.l == 2;
  }
  
  public final boolean c()
  {
    return this.l == 3;
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
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Status
 * JD-Core Version:    0.7.0.1
 */