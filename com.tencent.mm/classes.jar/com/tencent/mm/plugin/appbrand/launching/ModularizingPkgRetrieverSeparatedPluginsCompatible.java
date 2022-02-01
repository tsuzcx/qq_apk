package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bu;
import com.tencent.mm.plugin.appbrand.appcache.bu.a;
import com.tencent.mm.plugin.appbrand.appcache.bu.i;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.q.d.a;
import com.tencent.mm.plugin.appbrand.q.d.b;
import com.tencent.mm.plugin.appbrand.q.d.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestedModuleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "callArgs", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallbackEx;", "dead", "", "setCallback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "start", "Companion", "IPCCallArgs", "IPCCallResult", "IPCCallTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ModularizingPkgRetrieverSeparatedPluginsCompatible
  implements com.tencent.mm.plugin.appbrand.q.d, com.tencent.mm.vending.e.a
{
  public static final ModularizingPkgRetrieverSeparatedPluginsCompatible.a tbw;
  private AppBrandRuntime euM;
  private final String tbx;
  private d.b tby;
  private final IPCCallArgs tbz;
  
  static
  {
    AppMethodBeat.i(180638);
    tbw = new ModularizingPkgRetrieverSeparatedPluginsCompatible.a((byte)0);
    d.c.tmk = (d.c)new b();
    AppMethodBeat.o(180638);
  }
  
  public ModularizingPkgRetrieverSeparatedPluginsCompatible(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(180637);
    this.tbx = paramString;
    this.euM = paramAppBrandRuntime;
    this.tbz = new IPCCallArgs(paramAppBrandRuntime, this.tbx);
    paramAppBrandRuntime.keep((com.tencent.mm.vending.e.a)this);
    AppMethodBeat.o(180637);
  }
  
  private static final Boolean a(ModularizingPkgRetrieverSeparatedPluginsCompatible paramModularizingPkgRetrieverSeparatedPluginsCompatible, IPCCallResult paramIPCCallResult, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(320914);
    s.u(paramModularizingPkgRetrieverSeparatedPluginsCompatible, "this$0");
    StringBuilder localStringBuilder = new StringBuilder("onResultCustomAction, appId:");
    Object localObject;
    if (paramAppBrandRuntime == null)
    {
      localObject = null;
      Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", localObject + ", module:" + paramModularizingPkgRetrieverSeparatedPluginsCompatible.tbx + ", succeed:" + paramIPCCallResult.hUW);
      if (!paramIPCCallResult.hUW) {
        break label169;
      }
      paramModularizingPkgRetrieverSeparatedPluginsCompatible = bu.qIe;
      s.s(paramAppBrandRuntime, "rt");
      paramModularizingPkgRetrieverSeparatedPluginsCompatible = bu.a.T(paramAppBrandRuntime);
      if (paramModularizingPkgRetrieverSeparatedPluginsCompatible != null) {
        break label115;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(320914);
      return Boolean.valueOf(bool);
      localObject = paramAppBrandRuntime.mAppId;
      break;
      label115:
      paramIPCCallResult = paramIPCCallResult.tbH;
      s.checkNotNull(paramIPCCallResult);
      s.u(paramIPCCallResult, "_pkgList");
      if (!paramModularizingPkgRetrieverSeparatedPluginsCompatible.closed) {
        paramModularizingPkgRetrieverSeparatedPluginsCompatible.ak((kotlin.g.a.a)new bu.i(new LinkedList((Collection)paramIPCCallResult), paramModularizingPkgRetrieverSeparatedPluginsCompatible));
      }
    }
    label169:
    paramModularizingPkgRetrieverSeparatedPluginsCompatible = Boolean.FALSE;
    AppMethodBeat.o(320914);
    return paramModularizingPkgRetrieverSeparatedPluginsCompatible;
  }
  
  private static final void a(ModularizingPkgRetrieverSeparatedPluginsCompatible paramModularizingPkgRetrieverSeparatedPluginsCompatible, IPCCallResult paramIPCCallResult)
  {
    AppMethodBeat.i(320922);
    s.u(paramModularizingPkgRetrieverSeparatedPluginsCompatible, "this$0");
    for (;;)
    {
      try
      {
        int i = paramIPCCallResult.tbF;
        switch (i)
        {
        default: 
          AppMethodBeat.o(320922);
          return;
        }
      }
      finally
      {
        Log.e("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", s.X("IPCCallTask.onCallback t=", paramModularizingPkgRetrieverSeparatedPluginsCompatible));
        h.ahAA.bk(new ModularizingPkgRetrieverSeparatedPluginsCompatible..ExternalSyntheticLambda2(paramModularizingPkgRetrieverSeparatedPluginsCompatible));
        AppMethodBeat.o(320922);
        return;
      }
      paramModularizingPkgRetrieverSeparatedPluginsCompatible = paramModularizingPkgRetrieverSeparatedPluginsCompatible.tby;
      if (paramModularizingPkgRetrieverSeparatedPluginsCompatible != null)
      {
        paramIPCCallResult = paramIPCCallResult.tbG;
        s.checkNotNull(paramIPCCallResult);
        paramModularizingPkgRetrieverSeparatedPluginsCompatible.a(paramIPCCallResult);
        AppMethodBeat.o(320922);
        return;
      }
      d.b localb = paramModularizingPkgRetrieverSeparatedPluginsCompatible.tby;
      if (localb != null) {
        localb.a(new ModularizingPkgRetrieverSeparatedPluginsCompatible..ExternalSyntheticLambda0(paramModularizingPkgRetrieverSeparatedPluginsCompatible, paramIPCCallResult));
      }
      paramModularizingPkgRetrieverSeparatedPluginsCompatible.dead();
    }
  }
  
  private static final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(320917);
    s.u(paramThrowable, "$t");
    AppMethodBeat.o(320917);
    throw paramThrowable;
  }
  
  public final void a(d.a parama)
  {
    this.tby = ((d.b)parama);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(320946);
    AppBrandRuntime localAppBrandRuntime = this.euM;
    if (localAppBrandRuntime != null) {
      localAppBrandRuntime.a((com.tencent.mm.vending.e.a)this);
    }
    this.euM = null;
    this.tby = null;
    AppMethodBeat.o(320946);
  }
  
  public final void start()
  {
    AppMethodBeat.i(180636);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, this.tbz, c.class, new ModularizingPkgRetrieverSeparatedPluginsCompatible..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(180636);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "appId", "version", "", "versionType", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "isGame", "", "isSeparatedPluginsUsed", "isFromRemoteDebug", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "forcedPluginVersions", "", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "underPreRenderMode", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;ZZZLcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Z)V", "getAcceptedLibReader", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "setAcceptedLibReader", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getForcedPluginVersions", "()Ljava/util/Map;", "setForcedPluginVersions", "(Ljava/util/Map;)V", "()Z", "setFromRemoteDebug", "(Z)V", "setGame", "setSeparatedPluginsUsed", "getModuleName", "setModuleName", "getReportQualitySession", "()Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setReportQualitySession", "(Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getUnderPreRenderMode", "setUnderPreRenderMode", "getVersion", "()I", "setVersion", "(I)V", "getVersionType", "setVersionType", "getWxaVersionInfo", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "setWxaVersionInfo", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class IPCCallArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallArgs> CREATOR;
    public static final ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs.a tbA;
    String appId;
    boolean ekt;
    WxaAttributes.WxaVersionInfo epa;
    String esT;
    int euz;
    ICommLibReader sXT;
    boolean sXU;
    QualitySession taI;
    boolean tbB;
    Map<String, Integer> tbC;
    boolean tbD;
    private int version;
    
    static
    {
      AppMethodBeat.i(320965);
      tbA = new ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(320965);
    }
    
    public IPCCallArgs(Parcel paramParcel) {}
    
    public IPCCallArgs(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      this(str, paramString, j, k, (WxaAttributes.WxaVersionInfo)localObject1, bool2, bool1, bool3, (ICommLibReader)localObject2, (Map)localObject3, (QualitySession)localObject4, ((w)paramAppBrandRuntime).asE());
      AppMethodBeat.o(320957);
    }
    
    private IPCCallArgs(String paramString1, String paramString2, int paramInt1, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ICommLibReader paramICommLibReader, Map<String, Integer> paramMap, QualitySession paramQualitySession, boolean paramBoolean4)
    {
      AppMethodBeat.i(320936);
      this.appId = paramString1;
      this.esT = paramString2;
      this.version = paramInt1;
      this.euz = paramInt2;
      this.epa = paramWxaVersionInfo;
      this.ekt = paramBoolean1;
      this.tbB = paramBoolean2;
      this.sXU = paramBoolean3;
      this.sXT = paramICommLibReader;
      this.tbC = paramMap;
      this.taI = paramQualitySession;
      this.tbD = paramBoolean4;
      AppMethodBeat.o(320936);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(320979);
      s.u(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.esT);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.euz);
      paramParcel.writeParcelable((Parcelable)this.epa, 0);
      byte b;
      if (this.ekt)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.tbB) {
          break label159;
        }
        b = 1;
        label83:
        paramParcel.writeByte(b);
        if (!this.sXU) {
          break label164;
        }
        b = 1;
        label97:
        paramParcel.writeByte(b);
        ICommLibReader.b.a(this.sXT, paramParcel, paramInt);
        paramParcel.writeMap(this.tbC);
        paramParcel.writeParcelable((Parcelable)this.taI, 0);
        if (!this.tbD) {
          break label169;
        }
      }
      label159:
      label164:
      label169:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(320979);
        return;
        b = 0;
        break;
        b = 0;
        break label83;
        b = 0;
        break label97;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackType", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "result", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "succeed", "", "errCode", "errMsg", "", "(ILcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;Ljava/util/List;ZILjava/lang/String;)V", "getCallbackType", "()I", "setCallbackType", "(I)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getProgress", "()Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "setProgress", "(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;)V", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "getSucceed", "()Z", "setSucceed", "(Z)V", "describeContents", "readFromParcel", "", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class IPCCallResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallResult> CREATOR;
    public static final ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult.a tbE;
    private int errCode;
    private String errMsg;
    boolean hUW;
    int tbF;
    WxaPkgLoadProgress tbG;
    List<? extends IPkgInfo> tbH;
    
    static
    {
      AppMethodBeat.i(180629);
      tbE = new ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(180629);
    }
    
    private IPCCallResult(int paramInt1, WxaPkgLoadProgress paramWxaPkgLoadProgress, List<? extends IPkgInfo> paramList, boolean paramBoolean, int paramInt2, String paramString)
    {
      this.tbF = paramInt1;
      this.tbG = paramWxaPkgLoadProgress;
      this.tbH = paramList;
      this.hUW = paramBoolean;
      this.errCode = paramInt2;
      this.errMsg = paramString;
    }
    
    public IPCCallResult(Parcel paramParcel)
    {
      this(0, null, null, false, 0, null, 62);
      AppMethodBeat.i(180628);
      s.u(paramParcel, "source");
      this.tbF = paramParcel.readInt();
      switch (this.tbF)
      {
      default: 
        AppMethodBeat.o(180628);
        return;
      case 1: 
        this.tbG = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
        AppMethodBeat.o(180628);
        return;
      }
      Object localObject = ModularizingPkgRetrieverSeparatedPluginsCompatible.tbw;
      int j = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(j);
      int i;
      if (j > 0) {
        i = 0;
      }
      for (;;)
      {
        i += 1;
        localObject = paramParcel.readString();
        if (s.p(localObject, ModulePkgInfo.class.getName())) {
          localObject = ModulePkgInfo.class.getClassLoader();
        }
        for (;;)
        {
          s.checkNotNull(localObject);
          localObject = paramParcel.readParcelable((ClassLoader)localObject);
          if (localObject != null) {
            break;
          }
          paramParcel = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IPkgInfo");
          AppMethodBeat.o(180628);
          throw paramParcel;
          if (s.p(localObject, WxaPluginPkgInfo.class.getName())) {
            localObject = WxaPluginPkgInfo.class.getClassLoader();
          } else {
            localObject = null;
          }
        }
        localArrayList.add((IPkgInfo)localObject);
        if (i >= j)
        {
          this.tbH = ((List)localArrayList);
          if (paramParcel.readByte() > 0) {
            bool = true;
          }
          this.hUW = bool;
          this.errCode = paramParcel.readInt();
          this.errMsg = paramParcel.readString();
          break;
        }
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(180626);
      s.u(paramParcel, "dest");
      paramParcel.writeInt(this.tbF);
      switch (this.tbF)
      {
      default: 
        AppMethodBeat.o(180626);
        return;
      case 1: 
        paramParcel.writeParcelable((Parcelable)this.tbG, 0);
        AppMethodBeat.o(180626);
        return;
      }
      Object localObject1 = ModularizingPkgRetrieverSeparatedPluginsCompatible.tbw;
      Object localObject2 = this.tbH;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)ab.aivy;
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
      if (this.hUW) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
    {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$Companion$1", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieverCreator;", "createRetriever", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestModuleName", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends d.c
  {
    public final com.tencent.mm.plugin.appbrand.q.d k(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(320808);
      s.u(paramAppBrandRuntime, "runtime");
      s.u(paramString, "requestModuleName");
      paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.q.d)new ModularizingPkgRetrieverSeparatedPluginsCompatible(paramAppBrandRuntime, paramString);
      AppMethodBeat.o(320808);
      return paramAppBrandRuntime;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements com.tencent.mm.ipcinvoker.d<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
  {
    @Metadata(d1={""}, d2={"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<List<? extends IPkgInfo>, ah>
    {
      a(f<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult> paramf, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs paramIPCCallArgs)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "wholeProgressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements b<WxaPkgLoadProgress, ah>
    {
      b(f<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult> paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "err", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements m<Integer, String, ah>
    {
      c(f<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult> paramf, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs paramIPCCallArgs)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible
 * JD-Core Version:    0.7.0.1
 */