package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bax;
import d.g.a.b;
import d.g.a.q;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"})
public abstract interface z
{
  public abstract void a(b paramb, b<? super bax[], d.z> paramb1, q<? super Integer, ? super Integer, ? super String, d.z> paramq, int paramInt);
  
  @l(gjZ={1, 1, 16})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"})
  public static final class b
    implements Comparable<b>
  {
    @Deprecated
    public static final a lMN;
    int aDD;
    String appId = "";
    String coY;
    int doK;
    int hSZ;
    int lLN;
    int lMK;
    int lML;
    boolean lMM;
    
    static
    {
      AppMethodBeat.i(180587);
      lMN = new a((byte)0);
      AppMethodBeat.o(180587);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180584);
      if (((paramObject instanceof b)) && (((b)this == paramObject) || (hashCode() == paramObject.hashCode())))
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
      p.h(paramString, "<set-?>");
      this.appId = paramString;
      AppMethodBeat.o(180582);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180586);
      String str = "LocalUnifiedGetDownloadUrlRequest(appId='" + this.appId + "', moduleName=" + this.coY + ", packageType=" + this.doK + ", versionType=" + this.hSZ + ", appVersion=" + this.aDD + ", supportEncryptVersion=" + this.lMK + ", localPkgVersion=" + this.lLN + ", localPkgEncryptVersion=" + this.lML + ", needLatestVersion=" + this.lMM + ')';
      AppMethodBeat.o(180586);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */