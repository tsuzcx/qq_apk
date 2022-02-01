package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore;", "", "()V", "MAP", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetails;", "getReportDetails", "shareActionId", "init", "", "setReportDetails", "details", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z svK;
  private static final com.tencent.mm.b.f<String, y> svL;
  
  static
  {
    AppMethodBeat.i(326381);
    svK = new z();
    svL = (com.tencent.mm.b.f)new c(100);
    AppMethodBeat.o(326381);
  }
  
  public static final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(326376);
    s.u(paramString, "shareActionId");
    s.u(paramy, "details");
    paramy.hzD = paramString;
    synchronized (svL)
    {
      svL.put(paramString, paramy);
      AppMethodBeat.o(326376);
      return;
    }
  }
  
  public static final y abE(String paramString)
  {
    AppMethodBeat.i(326373);
    ??? = (CharSequence)paramString;
    if ((??? == null) || (((CharSequence)???).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(326373);
      return null;
    }
    synchronized (svL)
    {
      paramString = (y)svL.get(paramString);
      AppMethodBeat.o(326373);
      return paramString;
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(326368);
    new ShareReportDetailsStore.init.1(com.tencent.mm.app.f.hfK).alive();
    AppMethodBeat.o(326368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.z
 * JD-Core Version:    0.7.0.1
 */