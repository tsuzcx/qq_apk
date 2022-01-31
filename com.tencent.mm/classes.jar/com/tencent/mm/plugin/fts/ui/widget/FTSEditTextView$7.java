package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class FTSEditTextView$7
  implements View.OnFocusChangeListener
{
  FTSEditTextView$7(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (FTSEditTextView.h(this.kEA) != null) {
      FTSEditTextView.h(this.kEA).gn(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.7
 * JD-Core Version:    0.7.0.1
 */