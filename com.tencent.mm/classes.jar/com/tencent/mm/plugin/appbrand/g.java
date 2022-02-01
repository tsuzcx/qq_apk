package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class g
{
  public static final a jyU;
  
  static
  {
    AppMethodBeat.i(223189);
    jyU = new a((byte)0);
    AppMethodBeat.o(223189);
  }
  
  public static final void clean()
  {
    AppMethodBeat.i(223190);
    a locala = jyU;
    long l = bu.HQ();
    Object localObject1 = j.T(com.tencent.mm.plugin.appbrand.appusage.k.class);
    p.g(localObject1, "SubCoreAppBrand.getStora…icateStorage::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.appusage.k)localObject1).bcE();
    localObject1 = f.bzB();
    p.g(localObject1, "aliveTaskAppId");
    ((List)localObject2).removeAll((Collection)localObject1);
    p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    localObject1 = com.tencent.mm.kernel.a.aiF();
    Object localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("MicroMsg.AppBrandFileCleaner", "uin value is invaild");
      AppMethodBeat.o(223190);
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
          localk = new com.tencent.mm.vfs.k(at.bkQ() + (String)localObject3 + "/");
          n.u(localk);
          if (localk.exists()) {
            localk.delete();
          }
        }
        catch (Exception localException3)
        {
          try
          {
            at.dd((String)localObject1, (String)localObject3).bcb();
          }
          catch (Exception localException3)
          {
            try
            {
              at.dh((String)localObject1, (String)localObject3).bcb();
            }
            catch (Exception localException3)
            {
              try
              {
                for (;;)
                {
                  com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(at.bkQ() + (String)localObject3 + "/blobTmp/");
                  n.u(localk);
                  if (localk.exists()) {
                    localk.delete();
                  }
                  AppBrandLocalMediaObjectManager.clear((String)localObject3);
                  j.El().MA((String)localObject3);
                  ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).dl((String)localObject3).MA((String)localObject3);
                  JsApiOperateWXData.clear((String)localObject3);
                  break;
                  localException1 = localException1;
                  ae.e("MicroMsg.AppBrandFileCleaner", "clean Flatten appId=%s e=%s", new Object[] { localObject3, localException1 });
                  continue;
                  localException2 = localException2;
                  ae.e("MicroMsg.AppBrandFileCleaner", "clean NonFlatten appId=%s e=%s", new Object[] { localObject3, localException2 });
                  continue;
                  localException3 = localException3;
                  ae.e("MicroMsg.AppBrandFileCleaner", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { localObject3, localException3 });
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ae.e("MicroMsg.AppBrandFileCleaner", "clean flattenBlobPath appId=%s e=%s", new Object[] { localObject3, localException4 });
                }
              }
            }
          }
        }
      }
    }
    l = bu.aO(l);
    ae.d("MicroMsg.AppBrandFileCleaner", "%d clean appbrand file costTime[%d]", new Object[] { Integer.valueOf(((a)locala).hashCode()), Long.valueOf(l) });
    com.tencent.mm.plugin.report.service.g.yxI.n(1508L, 0L, l);
    com.tencent.mm.plugin.report.service.g.yxI.n(1508L, 1L, 1L);
    AppMethodBeat.o(223190);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/AppBrandFileCleaner$Companion;", "", "()V", "IDKEY_CLEAN_APPBRAND_FILE", "", "TAG", "", "clean", "", "cleanImpl", "uinStr", "appId", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */