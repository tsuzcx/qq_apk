package com.tencent.luggage.sdk.g;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wxa-app_release"})
public final class d
  implements c.a
{
  private final ArrayMap<b, a<z>> cqr;
  
  public d()
  {
    AppMethodBeat.i(147859);
    this.cqr = new ArrayMap();
    AppMethodBeat.o(147859);
  }
  
  public final void a(b paramb, a<z> parama)
  {
    AppMethodBeat.i(147857);
    ((Map)this.cqr).put(paramb, parama);
    AppMethodBeat.o(147857);
  }
  
  public final void a(a<z> parama)
  {
    AppMethodBeat.i(208035);
    p.h(parama, "callback");
    a(b.jOa, parama);
    AppMethodBeat.o(208035);
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
    paramString = (a)this.cqr.get(paramb);
    if (paramString != null)
    {
      paramString.invoke();
      AppMethodBeat.o(147856);
      return;
    }
    AppMethodBeat.o(147856);
  }
  
  public final void b(a<z> parama)
  {
    AppMethodBeat.i(208036);
    p.h(parama, "callback");
    a(b.jOb, parama);
    AppMethodBeat.o(208036);
  }
  
  public final void c(a<z> parama)
  {
    AppMethodBeat.i(147858);
    p.h(parama, "callback");
    a(b.jOd, parama);
    AppMethodBeat.o(147858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.d
 * JD-Core Version:    0.7.0.1
 */