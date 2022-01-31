package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSEditTextView$4
  implements View.OnClickListener
{
  FTSEditTextView$4(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(62108);
    this.naY.clearText();
    if (FTSEditTextView.h(this.naY) != null) {
      FTSEditTextView.h(this.naY).onClickClearTextBtn(paramView);
    }
    AppMethodBeat.o(62108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.4
 * JD-Core Version:    0.7.0.1
 */