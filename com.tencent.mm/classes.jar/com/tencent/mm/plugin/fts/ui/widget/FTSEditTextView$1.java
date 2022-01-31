package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import java.util.List;

final class FTSEditTextView$1
  implements View.OnKeyListener
{
  FTSEditTextView$1(FTSEditTextView paramFTSEditTextView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (67 == paramInt))
    {
      paramInt = FTSEditTextView.a(this.kEA).getSelectionStart();
      int i = FTSEditTextView.a(this.kEA).getSelectionEnd();
      if ((paramInt == 0) && (i == 0) && (FTSEditTextView.b(this.kEA).size() > 0) && (FTSEditTextView.c(this.kEA)))
      {
        FTSEditTextView.b(this.kEA).remove(FTSEditTextView.b(this.kEA).size() - 1);
        FTSEditTextView.d(this.kEA);
        FTSEditTextView.e(this.kEA);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.1
 * JD-Core Version:    0.7.0.1
 */