package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.p.e.a;
import com.tencent.mm.plugin.appbrand.p.e.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestedModuleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallbackEx;", "dead", "", "setCallback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "start", "Companion", "IPCCallParams", "IPCCallResult", "IPCCallTask", "plugin-appbrand-integration_release"})
public final class ModularizingPkgRetrieverSeparatedPluginsCompatible
  implements e, com.tencent.mm.vending.e.a
{
  public static final a mWg;
  private AppBrandRuntime cBW;
  private e.b mWe;
  private final String mWf;
  
  static
  {
    AppMethodBeat.i(180638);
    mWg = new a((byte)0);
    AppMethodBeat.o(180638);
  }
  
  public ModularizingPkgRetrieverSeparatedPluginsCompatible(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(180637);
    this.mWf = paramString;
    this.cBW = paramAppBrandRuntime;
    AppMethodBeat.o(180637);
  }
  
  public static final boolean Z(AppBrandRuntime paramAppBrandRuntime)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180639);
    p.h(paramAppBrandRuntime, "rt");
    Object localObject2 = bg.M(paramAppBrandRuntime);
    paramAppBrandRuntime = (AppBrandRuntime)localObject2;
    if (!(localObject2 instanceof bg)) {
      paramAppBrandRuntime = null;
    }
    localObject2 = (bg)paramAppBrandRuntime;
    paramAppBrandRuntime = localObject1;
    if (localObject2 != null) {
      paramAppBrandRuntime = ((bg)localObject2).bwy();
    }
    boolean bool = paramAppBrandRuntime instanceof bn;
    AppMethodBeat.o(180639);
    return bool;
  }
  
  public final void a(e.a parama)
  {
    this.mWe = ((e.b)parama);
  }
  
  public final void dead()
  {
    this.cBW = null;
    this.mWe = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(180636);
    String str = MainProcessIPCService.dkO;
    AppBrandRuntime localAppBrandRuntime = this.cBW;
    if (localAppBrandRuntime == null) {
      p.hyc();
    }
    XIPCInvoker.a(str, new IPCCallParams(localAppBrandRuntime, this.mWf), b.class, (d)new c(this));
    AppMethodBeat.o(180636);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "appId", "version", "", "versionType", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "isGame", "", "isFromRemoteDebug", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "underPreRenderMode", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;ZZLcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Z)V", "getAcceptedLibReader", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "setAcceptedLibReader", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "()Z", "setFromRemoteDebug", "(Z)V", "setGame", "getModuleName", "setModuleName", "getReportQualitySession", "()Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setReportQualitySession", "(Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getUnderPreRenderMode", "setUnderPreRenderMode", "getVersion", "()I", "setVersion", "(I)V", "getVersionType", "setVersionType", "getWxaVersionInfo", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "setWxaVersionInfo", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPCCallParams
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallParams> CREATOR;
    public static final a mWi;
    String appId;
    String cBp;
    boolean cuy;
    WxaAttributes.WxaVersionInfo cyv;
    int iOo;
    ICommLibReader leM;
    boolean mSa;
    QualitySession mUY;
    boolean mWh;
    int version;
    
    static
    {
      AppMethodBeat.i(180624);
      mWi = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(180624);
    }
    
    public IPCCallParams(Parcel paramParcel) {}
    
    public IPCCallParams(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      this(str, paramString, i, j, (WxaAttributes.WxaVersionInfo)localObject, bool1, bool2, localICommLibReader, (QualitySession)localQualitySessionRuntime, ((com.tencent.mm.plugin.appbrand.q)paramAppBrandRuntime).OS());
      AppMethodBeat.i(180623);
      AppMethodBeat.o(180623);
    }
    
    private IPCCallParams(String paramString1, String paramString2, int paramInt1, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, boolean paramBoolean3)
    {
      AppMethodBeat.i(228725);
      this.appId = paramString1;
      this.cBp = paramString2;
      this.version = paramInt1;
      this.iOo = paramInt2;
      this.cyv = paramWxaVersionInfo;
      this.cuy = paramBoolean1;
      this.mSa = paramBoolean2;
      this.leM = paramICommLibReader;
      this.mUY = paramQualitySession;
      this.mWh = paramBoolean3;
      AppMethodBeat.o(228725);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(180620);
      p.h(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.cBp);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeParcelable((Parcelable)this.cyv, 0);
      byte b;
      if (this.cuy)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.mSa) {
          break label137;
        }
        b = 1;
        label83:
        paramParcel.writeByte(b);
        ICommLibReader.b.a(this.leM, paramParcel, paramInt);
        paramParcel.writeParcelable((Parcelable)this.mUY, 0);
        if (!this.mWh) {
          break label142;
        }
      }
      label137:
      label142:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(180620);
        return;
        b = 0;
        break;
        b = 0;
        break label83;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackType", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "result", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "succeed", "", "errCode", "errMsg", "", "(ILcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;Ljava/util/List;ZILjava/lang/String;)V", "getCallbackType", "()I", "setCallbackType", "(I)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getProgress", "()Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "setProgress", "(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;)V", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "getSucceed", "()Z", "setSucceed", "(Z)V", "describeContents", "readFromParcel", "", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPCCallResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallResult> CREATOR;
    public static final a mWm;
    boolean dVA;
    private int errCode;
    private String errMsg;
    int mWj;
    WxaPkgLoadProgress mWk;
    List<? extends IPkgInfo> mWl;
    
    static
    {
      AppMethodBeat.i(180629);
      mWm = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(180629);
    }
    
    private IPCCallResult(int paramInt1, WxaPkgLoadProgress paramWxaPkgLoadProgress, List<? extends IPkgInfo> paramList, boolean paramBoolean, int paramInt2, String paramString)
    {
      this.mWj = paramInt1;
      this.mWk = paramWxaPkgLoadProgress;
      this.mWl = paramList;
      this.dVA = paramBoolean;
      this.errCode = paramInt2;
      this.errMsg = paramString;
    }
    
    public IPCCallResult(Parcel paramParcel)
    {
      this(0, null, null, false, 0, null, 62);
      AppMethodBeat.i(180628);
      p.h(paramParcel, "source");
      this.mWj = paramParcel.readInt();
      switch (this.mWj)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(180628);
        return;
        this.mWk = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
        AppMethodBeat.o(180628);
        return;
        Object localObject = ModularizingPkgRetrieverSeparatedPluginsCompatible.mWg;
        int j = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localObject = paramParcel.readString();
          if (p.j(localObject, ModulePkgInfo.class.getName())) {
            localObject = ModulePkgInfo.class.getClassLoader();
          }
          for (;;)
          {
            if (localObject == null) {
              p.hyc();
            }
            localObject = paramParcel.readParcelable((ClassLoader)localObject);
            if (localObject != null) {
              break;
            }
            paramParcel = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IPkgInfo");
            AppMethodBeat.o(180628);
            throw paramParcel;
            if (p.j(localObject, WxaPluginPkgInfo.class.getName())) {
              localObject = WxaPluginPkgInfo.class.getClassLoader();
            } else {
              localObject = null;
            }
          }
          localArrayList.add((IPkgInfo)localObject);
          i += 1;
        }
        this.mWl = ((List)localArrayList);
        if (paramParcel.readByte() > 0) {
          bool = true;
        }
        this.dVA = bool;
        this.errCode = paramParcel.readInt();
        this.errMsg = paramParcel.readString();
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(180626);
      p.h(paramParcel, "dest");
      paramParcel.writeInt(this.mWj);
      switch (this.mWj)
      {
      default: 
        AppMethodBeat.o(180626);
        return;
      case 1: 
        paramParcel.writeParcelable((Parcelable)this.mWk, 0);
        AppMethodBeat.o(180626);
        return;
      }
      Object localObject1 = ModularizingPkgRetrieverSeparatedPluginsCompatible.mWg;
      Object localObject2 = this.mWl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)v.SXr;
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label188:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Parcelable localParcelable = (Parcelable)localObject3;
        if (((localParcelable instanceof ModulePkgInfo)) || ((localParcelable instanceof WxaPluginPkgInfo))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label188;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      paramParcel.writeInt(((List)localObject1).size());
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Parcelable)((Iterator)localObject1).next();
        paramParcel.writeString(localObject2.getClass().getName());
        paramParcel.writeParcelable((Parcelable)localObject2, 0);
      }
      if (this.dVA) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        break;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$Companion;", "", "()V", "CALLBACK_TYPE_PROGRESS", "", "CALLBACK_TYPE_RESULT", "TAG", "", "shouldIntercept", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "readPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Landroid/os/Parcel;", "writePkgListToParcel", "", "Landroid/os/Parcelable;", "dest", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<List<? extends IPkgInfo>, x>
    {
      a(d paramd, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams paramIPCCallParams)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wholeProgressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<WxaPkgLoadProgress, x>
    {
      b(d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "err", "", "errMsg", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements m<Integer, String, x>
    {
      c(d paramd, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams paramIPCCallParams)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "callbackResult", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements d<ResultType>
  {
    c(ModularizingPkgRetrieverSeparatedPluginsCompatible paramModularizingPkgRetrieverSeparatedPluginsCompatible) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible
 * JD-Core Version:    0.7.0.1
 */