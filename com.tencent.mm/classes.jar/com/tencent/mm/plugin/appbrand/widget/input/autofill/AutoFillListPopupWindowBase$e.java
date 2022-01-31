package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.tencent.mm.sdk.platformtools.ah;

final class AutoFillListPopupWindowBase$e
  implements View.OnTouchListener
{
  private AutoFillListPopupWindowBase$e(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (AutoFillListPopupWindowBase.b(this.hxk) != null) && (AutoFillListPopupWindowBase.b(this.hxk).isShowing()) && (j >= 0) && (j < AutoFillListPopupWindowBase.b(this.hxk).getWidth()) && (k >= 0) && (k < AutoFillListPopupWindowBase.b(this.hxk).getHeight())) {
      AutoFillListPopupWindowBase.d(this.hxk).postDelayed(AutoFillListPopupWindowBase.c(this.hxk), 250L);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        AutoFillListPopupWindowBase.d(this.hxk).removeCallbacks(AutoFillListPopupWindowBase.c(this.hxk));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.e
 * JD-Core Version:    0.7.0.1
 */