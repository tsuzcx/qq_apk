package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandGlobalSystemConfig$PackageManager
  implements Parcelable
{
  public static final Parcelable.Creator<PackageManager> CREATOR = new AppBrandGlobalSystemConfig.PackageManager.1();
  public long fPi = 86400L;
  public long fPj = 864000L;
  public long fPk = 256L;
  public int fPl = 5;
  
  public AppBrandGlobalSystemConfig$PackageManager() {}
  
  protected AppBrandGlobalSystemConfig$PackageManager(Parcel paramParcel)
  {
    this.fPi = paramParcel.readLong();
    this.fPj = paramParcel.readLong();
    this.fPk = paramParcel.readLong();
    this.fPl = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.fPi);
    paramParcel.writeLong(this.fPj);
    paramParcel.writeLong(this.fPk);
    paramParcel.writeInt(this.fPl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager
 * JD-Core Version:    0.7.0.1
 */