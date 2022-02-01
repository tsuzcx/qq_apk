package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.a.a.a.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a qrt;
  
  static
  {
    AppMethodBeat.i(316802);
    qrt = new j.a((byte)0);
    AppMethodBeat.o(316802);
  }
  
  public static final void clean()
  {
    AppMethodBeat.i(316798);
    j.a locala = qrt;
    long l = Util.currentTicks();
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.appusage.j)n.ag(com.tencent.mm.plugin.appbrand.appusage.j.class)).ciM();
    if (localObject2 != null)
    {
      Object localObject1 = i.tWq;
      Object localObject3 = (Iterable)i.a.cJV().asj();
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.luggage.sdk.processes.e)((Iterator)localObject3).next()).appId);
      }
      ((List)localObject2).removeAll((Collection)localObject1);
      com.tencent.mm.kernel.h.baC();
      localObject1 = b.aZs();
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e("MicroMsg.AppBrandFileCleaner", "uin value is invaild");
        AppMethodBeat.o(316798);
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          s.s(localObject1, "uin");
          s.s(localObject3, "appId");
          try
          {
            localObject4 = new u(ax.cse() + (String)localObject3 + '/');
            t.t((u)localObject4);
            if (((u)localObject4).jKS()) {
              ((u)localObject4).diJ();
            }
          }
          catch (Exception localException3)
          {
            try
            {
              ax.dU((String)localObject1, (String)localObject3).cij();
            }
            catch (Exception localException3)
            {
              try
              {
                ax.dX((String)localObject1, (String)localObject3).cij();
              }
              catch (Exception localException3)
              {
                try
                {
                  for (;;)
                  {
                    Object localObject4 = new u(ax.cse() + (String)localObject3 + "/blobTmp/");
                    t.t((u)localObject4);
                    if (((u)localObject4).jKS()) {
                      ((u)localObject4).diJ();
                    }
                    AppBrandLocalMediaObjectManager.clear((String)localObject3);
                    ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.T(com.tencent.luggage.sdk.customize.a.class)).fn((String)localObject3);
                    JsApiOperateWXData.clear((String)localObject3);
                    localObject4 = com.tencent.mm.plugin.appbrand.a.a.a.qAy;
                    a.a.cK((String)localObject1, (String)localObject3);
                    break;
                    localException1 = localException1;
                    Log.e("MicroMsg.AppBrandFileCleaner", "clean Flatten appId=%s e=%s", new Object[] { localObject3, localException1 });
                    continue;
                    localException2 = localException2;
                    Log.e("MicroMsg.AppBrandFileCleaner", "clean NonFlatten appId=%s e=%s", new Object[] { localObject3, localException2 });
                    continue;
                    localException3 = localException3;
                    Log.e("MicroMsg.AppBrandFileCleaner", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { localObject3, localException3 });
                  }
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.AppBrandFileCleaner", "clean flattenBlobPath appId=%s e=%s", new Object[] { localObject3, localException4 });
                  }
                }
              }
            }
          }
        }
      }
      l = Util.ticksToNow(l);
      Log.d("MicroMsg.AppBrandFileCleaner", "%d clean appbrand file costTime[%d]", new Object[] { Integer.valueOf(locala.hashCode()), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1508L, 0L, l);
      com.tencent.mm.plugin.report.service.h.OAn.p(1508L, 1L, 1L);
    }
    AppMethodBeat.o(316798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */