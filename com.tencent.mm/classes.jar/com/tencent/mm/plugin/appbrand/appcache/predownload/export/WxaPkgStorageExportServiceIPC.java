package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "TAG", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "versionType", "", "version", "getServerNotifiedReleaseVersion", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "PkgParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaPkgStorageExportServiceIPC
  implements x
{
  public static final WxaPkgStorageExportServiceIPC qJV;
  
  static
  {
    AppMethodBeat.i(320615);
    qJV = new WxaPkgStorageExportServiceIPC();
    AppMethodBeat.o(320615);
  }
  
  private static final IPCBoolean a(PkgParams paramPkgParams)
  {
    AppMethodBeat.i(320584);
    String str = paramPkgParams.appId;
    int i = paramPkgParams.version;
    paramPkgParams = paramPkgParams.filePath;
    c.a locala = c.qJW;
    paramPkgParams = new IPCBoolean(c.a.chy().v(str, i, paramPkgParams));
    AppMethodBeat.o(320584);
    return paramPkgParams;
  }
  
  private static final void a(PkgParams paramPkgParams, f paramf)
  {
    AppMethodBeat.i(320602);
    String str = paramPkgParams.appId;
    int i = paramPkgParams.version;
    paramPkgParams = c.qJW;
    c.a.chy().bM(str, i);
    if (paramf != null) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    }
    AppMethodBeat.o(320602);
  }
  
  private static final ContentValues b(PkgParams paramPkgParams)
  {
    AppMethodBeat.i(320594);
    String str = paramPkgParams.appId;
    int i = paramPkgParams.euz;
    int j = paramPkgParams.version;
    paramPkgParams = c.qJW;
    paramPkgParams = c.a.chy().L(str, i, j);
    if (paramPkgParams == null)
    {
      AppMethodBeat.o(320594);
      return null;
    }
    paramPkgParams = paramPkgParams.convertTo();
    AppMethodBeat.o(320594);
    return paramPkgParams;
  }
  
  private static final IPCInteger c(PkgParams paramPkgParams)
  {
    AppMethodBeat.i(320609);
    paramPkgParams = paramPkgParams.appId;
    c.a locala = c.qJW;
    paramPkgParams = new IPCInteger(c.a.chy().VL(paramPkgParams));
    AppMethodBeat.o(320609);
    return paramPkgParams;
  }
  
  public final bh L(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(320671);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320671);
      return null;
    }
    paramString = (ContentValues)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, paramInt1, paramInt2, 8), WxaPkgStorageExportServiceIPC..ExternalSyntheticLambda2.INSTANCE);
    if (paramString != null)
    {
      localObject = new bh();
      a locala = a.qJN;
      a.a((IAutoDBItem)localObject, paramString);
      AppMethodBeat.o(320671);
      return localObject;
    }
    AppMethodBeat.o(320671);
    return null;
  }
  
  public final bh VK(String paramString)
  {
    AppMethodBeat.i(320664);
    paramString = L(paramString, 0, 0);
    AppMethodBeat.o(320664);
    return paramString;
  }
  
  public final int VL(String paramString)
  {
    AppMethodBeat.i(320683);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320683);
      return 0;
    }
    paramString = (IPCInteger)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, 0, 0, 14), WxaPkgStorageExportServiceIPC..ExternalSyntheticLambda1.INSTANCE);
    if (paramString == null)
    {
      AppMethodBeat.o(320683);
      return 0;
    }
    i = paramString.value;
    AppMethodBeat.o(320683);
    return i;
  }
  
  public final void bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(320680);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320680);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, 0, paramInt, 10), WxaPkgStorageExportServiceIPC..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(320680);
  }
  
  public final boolean v(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320655);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label115;
        }
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label121;
      }
      Log.e("MicroMsg.WxaPkgStorageExportIPC", "insertPkg, invalid args: appId:" + paramString1 + ", version:" + paramInt + ", filePath:" + paramString2);
      AppMethodBeat.o(320655);
      return false;
      i = 0;
      break;
    }
    label121:
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString1, 0, paramInt, paramString2), WxaPkgStorageExportServiceIPC..ExternalSyntheticLambda3.INSTANCE);
    if ((paramString1 != null) && (paramString1.value == true))
    {
      AppMethodBeat.o(320655);
      return true;
    }
    AppMethodBeat.o(320655);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "version", "filePath", "(Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getFilePath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class PkgParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PkgParams> CREATOR;
    final String appId;
    final int euz;
    final String filePath;
    final int version;
    
    static
    {
      AppMethodBeat.i(320579);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(320579);
    }
    
    public PkgParams(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(320560);
      this.appId = paramString1;
      this.euz = paramInt1;
      this.version = paramInt2;
      this.filePath = paramString2;
      AppMethodBeat.o(320560);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320596);
      if (this == paramObject)
      {
        AppMethodBeat.o(320596);
        return true;
      }
      if (!(paramObject instanceof PkgParams))
      {
        AppMethodBeat.o(320596);
        return false;
      }
      paramObject = (PkgParams)paramObject;
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(320596);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(320596);
        return false;
      }
      if (this.version != paramObject.version)
      {
        AppMethodBeat.o(320596);
        return false;
      }
      if (!s.p(this.filePath, paramObject.filePath))
      {
        AppMethodBeat.o(320596);
        return false;
      }
      AppMethodBeat.o(320596);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320592);
      int j = this.appId.hashCode();
      int k = this.euz;
      int m = this.version;
      if (this.filePath == null) {}
      for (int i = 0;; i = this.filePath.hashCode())
      {
        AppMethodBeat.o(320592);
        return i + ((j * 31 + k) * 31 + m) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320587);
      String str = "PkgParams(appId=" + this.appId + ", versionType=" + this.euz + ", version=" + this.version + ", filePath=" + this.filePath + ')';
      AppMethodBeat.o(320587);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(320605);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.euz);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(320605);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<WxaPkgStorageExportServiceIPC.PkgParams>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC
 * JD-Core Version:    0.7.0.1
 */