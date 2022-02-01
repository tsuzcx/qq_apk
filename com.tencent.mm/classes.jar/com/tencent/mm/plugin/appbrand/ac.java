package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ac
  implements com.tencent.mm.plugin.appbrand.platform.window.e
{
  private final e.b[] jDF;
  private final View mView;
  
  public ac(View paramView)
  {
    AppMethodBeat.i(208040);
    this.mView = paramView;
    this.jDF = new e.b[] { e.b.mtF, e.b.mtG, e.b.mtH, e.b.mtI };
    AppMethodBeat.o(208040);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(208038);
    if (paramb == null)
    {
      ((a)new a(parama)).invoke();
      AppMethodBeat.o(208038);
      return;
    }
    if (paramb == e.b.mtD)
    {
      if (parama != null)
      {
        e.b localb = aYg();
        if (aYg() == paramb) {}
        for (boolean bool = true;; bool = false)
        {
          parama.a(localb, bool);
          AppMethodBeat.o(208038);
          return;
        }
      }
      AppMethodBeat.o(208038);
      return;
    }
    if ((d.a.e.contains(this.jDF, paramb)) && (parama != null))
    {
      parama.a(aYg(), d.a.e.contains(this.jDF, aYg()));
      AppMethodBeat.o(208038);
      return;
    }
    AppMethodBeat.o(208038);
  }
  
  public final e.b aYg()
  {
    AppMethodBeat.i(208039);
    if (this.mView.getHeight() >= this.mView.getWidth())
    {
      localb = e.b.mtD;
      AppMethodBeat.o(208039);
      return localb;
    }
    e.b localb = e.b.mtG;
    AppMethodBeat.o(208039);
    return localb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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