package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.weishi.g;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

public final class q
  extends p
{
  q(z paramz, List<com.tencent.mm.plugin.appbrand.menu.q> paramList)
  {
    super(paramz, paramList);
  }
  
  protected final void a(d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(143467);
    super.a(paramd);
    z localz = (z)this.bBK;
    if (g.J(localz.getRuntime()))
    {
      paramd.vnU = true;
      paramd.vnV = true;
      AppMethodBeat.o(143467);
      return;
    }
    if (localz.getRuntime().vY())
    {
      if ((localz.isFullScreen()) || (localz.aJx())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramd.vnU = bool1;
        if (!localz.isFullScreen())
        {
          bool1 = bool2;
          if (!localz.aJx()) {}
        }
        else
        {
          bool1 = true;
        }
        paramd.vnV = bool1;
        AppMethodBeat.o(143467);
        return;
      }
    }
    paramd.vnU = localz.isFullScreen();
    paramd.vnV = localz.isFullScreen();
    AppMethodBeat.o(143467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q
 * JD-Core Version:    0.7.0.1
 */