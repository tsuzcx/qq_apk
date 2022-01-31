package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$1
  implements View.OnTouchListener
{
  private float ogB;
  private short ogC = 0;
  
  c$1(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113594);
    if (!c.a(this.ogD))
    {
      AppMethodBeat.o(113594);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113594);
      return false;
      ab.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()) });
      this.ogB = paramMotionEvent.getRawY();
      c.a(this.ogD, false);
      continue;
      ab.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()) });
      if (c.b(this.ogD))
      {
        ab.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
        c.c(this.ogD).setSelection(0);
      }
      float f = this.ogB - paramMotionEvent.getRawY();
      if (Math.abs(f) < BackwardSupportUtil.b.b(this.ogD.activity, 20.0F)) {
        this.ogC = 0;
      }
      while (((this.ogD.bMj() <= c.d(this.ogD)) && (this.ogC == 1)) || ((!c.c(this.ogD).getScroll2Top()) && (this.ogC == -1) && (this.ogD.bMj() < c.e(this.ogD))) || ((this.ogC == -1) && (this.ogD.bMj() >= c.e(this.ogD))))
      {
        AppMethodBeat.o(113594);
        return false;
        if (f > 0.0F) {
          this.ogC = 1;
        } else {
          this.ogC = -1;
        }
      }
      if ((c.a(this.ogD)) && (this.ogC != 0))
      {
        ab.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.ogC) });
        if (this.ogC == 1)
        {
          c.b(this.ogD, true);
          AppMethodBeat.o(113594);
          return false;
        }
        c.b(this.ogD, false);
        AppMethodBeat.o(113594);
        return false;
      }
      AppMethodBeat.o(113594);
      return true;
      ab.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
      c.a(this.ogD, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.1
 * JD-Core Version:    0.7.0.1
 */