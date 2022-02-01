package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lo;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Lcom/tencent/mm/vfs/VFSFile;", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b
  extends at
{
  private final String appId;
  private final d lUH;
  
  public b(com.tencent.luggage.sdk.d.d paramd, d paramd1)
  {
    super(paramd, paramd1);
    AppMethodBeat.i(50510);
    this.lUH = paramd1;
    this.appId = paramd.getAppId();
    bxv().addFirst(e.btJ());
    paramd = a.lUE;
    paramd = bxv();
    p.g(paramd, "orderedFileSystemList");
    paramd1 = this.appId;
    p.g(paramd1, "appId");
    p.h(paramd, "fileSystems");
    p.h(paramd1, "appId");
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(paramd1);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(50510);
      return;
    }
    p.g(localQualitySessionRuntime, "AppBrandQualitySystem.getSession(appId) ?: return");
    paramd = (Iterable)paramd;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramd.iterator();
    label271:
    while (localIterator.hasNext())
    {
      paramd = (q)localIterator.next();
      if ((paramd instanceof com.tencent.mm.plugin.appbrand.appstorage.o)) {
        paramd = new kotlin.o(((com.tencent.mm.plugin.appbrand.appstorage.o)paramd).kSO, ((com.tencent.mm.plugin.appbrand.appstorage.o)paramd).getRootPath());
      }
      for (;;)
      {
        if (paramd == null) {
          break label271;
        }
        localCollection.add(paramd);
        break;
        if ((paramd instanceof z))
        {
          String str = ((z)paramd).bxB();
          p.g(str, "fs.pathPrefix");
          paramd = new kotlin.o(n.j(str, "wxfile://", "", false), ((z)paramd).getRootPath());
        }
        else
        {
          Log.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramd.getClass().getSimpleName() });
          paramd = null;
        }
      }
    }
    com.tencent.mm.ac.d.i((kotlin.g.a.a)new a.a.a((List)localCollection, paramd1, localQualitySessionRuntime));
    AppMethodBeat.o(50510);
  }
  
  public final m a(com.tencent.mm.vfs.o paramo, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175167);
    if (paramo != null) {}
    for (long l = c.w(paramo);; l = -1L)
    {
      paramo = super.a(paramo, paramString, paramBoolean, parami);
      if (paramo == m.kSu)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.vg(l);
          paramString.bfK();
        }
      }
      p.g(paramo, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(175167);
      return paramo;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
  public static final class a
    implements r
  {
    public final void b(String paramString, com.tencent.mm.vfs.o paramo)
    {
      AppMethodBeat.i(175166);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.vg(c.w(paramo));
      paramString.bfK();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */