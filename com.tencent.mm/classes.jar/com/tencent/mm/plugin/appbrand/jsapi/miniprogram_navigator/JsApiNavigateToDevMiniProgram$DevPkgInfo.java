package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiNavigateToDevMiniProgram$DevPkgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DevPkgInfo> CREATOR = new JsApiNavigateToDevMiniProgram.DevPkgInfo.1();
  String appId;
  String cav;
  String caw;
  String gwV;
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo() {}
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.cav = paramParcel.readString();
    this.caw = paramParcel.readString();
    this.gwV = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cav);
    paramParcel.writeString(this.caw);
    paramParcel.writeString(this.gwV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo
 * JD-Core Version:    0.7.0.1
 */