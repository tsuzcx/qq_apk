package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements View.OnTouchListener
{
  b$1(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113593);
    int i = paramMotionEvent.getAction();
    ab.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113593);
      return false;
      this.ofI.nvl = paramMotionEvent.getX();
      this.ofI.nvm = paramMotionEvent.getY();
      continue;
      if ((Math.abs(paramMotionEvent.getX() - this.ofI.nvl) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.ofI.nvm) > 10.0F)) {
        this.ofI.bMh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b.1
 * JD-Core Version:    0.7.0.1
 */