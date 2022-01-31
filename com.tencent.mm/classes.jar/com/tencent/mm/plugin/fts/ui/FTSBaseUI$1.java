package com.tencent.mm.plugin.fts.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;

final class FTSBaseUI$1
  implements View.OnTouchListener
{
  FTSBaseUI$1(FTSBaseUI paramFTSBaseUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(61779);
    FTSBaseUI.a(this.mWQ).getFtsEditText().naN.clearFocus();
    this.mWQ.hideVKB();
    AppMethodBeat.o(61779);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI.1
 * JD-Core Version:    0.7.0.1
 */