package com.tencent.mm.plugin.appbrand.r.a.b.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.e;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.r.a.a.c
{
  private static final e.b[] jhL;
  @Deprecated
  public static final a lQd;
  private final com.tencent.mm.plugin.appbrand.r.a.c lQc;
  
  static
  {
    AppMethodBeat.i(193296);
    lQd = new a((byte)0);
    jhL = e.b.lOX;
    AppMethodBeat.o(193296);
  }
  
  public a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(193295);
    this.lQc = paramc;
    AppMethodBeat.o(193295);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(193293);
    if (paramb == null)
    {
      ((d.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(193293);
      return;
    }
    ac.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.lOW + ',' + paramb.name());
    if (paramb == e.b.lOQ)
    {
      this.lQc.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = aUB();
        if (aUB() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(193293);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(193293);
      return;
    }
    Object localObject = jhL;
    k.g(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.lQc.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aUB();
        localObject = jhL;
        k.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aUB()));
        AppMethodBeat.o(193293);
        return;
      }
      AppMethodBeat.o(193293);
      return;
    }
    if (paramb == e.b.lOR)
    {
      this.lQc.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aUB();
        localObject = jhL;
        k.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aUB()));
        AppMethodBeat.o(193293);
        return;
      }
      AppMethodBeat.o(193293);
      return;
    }
    this.lQc.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = aUB();
      if (aUB() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(193293);
        return;
      }
    }
    AppMethodBeat.o(193293);
  }
  
  public final e.b aUB()
  {
    AppMethodBeat.i(193294);
    Object localObject = this.lQc.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      ac.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.lOQ;
      AppMethodBeat.o(193294);
      return localObject;
    }
    ac.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.lOS;
    AppMethodBeat.o(193294);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler$Companion;", "", "()V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "kotlin.jvm.PlatformType", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */