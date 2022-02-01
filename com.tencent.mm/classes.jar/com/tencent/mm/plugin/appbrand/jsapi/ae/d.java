package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewLU;", "Component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNew;", "()V", "handleInvoke", "", "", "", "type", "component", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)Ljava/util/Map;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d<Component extends g>
  extends c<Component>
{
  public static final a swq;
  private static final j<List<af>> swr;
  private static final j<Map<String, ae<g>>> sws;
  
  static
  {
    AppMethodBeat.i(326056);
    swq = new a((byte)0);
    swr = k.cm((a)b.swt);
    sws = k.cm((a)c.swu);
    AppMethodBeat.o(326056);
  }
  
  public Map<String, Object> a(String paramString, Component paramComponent)
  {
    AppMethodBeat.i(326061);
    s.u(paramString, "type");
    s.u(paramComponent, "component");
    Object localObject = ((Iterable)swr.getValue()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map localMap = ((af)((Iterator)localObject).next()).b(paramString, paramComponent);
      if (localMap != null)
      {
        AppMethodBeat.o(326061);
        return localMap;
      }
    }
    localObject = (ae)((Map)sws.getValue()).get(paramString);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((ae)localObject).c(paramString, (f)paramComponent))
    {
      paramString = super.a(paramString, (f)paramComponent);
      AppMethodBeat.o(326061);
      return paramString;
    }
    AppMethodBeat.o(326061);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewLU$Companion;", "", "()V", "parts1", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeSpecificInfo;", "getParts1", "()Ljava/util/List;", "parts1$delegate", "Lkotlin/Lazy;", "parts2", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeAsPart;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getParts2", "()Ljava/util/Map;", "parts2$delegate", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeSpecificInfo;", "Component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<List<? extends af>>
  {
    public static final b swt;
    
    static
    {
      AppMethodBeat.i(326088);
      swt = new b();
      AppMethodBeat.o(326088);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeAsPart;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Component"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Map<String, ? extends ae<g>>>
  {
    public static final c swu;
    
    static
    {
      AppMethodBeat.i(326087);
      swu = new c();
      AppMethodBeat.o(326087);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.d
 * JD-Core Version:    0.7.0.1
 */