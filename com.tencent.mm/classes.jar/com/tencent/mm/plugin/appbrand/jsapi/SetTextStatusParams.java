package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "Landroid/os/Parcelable;", "iconResId", "", "thumbUrl", "desc", "enterPath", "verifyInfo", "activityId", "appId", "appUsername", "versionType", "", "version", "appName", "appIconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getAppIconUrl", "getAppId", "getAppName", "getAppUsername", "getDesc", "getEnterPath", "getIconResId", "getThumbUrl", "getVerifyInfo", "getVersion", "()I", "getVersionType", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class SetTextStatusParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final String appId;
  final String appName;
  final int cBU;
  final String desc;
  final String fvb;
  final String mnM;
  final String nBq;
  final String oyl;
  final String oym;
  final String thumbUrl;
  final String verifyInfo;
  final int version;
  
  static
  {
    AppMethodBeat.i(269725);
    CREATOR = new a();
    AppMethodBeat.o(269725);
  }
  
  public SetTextStatusParams()
  {
    this(null, null, null, null, null, null, null, null, 0, 0, null, null, 4095);
  }
  
  public SetTextStatusParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9, String paramString10)
  {
    AppMethodBeat.i(269722);
    this.oyl = paramString1;
    this.thumbUrl = paramString2;
    this.desc = paramString3;
    this.nBq = paramString4;
    this.verifyInfo = paramString5;
    this.oym = paramString6;
    this.appId = paramString7;
    this.fvb = paramString8;
    this.cBU = paramInt1;
    this.version = paramInt2;
    this.appName = paramString9;
    this.mnM = paramString10;
    AppMethodBeat.o(269722);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269721);
    String str = "SetTextStatusParams(iconResId='" + this.oyl + "', thumbUrl='" + this.thumbUrl + "', desc='" + this.desc + "', enterPath='" + this.nBq + "', verifyInfo='" + this.verifyInfo + "', activityId='" + this.oym + "', appId='" + this.appId + "', appUsername='" + this.fvb + "', versionType=" + this.cBU + ", version=" + this.version + ", appName='" + this.appName + "', appIconUrl='" + this.mnM + "')";
    AppMethodBeat.o(269721);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269724);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.oyl);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.nBq);
    paramParcel.writeString(this.verifyInfo);
    paramParcel.writeString(this.oym);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fvb);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.mnM);
    AppMethodBeat.o(269724);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(269919);
      p.k(paramParcel, "in");
      paramParcel = new SetTextStatusParams(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(269919);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new SetTextStatusParams[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.SetTextStatusParams
 * JD-Core Version:    0.7.0.1
 */