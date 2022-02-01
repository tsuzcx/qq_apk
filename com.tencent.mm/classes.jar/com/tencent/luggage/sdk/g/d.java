package com.tencent.luggage.sdk.g;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wechat-full-sdk_release"})
public final class d
  implements c.a
{
  private final ArrayMap<b, a<y>> ciC;
  
  public d()
  {
    AppMethodBeat.i(147859);
    this.ciC = new ArrayMap();
    AppMethodBeat.o(147859);
  }
  
  public final void a(b paramb, a<y> parama)
  {
    AppMethodBeat.i(147857);
    ((Map)this.ciC).put(paramb, parama);
    AppMethodBeat.o(147857);
  }
  
  public final void a(a<y> parama)
  {
    AppMethodBeat.i(186851);
    k.h(parama, "callback");
    a(b.iQL, parama);
    AppMethodBeat.o(186851);
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
    paramString = (a)this.ciC.get(paramb);
    if (paramString != null)
    {
      paramString.invoke();
      AppMethodBeat.o(147856);
      return;
    }
    AppMethodBeat.o(147856);
  }
  
  public final void b(a<y> parama)
  {
    AppMethodBeat.i(147858);
    k.h(parama, "callback");
    a(b.iQN, parama);
    AppMethodBeat.o(147858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.d
 * JD-Core Version:    0.7.0.1
 */