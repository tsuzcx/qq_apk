package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "()V", "triggerPreDownload", "", "username", "", "scene", "", "appId", "triggerPreDownloadForPath", "path", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "appUsernames", "triggerPrefetchWeAppQRCode", "PreDownloadInvokeParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PreDownloadServiceExportAnyProcess
  implements y
{
  public static final PreDownloadServiceExportAnyProcess qIN;
  
  static
  {
    AppMethodBeat.i(320474);
    qIN = new PreDownloadServiceExportAnyProcess();
    AppMethodBeat.o(320474);
  }
  
  private static final void a(PreDownloadInvokeParams paramPreDownloadInvokeParams, f paramf)
  {
    AppMethodBeat.i(320460);
    if (paramPreDownloadInvokeParams != null)
    {
      paramf = paramPreDownloadInvokeParams.username;
      int i = paramPreDownloadInvokeParams.scene;
      ((y)h.ax(y.class)).bL(paramf, i);
    }
    AppMethodBeat.o(320460);
  }
  
  private static final void b(PreDownloadInvokeParams paramPreDownloadInvokeParams, f paramf)
  {
    AppMethodBeat.i(320468);
    paramf = paramPreDownloadInvokeParams.username;
    int i = paramPreDownloadInvokeParams.scene;
    paramPreDownloadInvokeParams = paramPreDownloadInvokeParams.path;
    ((y)h.ax(y.class)).y(paramf, paramPreDownloadInvokeParams, i);
    AppMethodBeat.o(320468);
  }
  
  private static final void c(PreDownloadInvokeParams paramPreDownloadInvokeParams, f paramf)
  {
    AppMethodBeat.i(320472);
    if (paramPreDownloadInvokeParams != null)
    {
      paramf = paramPreDownloadInvokeParams.username;
      int i = paramPreDownloadInvokeParams.scene;
      paramPreDownloadInvokeParams = paramPreDownloadInvokeParams.appId;
      ((y)h.ax(y.class)).z(paramf, paramPreDownloadInvokeParams, i);
    }
    AppMethodBeat.o(320472);
  }
  
  public final void VF(String paramString) {}
  
  public final void bL(String paramString, int paramInt)
  {
    AppMethodBeat.i(320494);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320494);
      return;
    }
    a.a(new PreDownloadInvokeParams(paramString, paramInt, null, 12), PreDownloadServiceExportAnyProcess..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(320494);
  }
  
  public final void cM(List<String> paramList) {}
  
  public final void cN(List<String> paramList) {}
  
  public final void chp() {}
  
  public final void y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320498);
    a.a(new PreDownloadInvokeParams(paramString1, paramInt, null, paramString2), PreDownloadServiceExportAnyProcess..ExternalSyntheticLambda2.INSTANCE, null);
    AppMethodBeat.o(320498);
  }
  
  public final void z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320504);
    a.a(new PreDownloadInvokeParams(paramString1, paramInt, paramString2, 8), PreDownloadServiceExportAnyProcess..ExternalSyntheticLambda1.INSTANCE, null);
    AppMethodBeat.o(320504);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "Landroid/os/Parcelable;", "username", "", "scene", "", "appId", "path", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getScene", "()I", "getUsername", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class PreDownloadInvokeParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PreDownloadInvokeParams> CREATOR;
    final String appId;
    final String path;
    final int scene;
    final String username;
    
    static
    {
      AppMethodBeat.i(320407);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(320407);
    }
    
    public PreDownloadInvokeParams(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.username = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
      this.path = paramString3;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320417);
      if (this == paramObject)
      {
        AppMethodBeat.o(320417);
        return true;
      }
      if (!(paramObject instanceof PreDownloadInvokeParams))
      {
        AppMethodBeat.o(320417);
        return false;
      }
      paramObject = (PreDownloadInvokeParams)paramObject;
      if (!s.p(this.username, paramObject.username))
      {
        AppMethodBeat.o(320417);
        return false;
      }
      if (this.scene != paramObject.scene)
      {
        AppMethodBeat.o(320417);
        return false;
      }
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(320417);
        return false;
      }
      if (!s.p(this.path, paramObject.path))
      {
        AppMethodBeat.o(320417);
        return false;
      }
      AppMethodBeat.o(320417);
      return true;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(320413);
      int i;
      int m;
      int j;
      if (this.username == null)
      {
        i = 0;
        m = this.scene;
        if (this.appId != null) {
          break label72;
        }
        j = 0;
        label31:
        if (this.path != null) {
          break label83;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(320413);
        return (j + (i * 31 + m) * 31) * 31 + k;
        i = this.username.hashCode();
        break;
        label72:
        j = this.appId.hashCode();
        break label31;
        label83:
        k = this.path.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320412);
      String str = "PreDownloadInvokeParams(username=" + this.username + ", scene=" + this.scene + ", appId=" + this.appId + ", path=" + this.path + ')';
      AppMethodBeat.o(320412);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(320422);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.path);
      AppMethodBeat.o(320422);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess
 * JD-Core Version:    0.7.0.1
 */