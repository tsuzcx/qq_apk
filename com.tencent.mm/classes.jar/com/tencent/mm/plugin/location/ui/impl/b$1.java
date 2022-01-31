package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements View.OnTouchListener
{
  b$1(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    y.i("MicroMsg.MMBaseMapUI", "map action " + i);
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      this.lIv.kXk = paramMotionEvent.getX();
      this.lIv.hZz = paramMotionEvent.getY();
      continue;
      if ((Math.abs(paramMotionEvent.getX() - this.lIv.kXk) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.lIv.hZz) > 10.0F)) {
        this.lIv.beN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b.1
 * JD-Core Version:    0.7.0.1
 */