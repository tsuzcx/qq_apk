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
  String cIU;
  String cIV;
  String hTi;
  
  static
  {
    AppMethodBeat.i(131341);
    CREATOR = new JsApiNavigateToDevMiniProgram.DevPkgInfo.1();
    AppMethodBeat.o(131341);
  }
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo() {}
  
  JsApiNavigateToDevMiniProgram$DevPkgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(131340);
    this.appId = paramParcel.readString();
    this.cIU = paramParcel.readString();
    this.cIV = paramParcel.readString();
    this.hTi = paramParcel.readString();
    AppMethodBeat.o(131340);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131339);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cIU);
    paramParcel.writeString(this.cIV);
    paramParcel.writeString(this.hTi);
    AppMethodBeat.o(131339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo
 * JD-Core Version:    0.7.0.1
 */