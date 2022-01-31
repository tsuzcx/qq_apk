package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class AutoFillListPopupWindowBase$e
  implements View.OnTouchListener
{
  private AutoFillListPopupWindowBase$e(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123920);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (AutoFillListPopupWindowBase.b(this.jpu) != null) && (AutoFillListPopupWindowBase.b(this.jpu).isShowing()) && (j >= 0) && (j < AutoFillListPopupWindowBase.b(this.jpu).getWidth()) && (k >= 0) && (k < AutoFillListPopupWindowBase.b(this.jpu).getHeight())) {
      AutoFillListPopupWindowBase.d(this.jpu).postDelayed(AutoFillListPopupWindowBase.c(this.jpu), 250L);
    }
    for (;;)
    {
      AppMethodBeat.o(123920);
      return false;
      if (i == 1) {
        AutoFillListPopupWindowBase.d(this.jpu).removeCallbacks(AutoFillListPopupWindowBase.c(this.jpu));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.e
 * JD-Core Version:    0.7.0.1
 */