package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import d.g.a.a;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"})
public final class ac
  implements com.tencent.mm.plugin.appbrand.s.a.e
{
  private final e.b[] iHJ;
  private final View mView;
  
  public ac(View paramView)
  {
    AppMethodBeat.i(194362);
    this.mView = paramView;
    this.iHJ = new e.b[] { e.b.lmQ, e.b.lmR, e.b.lmS, e.b.lmT };
    AppMethodBeat.o(194362);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(194360);
    if (paramb == null)
    {
      ((a)new a(parama)).invoke();
      AppMethodBeat.o(194360);
      return;
    }
    if (paramb == e.b.lmO)
    {
      if (parama != null)
      {
        e.b localb = aNL();
        if (aNL() == paramb) {}
        for (boolean bool = true;; bool = false)
        {
          parama.a(localb, bool);
          AppMethodBeat.o(194360);
          return;
        }
      }
      AppMethodBeat.o(194360);
      return;
    }
    if ((d.a.e.contains(this.iHJ, paramb)) && (parama != null))
    {
      parama.a(aNL(), d.a.e.contains(this.iHJ, aNL()));
      AppMethodBeat.o(194360);
      return;
    }
    AppMethodBeat.o(194360);
  }
  
  public final e.b aNL()
  {
    AppMethodBeat.i(194361);
    if (this.mView.getHeight() >= this.mView.getWidth())
    {
      localb = e.b.lmO;
      AppMethodBeat.o(194361);
      return localb;
    }
    e.b localb = e.b.lmR;
    AppMethodBeat.o(194361);
    return localb;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac
 * JD-Core Version:    0.7.0.1
 */