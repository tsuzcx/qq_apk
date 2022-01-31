package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class FTSEditTextView$3
  implements TextView.OnEditorActionListener
{
  FTSEditTextView$3(FTSEditTextView paramFTSEditTextView) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((3 == paramInt) && (FTSEditTextView.h(this.kEA) != null)) {
      return FTSEditTextView.h(this.kEA).apb();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.3
 * JD-Core Version:    0.7.0.1
 */