package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPCollapseTextLayout$c
  implements Runnable
{
  MPCollapseTextLayout$c(MPCollapseTextLayout paramMPCollapseTextLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(152988);
    TextView localTextView = MPCollapseTextLayout.d(this.kjp);
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = MPCollapseTextLayout.d(this.kjp);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)MPCollapseTextLayout.e(this.kjp));
      AppMethodBeat.o(152988);
      return;
    }
    AppMethodBeat.o(152988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout.c
 * JD-Core Version:    0.7.0.1
 */