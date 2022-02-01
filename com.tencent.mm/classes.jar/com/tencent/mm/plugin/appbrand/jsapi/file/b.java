package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sf;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "currentTempSize", "", "mWxaStorageSpaceStatisticsService", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService;", "maxTempSize", "maxTempTotalSize", "minTempSize", "allocTempFile", "Lcom/tencent/mm/vfs/VFSFile;", "name", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "srcFile", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "getStorageSpaceStatistics", "Lcom/tencent/mm/plugin/appbrand/appstorage/IWxaStorageSpaceStatistics;", "getTempDirectory", "pPath", "isTempFileSizeExceedLimit", "incrementSize", "registerQuotaManager", "", "release", "saveFile", "specifiedPath", "generatedPath", "Companion", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ax
{
  public static final b.a rXb;
  private final String appId;
  private long qMw;
  private long qMx;
  private final d rXc;
  private long rXd;
  private long rXe;
  private bp rXf;
  
  static
  {
    AppMethodBeat.i(329036);
    rXb = new b.a((byte)0);
    AppMethodBeat.o(329036);
  }
  
  public b(com.tencent.mm.plugin.appbrand.w paramw, d paramd)
  {
    super((com.tencent.luggage.sdk.e.d)paramw, paramd);
    AppMethodBeat.i(329001);
    this.rXc = paramd;
    this.appId = paramw.mAppId;
    this.qMx = 314572800L;
    this.qMw = 104857600L;
    this.rXd = 314572800L;
    paramw = paramw.cbl();
    boolean bool;
    if (paramw != null)
    {
      paramw.cfG();
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvs, 0) == 1)
      {
        paramw = this.appId;
        kotlin.g.b.s.s(paramw, "appId");
        paramw = new bp(paramw);
        paramd = f.qBv;
        paramd = f.aBP();
        if ((paramd == null) || (paramd.getBoolean("enable_appbrand_file_size_statistics_debug", false) != true)) {
          break label329;
        }
        bool = true;
        paramw.debug = bool;
        paramd = ah.aiuX;
        this.rXf = paramw;
      }
    }
    label165:
    QualitySessionRuntime localQualitySessionRuntime;
    Collection localCollection;
    Iterator localIterator;
    if (this.rXf != null)
    {
      bool = true;
      Log.i("MicroMsg.AppBrandRuntimeFileSystemRegistry", kotlin.g.b.s.X("init WxaStorageSpaceStatisticsService ?  ", Boolean.valueOf(bool)));
      this.qNv.addFirst(e.cdS());
      paramw = a.rWY;
      paramw = this.qNv;
      kotlin.g.b.s.s(paramw, "orderedFileSystemList");
      paramd = this.appId;
      kotlin.g.b.s.s(paramd, "appId");
      kotlin.g.b.s.u(paramw, "fileSystems");
      kotlin.g.b.s.u(paramd, "appId");
      localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(paramd);
      if (localQualitySessionRuntime != null)
      {
        paramw = (Iterable)paramw;
        localCollection = (Collection)new ArrayList();
        localIterator = paramw.iterator();
      }
    }
    else
    {
      label263:
      label418:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label420;
        }
        paramw = (com.tencent.mm.plugin.appbrand.appstorage.w)localIterator.next();
        if ((paramw instanceof com.tencent.mm.plugin.appbrand.appstorage.u)) {
          paramw = new kotlin.r(((com.tencent.mm.plugin.appbrand.appstorage.u)paramw).qNf, ((com.tencent.mm.plugin.appbrand.appstorage.u)paramw).qMI);
        }
        for (;;)
        {
          if (paramw == null) {
            break label418;
          }
          localCollection.add(paramw);
          break label263;
          label329:
          bool = false;
          break;
          bool = false;
          break label165;
          if ((paramw instanceof af))
          {
            String str = ((af)paramw).qNA;
            kotlin.g.b.s.s(str, "fs.pathPrefix");
            paramw = new kotlin.r(n.bV(str, "wxfile://", ""), ((af)paramw).qMI);
          }
          else
          {
            Log.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramw.getClass().getSimpleName() });
            paramw = null;
          }
        }
      }
      label420:
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new a.a.a((List)localCollection, paramd, localQualitySessionRuntime));
    }
    csc();
    paramw = AppBrandStorageQuotaManager.qMt;
    paramw = this.appId;
    kotlin.g.b.s.s(paramw, "appId");
    this.rXe = AppBrandStorageQuotaManager.dc(paramw, "temp");
    Log.i("MicroMsg.AppBrandRuntimeFileSystemRegistry", this.appId + " currentTempSize " + this.rXe);
    this.qMx = (this.rXc.epO * 1048576L);
    this.qMw = (this.rXc.epP * 1048576L);
    this.rXd = (this.rXc.rXg * 1048576L);
    AppMethodBeat.o(329001);
  }
  
  private final void csc()
  {
    AppMethodBeat.i(329022);
    Object localObject1 = AppBrandStorageQuotaManager.qMt;
    AppBrandStorageQuotaManager.reset();
    localObject1 = this.qNv;
    kotlin.g.b.s.s(localObject1, "orderedFileSystemList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.plugin.appbrand.appstorage.w localw = (com.tencent.mm.plugin.appbrand.appstorage.w)((Iterator)localObject1).next();
      Object localObject2;
      int i;
      label119:
      long l;
      String str;
      if ((localw instanceof com.tencent.mm.plugin.appbrand.appstorage.u))
      {
        localObject2 = (CharSequence)((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qMI;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label119;
          }
          Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "fs root path is null, skip");
          break;
        }
        if (kotlin.g.b.s.p(((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qMH, "wxfile://"))
        {
          localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qMI;
          kotlin.g.b.s.s(localObject2, "fs.rootPath");
          AppBrandStorageQuotaManager.da("temp", (String)localObject2);
          localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qMI;
          kotlin.g.b.s.s(localObject2, "fs.rootPath");
          AppBrandStorageQuotaManager.da("saved_temp", (String)localObject2);
          localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = this.appId;
          kotlin.g.b.s.s(localObject2, "appId");
          if (!AppBrandStorageQuotaManager.db((String)localObject2, "saved_temp")) {}
          for (l = -9223372036854775808L;; l = AppBrandStorageQuotaManager.dc((String)localObject2, "saved_temp"))
          {
            localObject2 = this.rXf;
            if (localObject2 != null)
            {
              str = ((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qMI;
              kotlin.g.b.s.s(str, "fs.rootPath");
              kotlin.g.b.s.s(localw, "fs");
              com.tencent.mm.plugin.appbrand.appstorage.u localu = (com.tencent.mm.plugin.appbrand.appstorage.u)localw;
              kotlin.g.b.s.u(str, "dirPath");
              kotlin.g.b.s.u(localu, "fs");
              ((bp)localObject2).a(str, (com.tencent.mm.plugin.appbrand.appstorage.s)new bp.c(localu), l);
            }
            localObject2 = AppBrandStorageQuotaManager.qMt;
            AppBrandStorageQuotaManager.dd(this.appId, "saved_temp");
            ((com.tencent.mm.plugin.appbrand.appstorage.u)localw).qNe = ((y)this.rXf);
            break;
            localObject2 = AppBrandStorageQuotaManager.qMt;
            localObject2 = this.appId;
            kotlin.g.b.s.s(localObject2, "appId");
          }
        }
      }
      else if ((localw instanceof af))
      {
        localObject2 = (CharSequence)((af)localw).qMI;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label433;
          }
          Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "fs root path is null, skip");
          break;
        }
        label433:
        if (kotlin.g.b.s.p(((af)localw).qNA, "wxfile://usr"))
        {
          localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = ((af)localw).qMI;
          kotlin.g.b.s.s(localObject2, "fs.rootPath");
          AppBrandStorageQuotaManager.da("normal_none_flatten", (String)localObject2);
          localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = this.appId;
          kotlin.g.b.s.s(localObject2, "appId");
          if (!AppBrandStorageQuotaManager.db((String)localObject2, "normal_none_flatten")) {}
          for (l = -9223372036854775808L;; l = AppBrandStorageQuotaManager.dc((String)localObject2, "normal_none_flatten"))
          {
            localObject2 = this.rXf;
            if (localObject2 != null)
            {
              str = ((af)localw).qMI;
              kotlin.g.b.s.s(str, "fs.rootPath");
              kotlin.g.b.s.u(str, "dirPath");
              ((bp)localObject2).a(str, (com.tencent.mm.plugin.appbrand.appstorage.s)new bp.b(), l);
            }
            localObject2 = AppBrandStorageQuotaManager.qMt;
            AppBrandStorageQuotaManager.dd(this.appId, "normal_none_flatten");
            ((af)localw).qNe = ((y)this.rXf);
            break;
            localObject2 = AppBrandStorageQuotaManager.qMt;
            localObject2 = this.appId;
            kotlin.g.b.s.s(localObject2, "appId");
          }
        }
      }
    }
    AppMethodBeat.o(329022);
  }
  
  private final boolean jJ(long paramLong)
  {
    AppMethodBeat.i(329030);
    if (this.rXe + paramLong > this.qMx) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(358, 225);
        Log.w("MicroMsg.AppBrandRuntimeFileSystemRegistry", "temp file size exceed limit! %d limit:%d", new Object[] { Long.valueOf(this.rXe + paramLong), Long.valueOf(this.qMx) });
      }
      AppMethodBeat.o(329030);
      return bool;
    }
  }
  
  public final com.tencent.mm.vfs.u Wo(String paramString)
  {
    AppMethodBeat.i(329044);
    if (jJ(0L))
    {
      AppMethodBeat.o(329044);
      return null;
    }
    paramString = super.Wo(paramString);
    AppMethodBeat.o(329044);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r a(k<String> paramk)
  {
    AppMethodBeat.i(329052);
    if (jJ(0L))
    {
      if (paramk != null) {
        paramk.value = null;
      }
      paramk = com.tencent.mm.plugin.appbrand.appstorage.r.qNa;
      AppMethodBeat.o(329052);
      return paramk;
    }
    paramk = super.a(paramk);
    kotlin.g.b.s.s(paramk, "super.getTempDirectory(pPath)");
    AppMethodBeat.o(329052);
    return paramk;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r a(com.tencent.mm.vfs.u paramu, String paramString, k<String> paramk)
  {
    AppMethodBeat.i(329068);
    long l2 = this.rXe;
    if (paramu == null) {}
    for (long l1 = 0L;; l1 = paramu.length())
    {
      this.rXe = (l2 - l1);
      paramu = super.a(paramu, paramString, paramk);
      kotlin.g.b.s.s(paramu, "super.saveFile(srcFile, …ifiedPath, generatedPath)");
      AppMethodBeat.o(329068);
      return paramu;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.r a(com.tencent.mm.vfs.u paramu, String paramString, boolean paramBoolean, k<String> paramk)
  {
    long l2 = 0L;
    AppMethodBeat.i(175167);
    if (paramu == null) {}
    for (long l1 = 0L; jJ(l1); l1 = paramu.length())
    {
      if (paramk != null) {
        paramk.value = null;
      }
      paramu = com.tencent.mm.plugin.appbrand.appstorage.r.qNa;
      AppMethodBeat.o(175167);
      return paramu;
    }
    long l3 = this.rXe;
    if (paramu == null)
    {
      l1 = l2;
      this.rXe = (l3 + l1);
      if (paramu != null) {
        break label158;
      }
    }
    label158:
    for (l1 = -1L;; l1 = c.w(paramu))
    {
      paramu = super.a(paramu, paramString, paramBoolean, paramk);
      kotlin.g.b.s.s(paramu, "super.createTempFileFrom…, deleteSrc, pResultPath)");
      if (paramu == com.tencent.mm.plugin.appbrand.appstorage.r.qML)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.jxJ = l1;
          paramString.bMH();
        }
      }
      AppMethodBeat.o(175167);
      return paramu;
      l1 = paramu.length();
      break;
    }
  }
  
  public final y cim()
  {
    return (y)this.rXf;
  }
  
  public final void release()
  {
    AppMethodBeat.i(329079);
    ??? = AppBrandStorageQuotaManager.qMt;
    Object localObject2 = this.appId;
    kotlin.g.b.s.s(localObject2, "appId");
    long l3 = this.qMw;
    long l4 = this.qMx;
    long l5 = this.rXd;
    kotlin.g.b.s.u(localObject2, "appId");
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.afZ((String)localObject2);
    boolean bool1;
    if (localQualitySessionRuntime != null) {
      bool1 = true;
    }
    for (;;)
    {
      ??? = com.tencent.mm.plugin.appbrand.d.Ud((String)localObject2);
      label79:
      long l1;
      label91:
      int i;
      label98:
      long l2;
      label106:
      boolean bool2;
      if (??? == null)
      {
        ??? = null;
        if (??? != null) {
          break label372;
        }
        if (localQualitySessionRuntime != null) {
          break label362;
        }
        l1 = 0L;
        if (localQualitySessionRuntime != null) {
          break label381;
        }
        i = 0;
        if (localQualitySessionRuntime != null) {
          break label390;
        }
        l2 = 0L;
        Log.i("MicroMsg.AppBrandStorageQuotaManager", "start check: appId[" + (String)localObject2 + "] minTemp[" + l3 + "] maxTemp[" + l4 + "] maxTotal[" + l5 + "] " + bool1 + ' ' + l2 + ' ' + i + ' ' + l1);
        ??? = com.tencent.mm.plugin.appbrand.d.Uc((String)localObject2);
        if (??? != null) {
          break label401;
        }
        ??? = null;
        label217:
        if (??? == null) {
          break label429;
        }
        bool2 = true;
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams((String)localObject2, l3, l4, l5, AppBrandStorageQuotaManager.qMu, bool1, l1, i, l2, bool2, AppBrandStorageQuotaManager.qMv), AppBrandStorageQuotaManager.a.class, null);
        localObject2 = this.rXf;
        if (localObject2 == null) {}
      }
      synchronized (((bp)localObject2).Mp)
      {
        ((bp)localObject2).rYl.clear();
        ((bp)localObject2).rYk.clear();
        localObject2 = ah.aiuX;
        super.release();
        AppMethodBeat.o(329079);
        return;
        bool1 = false;
        continue;
        ??? = ((AppBrandSysConfigWC)???).qYY;
        if (??? == null)
        {
          ??? = null;
          break label79;
        }
        ??? = Long.valueOf(((WxaPkgWrappingInfo)???).pkgVersion);
        break label79;
        label362:
        l1 = localQualitySessionRuntime.tSh;
        break label91;
        label372:
        l1 = ((Long)???).longValue();
        break label91;
        label381:
        i = localQualitySessionRuntime.tQx;
        break label98;
        label390:
        l2 = localQualitySessionRuntime.apptype;
        break label106;
        label401:
        ??? = ((com.tencent.mm.plugin.appbrand.w)???).asx();
        if (??? == null)
        {
          ??? = null;
          break label217;
        }
        ??? = ((ax)???).cim();
        break label217;
        label429:
        bool2 = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements x
  {
    public final void b(String paramString, com.tencent.mm.vfs.u paramu)
    {
      AppMethodBeat.i(175166);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.jxJ = c.w(paramu);
      paramString.bMH();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */