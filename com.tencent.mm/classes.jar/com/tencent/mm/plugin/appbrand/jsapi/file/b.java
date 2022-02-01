package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.om;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "currentTempSize", "", "mWxaStorageSpaceStatisticsService", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService;", "maxTempSize", "maxTempTotalSize", "minTempSize", "allocTempFile", "Lcom/tencent/mm/vfs/VFSFile;", "name", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "srcFile", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "getStorageSpaceStatistics", "Lcom/tencent/mm/plugin/appbrand/appstorage/IWxaStorageSpaceStatistics;", "getTempDirectory", "pPath", "isTempFileSizeExceedLimit", "incrementSize", "registerQuotaManager", "", "release", "saveFile", "specifiedPath", "generatedPath", "Companion", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b
  extends av
{
  public static final b.a oRF;
  private final String appId;
  private long nMw;
  private long nMx;
  private long oRB;
  private long oRC;
  private bm oRD;
  private final d oRE;
  
  static
  {
    AppMethodBeat.i(253314);
    oRF = new b.a((byte)0);
    AppMethodBeat.o(253314);
  }
  
  public b(com.tencent.mm.plugin.appbrand.t paramt, d paramd)
  {
    super((com.tencent.luggage.sdk.e.d)paramt, paramd);
    AppMethodBeat.i(253313);
    this.oRE = paramd;
    this.appId = paramt.getAppId();
    this.nMx = 314572800L;
    this.nMw = 104857600L;
    this.oRB = 314572800L;
    paramt = paramt.bBP();
    if (paramt != null)
    {
      paramt.bGi();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbT, 0) == 1)
      {
        paramt = this.appId;
        kotlin.g.b.p.j(paramt, "appId");
        paramt = new bm(paramt);
        paramd = f.nCi.aal();
        if ((paramd == null) || (paramd.getBoolean("enable_appbrand_file_size_statistics_debug", false) != true)) {
          break label343;
        }
        bool1 = true;
        paramt.aGM = bool1;
        this.oRD = paramt;
      }
    }
    paramt = new StringBuilder("init WxaStorageSpaceStatisticsService ?  ");
    if (this.oRD != null) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeFileSystemRegistry", bool1);
      bIK().addFirst(e.bEH());
      paramt = a.oRy;
      paramt = bIK();
      kotlin.g.b.p.j(paramt, "orderedFileSystemList");
      paramd = this.appId;
      kotlin.g.b.p.j(paramd, "appId");
      a.a.d(paramt, paramd);
      bRY();
      paramt = AppBrandStorageQuotaManager.nMv;
      paramt = this.appId;
      kotlin.g.b.p.j(paramt, "appId");
      this.oRC = AppBrandStorageQuotaManager.cL(paramt, "temp");
      Log.i("MicroMsg.AppBrandRuntimeFileSystemRegistry", this.appId + " currentTempSize " + this.oRC);
      this.nMx = (this.oRE.cxw * 1048576L);
      this.nMw = (this.oRE.cxx * 1048576L);
      this.oRB = (this.oRE.oRG * 1048576L);
      AppMethodBeat.o(253313);
      return;
      label343:
      bool1 = false;
      break;
    }
  }
  
  private final boolean Ht(long paramLong)
  {
    AppMethodBeat.i(253312);
    if (this.oRC + paramLong > this.nMx) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(358, 225);
        Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "temp file size exceed limit! %d limit:%d", new Object[] { Long.valueOf(this.oRC + paramLong), Long.valueOf(this.nMx) });
      }
      AppMethodBeat.o(253312);
      return bool;
    }
  }
  
  private final void bRY()
  {
    AppMethodBeat.i(253305);
    Object localObject1 = AppBrandStorageQuotaManager.nMv;
    AppBrandStorageQuotaManager.reset();
    localObject1 = bIK();
    kotlin.g.b.p.j(localObject1, "orderedFileSystemList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      r localr = (r)((Iterator)localObject1).next();
      Object localObject2;
      int i;
      label119:
      long l;
      String str;
      if ((localr instanceof com.tencent.mm.plugin.appbrand.appstorage.p))
      {
        localObject2 = (CharSequence)((com.tencent.mm.plugin.appbrand.appstorage.p)localr).getRootPath();
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label119;
          }
          Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "fs root path is null, skip");
          break;
        }
        if (kotlin.g.b.p.h(((com.tencent.mm.plugin.appbrand.appstorage.p)localr).getPrefix(), "wxfile://"))
        {
          localObject2 = AppBrandStorageQuotaManager.nMv;
          localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.p)localr).getRootPath();
          kotlin.g.b.p.j(localObject2, "fs.rootPath");
          AppBrandStorageQuotaManager.cJ("temp", (String)localObject2);
          localObject2 = AppBrandStorageQuotaManager.nMv;
          localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.p)localr).getRootPath();
          kotlin.g.b.p.j(localObject2, "fs.rootPath");
          AppBrandStorageQuotaManager.cJ("saved_temp", (String)localObject2);
          localObject2 = AppBrandStorageQuotaManager.nMv;
          localObject2 = this.appId;
          kotlin.g.b.p.j(localObject2, "appId");
          if (!AppBrandStorageQuotaManager.cK((String)localObject2, "saved_temp")) {}
          for (l = -9223372036854775808L;; l = AppBrandStorageQuotaManager.cL((String)localObject2, "saved_temp"))
          {
            localObject2 = this.oRD;
            if (localObject2 != null)
            {
              str = ((com.tencent.mm.plugin.appbrand.appstorage.p)localr).getRootPath();
              kotlin.g.b.p.j(str, "fs.rootPath");
              com.tencent.mm.plugin.appbrand.appstorage.p localp = (com.tencent.mm.plugin.appbrand.appstorage.p)localr;
              kotlin.g.b.p.k(str, "dirPath");
              kotlin.g.b.p.k(localp, "fs");
              ((bm)localObject2).a(str, (n)new bm.c(localp), l);
            }
            localObject2 = AppBrandStorageQuotaManager.nMv;
            AppBrandStorageQuotaManager.cM(this.appId, "saved_temp");
            ((com.tencent.mm.plugin.appbrand.appstorage.p)localr).a((com.tencent.mm.plugin.appbrand.appstorage.t)this.oRD);
            break;
            localObject2 = AppBrandStorageQuotaManager.nMv;
            localObject2 = this.appId;
            kotlin.g.b.p.j(localObject2, "appId");
          }
        }
      }
      else if ((localr instanceof ab))
      {
        localObject2 = (CharSequence)((ab)localr).getRootPath();
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label424;
          }
          Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "fs root path is null, skip");
          break;
        }
        label424:
        localObject2 = ((ab)localr).bIR();
        if (localObject2 != null) {
          switch (((String)localObject2).hashCode())
          {
          default: 
            break;
          case -1684596265: 
            if (((String)localObject2).equals("wxfile://usr"))
            {
              localObject2 = AppBrandStorageQuotaManager.nMv;
              localObject2 = ((ab)localr).getRootPath();
              kotlin.g.b.p.j(localObject2, "fs.rootPath");
              AppBrandStorageQuotaManager.cJ("normal_none_flatten", (String)localObject2);
              localObject2 = AppBrandStorageQuotaManager.nMv;
              localObject2 = this.appId;
              kotlin.g.b.p.j(localObject2, "appId");
              if (!AppBrandStorageQuotaManager.cK((String)localObject2, "normal_none_flatten")) {}
              for (l = -9223372036854775808L;; l = AppBrandStorageQuotaManager.cL((String)localObject2, "normal_none_flatten"))
              {
                localObject2 = this.oRD;
                if (localObject2 != null)
                {
                  str = ((ab)localr).getRootPath();
                  kotlin.g.b.p.j(str, "fs.rootPath");
                  kotlin.g.b.p.k(str, "dirPath");
                  ((bm)localObject2).a(str, (n)new bm.b(), l);
                }
                localObject2 = AppBrandStorageQuotaManager.nMv;
                AppBrandStorageQuotaManager.cM(this.appId, "normal_none_flatten");
                ((ab)localr).a((com.tencent.mm.plugin.appbrand.appstorage.t)this.oRD);
                break;
                localObject2 = AppBrandStorageQuotaManager.nMv;
                localObject2 = this.appId;
                kotlin.g.b.p.j(localObject2, "appId");
              }
            }
            break;
          }
        }
      }
    }
    AppMethodBeat.o(253305);
  }
  
  public final m a(i<String> parami)
  {
    AppMethodBeat.i(253308);
    if (Ht(0L))
    {
      if (parami != null) {
        parami.value = null;
      }
      parami = m.nNg;
      AppMethodBeat.o(253308);
      return parami;
    }
    parami = super.a(parami);
    kotlin.g.b.p.j(parami, "super.getTempDirectory(pPath)");
    AppMethodBeat.o(253308);
    return parami;
  }
  
  public final m a(q paramq, String paramString, i<String> parami)
  {
    AppMethodBeat.i(253310);
    long l2 = this.oRC;
    if (paramq != null) {}
    for (long l1 = paramq.length();; l1 = 0L)
    {
      this.oRC = (l2 - l1);
      paramq = super.a(paramq, paramString, parami);
      kotlin.g.b.p.j(paramq, "super.saveFile(srcFile, …ifiedPath, generatedPath)");
      AppMethodBeat.o(253310);
      return paramq;
    }
  }
  
  public final m a(q paramq, String paramString, boolean paramBoolean, i<String> parami)
  {
    long l2 = 0L;
    AppMethodBeat.i(175167);
    if (paramq != null) {}
    for (long l1 = paramq.length(); Ht(l1); l1 = 0L)
    {
      if (parami != null) {
        parami.value = null;
      }
      paramq = m.nNg;
      AppMethodBeat.o(175167);
      return paramq;
    }
    long l3 = this.oRC;
    l1 = l2;
    if (paramq != null) {
      l1 = paramq.length();
    }
    this.oRC = (l3 + l1);
    if (paramq != null) {}
    for (l1 = c.v(paramq);; l1 = -1L)
    {
      paramq = super.a(paramq, paramString, paramBoolean, parami);
      if (paramq == m.nMR)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.Bb(l1);
          paramString.bpa();
        }
      }
      kotlin.g.b.p.j(paramq, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(175167);
      return paramq;
    }
  }
  
  public final q adN(String paramString)
  {
    AppMethodBeat.i(253306);
    if (Ht(0L))
    {
      AppMethodBeat.o(253306);
      return null;
    }
    paramString = super.adN(paramString);
    AppMethodBeat.o(253306);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.t bIH()
  {
    return (com.tencent.mm.plugin.appbrand.appstorage.t)this.oRD;
  }
  
  public final void release()
  {
    AppMethodBeat.i(253311);
    ??? = AppBrandStorageQuotaManager.nMv;
    Object localObject2 = this.appId;
    kotlin.g.b.p.j(localObject2, "appId");
    long l3 = this.nMw;
    long l4 = this.nMx;
    long l5 = this.oRB;
    kotlin.g.b.p.k(localObject2, "appId");
    ??? = com.tencent.mm.plugin.appbrand.report.quality.b.amO((String)localObject2);
    boolean bool1;
    if (??? != null) {
      bool1 = true;
    }
    for (;;)
    {
      Object localObject4 = com.tencent.mm.plugin.appbrand.d.abB((String)localObject2);
      long l1;
      label95:
      int i;
      label106:
      long l2;
      label119:
      boolean bool2;
      if (localObject4 != null)
      {
        localObject4 = ((AppBrandSysConfigWC)localObject4).nYR;
        if (localObject4 != null)
        {
          l1 = ((WxaPkgWrappingInfo)localObject4).pkgVersion;
          if (??? == null) {
            break label379;
          }
          i = ((QualitySessionRuntime)???).qLQ;
          if (??? == null) {
            break label384;
          }
          l2 = ((QualitySessionRuntime)???).apptype;
          Log.i("MicroMsg.AppBrandStorageQuotaManager", "start check: appId[" + (String)localObject2 + "] minTemp[" + l3 + "] maxTemp[" + l4 + "] maxTotal[" + l5 + "] " + bool1 + ' ' + l2 + ' ' + i + ' ' + l1);
          ??? = com.tencent.mm.plugin.appbrand.d.abA((String)localObject2);
          if (??? == null) {
            break label390;
          }
          ??? = ((com.tencent.mm.plugin.appbrand.t)???).Sh();
          if (??? == null) {
            break label390;
          }
          ??? = ((av)???).bIH();
          label246:
          if (??? == null) {
            break label396;
          }
          bool2 = true;
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams((String)localObject2, l3, l4, l5, AppBrandStorageQuotaManager.nMt, bool1, l1, i, l2, bool2, AppBrandStorageQuotaManager.nMu), AppBrandStorageQuotaManager.a.class, null);
          localObject2 = this.oRD;
          if (localObject2 == null) {}
        }
      }
      synchronized (((bm)localObject2).LOCK)
      {
        ((bm)localObject2).oSR.clear();
        ((bm)localObject2).oSQ.clear();
        localObject2 = x.aazN;
        super.release();
        AppMethodBeat.o(253311);
        return;
        bool1 = false;
        continue;
        if (??? != null)
        {
          l1 = ((QualitySessionRuntime)???).qNx;
          break label95;
        }
        l1 = 0L;
        break label95;
        label379:
        i = 0;
        break label106;
        label384:
        l2 = 0L;
        break label119;
        label390:
        ??? = null;
        break label246;
        label396:
        bool2 = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
  public static final class b
    implements s
  {
    public final void b(String paramString, q paramq)
    {
      AppMethodBeat.i(175166);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.report.quality.b.amO(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.Bb(c.v(paramq));
      paramString.bpa();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */