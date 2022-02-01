package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ac
  implements com.tencent.mm.plugin.appbrand.r.a.e
{
  private final e.b[] jAU;
  private final View mView;
  
  public ac(View paramView)
  {
    AppMethodBeat.i(197491);
    this.mView = paramView;
    this.jAU = new e.b[] { e.b.moI, e.b.moJ, e.b.moK, e.b.moL };
    AppMethodBeat.o(197491);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(197489);
    if (paramb == null)
    {
      ((a)new a(parama)).invoke();
      AppMethodBeat.o(197489);
      return;
    }
    if (paramb == e.b.moG)
    {
      if (parama != null)
      {
        e.b localb = aXN();
        if (aXN() == paramb) {}
        for (boolean bool = true;; bool = false)
        {
          parama.a(localb, bool);
          AppMethodBeat.o(197489);
          return;
        }
      }
      AppMethodBeat.o(197489);
      return;
    }
    if ((d.a.e.contains(this.jAU, paramb)) && (parama != null))
    {
      parama.a(aXN(), d.a.e.contains(this.jAU, aXN()));
      AppMethodBeat.o(197489);
      return;
    }
    AppMethodBeat.o(197489);
  }
  
  public final e.b aXN()
  {
    AppMethodBeat.i(197490);
    if (this.mView.getHeight() >= this.mView.getWidth())
    {
      localb = e.b.moG;
      AppMethodBeat.o(197490);
      return localb;
    }
    e.b localb = e.b.moJ;
    AppMethodBeat.o(197490);
    return localb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac
 * JD-Core Version:    0.7.0.1
 */