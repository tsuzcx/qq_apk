package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.aj;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements v
{
  public static final a tLs;
  private final e tLt;
  
  static
  {
    AppMethodBeat.i(317496);
    tLs = new a((byte)0);
    AppMethodBeat.o(317496);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(317493);
    this.tLt = parame;
    AppMethodBeat.o(317493);
  }
  
  public final aj cHR()
  {
    AppMethodBeat.i(317501);
    Object localObject = this.tLt.cHQ();
    s.s(localObject, "orientationHandler.currentOrientation");
    switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new p();
      AppMethodBeat.o(317501);
      throw ((Throwable)localObject);
    case 1: 
      localObject = aj.ury;
      AppMethodBeat.o(317501);
      return localObject;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      localObject = aj.urz;
      AppMethodBeat.o(317501);
      return localObject;
    }
    localObject = aj.urx;
    AppMethodBeat.o(317501);
    return localObject;
  }
  
  public final String getName()
  {
    return "WxaOrientationGetter";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements v.a
  {
    public final v a(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
    {
      AppMethodBeat.i(317497);
      if ((paramh instanceof k))
      {
        localObject = ((k)paramh).getRuntime();
        if (localObject == null) {
          localObject = null;
        }
        while (localObject == null)
        {
          localObject = b.uql;
          paramh = b.a.b(paramh);
          Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
          paramh = (v)paramh;
          AppMethodBeat.o(317497);
          return paramh;
          localObject = ((AppBrandRuntime)localObject).qsc;
          if (localObject == null)
          {
            localObject = null;
          }
          else
          {
            localObject = ((ap)localObject).getWindowAndroid();
            if (localObject == null)
            {
              localObject = null;
            }
            else
            {
              localObject = ((c)localObject).getOrientationHandler();
              if (localObject == null) {
                localObject = null;
              } else {
                localObject = new h((e)localObject);
              }
            }
          }
        }
        paramh = (v)localObject;
        AppMethodBeat.o(317497);
        return paramh;
      }
      Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
      Object localObject = b.uql;
      paramh = (v)b.a.b(paramh);
      AppMethodBeat.o(317497);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.h
 * JD-Core Version:    0.7.0.1
 */