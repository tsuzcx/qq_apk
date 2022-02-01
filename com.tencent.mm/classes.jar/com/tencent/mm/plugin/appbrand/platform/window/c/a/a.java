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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.platform.window.a.c
{
  private static final e.b[] kEN;
  @Deprecated
  public static final a nFA;
  private final com.tencent.mm.plugin.appbrand.platform.window.c nFz;
  
  static
  {
    AppMethodBeat.i(219784);
    nFA = new a((byte)0);
    kEN = e.b.nEs;
    AppMethodBeat.o(219784);
  }
  
  public a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(219783);
    this.nFz = paramc;
    AppMethodBeat.o(219783);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(219781);
    if (paramb == null)
    {
      ((kotlin.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(219781);
      return;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.nEr + ',' + paramb.name());
    if (paramb == e.b.nEl)
    {
      this.nFz.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = btm();
        if (btm() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(219781);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(219781);
      return;
    }
    Object localObject = kEN;
    p.g(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.nFz.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = btm();
        localObject = kEN;
        p.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, btm()));
        AppMethodBeat.o(219781);
        return;
      }
      AppMethodBeat.o(219781);
      return;
    }
    if (paramb == e.b.nEm)
    {
      this.nFz.setSoftOrientation("auto");
      if (parama != null)
      {
        parama.a(btm(), true);
        AppMethodBeat.o(219781);
        return;
      }
      AppMethodBeat.o(219781);
      return;
    }
    this.nFz.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = btm();
      if (btm() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(219781);
        return;
      }
    }
    AppMethodBeat.o(219781);
  }
  
  public final e.b btm()
  {
    AppMethodBeat.i(219782);
    Object localObject = this.nFz.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.nEl;
      AppMethodBeat.o(219782);
      return localObject;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.nEn;
    AppMethodBeat.o(219782);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler$Companion;", "", "()V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "kotlin.jvm.PlatformType", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c.a.a
 * JD-Core Version:    0.7.0.1
 */