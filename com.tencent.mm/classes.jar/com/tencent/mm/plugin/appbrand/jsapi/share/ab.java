package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore;", "", "()V", "MAP", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetails;", "getReportDetails", "shareActionId", "init", "", "setReportDetails", "details", "plugin-appbrand-integration_release"})
public final class ab
{
  private static final f<String, aa> pra;
  public static final ab prb;
  
  static
  {
    AppMethodBeat.i(275813);
    prb = new ab();
    pra = (f)new c(100);
    AppMethodBeat.o(275813);
  }
  
  public static final void a(String paramString, aa paramaa)
  {
    AppMethodBeat.i(275811);
    p.k(paramString, "shareActionId");
    p.k(paramaa, "details");
    paramaa.fvj = paramString;
    synchronized (pra)
    {
      pra.put(paramString, paramaa);
      AppMethodBeat.o(275811);
      return;
    }
  }
  
  public static final aa aiE(String paramString)
  {
    AppMethodBeat.i(275810);
    ??? = (CharSequence)paramString;
    if ((??? == null) || (((CharSequence)???).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275810);
      return null;
    }
    synchronized (pra)
    {
      paramString = (aa)pra.get(paramString);
      AppMethodBeat.o(275810);
      return paramString;
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(275809);
    EventCenter.instance.add((IListener)new a());
    AppMethodBeat.o(275809);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore$init$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/message/OnAppBrandAppMessageRetransmitEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class a
    extends IListener<com.tencent.mm.aj.aa>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ab
 * JD-Core Version:    0.7.0.1
 */