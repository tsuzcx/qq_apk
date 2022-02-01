package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b;

import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/base/GamePrefetchJsApiPool;", "", "()V", "TAG", "", "prefetchJsApis", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "Lkotlin/collections/ArrayList;", "initJsApiPool", "", "runtime", "Lcom/tencent/luggage/container/LuggageRuntime;", "context", "Lcom/tencent/luggage/container/LuggageJsApiContext;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vVJ;
  private static final ArrayList<Class<? extends bv<?>>> vVK;
  
  static
  {
    AppMethodBeat.i(303149);
    vVJ = new a();
    vVK = p.al(new Class[] { b.class, com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.c.class, com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.class, e.class });
    AppMethodBeat.o(303149);
  }
  
  public static void a(n paramn, com.tencent.luggage.d.c paramc)
  {
    AppMethodBeat.i(303140);
    s.u(paramn, "runtime");
    s.u(paramc, "context");
    for (;;)
    {
      Class localClass;
      try
      {
        localObject = ((com.tencent.mm.plugin.game.luggage.a.a)h.ax(com.tencent.mm.plugin.game.luggage.a.a.class)).fEq();
        s.s(localObject, "gameJsApiPool");
        localObject = ((Iterable)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localClass = (Class)((Iterator)localObject).next();
        if (localClass == null)
        {
          paramn = new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.tencent.luggage.container.LuggageJsApi<com.tencent.luggage.container.LuggageJsApiContext>>");
          AppMethodBeat.o(303140);
          throw paramn;
        }
      }
      catch (Exception paramn)
      {
        Log.printErrStackTrace("MicroMsg.GamePrefetchJsApiPool", (Throwable)paramn, "[game-web-prefetch] init jsApiPool exception", new Object[0]);
        AppMethodBeat.o(303140);
        return;
      }
      paramn.a(localClass, paramc);
    }
    Object localObject = ((Iterable)vVK).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramn.a((Class)((Iterator)localObject).next(), paramc);
    }
    AppMethodBeat.o(303140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */