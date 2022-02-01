package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "pkgPath", "getPkgPath", "setPkgPath", "qrUrlQueryStr", "getQrUrlQueryStr", "setQrUrlQueryStr", "query", "getQuery", "setQuery", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"})
public final class WxaLiteAppLaunchInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String appId = "";
  public String crh = "";
  public String path = "";
  public String pkgPath = "";
  public String query = "";
  public long startTime;
  public String yEx = "";
  
  static
  {
    AppMethodBeat.i(198973);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(198973);
  }
  
  public WxaLiteAppLaunchInfo() {}
  
  public WxaLiteAppLaunchInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(198972);
    String str = paramParcel.readString();
    if (str != null) {}
    for (;;)
    {
      this.appId = str;
      this.pkgPath = paramParcel.readString();
      this.crh = paramParcel.readString();
      this.path = paramParcel.readString();
      this.query = paramParcel.readString();
      this.yEx = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      AppMethodBeat.o(198972);
      return;
      str = "";
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(198969);
    p.h(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(198969);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198970);
    String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
    AppMethodBeat.o(198970);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(198971);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.crh);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.yEx);
    paramParcel.writeLong(this.startTime);
    AppMethodBeat.o(198971);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"})
  public static final class a
    implements Parcelable.Creator<WxaLiteAppLaunchInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo
 * JD-Core Version:    0.7.0.1
 */