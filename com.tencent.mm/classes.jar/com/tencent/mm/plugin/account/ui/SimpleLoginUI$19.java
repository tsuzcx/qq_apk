package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SimpleLoginUI$19
  implements View.OnTouchListener
{
  SimpleLoginUI$19(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(125616);
    this.gKt.hideVKB();
    AppMethodBeat.o(125616);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.19
 * JD-Core Version:    0.7.0.1
 */