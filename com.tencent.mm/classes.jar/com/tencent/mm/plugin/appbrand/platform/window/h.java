package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"})
public final class h
  implements q
{
  public static final a nEx;
  private final e nEw;
  
  static
  {
    AppMethodBeat.i(219773);
    nEx = new a((byte)0);
    AppMethodBeat.o(219773);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(219772);
    this.nEw = parame;
    AppMethodBeat.o(219772);
  }
  
  public final ac bTN()
  {
    AppMethodBeat.i(219771);
    Object localObject = this.nEw.btm();
    p.g(localObject, "orientationHandler.currentOrientation");
    switch (i.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new m();
      AppMethodBeat.o(219771);
      throw ((Throwable)localObject);
    case 1: 
      localObject = ac.ohv;
      AppMethodBeat.o(219771);
      return localObject;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      localObject = ac.ohw;
      AppMethodBeat.o(219771);
      return localObject;
    }
    localObject = ac.ohu;
    AppMethodBeat.o(219771);
    return localObject;
  }
  
  public final String getName()
  {
    return "WxaOrientationGetter";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"})
  public static final class a
    implements q.a
  {
    public final q a(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
    {
      AppMethodBeat.i(219769);
      if ((paramh instanceof k))
      {
        localObject = ((k)paramh).getRuntime();
        if (localObject != null)
        {
          localObject = ((AppBrandRuntime)localObject).bri();
          if (localObject != null)
          {
            localObject = ((ak)localObject).getWindowAndroid();
            if (localObject != null)
            {
              localObject = ((c)localObject).getOrientationHandler();
              if (localObject != null)
              {
                paramh = (q)new h((e)localObject);
                AppMethodBeat.o(219769);
                return paramh;
              }
            }
          }
        }
        localObject = a.ogC;
        paramh = a.a.b(paramh);
        Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
        paramh = (q)paramh;
        AppMethodBeat.o(219769);
        return paramh;
      }
      Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
      Object localObject = a.ogC;
      paramh = (q)a.a.b(paramh);
      AppMethodBeat.o(219769);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.h
 * JD-Core Version:    0.7.0.1
 */