package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiNavigateToDevMiniProgram$DevPkgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DevPkgInfo> CREATOR;
  String appId;
  String fWS;
  String fWT;
  String pcT;
  
  static
  {
    AppMethodBeat.i(46626);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46626);
  }
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo() {}
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46625);
    this.appId = paramParcel.readString();
    this.fWS = paramParcel.readString();
    this.fWT = paramParcel.readString();
    this.pcT = paramParcel.readString();
    AppMethodBeat.o(46625);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280751);
    String str = "DevPkgInfo{appId='" + this.appId + '\'' + ", downloadURL='" + this.fWS + '\'' + ", checkSumMd5='" + this.fWT + '\'' + ", extoptions='" + this.pcT + '\'' + '}';
    AppMethodBeat.o(280751);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46624);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fWS);
    paramParcel.writeString(this.fWT);
    paramParcel.writeString(this.pcT);
    AppMethodBeat.o(46624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo
 * JD-Core Version:    0.7.0.1
 */