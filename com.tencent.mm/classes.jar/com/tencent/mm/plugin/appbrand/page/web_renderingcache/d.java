package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d mlF;
  
  static
  {
    AppMethodBeat.i(50968);
    mlF = new d();
    AppMethodBeat.o(50968);
  }
  
  public static final void bV(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(50967);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50967);
      return;
    }
    Object localObject3 = (c)j.T(c.class);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new y.f();
        ((y.f)localObject1).NiY = "  appId=? ";
        switch (paramInt)
        {
        case 1: 
          localObject2 = new LinkedList();
          localObject3 = ((c)localObject3).kch;
          localObject1 = (b)new a((y.f)localObject1, (LinkedList)localObject2, paramInt, paramString);
          Thread localThread = Thread.currentThread();
          p.g(localThread, "Thread.currentThread()");
          long l = ((f)localObject3).yi(localThread.getId());
          ((b)localObject1).invoke(localObject3);
          ((f)localObject3).sW(l);
          localObject1 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label337;
          }
          o.deleteFile((String)((Iterator)localObject1).next());
          continue;
          localObject2 = (String)localException.NiY;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + paramString + "] versionType[" + paramInt + "], e=" + localException);
        AppMethodBeat.o(50967);
        return;
      }
      localException.NiY = ((String)localObject2 + " and appVersionId = TEST");
      continue;
      Object localObject2 = (String)localException.NiY;
      localException.NiY = ((String)localObject2 + " and appVersionId = DEMO");
      continue;
      label337:
      AppMethodBeat.o(50967);
      return;
      AppMethodBeat.o(50967);
      return;
    }
  }
  
  public static final void bwy()
  {
    AppMethodBeat.i(50966);
    final k localk = new k(h.bwA());
    if ((!localk.exists()) || (!localk.isDirectory()))
    {
      localk.delete();
      AppMethodBeat.o(50966);
      return;
    }
    ae.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "evictExpiredCache enter");
    c localc = (c)j.T(c.class);
    if (localc != null)
    {
      ((a)new d(localc)).invoke();
      ((a)new e(localc)).invoke();
      ((a)new b(localc, localk)).invoke();
      ((a)new c(localc, localk)).invoke();
      AppMethodBeat.o(50966);
      return;
    }
    AppMethodBeat.o(50966);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$clearCache$1$1"})
  static final class a
    extends q
    implements b<f, z>
  {
    a(y.f paramf, LinkedList paramLinkedList, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$3"})
  static final class b
    extends q
    implements a<z>
  {
    b(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$4"})
  static final class c
    extends q
    implements a<z>
  {
    c(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.d
 * JD-Core Version:    0.7.0.1
 */