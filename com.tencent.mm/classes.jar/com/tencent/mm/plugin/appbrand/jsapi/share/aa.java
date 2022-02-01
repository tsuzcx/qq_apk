package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore;", "", "()V", "MAP", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetails;", "getReportDetails", "shareActionId", "init", "", "setReportDetails", "details", "plugin-appbrand-integration_release"})
public final class aa
{
  private static final f<String, z> msR;
  public static final aa msS;
  
  static
  {
    AppMethodBeat.i(228548);
    msS = new aa();
    msR = (f)new c(100);
    AppMethodBeat.o(228548);
  }
  
  public static final void a(String paramString, z paramz)
  {
    AppMethodBeat.i(228547);
    p.h(paramString, "shareActionId");
    p.h(paramz, "details");
    paramz.dCC = paramString;
    synchronized (msR)
    {
      msR.put(paramString, paramz);
      AppMethodBeat.o(228547);
      return;
    }
  }
  
  public static final z aaM(String paramString)
  {
    AppMethodBeat.i(228546);
    ??? = (CharSequence)paramString;
    if ((??? == null) || (((CharSequence)???).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228546);
      return null;
    }
    synchronized (msR)
    {
      paramString = (z)msR.get(paramString);
      AppMethodBeat.o(228546);
      return paramString;
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(228545);
    EventCenter.instance.add((IListener)new a());
    AppMethodBeat.o(228545);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore$init$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/message/OnAppBrandAppMessageRetransmitEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class a
    extends IListener<com.tencent.mm.ag.aa>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.aa
 * JD-Core Version:    0.7.0.1
 */