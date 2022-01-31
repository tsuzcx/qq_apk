package com.tencent.mm.plugin.aa.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LaunchAAByPersonAmountSelectUI$5
  implements View.OnTouchListener
{
  LaunchAAByPersonAmountSelectUI$5(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40792);
    if (!LaunchAAByPersonAmountSelectUI.k(this.gqx))
    {
      AppMethodBeat.o(40792);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      LaunchAAByPersonAmountSelectUI.l(this.gqx).setTextColor(this.gqx.getResources().getColor(2131689795));
    }
    for (;;)
    {
      AppMethodBeat.o(40792);
      return false;
      if (LaunchAAByPersonAmountSelectUI.k(this.gqx)) {
        LaunchAAByPersonAmountSelectUI.l(this.gqx).setTextColor(this.gqx.getResources().getColor(2131689794));
      } else {
        LaunchAAByPersonAmountSelectUI.l(this.gqx).setTextColor(this.gqx.getResources().getColor(2131689793));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.5
 * JD-Core Version:    0.7.0.1
 */