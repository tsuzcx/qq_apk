package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.ciq;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface z
{
  public abstract void a(a parama, b<? super ciq[], ah> paramb, q<? super Integer, ? super Integer, ? super String, ah> paramq, int paramInt, aeo paramaeo);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionDesc", "getVersionDesc", "setVersionDesc", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Comparable<a>
  {
    private static final z.a.a taf;
    String appId = "";
    int appVersion;
    String esT;
    int euz;
    int hDq;
    String qGf;
    int tah;
    int tai;
    int taj;
    boolean tak;
    
    static
    {
      AppMethodBeat.i(180587);
      taf = new z.a.a((byte)0);
      AppMethodBeat.o(180587);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180584);
      if (((paramObject instanceof a)) && ((this == paramObject) || (hashCode() == ((a)paramObject).hashCode())))
      {
        AppMethodBeat.o(180584);
        return true;
      }
      AppMethodBeat.o(180584);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(180585);
      int i = toString().hashCode();
      AppMethodBeat.o(180585);
      return i;
    }
    
    public final void setAppId(String paramString)
    {
      AppMethodBeat.i(180582);
      s.u(paramString, "<set-?>");
      this.appId = paramString;
      AppMethodBeat.o(180582);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180586);
      StringBuilder localStringBuilder = new StringBuilder("LocalUnifiedGetDownloadUrlRequest(appId='").append(this.appId).append("', moduleName=").append(this.esT).append(", packageType=").append(this.hDq).append(", versionType=").append(this.euz).append(", appVersion=").append(this.appVersion).append(", versionDesc='");
      String str2 = this.qGf;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = str1 + "' supportEncryptVersion=" + this.tah + ", localPkgVersion=" + this.tai + ", localPkgEncryptVersion=" + this.taj + ", needLatestVersion=" + this.tak + ')';
      AppMethodBeat.o(180586);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */