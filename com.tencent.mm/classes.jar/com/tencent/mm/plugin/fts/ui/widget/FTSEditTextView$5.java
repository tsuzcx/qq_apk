package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSEditTextView$5
  implements Runnable
{
  FTSEditTextView$5(FTSEditTextView paramFTSEditTextView) {}
  
  public final void run()
  {
    AppMethodBeat.i(62109);
    ((InputMethodManager)this.naY.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.a(this.naY), 0);
    AppMethodBeat.o(62109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.5
 * JD-Core Version:    0.7.0.1
 */