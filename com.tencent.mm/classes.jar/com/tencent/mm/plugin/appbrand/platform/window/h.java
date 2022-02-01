package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.m;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"})
public final class h
  implements q
{
  public static final a mtP;
  private final e mtO;
  
  static
  {
    AppMethodBeat.i(208155);
    mtP = new a((byte)0);
    AppMethodBeat.o(208155);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(208154);
    this.mtO = parame;
    AppMethodBeat.o(208154);
  }
  
  public final ac bxC()
  {
    AppMethodBeat.i(208153);
    Object localObject = this.mtO.aYg();
    p.g(localObject, "orientationHandler.currentOrientation");
    switch (i.cqt[localObject.ordinal()])
    {
    default: 
      localObject = new m();
      AppMethodBeat.o(208153);
      throw ((Throwable)localObject);
    case 1: 
      localObject = ac.mUu;
      AppMethodBeat.o(208153);
      return localObject;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      localObject = ac.mUv;
      AppMethodBeat.o(208153);
      return localObject;
    }
    localObject = ac.mUt;
    AppMethodBeat.o(208153);
    return localObject;
  }
  
  public final String getName()
  {
    return "WxaOrientationGetter";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"})
  public static final class a
    implements q.a
  {
    public final q a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(208151);
      if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
      {
        localObject = ((com.tencent.mm.plugin.appbrand.jsapi.h)parame).getRuntime();
        if (localObject != null)
        {
          localObject = ((AppBrandRuntime)localObject).aWn();
          if (localObject != null)
          {
            localObject = ((ai)localObject).getWindowAndroid();
            if (localObject != null)
            {
              localObject = ((c)localObject).getOrientationHandler();
              if (localObject != null)
              {
                parame = (q)new h((e)localObject);
                AppMethodBeat.o(208151);
                return parame;
              }
            }
          }
        }
        localObject = a.mTz;
        parame = a.a.b(parame);
        ae.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
        parame = (q)parame;
        AppMethodBeat.o(208151);
        return parame;
      }
      ae.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
      Object localObject = a.mTz;
      parame = (q)a.a.b(parame);
      AppMethodBeat.o(208151);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.h
 * JD-Core Version:    0.7.0.1
 */