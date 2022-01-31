package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class g$1$a
  implements Runnable
{
  g$1$a(g.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(134761);
    ViewParent localViewParent = this.ivE.ivD.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeView((View)this.ivE.ivD);
      AppMethodBeat.o(134761);
      return;
    }
    AppMethodBeat.o(134761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.1.a
 * JD-Core Version:    0.7.0.1
 */