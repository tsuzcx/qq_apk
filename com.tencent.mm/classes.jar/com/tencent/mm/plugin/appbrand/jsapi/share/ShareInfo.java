package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareInfo> CREATOR = new ShareInfo.1();
  public String dTX;
  public String dZN;
  
  private ShareInfo(Parcel paramParcel)
  {
    this.dTX = paramParcel.readString();
    this.dZN = paramParcel.readString();
  }
  
  public ShareInfo(String paramString1, String paramString2)
  {
    this.dTX = paramString1;
    this.dZN = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dTX);
    paramParcel.writeString(this.dZN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo
 * JD-Core Version:    0.7.0.1
 */