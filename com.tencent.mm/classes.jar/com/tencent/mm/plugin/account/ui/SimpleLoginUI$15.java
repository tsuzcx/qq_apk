package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMClearEditText;

final class SimpleLoginUI$15
  implements View.OnTouchListener
{
  SimpleLoginUI$15(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(125611);
    SimpleLoginUI.d(this.gKt).setFocusableInTouchMode(true);
    SimpleLoginUI.c(this.gKt).setFocusableInTouchMode(false);
    boolean bool = SimpleLoginUI.d(this.gKt).getDefaultOnTouchListener().onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(125611);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.15
 * JD-Core Version:    0.7.0.1
 */