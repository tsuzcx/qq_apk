package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements View.OnTouchListener
{
  g$1(g paramg) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49379);
    if (paramMotionEvent.getAction() == 1)
    {
      this.roZ.dismiss();
      AppMethodBeat.o(49379);
      return true;
    }
    AppMethodBeat.o(49379);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g.1
 * JD-Core Version:    0.7.0.1
 */