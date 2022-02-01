package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgParam;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaPkgDownloaderExportServiceIPC$DownloadPkgParam
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadPkgParam> CREATOR;
  final String appId;
  final int euz;
  
  static
  {
    AppMethodBeat.i(320563);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(320563);
  }
  
  public WxaPkgDownloaderExportServiceIPC$DownloadPkgParam(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.euz = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(320590);
    if (this == paramObject)
    {
      AppMethodBeat.o(320590);
      return true;
    }
    if (!(paramObject instanceof DownloadPkgParam))
    {
      AppMethodBeat.o(320590);
      return false;
    }
    paramObject = (DownloadPkgParam)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(320590);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(320590);
      return false;
    }
    AppMethodBeat.o(320590);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(320583);
    if (this.appId == null) {}
    for (int i = 0;; i = this.appId.hashCode())
    {
      int j = this.euz;
      AppMethodBeat.o(320583);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320573);
    String str = "DownloadPkgParam(appId=" + this.appId + ", versionType=" + this.euz + ')';
    AppMethodBeat.o(320573);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320597);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    AppMethodBeat.o(320597);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WxaPkgDownloaderExportServiceIPC.DownloadPkgParam>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgParam
 * JD-Core Version:    0.7.0.1
 */