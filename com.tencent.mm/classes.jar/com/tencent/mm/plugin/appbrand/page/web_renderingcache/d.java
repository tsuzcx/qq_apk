package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.g.b.v.f;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d lGU;
  
  static
  {
    AppMethodBeat.i(50968);
    lGU = new d();
    AppMethodBeat.o(50968);
  }
  
  public static final void bO(final String paramString, final int paramInt)
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
        localObject1 = new v.f();
        ((v.f)localObject1).KUQ = "  appId=? ";
        switch (paramInt)
        {
        case 1: 
          localObject2 = new LinkedList();
          localObject3 = ((c)localObject3).lGS;
          localObject1 = (b)new a((v.f)localObject1, (LinkedList)localObject2, paramInt, paramString);
          Thread localThread = Thread.currentThread();
          k.g(localThread, "Thread.currentThread()");
          long l = ((f)localObject3).vE(localThread.getId());
          ((b)localObject1).ay(localObject3);
          ((f)localObject3).qL(l);
          localObject1 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label337;
          }
          i.deleteFile((String)((Iterator)localObject1).next());
          continue;
          localObject2 = (String)localException.KUQ;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + paramString + "] versionType[" + paramInt + "], e=" + localException);
        AppMethodBeat.o(50967);
        return;
      }
      localException.KUQ = ((String)localObject2 + " and appVersionId = TEST");
      continue;
      Object localObject2 = (String)localException.KUQ;
      localException.KUQ = ((String)localObject2 + " and appVersionId = DEMO");
      continue;
      label337:
      AppMethodBeat.o(50967);
      return;
      AppMethodBeat.o(50967);
      return;
    }
  }
  
  public static final void brD()
  {
    AppMethodBeat.i(50966);
    final e locale = new e(h.brF());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      locale.delete();
      AppMethodBeat.o(50966);
      return;
    }
    ac.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "evictExpiredCache enter");
    c localc = (c)j.T(c.class);
    if (localc != null)
    {
      ((a)new d(localc)).invoke();
      ((a)new e(localc)).invoke();
      ((a)new b(localc, locale)).invoke();
      ((a)new c(localc, locale)).invoke();
      AppMethodBeat.o(50966);
      return;
    }
    AppMethodBeat.o(50966);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$clearCache$1$1"})
  static final class a
    extends d.g.b.l
    implements b<f, y>
  {
    a(v.f paramf, LinkedList paramLinkedList, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$3"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(c paramc, e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$4"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(c paramc, e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
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