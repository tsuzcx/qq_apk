package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class AppBrandBackgroundFetchDataStorageIPC$WxappIdentity
  implements Parcelable
{
  public static final Parcelable.Creator<WxappIdentity> CREATOR = new AppBrandBackgroundFetchDataStorageIPC.WxappIdentity.1();
  public int fKK;
  public String username;
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentity() {}
  
  protected AppBrandBackgroundFetchDataStorageIPC$WxappIdentity(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.fKK = paramParcel.readInt();
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentity(String paramString, int paramInt)
  {
    this.username = paramString;
    this.fKK = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.fKK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappIdentity
 * JD-Core Version:    0.7.0.1
 */