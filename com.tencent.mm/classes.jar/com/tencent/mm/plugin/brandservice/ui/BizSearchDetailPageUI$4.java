package com.tencent.mm.plugin.brandservice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.q;

final class BizSearchDetailPageUI$4
  implements View.OnTouchListener
{
  BizSearchDetailPageUI$4(BizSearchDetailPageUI paramBizSearchDetailPageUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(13878);
    if (BizSearchDetailPageUI.f(this.jTp) != null) {
      BizSearchDetailPageUI.f(this.jTp).clearFocus();
    }
    this.jTp.hideVKB();
    AppMethodBeat.o(13878);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.4
 * JD-Core Version:    0.7.0.1
 */