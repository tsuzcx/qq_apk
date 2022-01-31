package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSEditTextView$3
  implements TextView.OnEditorActionListener
{
  FTSEditTextView$3(FTSEditTextView paramFTSEditTextView) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(62107);
    if ((3 == paramInt) && (FTSEditTextView.h(this.naY) != null))
    {
      boolean bool = FTSEditTextView.h(this.naY).aMm();
      AppMethodBeat.o(62107);
      return bool;
    }
    AppMethodBeat.o(62107);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.3
 * JD-Core Version:    0.7.0.1
 */