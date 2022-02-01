package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class g
{
  public static final a kzC;
  
  static
  {
    AppMethodBeat.i(227885);
    kzC = new a((byte)0);
    AppMethodBeat.o(227885);
  }
  
  public static final void clean()
  {
    AppMethodBeat.i(227886);
    a locala = kzC;
    long l = Util.currentTicks();
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.W(k.class);
    p.g(localObject1, "SubCoreAppBrand.getStora…icateStorage::class.java)");
    Object localObject2 = ((k)localObject1).bxT();
    localObject1 = com.tencent.mm.plugin.appbrand.task.h.bWa();
    p.g(localObject1, "aliveTaskAppId");
    ((List)localObject2).removeAll((Collection)localObject1);
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    localObject1 = com.tencent.mm.kernel.a.ayV();
    Object localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.AppBrandFileCleaner", "uin value is invaild");
      AppMethodBeat.o(227886);
      return;
    }
    localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        p.g(localObject3, "appId");
        try
        {
          localo = new o(at.bGo() + (String)localObject3 + "/");
          com.tencent.mm.plugin.appbrand.appstorage.n.t(localo);
          if (localo.exists()) {
            localo.delete();
          }
        }
        catch (Exception localException3)
        {
          try
          {
            at.dt((String)localObject1, (String)localObject3).bxq();
          }
          catch (Exception localException3)
          {
            try
            {
              at.dw((String)localObject1, (String)localObject3).bxq();
            }
            catch (Exception localException3)
            {
              try
              {
                for (;;)
                {
                  o localo = new o(at.bGo() + (String)localObject3 + "/blobTmp/");
                  com.tencent.mm.plugin.appbrand.appstorage.n.t(localo);
                  if (localo.exists()) {
                    localo.delete();
                  }
                  AppBrandLocalMediaObjectManager.clear((String)localObject3);
                  com.tencent.mm.plugin.appbrand.app.n.NK().VJ((String)localObject3);
                  ((com.tencent.luggage.sdk.customize.a)e.M(com.tencent.luggage.sdk.customize.a.class)).dD((String)localObject3).VJ((String)localObject3);
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
    com.tencent.mm.plugin.report.service.h.CyF.n(1508L, 0L, l);
    com.tencent.mm.plugin.report.service.h.CyF.n(1508L, 1L, 1L);
    AppMethodBeat.o(227886);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner$Companion;", "", "()V", "IDKEY_CLEAN_APPBRAND_FILE", "", "TAG", "", "clean", "", "cleanImpl", "uinStr", "appId", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */