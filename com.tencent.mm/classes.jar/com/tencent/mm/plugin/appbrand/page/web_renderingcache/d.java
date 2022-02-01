package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d nwd;
  
  static
  {
    AppMethodBeat.i(50968);
    nwd = new d();
    AppMethodBeat.o(50968);
  }
  
  public static final void bSG()
  {
    AppMethodBeat.i(50966);
    final o localo = new o(h.bSI());
    if ((!localo.exists()) || (!localo.isDirectory()))
    {
      localo.delete();
      AppMethodBeat.o(50966);
      return;
    }
    Log.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "evictExpiredCache enter");
    c localc = (c)n.W(c.class);
    if (localc != null)
    {
      ((a)new d(localc)).invoke();
      ((a)new e(localc)).invoke();
      ((a)new b(localc, localo)).invoke();
      ((a)new c(localc, localo)).invoke();
      AppMethodBeat.o(50966);
      return;
    }
    AppMethodBeat.o(50966);
  }
  
  public static final void cd(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(50967);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50967);
      return;
    }
    Object localObject3 = (c)n.W(c.class);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new z.f();
        ((z.f)localObject1).SYG = "  appId=? ";
        switch (paramInt)
        {
        case 1: 
          localObject2 = new LinkedList();
          localObject3 = ((c)localObject3).kOg;
          localObject1 = (b)new a((z.f)localObject1, (LinkedList)localObject2, paramInt, paramString);
          Thread localThread = Thread.currentThread();
          p.g(localThread, "Thread.currentThread()");
          long l = ((ISQLiteDatabaseEx)localObject3).beginTransaction(localThread.getId());
          ((b)localObject1).invoke(localObject3);
          ((ISQLiteDatabaseEx)localObject3).endTransaction(l);
          localObject1 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label338;
          }
          s.deleteFile((String)((Iterator)localObject1).next());
          continue;
          localObject2 = (String)localException.SYG;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + paramString + "] versionType[" + paramInt + "], e=" + localException);
        AppMethodBeat.o(50967);
        return;
      }
      localException.SYG = ((String)localObject2 + " and appVersionId = TEST");
      continue;
      Object localObject2 = (String)localException.SYG;
      localException.SYG = ((String)localObject2 + " and appVersionId = DEMO");
      continue;
      label338:
      AppMethodBeat.o(50967);
      return;
      AppMethodBeat.o(50967);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$clearCache$1$1"})
  static final class a
    extends q
    implements b<ISQLiteDatabaseEx, x>
  {
    a(z.f paramf, LinkedList paramLinkedList, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "()Lkotlin/Unit;", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$3"})
  static final class b
    extends q
    implements a<x>
  {
    b(c paramc, o paramo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$4"})
  static final class c
    extends q
    implements a<x>
  {
    c(c paramc, o paramo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.d
 * JD-Core Version:    0.7.0.1
 */