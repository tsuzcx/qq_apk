package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPCollapseTextLayout$d
  implements Runnable
{
  MPCollapseTextLayout$d(MPCollapseTextLayout paramMPCollapseTextLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(152989);
    MMNeat7extView localMMNeat7extView = MPCollapseTextLayout.f(this.kjp);
    if (localMMNeat7extView != null)
    {
      localMMNeat7extView.requestLayout();
      AppMethodBeat.o(152989);
      return;
    }
    AppMethodBeat.o(152989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout.d
 * JD-Core Version:    0.7.0.1
 */