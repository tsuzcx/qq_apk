package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$1
  implements View.OnTouchListener
{
  m$1(m paramm) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113560);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113560);
      return false;
      if ((Math.abs(paramMotionEvent.getX() - this.oeH.nvl) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.oeH.nvm) > 10.0F))
      {
        m.a(this.oeH, true);
        continue;
        this.oeH.nvl = paramMotionEvent.getX();
        this.oeH.nvm = paramMotionEvent.getY();
        m.a(this.oeH, System.currentTimeMillis());
        m.a(this.oeH, false);
        continue;
        if ((!m.a(this.oeH)) && (System.currentTimeMillis() - m.b(this.oeH) < 200L)) {
          m.c(this.oeH);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.1
 * JD-Core Version:    0.7.0.1
 */