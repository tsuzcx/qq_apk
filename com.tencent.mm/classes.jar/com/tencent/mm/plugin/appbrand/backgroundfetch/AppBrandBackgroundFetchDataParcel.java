package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandBackgroundFetchDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundFetchDataParcel> CREATOR = new AppBrandBackgroundFetchDataParcel.1();
  public String bVk;
  public String data;
  public int fKK;
  public String path;
  public int scene;
  public long updateTime;
  public String username;
  
  public AppBrandBackgroundFetchDataParcel() {}
  
  protected AppBrandBackgroundFetchDataParcel(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.fKK = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.bVk = paramParcel.readString();
    this.data = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.updateTime = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.fKK);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.bVk);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.scene);
    paramParcel.writeLong(this.updateTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel
 * JD-Core Version:    0.7.0.1
 */