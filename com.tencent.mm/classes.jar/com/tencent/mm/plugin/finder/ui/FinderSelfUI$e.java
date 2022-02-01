package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class FinderSelfUI$e
  implements Runnable
{
  FinderSelfUI$e(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(204744);
    this.sRI.performClick();
    AppMethodBeat.o(204744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.e
 * JD-Core Version:    0.7.0.1
 */