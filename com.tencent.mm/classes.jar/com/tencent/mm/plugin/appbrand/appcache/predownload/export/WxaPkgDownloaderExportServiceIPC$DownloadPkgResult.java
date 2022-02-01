package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "Landroid/os/Parcelable;", "isSuccess", "", "recordContentValues", "Landroid/content/ContentValues;", "filePath", "", "errCode", "", "errMsg", "(ZLandroid/content/ContentValues;Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getFilePath", "()Z", "getRecordContentValues", "()Landroid/content/ContentValues;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaPkgDownloaderExportServiceIPC$DownloadPkgResult
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadPkgResult> CREATOR;
  final int errCode;
  final String errMsg;
  final String filePath;
  final boolean isSuccess;
  final ContentValues qJP;
  
  static
  {
    AppMethodBeat.i(320607);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(320607);
  }
  
  public WxaPkgDownloaderExportServiceIPC$DownloadPkgResult(boolean paramBoolean, ContentValues paramContentValues, String paramString1, int paramInt, String paramString2)
  {
    this.isSuccess = paramBoolean;
    this.qJP = paramContentValues;
    this.filePath = paramString1;
    this.errCode = paramInt;
    this.errMsg = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(320634);
    if (this == paramObject)
    {
      AppMethodBeat.o(320634);
      return true;
    }
    if (!(paramObject instanceof DownloadPkgResult))
    {
      AppMethodBeat.o(320634);
      return false;
    }
    paramObject = (DownloadPkgResult)paramObject;
    if (this.isSuccess != paramObject.isSuccess)
    {
      AppMethodBeat.o(320634);
      return false;
    }
    if (!s.p(this.qJP, paramObject.qJP))
    {
      AppMethodBeat.o(320634);
      return false;
    }
    if (!s.p(this.filePath, paramObject.filePath))
    {
      AppMethodBeat.o(320634);
      return false;
    }
    if (this.errCode != paramObject.errCode)
    {
      AppMethodBeat.o(320634);
      return false;
    }
    if (!s.p(this.errMsg, paramObject.errMsg))
    {
      AppMethodBeat.o(320634);
      return false;
    }
    AppMethodBeat.o(320634);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320613);
    String str = "DownloadPkgResult(isSuccess=" + this.isSuccess + ", recordContentValues=" + this.qJP + ", filePath=" + this.filePath + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    AppMethodBeat.o(320613);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320650);
    s.u(paramParcel, "out");
    if (this.isSuccess) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable((Parcelable)this.qJP, paramInt);
      paramParcel.writeString(this.filePath);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(320650);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WxaPkgDownloaderExportServiceIPC.DownloadPkgResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgResult
 * JD-Core Version:    0.7.0.1
 */