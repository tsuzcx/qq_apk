package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$1
  implements View.OnTouchListener
{
  private float lJn;
  private short lJo = 0;
  
  c$1(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!c.a(this.lJp)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      y.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()) });
      this.lJn = paramMotionEvent.getRawY();
      c.a(this.lJp, false);
      continue;
      y.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()) });
      if (c.b(this.lJp))
      {
        y.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
        c.c(this.lJp).setSelection(0);
      }
      float f = this.lJn - paramMotionEvent.getRawY();
      if (Math.abs(f) < BackwardSupportUtil.b.b(this.lJp.activity, 20.0F)) {
        this.lJo = 0;
      }
      while (((this.lJp.beO() <= c.d(this.lJp)) && (this.lJo == 1)) || ((!c.c(this.lJp).getScroll2Top()) && (this.lJo == -1) && (this.lJp.beO() < c.e(this.lJp))) || ((this.lJo == -1) && (this.lJp.beO() >= c.e(this.lJp))))
      {
        return false;
        if (f > 0.0F) {
          this.lJo = 1;
        } else {
          this.lJo = -1;
        }
      }
      if ((!c.a(this.lJp)) || (this.lJo == 0)) {
        break;
      }
      y.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.lJo) });
      if (this.lJo == 1)
      {
        c.b(this.lJp, true);
        return false;
      }
      c.b(this.lJp, false);
      return false;
      y.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
      c.a(this.lJp, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.1
 * JD-Core Version:    0.7.0.1
 */