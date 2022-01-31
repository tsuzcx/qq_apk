package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  r$1(r paramr, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(112171);
    if (this.nCK.getLineCount() > 1)
    {
      this.nCK.setMaxLines(2);
      this.nCL.setMaxLines(1);
      AppMethodBeat.o(112171);
      return;
    }
    this.nCL.setMaxLines(2);
    AppMethodBeat.o(112171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.1
 * JD-Core Version:    0.7.0.1
 */