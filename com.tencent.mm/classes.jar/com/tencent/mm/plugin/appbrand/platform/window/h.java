package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"})
public final class h
  implements s
{
  public static final a qGH;
  private final e qGG;
  
  static
  {
    AppMethodBeat.i(242628);
    qGH = new a((byte)0);
    AppMethodBeat.o(242628);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(242625);
    this.qGG = parame;
    AppMethodBeat.o(242625);
  }
  
  public final ae cgT()
  {
    AppMethodBeat.i(242624);
    Object localObject = this.qGG.cgS();
    p.j(localObject, "orientationHandler.currentOrientation");
    switch (i.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new m();
      AppMethodBeat.o(242624);
      throw ((Throwable)localObject);
    case 1: 
      localObject = ae.rjj;
      AppMethodBeat.o(242624);
      return localObject;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      localObject = ae.rjk;
      AppMethodBeat.o(242624);
      return localObject;
    }
    localObject = ae.rji;
    AppMethodBeat.o(242624);
    return localObject;
  }
  
  public final String getName()
  {
    return "WxaOrientationGetter";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"})
  public static final class a
    implements s.a
  {
    public final s a(g paramg)
    {
      AppMethodBeat.i(245052);
      if ((paramg instanceof j))
      {
        localObject = ((j)paramg).getRuntime();
        if (localObject != null)
        {
          localObject = ((AppBrandRuntime)localObject).bBY();
          if (localObject != null)
          {
            localObject = ((ak)localObject).getWindowAndroid();
            if (localObject != null)
            {
              localObject = ((c)localObject).getOrientationHandler();
              if (localObject != null)
              {
                paramg = (s)new h((e)localObject);
                AppMethodBeat.o(245052);
                return paramg;
              }
            }
          }
        }
        localObject = b.rip;
        paramg = b.a.b(paramg);
        Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
        paramg = (s)paramg;
        AppMethodBeat.o(245052);
        return paramg;
      }
      Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
      Object localObject = b.rip;
      paramg = (s)b.a.b(paramg);
      AppMethodBeat.o(245052);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.h
 * JD-Core Version:    0.7.0.1
 */