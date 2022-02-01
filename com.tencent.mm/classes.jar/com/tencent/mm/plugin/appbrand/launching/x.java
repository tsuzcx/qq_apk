package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btv;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"})
public abstract interface x
{
  public abstract void a(a parama, b<? super btv[], kotlin.x> paramb, q<? super Integer, ? super Integer, ? super String, kotlin.x> paramq, int paramInt, ack paramack);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionDesc", "getVersionDesc", "setVersionDesc", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"})
  public static final class a
    implements Comparable<a>
  {
    @Deprecated
    public static final a pVw;
    String appId = "";
    int appVersion;
    String cAy;
    int cBU;
    int fyH;
    String nGm;
    int pVs;
    int pVt;
    int pVu;
    boolean pVv;
    
    static
    {
      AppMethodBeat.i(180587);
      pVw = new a((byte)0);
      AppMethodBeat.o(180587);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180584);
      if (((paramObject instanceof a)) && (((a)this == paramObject) || (hashCode() == paramObject.hashCode())))
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
      p.k(paramString, "<set-?>");
      this.appId = paramString;
      AppMethodBeat.o(180582);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180586);
      StringBuilder localStringBuilder = new StringBuilder("LocalUnifiedGetDownloadUrlRequest(appId='").append(this.appId).append("', moduleName=").append(this.cAy).append(", packageType=").append(this.fyH).append(", versionType=").append(this.cBU).append(", appVersion=").append(this.appVersion).append(", versionDesc='");
      String str2 = this.nGm;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = str1 + "' supportEncryptVersion=" + this.pVs + ", localPkgVersion=" + this.pVt + ", localPkgEncryptVersion=" + this.pVu + ", needLatestVersion=" + this.pVv + ')';
      AppMethodBeat.o(180586);
      return str1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */