package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"})
public abstract interface y
{
  public abstract void a(b paramb, b<? super bmm[], x> paramb1, q<? super Integer, ? super Integer, ? super String, x> paramq, int paramInt, acc paramacc);
  
  @l(hxD={1, 1, 16})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionType", "getVersionType", "setVersionType", "compareTo", "other", "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"})
  public static final class b
    implements Comparable<b>
  {
    @Deprecated
    public static final a mUy;
    String appId = "";
    int appVersion;
    String cBp;
    int iOo;
    int mUu;
    int mUv;
    int mUw;
    boolean mUx;
    int packageType;
    
    static
    {
      AppMethodBeat.i(180587);
      mUy = new a((byte)0);
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
      String str = "LocalUnifiedGetDownloadUrlRequest(appId='" + this.appId + "', moduleName=" + this.cBp + ", packageType=" + this.packageType + ", versionType=" + this.iOo + ", appVersion=" + this.appVersion + ", supportEncryptVersion=" + this.mUu + ", localPkgVersion=" + this.mUv + ", localPkgEncryptVersion=" + this.mUw + ", needLatestVersion=" + this.mUx + ')';
      AppMethodBeat.o(180586);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y
 * JD-Core Version:    0.7.0.1
 */