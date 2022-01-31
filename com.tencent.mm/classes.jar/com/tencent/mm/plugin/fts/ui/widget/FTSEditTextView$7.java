package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSEditTextView$7
  implements View.OnFocusChangeListener
{
  FTSEditTextView$7(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(62111);
    if (FTSEditTextView.h(this.naY) != null) {
      FTSEditTextView.h(this.naY).hQ(paramBoolean);
    }
    AppMethodBeat.o(62111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.7
 * JD-Core Version:    0.7.0.1
 */