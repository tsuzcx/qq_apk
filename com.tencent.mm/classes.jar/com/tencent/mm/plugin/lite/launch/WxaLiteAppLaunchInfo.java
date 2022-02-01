package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "pkgPath", "getPkgPath", "setPkgPath", "qrUrlQueryStr", "getQrUrlQueryStr", "setQrUrlQueryStr", "query", "getQuery", "setQuery", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaLiteAppLaunchInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String KaF = "";
  public String appId = "";
  public String egI = "";
  public String path = "";
  public String pkgPath = "";
  public String query = "";
  public long startTime;
  
  static
  {
    AppMethodBeat.i(271315);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(271315);
  }
  
  public WxaLiteAppLaunchInfo() {}
  
  public WxaLiteAppLaunchInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(271308);
    String str = paramParcel.readString();
    if (str != null) {}
    for (;;)
    {
      this.appId = str;
      this.pkgPath = paramParcel.readString();
      this.egI = paramParcel.readString();
      this.path = paramParcel.readString();
      this.query = paramParcel.readString();
      this.KaF = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      AppMethodBeat.o(271308);
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
    AppMethodBeat.i(271320);
    s.u(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(271320);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(271326);
    String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
    AppMethodBeat.o(271326);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(271330);
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.egI);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.KaF);
    paramParcel.writeLong(this.startTime);
    AppMethodBeat.o(271330);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WxaLiteAppLaunchInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo
 * JD-Core Version:    0.7.0.1
 */