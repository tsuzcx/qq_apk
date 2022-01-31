package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class AppBrandBackgroundFetchDataStorageIPC$WxappParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxappParams> CREATOR = new Parcelable.Creator() {};
  public String bVk;
  public String data;
  public int fKK;
  public String path;
  public int scene;
  public long time;
  public String username;
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappParams() {}
  
  protected AppBrandBackgroundFetchDataStorageIPC$WxappParams(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.fKK = paramParcel.readInt();
    this.data = paramParcel.readString();
    this.path = paramParcel.readString();
    this.bVk = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.time = paramParcel.readLong();
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappParams(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    this.username = paramString1;
    this.fKK = paramInt1;
    this.data = paramString2;
    this.path = paramString3;
    this.bVk = paramString4;
    this.scene = paramInt2;
    this.time = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.fKK);
    paramParcel.writeString(this.data);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.bVk);
    paramParcel.writeInt(this.scene);
    paramParcel.writeLong(this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappParams
 * JD-Core Version:    0.7.0.1
 */