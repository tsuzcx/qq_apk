package com.tencent.mm.plugin.appbrand.platform.window.b.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.platform.window.a.c
{
  private static final e.b[] jDF;
  @Deprecated
  public static final a.a muR;
  private final com.tencent.mm.plugin.appbrand.platform.window.c muQ;
  
  static
  {
    AppMethodBeat.i(208166);
    muR = new a.a((byte)0);
    jDF = e.b.mtK;
    AppMethodBeat.o(208166);
  }
  
  public a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(208165);
    this.muQ = paramc;
    AppMethodBeat.o(208165);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(208163);
    if (paramb == null)
    {
      ((d.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(208163);
      return;
    }
    ae.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.mtJ + ',' + paramb.name());
    if (paramb == e.b.mtD)
    {
      this.muQ.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = aYg();
        if (aYg() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(208163);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(208163);
      return;
    }
    Object localObject = jDF;
    p.g(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.muQ.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aYg();
        localObject = jDF;
        p.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aYg()));
        AppMethodBeat.o(208163);
        return;
      }
      AppMethodBeat.o(208163);
      return;
    }
    if (paramb == e.b.mtE)
    {
      this.muQ.setSoftOrientation("auto");
      if (parama != null)
      {
        parama.a(aYg(), true);
        AppMethodBeat.o(208163);
        return;
      }
      AppMethodBeat.o(208163);
      return;
    }
    this.muQ.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = aYg();
      if (aYg() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(208163);
        return;
      }
    }
    AppMethodBeat.o(208163);
  }
  
  public final e.b aYg()
  {
    AppMethodBeat.i(208164);
    Object localObject = this.muQ.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      ae.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.mtD;
      AppMethodBeat.o(208164);
      return localObject;
    }
    ae.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.mtF;
    AppMethodBeat.o(208164);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.b.a.a
 * JD-Core Version:    0.7.0.1
 */