package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId
  implements Parcelable
{
  public static final Parcelable.Creator<WxappIdentityWithAppId> CREATOR = new Parcelable.Creator() {};
  public String bOL;
  public int fKK;
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId() {}
  
  protected AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId(Parcel paramParcel)
  {
    this.bOL = paramParcel.readString();
    this.fKK = paramParcel.readInt();
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId(String paramString, int paramInt)
  {
    this.bOL = paramString;
    this.fKK = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bOL);
    paramParcel.writeInt(this.fKK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId
 * JD-Core Version:    0.7.0.1
 */