package com.tencent.mm.plugin.aa.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LaunchAAByPersonAmountSelectUI$5
  implements View.OnTouchListener
{
  LaunchAAByPersonAmountSelectUI$5(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63593);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (!LaunchAAByPersonAmountSelectUI.l(this.iWk))
    {
      a.a(true, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(63593);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      LaunchAAByPersonAmountSelectUI.m(this.iWk).setTextColor(this.iWk.getResources().getColor(2131100054));
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(63593);
      return false;
      if (LaunchAAByPersonAmountSelectUI.l(this.iWk)) {
        LaunchAAByPersonAmountSelectUI.m(this.iWk).setTextColor(this.iWk.getResources().getColor(2131100053));
      } else {
        LaunchAAByPersonAmountSelectUI.m(this.iWk).setTextColor(this.iWk.getResources().getColor(2131100052));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.5
 * JD-Core Version:    0.7.0.1
 */