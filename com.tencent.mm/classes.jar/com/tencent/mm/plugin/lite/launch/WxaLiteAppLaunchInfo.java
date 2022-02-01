package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "pkgPath", "getPkgPath", "setPkgPath", "query", "getQuery", "setQuery", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"})
public final class WxaLiteAppLaunchInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String appId = "";
  public String nZO = "";
  public String path = "";
  public String pkgPath = "";
  public String query = "";
  public long startTime;
  
  static
  {
    AppMethodBeat.i(212467);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(212467);
  }
  
  public WxaLiteAppLaunchInfo() {}
  
  public WxaLiteAppLaunchInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(212466);
    String str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.appId = str;
    str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.pkgPath = str;
    this.nZO = paramParcel.readString();
    str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.path = str;
    str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.query = str;
    this.startTime = paramParcel.readLong();
    AppMethodBeat.o(212466);
  }
  
  public final void apA(String paramString)
  {
    AppMethodBeat.i(212463);
    p.h(paramString, "<set-?>");
    this.query = paramString;
    AppMethodBeat.o(212463);
  }
  
  public final void apz(String paramString)
  {
    AppMethodBeat.i(212461);
    p.h(paramString, "<set-?>");
    this.pkgPath = paramString;
    AppMethodBeat.o(212461);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(212460);
    p.h(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(212460);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(212462);
    p.h(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(212462);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212464);
    String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
    AppMethodBeat.o(212464);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(212465);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.nZO);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.query);
    paramParcel.writeLong(this.startTime);
    AppMethodBeat.o(212465);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"})
  public static final class a
    implements Parcelable.Creator<WxaLiteAppLaunchInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo
 * JD-Core Version:    0.7.0.1
 */