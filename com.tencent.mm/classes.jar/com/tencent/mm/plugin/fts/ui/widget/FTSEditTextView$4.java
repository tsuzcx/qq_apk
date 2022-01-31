package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class FTSEditTextView$4
  implements View.OnClickListener
{
  FTSEditTextView$4(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onClick(View paramView)
  {
    this.kEA.clearText();
    if (FTSEditTextView.h(this.kEA) != null) {
      FTSEditTextView.h(this.kEA).onClickClearTextBtn(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.4
 * JD-Core Version:    0.7.0.1
 */