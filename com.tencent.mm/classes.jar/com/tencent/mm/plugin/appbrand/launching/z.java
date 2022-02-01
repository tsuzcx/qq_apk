package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atf;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"})
public abstract interface z
{
  public abstract void a(b paramb, b<? super atf[], y> paramb1, q<? super Integer, ? super Integer, ? super String, y> paramq, int paramInt);
  
  @l(fvt={1, 1, 16})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"})
  public static final class b
    implements Comparable<b>
  {
    @Deprecated
    public static final a kJJ;
    int aAS;
    String appId = "";
    String chK;
    int deP;
    int gXn;
    int kIJ;
    int kJG;
    int kJH;
    boolean kJI;
    
    static
    {
      AppMethodBeat.i(180587);
      kJJ = new a((byte)0);
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
      k.h(paramString, "<set-?>");
      this.appId = paramString;
      AppMethodBeat.o(180582);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180586);
      String str = "LocalUnifiedGetDownloadUrlRequest(appId='" + this.appId + "', moduleName=" + this.chK + ", packageType=" + this.deP + ", versionType=" + this.gXn + ", appVersion=" + this.aAS + ", supportEncryptVersion=" + this.kJG + ", localPkgVersion=" + this.kIJ + ", localPkgEncryptVersion=" + this.kJH + ", needLatestVersion=" + this.kJI + ')';
      AppMethodBeat.o(180586);
      return str;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */