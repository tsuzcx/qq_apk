package com.tencent.mm.plugin.lite.launch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "pkgPath", "getPkgPath", "setPkgPath", "signatureKey", "getSignatureKey", "setSignatureKey", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-lite-app_release"})
public final class WxaLiteAppLaunchInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String appId = "";
  public String nUi = "";
  public String pkgPath = "";
  public long startTime;
  
  static
  {
    AppMethodBeat.i(214589);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(214589);
  }
  
  public WxaLiteAppLaunchInfo() {}
  
  public WxaLiteAppLaunchInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(214588);
    String str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.appId = str;
    str = paramParcel.readString();
    p.g(str, "parcel.readString()");
    this.pkgPath = str;
    this.nUi = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    AppMethodBeat.o(214588);
  }
  
  public final void aow(String paramString)
  {
    AppMethodBeat.i(214585);
    p.h(paramString, "<set-?>");
    this.pkgPath = paramString;
    AppMethodBeat.o(214585);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(214584);
    p.h(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(214584);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214586);
    String str = "appId:" + this.appId + " \n pkgPath: " + this.pkgPath + " signatureKey :xxx";
    AppMethodBeat.o(214586);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(214587);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.nUi);
    paramParcel.writeLong(this.startTime);
    AppMethodBeat.o(214587);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/lite/launch/WxaLiteAppLaunchInfo;", "luggage-lite-app_release"})
  public static final class a
    implements Parcelable.Creator<WxaLiteAppLaunchInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo
 * JD-Core Version:    0.7.0.1
 */