package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class FinderMediaCropUI$u
  implements Runnable
{
  FinderMediaCropUI$u(FinderMediaCropUI paramFinderMediaCropUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167370);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.bottomMargin = as.en(this.sOs.getBaseContext());
    localLayoutParams.gravity = 80;
    View localView = this.sOs.cMv();
    p.g(localView, "footer");
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(167370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.u
 * JD-Core Version:    0.7.0.1
 */