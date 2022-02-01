package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.customize.a;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class j
{
  public static final a nsO;
  
  static
  {
    AppMethodBeat.i(283324);
    nsO = new a((byte)0);
    AppMethodBeat.o(283324);
  }
  
  public static final void clean()
  {
    AppMethodBeat.i(283325);
    a locala = nsO;
    long l = Util.currentTicks();
    Object localObject1 = m.W(k.class);
    p.j(localObject1, "SubCoreAppBrand.getStora…icateStorage::class.java)");
    Object localObject2 = ((k)localObject1).bJi();
    localObject1 = i.qRL;
    Object localObject3 = (Iterable)i.a.cjb().RS();
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      kotlin.a.j.a((Collection)localObject1, (Iterable)((c)((Iterator)localObject3).next()).RO());
    }
    localObject3 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject1).add(((com.tencent.luggage.sdk.processes.e)((Iterator)localObject3).next()).appId);
    }
    ((List)localObject2).removeAll((Collection)localObject1);
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject1 = b.aGq();
    localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.AppBrandFileCleaner", "uin value is invaild");
      AppMethodBeat.o(283325);
      return;
    }
    localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        p.j(localObject3, "appId");
        try
        {
          localq = new q(av.bSa() + (String)localObject3 + "/");
          o.s(localq);
          if (localq.ifE()) {
            localq.cFq();
          }
        }
        catch (Exception localException3)
        {
          try
          {
            av.dB((String)localObject1, (String)localObject3).bIE();
          }
          catch (Exception localException3)
          {
            try
            {
              av.dE((String)localObject1, (String)localObject3).bIE();
            }
            catch (Exception localException3)
            {
              try
              {
                for (;;)
                {
                  q localq = new q(av.bSa() + (String)localObject3 + "/blobTmp/");
                  o.s(localq);
                  if (localq.ifE()) {
                    localq.cFq();
                  }
                  AppBrandLocalMediaObjectManager.clear((String)localObject3);
                  m.QF().adu((String)localObject3);
                  ((a)com.tencent.luggage.a.e.K(a.class)).dX((String)localObject3).adu((String)localObject3);
                  JsApiOperateWXData.clear((String)localObject3);
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
    Log.d("MicroMsg.AppBrandFileCleaner", "%d clean appbrand file costTime[%d]", new Object[] { Integer.valueOf(((a)locala).hashCode()), Long.valueOf(l) });
    com.tencent.mm.plugin.report.service.h.IzE.p(1508L, 0L, l);
    com.tencent.mm.plugin.report.service.h.IzE.p(1508L, 1L, 1L);
    AppMethodBeat.o(283325);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner$Companion;", "", "()V", "IDKEY_CLEAN_APPBRAND_FILE", "", "TAG", "", "clean", "", "cleanImpl", "uinStr", "appId", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */