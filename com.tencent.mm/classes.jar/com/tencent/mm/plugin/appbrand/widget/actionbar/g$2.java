package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$2
  implements View.OnKeyListener
{
  g$2(g paramg) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(133659);
    if (paramInt == 4)
    {
      this.jbM.dismiss();
      AppMethodBeat.o(133659);
      return true;
    }
    AppMethodBeat.o(133659);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.g.2
 * JD-Core Version:    0.7.0.1
 */