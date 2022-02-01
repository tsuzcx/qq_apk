package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.p.d;
import com.tencent.mm.plugin.appbrand.p.d.a;
import com.tencent.mm.plugin.appbrand.p.d.b;
import com.tencent.mm.plugin.appbrand.p.d.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.t;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestedModuleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "callArgs", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallbackEx;", "dead", "", "setCallback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "start", "Companion", "IPCCallArgs", "IPCCallResult", "IPCCallTask", "plugin-appbrand-integration_release"})
public final class ModularizingPkgRetrieverSeparatedPluginsCompatible
  implements d, com.tencent.mm.vending.e.a
{
  public static final ModularizingPkgRetrieverSeparatedPluginsCompatible.a pWK;
  private AppBrandRuntime cCA;
  private d.b pWH;
  private final IPCCallArgs pWI;
  private final String pWJ;
  
  static
  {
    AppMethodBeat.i(180638);
    pWK = new ModularizingPkgRetrieverSeparatedPluginsCompatible.a((byte)0);
    d.c.qhz = (d.c)new b();
    AppMethodBeat.o(180638);
  }
  
  public ModularizingPkgRetrieverSeparatedPluginsCompatible(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(180637);
    this.pWJ = paramString;
    this.cCA = paramAppBrandRuntime;
    this.pWI = new IPCCallArgs(paramAppBrandRuntime, this.pWJ);
    paramAppBrandRuntime.keep((com.tencent.mm.vending.e.a)this);
    AppMethodBeat.o(180637);
  }
  
  public final void a(d.a parama)
  {
    this.pWH = ((d.b)parama);
  }
  
  public final void dead()
  {
    this.cCA = null;
    this.pWH = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(180636);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, this.pWI, ModularizingPkgRetrieverSeparatedPluginsCompatible.c.class, (f)new d(this));
    AppMethodBeat.o(180636);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "appId", "version", "", "versionType", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "isGame", "", "isSeparatedPluginsUsed", "isFromRemoteDebug", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "forcedPluginVersions", "", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "underPreRenderMode", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;ZZZLcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Z)V", "getAcceptedLibReader", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "setAcceptedLibReader", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getForcedPluginVersions", "()Ljava/util/Map;", "setForcedPluginVersions", "(Ljava/util/Map;)V", "()Z", "setFromRemoteDebug", "(Z)V", "setGame", "setSeparatedPluginsUsed", "getModuleName", "setModuleName", "getReportQualitySession", "()Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setReportQualitySession", "(Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getUnderPreRenderMode", "setUnderPreRenderMode", "getVersion", "()I", "setVersion", "(I)V", "getVersionType", "setVersionType", "getWxaVersionInfo", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "setWxaVersionInfo", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPCCallArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallArgs> CREATOR;
    public static final ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs.a pWO;
    String appId;
    String cAy;
    int cBU;
    boolean csz;
    WxaAttributes.WxaVersionInfo cwY;
    ICommLibReader nYZ;
    boolean pSU;
    QualitySession pVW;
    boolean pWL;
    Map<String, Integer> pWM;
    boolean pWN;
    private int version;
    
    static
    {
      AppMethodBeat.i(267707);
      pWO = new ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs.a((byte)0);
      CREATOR = (Parcelable.Creator)new ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs.b();
      AppMethodBeat.o(267707);
    }
    
    public IPCCallArgs(Parcel paramParcel) {}
    
    public IPCCallArgs(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      this(str, paramString, j, k, (WxaAttributes.WxaVersionInfo)localObject1, bool2, bool1, bool3, (ICommLibReader)localObject2, (Map)localObject3, (QualitySession)localObject4, ((t)paramAppBrandRuntime).So());
      AppMethodBeat.o(267706);
    }
    
    private IPCCallArgs(String paramString1, String paramString2, int paramInt1, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ICommLibReader paramICommLibReader, Map<String, Integer> paramMap, QualitySession paramQualitySession, boolean paramBoolean4)
    {
      AppMethodBeat.i(267703);
      this.appId = paramString1;
      this.cAy = paramString2;
      this.version = paramInt1;
      this.cBU = paramInt2;
      this.cwY = paramWxaVersionInfo;
      this.csz = paramBoolean1;
      this.pWL = paramBoolean2;
      this.pSU = paramBoolean3;
      this.nYZ = paramICommLibReader;
      this.pWM = paramMap;
      this.pVW = paramQualitySession;
      this.pWN = paramBoolean4;
      AppMethodBeat.o(267703);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(267702);
      p.k(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.cAy);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeParcelable((Parcelable)this.cwY, 0);
      byte b;
      if (this.csz)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.pWL) {
          break label159;
        }
        b = 1;
        label83:
        paramParcel.writeByte(b);
        if (!this.pSU) {
          break label164;
        }
        b = 1;
        label97:
        paramParcel.writeByte(b);
        ICommLibReader.b.a(this.nYZ, paramParcel, paramInt);
        paramParcel.writeMap(this.pWM);
        paramParcel.writeParcelable((Parcelable)this.pVW, 0);
        if (!this.pWN) {
          break label169;
        }
      }
      label159:
      label164:
      label169:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(267702);
        return;
        b = 0;
        break;
        b = 0;
        break label83;
        b = 0;
        break label97;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$Companion$1", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieverCreator;", "createRetriever", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestModuleName", "", "plugin-appbrand-integration_release"})
  public static final class b
    extends d.c
  {
    public final d k(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(268970);
      p.k(paramAppBrandRuntime, "runtime");
      p.k(paramString, "requestModuleName");
      paramAppBrandRuntime = (d)new ModularizingPkgRetrieverSeparatedPluginsCompatible(paramAppBrandRuntime, paramString);
      AppMethodBeat.o(268970);
      return paramAppBrandRuntime;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "callbackResult", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class d<T>
    implements f<ResultType>
  {
    d(ModularizingPkgRetrieverSeparatedPluginsCompatible paramModularizingPkgRetrieverSeparatedPluginsCompatible) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible
 * JD-Core Version:    0.7.0.1
 */