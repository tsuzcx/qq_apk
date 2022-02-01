package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "appId", "", "kotlin.jvm.PlatformType", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Lcom/tencent/mm/vfs/VFSFile;", "suffix", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class b
  extends at
{
  private final String appId;
  private final d kPJ;
  
  public b(com.tencent.luggage.sdk.d.d paramd, d paramd1)
  {
    super(paramd, paramd1);
    AppMethodBeat.i(50510);
    this.kPJ = paramd1;
    this.appId = paramd.getAppId();
    bcg().addFirst(e.aYv());
    paramd = a.kPG;
    paramd = bcg();
    p.g(paramd, "orderedFileSystemList");
    paramd1 = this.appId;
    p.g(paramd1, "appId");
    p.h(paramd, "fileSystems");
    p.h(paramd1, "appId");
    QualitySessionRuntime localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(paramd1);
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
        paramd = new d.o(((com.tencent.mm.plugin.appbrand.appstorage.o)paramd).jQf, ((com.tencent.mm.plugin.appbrand.appstorage.o)paramd).getRootPath());
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
          String str = ((z)paramd).bcm();
          p.g(str, "fs.pathPrefix");
          paramd = new d.o(n.h(str, "wxfile://", "", false), ((z)paramd).getRootPath());
        }
        else
        {
          ae.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramd.getClass().getSimpleName() });
          paramd = null;
        }
      }
    }
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.a((List)localCollection, paramd1, localQualitySessionRuntime));
    AppMethodBeat.o(50510);
  }
  
  public final m a(k paramk, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175167);
    if (paramk != null) {}
    for (long l = c.x(paramk);; l = -1L)
    {
      paramk = super.a(paramk, paramString, paramBoolean, parami);
      if (paramk == m.jPM)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.appId);
        if (paramString != null)
        {
          paramString = c.a(paramString);
          paramString.nw(l);
          paramString.aLH();
        }
      }
      p.g(paramk, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(175167);
      return paramk;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
  public static final class a
    implements r
  {
    public final void b(String paramString, k paramk)
    {
      AppMethodBeat.i(175166);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(175166);
        return;
      }
      paramString = c.a(paramString);
      paramString.nw(c.x(paramk));
      paramString.aLH();
      AppMethodBeat.o(175166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */