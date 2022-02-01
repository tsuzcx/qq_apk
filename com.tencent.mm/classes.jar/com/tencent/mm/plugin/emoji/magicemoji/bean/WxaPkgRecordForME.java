package com.tencent.mm.plugin.emoji.magicemoji.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "pkgPath", "version", "", "versionMD5", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPkgPath", "getVersion", "()I", "getVersionMD5", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaPkgRecordForME
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgRecordForME> CREATOR;
  public static final a xIe;
  private final String appId;
  public final String pkgPath;
  public final int version;
  public final String xIf;
  
  static
  {
    AppMethodBeat.i(270008);
    xIe = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(270008);
  }
  
  private WxaPkgRecordForME(Parcel paramParcel)
  {
    this(str1, str2, i, paramParcel);
    AppMethodBeat.i(269976);
    AppMethodBeat.o(269976);
  }
  
  public WxaPkgRecordForME(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(269961);
    this.appId = paramString1;
    this.pkgPath = paramString2;
    this.version = paramInt;
    this.xIf = paramString3;
    AppMethodBeat.o(269961);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(270044);
    String str = "appId=" + this.appId + ", pkgPath=" + this.pkgPath + ", version=" + this.version + ", MD5=" + this.xIf;
    AppMethodBeat.o(270044);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(270023);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.xIf);
    AppMethodBeat.o(270023);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "create", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static WxaPkgRecordForME i(bh parambh)
    {
      AppMethodBeat.i(269957);
      s.u(parambh, "record");
      String str1 = parambh.field_appId;
      s.s(str1, "record.field_appId");
      String str2 = parambh.field_pkgPath;
      s.s(str2, "record.field_pkgPath");
      int i = parambh.field_version;
      parambh = parambh.field_versionMd5;
      s.s(parambh, "record.field_versionMd5");
      parambh = new WxaPkgRecordForME(str1, str2, i, parambh);
      AppMethodBeat.o(269957);
      return parambh;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WxaPkgRecordForME>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME
 * JD-Core Version:    0.7.0.1
 */