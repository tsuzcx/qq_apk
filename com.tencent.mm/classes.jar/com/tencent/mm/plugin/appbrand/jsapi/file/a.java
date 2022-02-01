package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandFileOccupationReporter;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a oRy;
  
  static
  {
    AppMethodBeat.i(180476);
    oRy = new a((byte)0);
    AppMethodBeat.o(180476);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandFileOccupationReporter$Companion;", "", "()V", "TAG", "", "reportOccupationOnStart", "", "fileSystems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "appId", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void d(LinkedList<r> paramLinkedList, final String paramString)
    {
      AppMethodBeat.i(276897);
      kotlin.g.b.p.k(paramLinkedList, "fileSystems");
      kotlin.g.b.p.k(paramString, "appId");
      final QualitySessionRuntime localQualitySessionRuntime = b.amO(paramString);
      if (localQualitySessionRuntime == null)
      {
        AppMethodBeat.o(276897);
        return;
      }
      kotlin.g.b.p.j(localQualitySessionRuntime, "AppBrandQualitySystem.getSession(appId) ?: return");
      paramLinkedList = (Iterable)paramLinkedList;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramLinkedList.iterator();
      label202:
      while (localIterator.hasNext())
      {
        paramLinkedList = (r)localIterator.next();
        if ((paramLinkedList instanceof com.tencent.mm.plugin.appbrand.appstorage.p)) {
          paramLinkedList = new o(((com.tencent.mm.plugin.appbrand.appstorage.p)paramLinkedList).nNm, ((com.tencent.mm.plugin.appbrand.appstorage.p)paramLinkedList).getRootPath());
        }
        for (;;)
        {
          if (paramLinkedList == null) {
            break label202;
          }
          localCollection.add(paramLinkedList);
          break;
          if ((paramLinkedList instanceof ab))
          {
            String str = ((ab)paramLinkedList).bIR();
            kotlin.g.b.p.j(str, "fs.pathPrefix");
            paramLinkedList = new o(n.l(str, "wxfile://", "", false), ((ab)paramLinkedList).getRootPath());
          }
          else
          {
            Log.w("MicroMsg.AppBrand.AppBrandFileOccupationReporter", "unknown type: %s", new Object[] { paramLinkedList.getClass().getSimpleName() });
            paramLinkedList = null;
          }
        }
      }
      d.h((kotlin.g.a.a)new a((List)localCollection, paramString, localQualitySessionRuntime));
      AppMethodBeat.o(276897);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(List paramList, String paramString, QualitySessionRuntime paramQualitySessionRuntime)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.a
 * JD-Core Version:    0.7.0.1
 */