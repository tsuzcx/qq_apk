package com.tencent.mm.plugin.fts.ui.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class FTSEditTextView$1
  implements View.OnKeyListener
{
  FTSEditTextView$1(FTSEditTextView paramFTSEditTextView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(62105);
    if ((paramKeyEvent.getAction() == 0) && (67 == paramInt))
    {
      paramInt = FTSEditTextView.a(this.naY).getSelectionStart();
      int i = FTSEditTextView.a(this.naY).getSelectionEnd();
      if ((paramInt == 0) && (i == 0) && (FTSEditTextView.b(this.naY).size() > 0) && (FTSEditTextView.c(this.naY)))
      {
        FTSEditTextView.b(this.naY).remove(FTSEditTextView.b(this.naY).size() - 1);
        FTSEditTextView.d(this.naY);
        FTSEditTextView.e(this.naY);
      }
    }
    AppMethodBeat.o(62105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.1
 * JD-Core Version:    0.7.0.1
 */