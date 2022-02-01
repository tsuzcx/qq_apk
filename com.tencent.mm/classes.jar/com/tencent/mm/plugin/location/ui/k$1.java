package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$1
  implements View.OnTouchListener
{
  k$1(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55963);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(55963);
      return false;
      if ((Math.abs(paramMotionEvent.getX() - this.vep.aTL) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.vep.aTM) > 10.0F))
      {
        k.a(this.vep, true);
        continue;
        this.vep.aTL = paramMotionEvent.getX();
        this.vep.aTM = paramMotionEvent.getY();
        k.a(this.vep, System.currentTimeMillis());
        k.a(this.vep, false);
        continue;
        if ((!k.a(this.vep)) && (System.currentTimeMillis() - k.b(this.vep) < 200L)) {
          k.c(this.vep);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.1
 * JD-Core Version:    0.7.0.1
 */