package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b;

import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/base/GamePrefetchJsApiPool;", "", "()V", "TAG", "", "prefetchJsApis", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "Lkotlin/collections/ArrayList;", "initJsApiPool", "", "runtime", "Lcom/tencent/luggage/container/LuggageRuntime;", "context", "Lcom/tencent/luggage/container/LuggageJsApiContext;", "plugin-brandservice_release"})
public final class a
{
  private static final ArrayList<Class<? extends br<?>>> sQv;
  public static final a sQw;
  
  static
  {
    AppMethodBeat.i(257501);
    sQw = new a();
    sQv = j.ag(new Class[] { com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.class, b.class, com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.c.class });
    AppMethodBeat.o(257501);
  }
  
  public static void a(n paramn, com.tencent.luggage.d.c paramc)
  {
    AppMethodBeat.i(257500);
    p.k(paramn, "runtime");
    p.k(paramc, "context");
    Class localClass;
    for (;;)
    {
      try
      {
        localObject = h.ae(com.tencent.mm.plugin.game.luggage.a.a.class);
        p.j(localObject, "MMKernel.service(ILuggageGameService::class.java)");
        localObject = ((com.tencent.mm.plugin.game.luggage.a.a)localObject).eww();
        p.j(localObject, "gameJsApiPool");
        localObject = ((Iterable)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localClass = (Class)((Iterator)localObject).next();
        if (localClass == null)
        {
          paramn = new t("null cannot be cast to non-null type java.lang.Class<com.tencent.luggage.container.LuggageJsApi<com.tencent.luggage.container.LuggageJsApiContext>>");
          AppMethodBeat.o(257500);
          throw paramn;
        }
      }
      catch (Exception paramn)
      {
        Log.printErrStackTrace("MicroMsg.GamePrefetchJsApiPool", (Throwable)paramn, "[game-web-prefetch] init jsApiPool exception", new Object[0]);
        AppMethodBeat.o(257500);
        return;
      }
      paramn.a(localClass, paramc);
    }
    Object localObject = ((Iterable)sQv).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localClass = (Class)((Iterator)localObject).next();
      if (localClass == null)
      {
        paramn = new t("null cannot be cast to non-null type java.lang.Class<com.tencent.luggage.container.LuggageJsApi<com.tencent.luggage.container.LuggageJsApiContext>>");
        AppMethodBeat.o(257500);
        throw paramn;
      }
      paramn.a(localClass, paramc);
    }
    AppMethodBeat.o(257500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */