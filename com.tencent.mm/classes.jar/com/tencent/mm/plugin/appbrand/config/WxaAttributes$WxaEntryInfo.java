package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class WxaAttributes$WxaEntryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaEntryInfo> CREATOR = new Parcelable.Creator() {};
  public String fRq;
  public String iconUrl;
  public String title;
  public String username;
  
  public WxaAttributes$WxaEntryInfo() {}
  
  protected WxaAttributes$WxaEntryInfo(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.title = paramParcel.readString();
    this.fRq = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.fRq);
    paramParcel.writeString(this.iconUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo
 * JD-Core Version:    0.7.0.1
 */