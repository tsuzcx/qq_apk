package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandGlobalSystemConfig$WeAppSyncVersionSetting
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.1();
  public long fPm = 21600L;
  public long fPn = 604800L;
  public int fPo = 1000;
  public int fPp = 100;
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting() {}
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting(Parcel paramParcel)
  {
    this.fPm = paramParcel.readLong();
    this.fPn = paramParcel.readLong();
    this.fPo = paramParcel.readInt();
    this.fPp = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.fPm);
    paramParcel.writeLong(this.fPn);
    paramParcel.writeInt(this.fPo);
    paramParcel.writeInt(this.fPp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting
 * JD-Core Version:    0.7.0.1
 */