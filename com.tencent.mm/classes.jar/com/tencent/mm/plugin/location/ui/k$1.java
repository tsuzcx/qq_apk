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
    a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(55963);
      return false;
      if ((Math.abs(paramMotionEvent.getX() - this.vqA.aTL) > 10.0F) || (Math.abs(paramMotionEvent.getY() - this.vqA.aTM) > 10.0F))
      {
        k.a(this.vqA, true);
        continue;
        this.vqA.aTL = paramMotionEvent.getX();
        this.vqA.aTM = paramMotionEvent.getY();
        k.a(this.vqA, System.currentTimeMillis());
        k.a(this.vqA, false);
        continue;
        if ((!k.a(this.vqA)) && (System.currentTimeMillis() - k.b(this.vqA) < 200L)) {
          k.c(this.vqA);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.1
 * JD-Core Version:    0.7.0.1
 */