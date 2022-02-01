package com.tencent.mm.plugin.appbrand.r.a.b.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.r.a.a.c
{
  private static final e.b[] jAU;
  @Deprecated
  public static final a.a mpT;
  private final com.tencent.mm.plugin.appbrand.r.a.c mpS;
  
  static
  {
    AppMethodBeat.i(197536);
    mpT = new a.a((byte)0);
    jAU = e.b.moN;
    AppMethodBeat.o(197536);
  }
  
  public a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    AppMethodBeat.i(197535);
    this.mpS = paramc;
    AppMethodBeat.o(197535);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(197533);
    if (paramb == null)
    {
      ((d.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(197533);
      return;
    }
    ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.moM + ',' + paramb.name());
    if (paramb == e.b.moG)
    {
      this.mpS.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = aXN();
        if (aXN() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(197533);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(197533);
      return;
    }
    Object localObject = jAU;
    p.g(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.mpS.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aXN();
        localObject = jAU;
        p.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aXN()));
        AppMethodBeat.o(197533);
        return;
      }
      AppMethodBeat.o(197533);
      return;
    }
    if (paramb == e.b.moH)
    {
      this.mpS.setSoftOrientation("auto");
      if (parama != null)
      {
        parama.a(aXN(), true);
        AppMethodBeat.o(197533);
        return;
      }
      AppMethodBeat.o(197533);
      return;
    }
    this.mpS.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = aXN();
      if (aXN() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(197533);
        return;
      }
    }
    AppMethodBeat.o(197533);
  }
  
  public final e.b aXN()
  {
    AppMethodBeat.i(197534);
    Object localObject = this.mpS.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.moG;
      AppMethodBeat.o(197534);
      return localObject;
    }
    ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.moI;
    AppMethodBeat.o(197534);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */