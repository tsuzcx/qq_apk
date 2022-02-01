package com.tencent.mm.plugin.appbrand.platform.window.c.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.platform.window.a.c
{
  private static final e.b[] qHL;
  @Deprecated
  public static final a.a qHM;
  private final com.tencent.mm.plugin.appbrand.platform.window.c qHK;
  
  static
  {
    AppMethodBeat.i(242882);
    qHM = new a.a((byte)0);
    qHL = e.b.qGC;
    AppMethodBeat.o(242882);
  }
  
  public a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(242880);
    this.qHK = paramc;
    AppMethodBeat.o(242880);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(242874);
    if (paramb == null)
    {
      ((kotlin.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(242874);
      return;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.qGB + ',' + paramb.name());
    if (paramb == e.b.qGv)
    {
      this.qHK.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = cgS();
        if (cgS() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(242874);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(242874);
      return;
    }
    Object localObject = qHL;
    p.j(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.qHK.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = cgS();
        localObject = qHL;
        p.j(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, cgS()));
        AppMethodBeat.o(242874);
        return;
      }
      AppMethodBeat.o(242874);
      return;
    }
    if (paramb == e.b.qGw)
    {
      this.qHK.setSoftOrientation("auto");
      if (parama != null)
      {
        parama.a(cgS(), true);
        AppMethodBeat.o(242874);
        return;
      }
      AppMethodBeat.o(242874);
      return;
    }
    this.qHK.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = cgS();
      if (cgS() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(242874);
        return;
      }
    }
    AppMethodBeat.o(242874);
  }
  
  public final e.b cgS()
  {
    AppMethodBeat.i(242879);
    Object localObject = this.qHK.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.qGv;
      AppMethodBeat.o(242879);
      return localObject;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.qGx;
    AppMethodBeat.o(242879);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c.a.a
 * JD-Core Version:    0.7.0.1
 */