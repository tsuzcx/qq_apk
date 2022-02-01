package com.tencent.mm.plugin.appbrand.s.a.b.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a
  implements com.tencent.mm.plugin.appbrand.s.a.a.c
{
  private static final e.b[] iHJ;
  @Deprecated
  public static final a lob;
  private final com.tencent.mm.plugin.appbrand.s.a.c loa;
  
  static
  {
    AppMethodBeat.i(194384);
    lob = new a((byte)0);
    iHJ = e.b.lmV;
    AppMethodBeat.o(194384);
  }
  
  public a(com.tencent.mm.plugin.appbrand.s.a.c paramc)
  {
    AppMethodBeat.i(194383);
    this.loa = paramc;
    AppMethodBeat.o(194383);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(194381);
    if (paramb == null)
    {
      ((d.g.a.a)new b(parama)).invoke();
      AppMethodBeat.o(194381);
      return;
    }
    ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.lmU + ',' + paramb.name());
    if (paramb == e.b.lmO)
    {
      this.loa.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = aNL();
        if (aNL() == paramb) {}
        for (;;)
        {
          parama.a((e.b)localObject, bool1);
          AppMethodBeat.o(194381);
          return;
          bool1 = false;
        }
      }
      AppMethodBeat.o(194381);
      return;
    }
    Object localObject = iHJ;
    k.g(localObject, "LANDSCAPE_ENUMS");
    if (e.contains((Object[])localObject, paramb))
    {
      this.loa.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aNL();
        localObject = iHJ;
        k.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aNL()));
        AppMethodBeat.o(194381);
        return;
      }
      AppMethodBeat.o(194381);
      return;
    }
    if (paramb == e.b.lmP)
    {
      this.loa.setSoftOrientation("landscape");
      if (parama != null)
      {
        paramb = aNL();
        localObject = iHJ;
        k.g(localObject, "LANDSCAPE_ENUMS");
        parama.a(paramb, e.contains((Object[])localObject, aNL()));
        AppMethodBeat.o(194381);
        return;
      }
      AppMethodBeat.o(194381);
      return;
    }
    this.loa.setSoftOrientation("portrait");
    if (parama != null)
    {
      localObject = aNL();
      if (aNL() == paramb) {}
      for (bool1 = bool2;; bool1 = false)
      {
        parama.a((e.b)localObject, bool1);
        AppMethodBeat.o(194381);
        return;
      }
    }
    AppMethodBeat.o(194381);
  }
  
  public final e.b aNL()
  {
    AppMethodBeat.i(194382);
    Object localObject = this.loa.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.lmO;
      AppMethodBeat.o(194382);
      return localObject;
    }
    ad.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.lmQ;
    AppMethodBeat.o(194382);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler$Companion;", "", "()V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "kotlin.jvm.PlatformType", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */