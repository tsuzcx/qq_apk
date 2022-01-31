package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class m$1
  implements View.OnTouchListener
{
  m$1(m paramm) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return false;
      } while ((Math.abs(paramMotionEvent.getX() - this.lHu.kXk) <= 10.0F) && (Math.abs(paramMotionEvent.getY() - this.lHu.hZz) <= 10.0F));
      m.a(this.lHu, true);
      return false;
      this.lHu.kXk = paramMotionEvent.getX();
      this.lHu.hZz = paramMotionEvent.getY();
      m.a(this.lHu, System.currentTimeMillis());
      m.a(this.lHu, false);
      return false;
    } while ((m.a(this.lHu)) || (System.currentTimeMillis() - m.b(this.lHu) >= 200L));
    m.c(this.lHu);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.1
 * JD-Core Version:    0.7.0.1
 */