package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class e$1
  implements View.OnTouchListener
{
  e$1(e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.hpa.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e.1
 * JD-Core Version:    0.7.0.1
 */