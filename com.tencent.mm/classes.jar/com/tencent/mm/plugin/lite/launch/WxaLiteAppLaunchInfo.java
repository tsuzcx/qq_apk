package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "pkgPath", "getPkgPath", "setPkgPath", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"})
public final class WxaLiteAppLaunchInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String appId = "";
  public String ntm = "";
  public String pkgPath = "";
  public long startTime;
  
  static
  {
    AppMethodBeat.i(208205);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(208205);
  }
  
  public WxaLiteAppLaunchInfo() {}
  
  public WxaLiteAppLaunchInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(208204);
    String str = paramParcel.readString();
    k.g(str, "parcel.readString()");
    this.appId = str;
    str = paramParcel.readString();
    k.g(str, "parcel.readString()");
    this.pkgPath = str;
    this.ntm = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    AppMethodBeat.o(208204);
  }
  
  public final void ajJ(String paramString)
  {
    AppMethodBeat.i(208201);
    k.h(paramString, "<set-?>");
    this.pkgPath = paramString;
    AppMethodBeat.o(208201);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(208200);
    k.h(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(208200);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208202);
    String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
    AppMethodBeat.o(208202);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208203);
    k.h(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.ntm);
    paramParcel.writeLong(this.startTime);
    AppMethodBeat.o(208203);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"})
  public static final class a
    implements Parcelable.Creator<WxaLiteAppLaunchInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo
 * JD-Core Version:    0.7.0.1
 */