package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a.a;
import com.tencent.mm.br.a.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "lastOrientation", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
final class ab$h
  implements a.b
{
  ab$h(ab paramab) {}
  
  public final void a(a.a parama1, a.a parama2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(288113);
    if (!ab.fY((Context)this.BlT.getContext()))
    {
      AppMethodBeat.o(288113);
      return;
    }
    if (!this.BlT.isUserVisibleFocused())
    {
      AppMethodBeat.o(288113);
      return;
    }
    if ((ab.c(this.BlT)) && (parama1 != parama2))
    {
      parama1 = g.Xox;
      parama1 = ((j)g.b(this.BlT.getActivity()).i(j.class)).xvK;
      if ((parama1 == null) || (parama1.eis() != true)) {
        break label208;
      }
    }
    for (;;)
    {
      parama1 = g.Xox;
      parama1 = ((r)g.b(this.BlT.getActivity()).i(r.class)).BjR;
      if (parama1 != null) {
        bool2 = parama1.eis();
      }
      Log.i("Finder.HorizontalVideoPreviewUIC", "[onConfigurationChanged] isDrawerOpen=" + bool1 + " isLikeDrawerOpen=" + bool2 + " newOrientation=" + parama2);
      if ((!bool1) && (!bool2))
      {
        parama1 = this.BlT;
        p.j(parama2, "newOrientation");
        ab.a(parama1, parama2);
      }
      AppMethodBeat.o(288113);
      return;
      label208:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ab.h
 * JD-Core Version:    0.7.0.1
 */