package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class am
  implements View.OnTouchListener
{
  private static final int EO = ;
  private boolean hwA = false;
  private final Handler hwx = new am.1(this, Looper.getMainLooper());
  private float hwy;
  private float hwz;
  
  private void ct(View paramView)
  {
    paramView.setPressed(false);
    this.hwA = false;
    this.hwx.removeMessages(1);
    this.hwx.removeMessages(2);
  }
  
  protected void akl() {}
  
  protected void asb() {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 3: 
    case 1: 
    case 2: 
      int i;
      float f1;
      float f2;
      do
      {
        return true;
        ct(paramView);
        return true;
        if ((!this.hwA) && (this.hwx.hasMessages(1))) {
          akl();
        }
        ct(paramView);
        return true;
        i = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
      } while ((-i <= f1) && (f1 <= paramView.getWidth() + i) && (-i <= f2) && (f2 <= i + paramView.getHeight()));
      this.hwA = true;
      return true;
    }
    paramView.setPressed(true);
    this.hwx.sendMessageDelayed(Message.obtain(this.hwx, 1), EO);
    this.hwy = paramMotionEvent.getX();
    this.hwz = paramMotionEvent.getY();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */