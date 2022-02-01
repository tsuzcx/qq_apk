package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Lcom/tencent/mm/vfs/VFSFile;", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b
  extends ar
{
  private final String appId;
  private final d kMt;
  
  public b(com.tencent.luggage.sdk.d.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(50510);
    this.kMt = paramd;
    this.appId = paramc.getAppId();
    bbB().addFirst(com.tencent.mm.plugin.appbrand.ad.d.aYb());
    paramc = a.kMq;
    paramc = bbB();
    d.g.b.p.g(paramc, "orderedFileSystemList");
    paramd = this.appId;
    d.g.b.p.g(paramd, "appId");
    d.g.b.p.h(paramc, "fileSystems");
    d.g.b.p.h(paramd, "appId");
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(paramd);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(50510);
      return;
    }
    d.g.b.p.g(localQualitySessionRuntime, "AppBrandQualitySystem.getSession(appId) ?: return");
    paramc = (Iterable)paramc;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.iterator();
    label271:
    while (localIterator.hasNext())
    {
      paramc = (com.tencent.mm.plugin.appbrand.appstorage.p)localIterator.next();
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.appstorage.n)) {
        paramc = new o(((com.tencent.mm.plugin.appbrand.appstorage.n)paramc).jMR, ((com.tencent.mm.plugin.appbrand.appstorage.n)paramc).getRootPath());
      }
      for (;;)
      {
        if (paramc == null) {
          break label271;
        }
        localCollection.add(paramc);
        break;
        if ((paramc instanceof x))
        {
          String str = ((x)paramc).bbI();
          d.g.b.p.g(str, "fs.pathPrefix");
          paramc = new o(d.n.n.h(str, "wxfile://", "", false), ((x)paramc).getRootPath());
        }
        else
        {
          ad.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramc.getClass().getSimpleName() });
          paramc = null;
        }
      }
    }
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.a((List)localCollection, paramd, localQualitySessionRuntime));
    AppMethodBeat.o(50510);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.l a(e parame, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175167);
    if (parame != null) {}
    for (long l = c.x(parame);; l = -1L)
    {
      parame = super.a(parame, paramString, paramBoolean, parami);
      if (parame == com.tencent.mm.plugin.appbrand.appstorage.l.jMv)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.nk(l);
          paramString.aLk();
        }
      }
      d.g.b.p.g(parame, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(175167);
      return parame;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
  public static final class a
    implements q
  {
    public final void b(String paramString, e parame)
    {
      AppMethodBeat.i(175166);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.nk(c.x(parame));
      paramString.aLk();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */