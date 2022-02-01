package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.s.a.e;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;)V", "lastOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "", "exitFullscreen", "", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class ar
  extends a
{
  private e.b iIi;
  private final c iIj;
  
  public ar(c paramc, d.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(194366);
    this.iIj = paramc;
    this.iIi = e.b.lmO;
    AppMethodBeat.o(194366);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(194364);
    k.h(paramView, "view");
    super.O(paramView, paramInt);
    qw(paramInt);
    blJ();
    AppMethodBeat.o(194364);
  }
  
  public final boolean aNT()
  {
    AppMethodBeat.i(194365);
    boolean bool = this.lmK;
    if (super.aNT())
    {
      if (e.b.c(this.iIi)) {
        this.iIj.setSoftOrientation("landscape");
      }
      for (;;)
      {
        blK();
        AppMethodBeat.o(194365);
        return true;
        this.iIj.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.lmK = false;
      blK();
      AppMethodBeat.o(194365);
      return true;
    }
    AppMethodBeat.o(194365);
    return false;
  }
  
  public final void qw(int paramInt)
  {
    AppMethodBeat.i(194363);
    this.lmK = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (String str = "landscape";; str = "portrait")
    {
      Object localObject = this.iIj.getOrientationHandler();
      k.g(localObject, "windowAndroid.orientationHandler");
      localObject = ((e)localObject).aNL();
      k.g(localObject, "windowAndroid.orientatio…andler.currentOrientation");
      this.iIi = ((e.b)localObject);
      this.iIj.setSoftOrientation(str);
      AppMethodBeat.o(194363);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ar
 * JD-Core Version:    0.7.0.1
 */