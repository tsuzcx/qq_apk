package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Lcom/tencent/mm/vfs/VFSFile;", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b
  extends ar
{
  private final String appId;
  private final d kqX;
  
  public b(com.tencent.luggage.sdk.d.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(50510);
    this.kqX = paramd;
    this.appId = paramc.getAppId();
    aYd().addFirst(com.tencent.mm.plugin.appbrand.ad.d.aUO());
    paramc = a.kqU;
    paramc = aYd();
    k.g(paramc, "orderedFileSystemList");
    paramd = this.appId;
    k.g(paramd, "appId");
    k.h(paramc, "fileSystems");
    k.h(paramd, "appId");
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.QN(paramd);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(50510);
      return;
    }
    k.g(localQualitySessionRuntime, "AppBrandQualitySystem.getSession(appId) ?: return");
    paramc = (Iterable)paramc;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.iterator();
    label271:
    while (localIterator.hasNext())
    {
      paramc = (p)localIterator.next();
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.appstorage.n)) {
        paramc = new o(((com.tencent.mm.plugin.appbrand.appstorage.n)paramc).jsX, ((com.tencent.mm.plugin.appbrand.appstorage.n)paramc).getRootPath());
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
          String str = ((x)paramc).aYk();
          k.g(str, "fs.pathPrefix");
          paramc = new o(d.n.n.h(str, "wxfile://", "", false), ((x)paramc).getRootPath());
        }
        else
        {
          ac.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramc.getClass().getSimpleName() });
          paramc = null;
        }
      }
    }
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.a((List)localCollection, paramd, localQualitySessionRuntime));
    AppMethodBeat.o(50510);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.l a(e parame, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175167);
    if (parame != null) {}
    for (long l = c.x(parame);; l = -1L)
    {
      parame = super.a(parame, paramString, paramBoolean, parami);
      if (parame == com.tencent.mm.plugin.appbrand.appstorage.l.jsB)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.lq(l);
          paramString.aHZ();
        }
      }
      k.g(parame, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(175167);
      return parame;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
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
      paramString = com.tencent.mm.plugin.appbrand.report.quality.a.QN(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.lq(c.x(parame));
      paramString.aHZ();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */