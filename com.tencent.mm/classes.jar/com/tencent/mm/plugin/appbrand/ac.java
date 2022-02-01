package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import d.g.a.a;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ac
  implements com.tencent.mm.plugin.appbrand.r.a.e
{
  private final e.b[] jhL;
  private final View mView;
  
  public ac(View paramView)
  {
    AppMethodBeat.i(193272);
    this.mView = paramView;
    this.jhL = new e.b[] { e.b.lOS, e.b.lOT, e.b.lOU, e.b.lOV };
    AppMethodBeat.o(193272);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(193270);
    if (paramb == null)
    {
      ((a)new a(parama)).invoke();
      AppMethodBeat.o(193270);
      return;
    }
    if (paramb == e.b.lOQ)
    {
      if (parama != null)
      {
        e.b localb = aUB();
        if (aUB() == paramb) {}
        for (boolean bool = true;; bool = false)
        {
          parama.a(localb, bool);
          AppMethodBeat.o(193270);
          return;
        }
      }
      AppMethodBeat.o(193270);
      return;
    }
    if ((d.a.e.contains(this.jhL, paramb)) && (parama != null))
    {
      parama.a(aUB(), d.a.e.contains(this.jhL, aUB()));
      AppMethodBeat.o(193270);
      return;
    }
    AppMethodBeat.o(193270);
  }
  
  public final e.b aUB()
  {
    AppMethodBeat.i(193271);
    if (this.mView.getHeight() >= this.mView.getWidth())
    {
      localb = e.b.lOQ;
      AppMethodBeat.o(193271);
      return localb;
    }
    e.b localb = e.b.lOT;
    AppMethodBeat.o(193271);
    return localb;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(e.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac
 * JD-Core Version:    0.7.0.1
 */