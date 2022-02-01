package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.w.a;
import com.tencent.mm.plugin.appbrand.service.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "TAG", "", "registerPkgSpecs", "", "appUsername", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "DownloadPkgParam", "DownloadPkgResult", "RegisterPkgSpecs", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaPkgDownloaderExportServiceIPC
  implements w
{
  public static final WxaPkgDownloaderExportServiceIPC qJO;
  
  static
  {
    AppMethodBeat.i(320608);
    qJO = new WxaPkgDownloaderExportServiceIPC();
    AppMethodBeat.o(320608);
  }
  
  private static final void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(320585);
    if (paramf != null) {
      paramf.onCallback(new WxaPkgDownloaderExportServiceIPC.DownloadPkgResult(false, null, null, paramInt, paramString, 6));
    }
    AppMethodBeat.o(320585);
  }
  
  private static final void a(f paramf, bh parambh, String paramString)
  {
    AppMethodBeat.i(320576);
    s.u(parambh, "record");
    s.u(paramString, "filePath");
    if (paramf != null) {
      paramf.onCallback(new WxaPkgDownloaderExportServiceIPC.DownloadPkgResult(true, parambh.convertTo(), paramString, 0, null, 24));
    }
    AppMethodBeat.o(320576);
  }
  
  private static final void a(WxaPkgDownloaderExportServiceIPC.DownloadPkgParam paramDownloadPkgParam, f paramf)
  {
    AppMethodBeat.i(320593);
    String str = paramDownloadPkgParam.appId;
    int i = paramDownloadPkgParam.euz;
    try
    {
      paramDownloadPkgParam = b.qJQ;
      b.a.chw().a(str, i, new WxaPkgDownloaderExportServiceIPC..ExternalSyntheticLambda4(paramf), new WxaPkgDownloaderExportServiceIPC..ExternalSyntheticLambda3(paramf));
      AppMethodBeat.o(320593);
      return;
    }
    catch (Exception paramDownloadPkgParam)
    {
      Log.e("MicroMsg.WxaPkgDownloaderExportServiceIPC", "startDownloadPkg(appId:" + str + ", versionType:" + i + ") get exception:" + paramDownloadPkgParam);
      if (paramf != null) {
        paramf.onCallback(new WxaPkgDownloaderExportServiceIPC.DownloadPkgResult(false, null, null, -1, "Exception{" + paramDownloadPkgParam + '}', 6));
      }
      AppMethodBeat.o(320593);
    }
  }
  
  private static final void a(RegisterPkgSpecs paramRegisterPkgSpecs, f paramf)
  {
    AppMethodBeat.i(320604);
    String str1 = paramRegisterPkgSpecs.username;
    String str2 = paramRegisterPkgSpecs.appId;
    int i = paramRegisterPkgSpecs.scene;
    try
    {
      paramRegisterPkgSpecs = b.qJQ;
      b.a.chw().A(str1, str2, i);
      if (paramf != null) {
        com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
      }
      AppMethodBeat.o(320604);
      return;
    }
    catch (Exception paramRegisterPkgSpecs)
    {
      for (;;)
      {
        Log.e("MicroMsg.WxaPkgDownloaderExportServiceIPC", "registerPkgSpecs(username:" + str1 + ", appId:" + str2 + ", scene:" + i + ") get exception:" + paramRegisterPkgSpecs);
      }
    }
  }
  
  private static final void a(w.b paramb, w.a parama, WxaPkgDownloaderExportServiceIPC.DownloadPkgResult paramDownloadPkgResult)
  {
    AppMethodBeat.i(320598);
    if (paramDownloadPkgResult.isSuccess)
    {
      parama = new bh();
      Object localObject = a.qJN;
      localObject = (IAutoDBItem)parama;
      ContentValues localContentValues = paramDownloadPkgResult.qJP;
      s.checkNotNull(localContentValues);
      a.a((IAutoDBItem)localObject, localContentValues);
      paramDownloadPkgResult = paramDownloadPkgResult.filePath;
      s.checkNotNull(paramDownloadPkgResult);
      if (paramb != null)
      {
        paramb.onSuccess(parama, paramDownloadPkgResult);
        AppMethodBeat.o(320598);
      }
    }
    else if (parama != null)
    {
      parama.onError(paramDownloadPkgResult.errCode, paramDownloadPkgResult.errMsg);
    }
    AppMethodBeat.o(320598);
  }
  
  public final void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320642);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label75;
        }
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label81;
      }
      AppMethodBeat.o(320642);
      return;
      i = 0;
      break;
    }
    label81:
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new RegisterPkgSpecs(paramString1, paramString2, paramInt), WxaPkgDownloaderExportServiceIPC..ExternalSyntheticLambda1.INSTANCE, null);
    AppMethodBeat.o(320642);
  }
  
  public final void a(String paramString, int paramInt, w.b paramb, w.a parama)
  {
    AppMethodBeat.i(320636);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (parama != null) {
        parama.onError(-1, "invalid appId");
      }
      AppMethodBeat.o(320636);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new WxaPkgDownloaderExportServiceIPC.DownloadPkgParam(paramString, paramInt), WxaPkgDownloaderExportServiceIPC..ExternalSyntheticLambda0.INSTANCE, new WxaPkgDownloaderExportServiceIPC..ExternalSyntheticLambda2(paramb, parama));
    AppMethodBeat.o(320636);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs;", "Landroid/os/Parcelable;", "username", "", "appId", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class RegisterPkgSpecs
    implements Parcelable
  {
    public static final Parcelable.Creator<RegisterPkgSpecs> CREATOR;
    final String appId;
    final int scene;
    final String username;
    
    static
    {
      AppMethodBeat.i(320522);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(320522);
    }
    
    public RegisterPkgSpecs(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(320520);
      this.username = paramString1;
      this.appId = paramString2;
      this.scene = paramInt;
      AppMethodBeat.o(320520);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320536);
      if (this == paramObject)
      {
        AppMethodBeat.o(320536);
        return true;
      }
      if (!(paramObject instanceof RegisterPkgSpecs))
      {
        AppMethodBeat.o(320536);
        return false;
      }
      paramObject = (RegisterPkgSpecs)paramObject;
      if (!s.p(this.username, paramObject.username))
      {
        AppMethodBeat.o(320536);
        return false;
      }
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(320536);
        return false;
      }
      if (this.scene != paramObject.scene)
      {
        AppMethodBeat.o(320536);
        return false;
      }
      AppMethodBeat.o(320536);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320530);
      int i = this.username.hashCode();
      int j = this.appId.hashCode();
      int k = this.scene;
      AppMethodBeat.o(320530);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320524);
      String str = "RegisterPkgSpecs(username=" + this.username + ", appId=" + this.appId + ", scene=" + this.scene + ')';
      AppMethodBeat.o(320524);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(320548);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.scene);
      AppMethodBeat.o(320548);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC
 * JD-Core Version:    0.7.0.1
 */