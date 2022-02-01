package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ad
  implements com.tencent.mm.plugin.appbrand.platform.window.e
{
  private final e.b[] kEN;
  private final View mView;
  
  public ad(View paramView)
  {
    AppMethodBeat.i(219647);
    this.mView = paramView;
    this.kEN = new e.b[] { e.b.nEn, e.b.nEo, e.b.nEp, e.b.nEq };
    AppMethodBeat.o(219647);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(219645);
    if (paramb == null)
    {
      ((a)new a(parama)).invoke();
      AppMethodBeat.o(219645);
      return;
    }
    if (paramb == e.b.nEl)
    {
      if (parama != null)
      {
        e.b localb = btm();
        if (btm() == paramb) {}
        for (boolean bool = true;; bool = false)
        {
          parama.a(localb, bool);
          AppMethodBeat.o(219645);
          return;
        }
      }
      AppMethodBeat.o(219645);
      return;
    }
    if ((kotlin.a.e.contains(this.kEN, paramb)) && (parama != null))
    {
      parama.a(btm(), kotlin.a.e.contains(this.kEN, btm()));
      AppMethodBeat.o(219645);
      return;
    }
    AppMethodBeat.o(219645);
  }
  
  public final e.b btm()
  {
    AppMethodBeat.i(219646);
    if (this.mView.getHeight() >= this.mView.getWidth())
    {
      localb = e.b.nEl;
      AppMethodBeat.o(219646);
      return localb;
    }
    e.b localb = e.b.nEo;
    AppMethodBeat.o(219646);
    return localb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad
 * JD-Core Version:    0.7.0.1
 */