package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.m.e.a;
import com.tencent.mm.plugin.appbrand.m.e.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestedModuleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallbackEx;", "dead", "", "setCallback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "start", "Companion", "IPCCallParams", "IPCCallResult", "IPCCallTask", "plugin-appbrand-integration_release"})
public final class ModularizingPkgRetrieverSeparatedPluginsCompatible
  implements e, com.tencent.mm.vending.e.a
{
  public static final a lKy;
  private AppBrandRuntime lKv;
  private e.b lKw;
  private final String lKx;
  
  static
  {
    AppMethodBeat.i(180638);
    lKy = new a((byte)0);
    AppMethodBeat.o(180638);
  }
  
  public ModularizingPkgRetrieverSeparatedPluginsCompatible(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(180637);
    this.lKx = paramString;
    this.lKv = paramAppBrandRuntime;
    AppMethodBeat.o(180637);
  }
  
  public static final boolean Z(AppBrandRuntime paramAppBrandRuntime)
  {
    Object localObject1 = null;
    AppMethodBeat.i(180639);
    p.h(paramAppBrandRuntime, "rt");
    Object localObject2 = bf.O(paramAppBrandRuntime);
    paramAppBrandRuntime = (AppBrandRuntime)localObject2;
    if (!(localObject2 instanceof bf)) {
      paramAppBrandRuntime = null;
    }
    localObject2 = (bf)paramAppBrandRuntime;
    paramAppBrandRuntime = localObject1;
    if (localObject2 != null) {
      paramAppBrandRuntime = ((bf)localObject2).baM();
    }
    boolean bool = paramAppBrandRuntime instanceof bm;
    AppMethodBeat.o(180639);
    return bool;
  }
  
  public final void a(e.a parama)
  {
    this.lKw = ((e.b)parama);
  }
  
  public final void dead()
  {
    this.lKv = null;
    this.lKw = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(180636);
    AppBrandRuntime localAppBrandRuntime = this.lKv;
    if (localAppBrandRuntime == null) {
      p.gfZ();
    }
    XIPCInvoker.a("com.tencent.mm", new IPCCallParams(localAppBrandRuntime, this.lKx), b.class, (d)new c(this));
    AppMethodBeat.o(180636);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "appId", "version", "", "versionType", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "isGame", "", "isFromRemoteDebug", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;ZZLcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getAcceptedLibReader", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "setAcceptedLibReader", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "()Z", "setFromRemoteDebug", "(Z)V", "setGame", "getModuleName", "setModuleName", "getReportQualitySession", "()Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setReportQualitySession", "(Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getVersion", "()I", "setVersion", "(I)V", "getVersionType", "setVersionType", "getWxaVersionInfo", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "setWxaVersionInfo", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPCCallParams
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallParams> CREATOR;
    public static final a lKz;
    String appId;
    boolean ciC;
    WxaAttributes.WxaVersionInfo cmy;
    String coW;
    int hQh;
    ICommLibReader jYp;
    boolean lFM;
    QualitySession lJc;
    int version;
    
    static
    {
      AppMethodBeat.i(180624);
      lKz = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(180624);
    }
    
    public IPCCallParams(Parcel paramParcel) {}
    
    public IPCCallParams(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      this(str, paramString, i, j, (WxaAttributes.WxaVersionInfo)localObject, bool1, bool2, localICommLibReader, (QualitySession)paramAppBrandRuntime);
      AppMethodBeat.i(180623);
      AppMethodBeat.o(180623);
    }
    
    private IPCCallParams(String paramString1, String paramString2, int paramInt1, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(180621);
      this.appId = paramString1;
      this.coW = paramString2;
      this.version = paramInt1;
      this.hQh = paramInt2;
      this.cmy = paramWxaVersionInfo;
      this.ciC = paramBoolean1;
      this.lFM = paramBoolean2;
      this.jYp = paramICommLibReader;
      this.lJc = paramQualitySession;
      AppMethodBeat.o(180621);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(180620);
      p.h(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.coW);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeParcelable((Parcelable)this.cmy, 0);
      if (this.ciC)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.lFM) {
          break label119;
        }
      }
      label119:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        ICommLibReader.b.a(this.jYp, paramParcel, paramInt);
        paramParcel.writeParcelable((Parcelable)this.lJc, 0);
        AppMethodBeat.o(180620);
        return;
        b1 = 0;
        break;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackType", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "result", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "succeed", "", "errCode", "errMsg", "", "(ILcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;Ljava/util/List;ZILjava/lang/String;)V", "getCallbackType", "()I", "setCallbackType", "(I)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getProgress", "()Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "setProgress", "(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;)V", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "getSucceed", "()Z", "setSucceed", "(Z)V", "describeContents", "readFromParcel", "", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  static final class IPCCallResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCCallResult> CREATOR;
    public static final a lKD;
    boolean dCH;
    private int errCode;
    private String errMsg;
    int lKA;
    WxaPkgLoadProgress lKB;
    List<? extends IPkgInfo> lKC;
    
    static
    {
      AppMethodBeat.i(180629);
      lKD = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(180629);
    }
    
    private IPCCallResult(int paramInt1, WxaPkgLoadProgress paramWxaPkgLoadProgress, List<? extends IPkgInfo> paramList, boolean paramBoolean, int paramInt2, String paramString)
    {
      this.lKA = paramInt1;
      this.lKB = paramWxaPkgLoadProgress;
      this.lKC = paramList;
      this.dCH = paramBoolean;
      this.errCode = paramInt2;
      this.errMsg = paramString;
    }
    
    public IPCCallResult(Parcel paramParcel)
    {
      this(0, null, null, false, 0, null, 62);
      AppMethodBeat.i(180628);
      p.h(paramParcel, "source");
      this.lKA = paramParcel.readInt();
      switch (this.lKA)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(180628);
        return;
        this.lKB = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
        AppMethodBeat.o(180628);
        return;
        Object localObject = ModularizingPkgRetrieverSeparatedPluginsCompatible.lKy;
        int j = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localObject = paramParcel.readString();
          if (p.i(localObject, ModulePkgInfo.class.getName())) {
            localObject = ModulePkgInfo.class.getClassLoader();
          }
          for (;;)
          {
            if (localObject == null) {
              p.gfZ();
            }
            localObject = paramParcel.readParcelable((ClassLoader)localObject);
            if (localObject != null) {
              break;
            }
            paramParcel = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IPkgInfo");
            AppMethodBeat.o(180628);
            throw paramParcel;
            if (p.i(localObject, WxaPluginPkgInfo.class.getName())) {
              localObject = WxaPluginPkgInfo.class.getClassLoader();
            } else {
              localObject = null;
            }
          }
          localArrayList.add((IPkgInfo)localObject);
          i += 1;
        }
        this.lKC = ((List)localArrayList);
        if (paramParcel.readByte() > 0) {
          bool = true;
        }
        this.dCH = bool;
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
      paramParcel.writeInt(this.lKA);
      switch (this.lKA)
      {
      default: 
        AppMethodBeat.o(180626);
        return;
      case 1: 
        paramParcel.writeParcelable((Parcelable)this.lKB, 0);
        AppMethodBeat.o(180626);
        return;
      }
      Object localObject1 = ModularizingPkgRetrieverSeparatedPluginsCompatible.lKy;
      Object localObject2 = this.lKC;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)d.a.v.MKE;
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
      if (this.dCH) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.errCode);
        paramParcel.writeString(this.errMsg);
        break;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
    {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$Companion;", "", "()V", "CALLBACK_TYPE_PROGRESS", "", "CALLBACK_TYPE_RESULT", "TAG", "", "shouldIntercept", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "readPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Landroid/os/Parcel;", "writePkgListToParcel", "", "Landroid/os/Parcelable;", "dest", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<List<? extends IPkgInfo>, z>
    {
      a(d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wholeProgressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class b
      extends q
      implements d.g.a.b<WxaPkgLoadProgress, z>
    {
      b(d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "err", "", "errMsg", "", "invoke"})
    static final class c
      extends q
      implements m<Integer, String, z>
    {
      c(d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "callbackResult", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements d<ResultType>
  {
    c(ModularizingPkgRetrieverSeparatedPluginsCompatible paramModularizingPkgRetrieverSeparatedPluginsCompatible) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible
 * JD-Core Version:    0.7.0.1
 */