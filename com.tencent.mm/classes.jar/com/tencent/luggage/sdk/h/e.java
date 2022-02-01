package com.tencent.luggage.sdk.h;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements c.a
{
  private final ArrayMap<b, a<ah>> evO;
  
  public e()
  {
    AppMethodBeat.i(147859);
    this.evO = new ArrayMap();
    AppMethodBeat.o(147859);
  }
  
  public final void a(b paramb, a<ah> parama)
  {
    AppMethodBeat.i(147857);
    ((Map)this.evO).put(paramb, parama);
    AppMethodBeat.o(147857);
  }
  
  public final void onRunningStateChanged(String paramString, b paramb)
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
    paramString = (a)this.evO.get(paramb);
    if (paramString != null) {
      paramString.invoke();
    }
    AppMethodBeat.o(147856);
  }
  
  public final void q(a<ah> parama)
  {
    AppMethodBeat.i(220577);
    s.u(parama, "callback");
    a(b.qKw, parama);
    AppMethodBeat.o(220577);
  }
  
  public final void r(a<ah> parama)
  {
    AppMethodBeat.i(220580);
    s.u(parama, "callback");
    a(b.qKx, parama);
    AppMethodBeat.o(220580);
  }
  
  public final void s(a<ah> parama)
  {
    AppMethodBeat.i(147858);
    s.u(parama, "callback");
    a(b.qKz, parama);
    AppMethodBeat.o(147858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.e
 * JD-Core Version:    0.7.0.1
 */