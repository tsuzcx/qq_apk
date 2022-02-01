package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "Landroid/os/Parcelable;", "iconResId", "", "thumbUrl", "desc", "enterPath", "verifyInfo", "activityId", "appId", "appUsername", "versionType", "", "version", "appName", "appIconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getAppIconUrl", "getAppId", "getAppName", "getAppUsername", "getDesc", "getEnterPath", "getIconResId", "getThumbUrl", "getVerifyInfo", "getVersion", "()I", "getVersionType", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class SetTextStatusParams
  implements Parcelable
{
  public static final Parcelable.Creator<SetTextStatusParams> CREATOR;
  final String appId;
  final String appName;
  final String desc;
  final int euz;
  final String hzv;
  final String phA;
  final String qAF;
  final String rBI;
  final String rBJ;
  final String thumbUrl;
  final String verifyInfo;
  final int version;
  
  static
  {
    AppMethodBeat.i(325741);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(325741);
  }
  
  public SetTextStatusParams()
  {
    this(null, null, null, null, null, null, null, null, 0, 0, null, null, 4095);
  }
  
  public SetTextStatusParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(325737);
    this.rBI = paramString1;
    this.thumbUrl = paramString2;
    this.desc = paramString3;
    this.qAF = paramString4;
    this.verifyInfo = paramString5;
    this.rBJ = paramString6;
    this.appId = paramString7;
    this.hzv = paramString8;
    this.euz = paramInt1;
    this.version = paramInt2;
    this.appName = paramString9;
    this.phA = paramString10;
    AppMethodBeat.o(325737);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(325744);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SetTextStatusParams(iconResId='").append(this.rBI).append("', thumbUrl='").append(this.thumbUrl).append("', desc='").append(this.desc).append("', enterPath='").append(this.qAF).append("', verifyInfo='").append(this.verifyInfo).append("', activityId='").append(this.rBJ).append("', appId='").append(this.appId).append("', appUsername='").append(this.hzv).append("', versionType=").append(this.euz).append(", version=").append(this.version).append(", appName='").append(this.appName).append("', appIconUrl='");
    ((StringBuilder)localObject).append(this.phA).append("')");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(325744);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325748);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.rBI);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.qAF);
    paramParcel.writeString(this.verifyInfo);
    paramParcel.writeString(this.rBJ);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hzv);
    paramParcel.writeInt(this.euz);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.phA);
    AppMethodBeat.o(325748);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<SetTextStatusParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.SetTextStatusParams
 * JD-Core Version:    0.7.0.1
 */