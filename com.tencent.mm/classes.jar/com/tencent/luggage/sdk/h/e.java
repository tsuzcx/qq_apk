package com.tencent.luggage.sdk.h;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wxa-app_release"})
public final class e
  implements c.a
{
  private final ArrayMap<b, a<x>> cDo;
  
  public e()
  {
    AppMethodBeat.i(147859);
    this.cDo = new ArrayMap();
    AppMethodBeat.o(147859);
  }
  
  public final void a(b paramb, a<x> parama)
  {
    AppMethodBeat.i(147857);
    ((Map)this.cDo).put(paramb, parama);
    AppMethodBeat.o(147857);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(147856);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147856);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(147856);
      return;
    }
    paramString = (a)this.cDo.get(paramb);
    if (paramString != null)
    {
      paramString.invoke();
      AppMethodBeat.o(147856);
      return;
    }
    AppMethodBeat.o(147856);
  }
  
  public final void a(a<x> parama)
  {
    AppMethodBeat.i(243607);
    p.k(parama, "callback");
    a(b.nKP, parama);
    AppMethodBeat.o(243607);
  }
  
  public final void b(a<x> parama)
  {
    AppMethodBeat.i(243609);
    p.k(parama, "callback");
    a(b.nKQ, parama);
    AppMethodBeat.o(243609);
  }
  
  public final void c(a<x> parama)
  {
    AppMethodBeat.i(147858);
    p.k(parama, "callback");
    a(b.nKS, parama);
    AppMethodBeat.o(147858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.e
 * JD-Core Version:    0.7.0.1
 */