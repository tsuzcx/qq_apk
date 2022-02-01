package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.aq;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfo;", "Component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeAsPart;", "()V", "partName", "", "getPartName", "()Ljava/lang/String;", "get", "", "", "type", "component", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)Ljava/util/Map;", "overrideWindowInfo", "", "outRes", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/util/Map;)V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ag<Component extends g>
  implements ae<Component>
{
  public static final a sxE;
  public final String sxw = "windowInfo";
  
  static
  {
    AppMethodBeat.i(326085);
    sxE = new a((byte)0);
    AppMethodBeat.o(326085);
  }
  
  protected void a(Component paramComponent, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326094);
    s.u(paramComponent, "component");
    s.u(paramMap, "outRes");
    AppMethodBeat.o(326094);
  }
  
  public final Map<String, Object> b(String paramString, Component paramComponent)
  {
    AppMethodBeat.i(326089);
    s.u(paramString, "type");
    s.u(paramComponent, "component");
    paramString = new HashMap();
    ((Map)paramString).put("pixelRatio", Float.valueOf(i.mn()));
    int[] arrayOfInt = aq.d((k)paramComponent);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    ((Map)paramString).put("screenWidth", Integer.valueOf(i.DA(i)));
    ((Map)paramString).put("screenHeight", Integer.valueOf(i.DA(j)));
    p.a((Map)paramString, paramComponent, i, j);
    i = p.f(paramComponent);
    ((Map)paramString).put("statusBarHeight", Integer.valueOf(i.DA(i)));
    arrayOfInt = aq.n(paramComponent);
    i = arrayOfInt[0];
    j = arrayOfInt[1];
    ((Map)paramString).put("windowWidth", Integer.valueOf(i.DA(i)));
    ((Map)paramString).put("windowHeight", Integer.valueOf(i.DA(j)));
    ((Map)paramString).put("screenTop", Integer.valueOf(i.DA(aq.f((k)paramComponent))));
    a(paramComponent, (Map)paramString);
    paramString = (Map)paramString;
    AppMethodBeat.o(326089);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_WindowInfo$Companion;", "", "()V", "INFO_KEY_PIXEL_RATIO", "", "INFO_KEY_SAFE_AREA", "getINFO_KEY_SAFE_AREA$annotations", "INFO_KEY_SCREEN_HEIGHT", "INFO_KEY_SCREEN_TOP", "INFO_KEY_SCREEN_WIDTH", "INFO_KEY_STATUS_BAR_HEIGHT", "INFO_KEY_WINDOW_HEIGHT", "INFO_KEY_WINDOW_WIDTH", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.ag
 * JD-Core Version:    0.7.0.1
 */