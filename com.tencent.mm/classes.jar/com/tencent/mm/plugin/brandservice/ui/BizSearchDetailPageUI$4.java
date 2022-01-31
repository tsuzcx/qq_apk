package com.tencent.mm.plugin.brandservice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.tools.n;

final class BizSearchDetailPageUI$4
  implements View.OnTouchListener
{
  BizSearchDetailPageUI$4(BizSearchDetailPageUI paramBizSearchDetailPageUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (BizSearchDetailPageUI.f(this.icA) != null) {
      BizSearchDetailPageUI.f(this.icA).clearFocus();
    }
    this.icA.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.4
 * JD-Core Version:    0.7.0.1
 */