package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewLU;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "handleInvoke", "", "", "", "type", "component", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d<g>
{
  public static final a swv;
  private static final j<ah> sww;
  
  static
  {
    AppMethodBeat.i(326060);
    swv = new a((byte)0);
    sww = k.cm((a)b.swx);
    AppMethodBeat.o(326060);
  }
  
  public final Map<String, Object> a(String paramString, g paramg)
  {
    AppMethodBeat.i(326066);
    s.u(paramString, "type");
    s.u(paramg, "component");
    Map localMap = null;
    if (s.p(a.cuK().sxw, paramString)) {
      localMap = a.cuK().b(paramString, paramg);
    }
    if (localMap == null)
    {
      paramString = super.a(paramString, paramg);
      AppMethodBeat.o(326066);
      return paramString;
    }
    AppMethodBeat.o(326066);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewWC$Companion;", "", "()V", "getWindowInfoWC", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfoWC;", "getGetWindowInfoWC", "()Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfoWC;", "getWindowInfoWC$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static ah cuK()
    {
      AppMethodBeat.i(326017);
      ah localah = (ah)e.cuJ().getValue();
      AppMethodBeat.o(326017);
      return localah;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfoWC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    public static final b swx;
    
    static
    {
      AppMethodBeat.i(326016);
      swx = new b();
      AppMethodBeat.o(326016);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.e
 * JD-Core Version:    0.7.0.1
 */