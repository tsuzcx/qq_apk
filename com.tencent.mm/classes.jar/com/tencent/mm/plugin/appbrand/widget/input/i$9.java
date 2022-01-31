package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class i$9
  implements View.OnKeyListener
{
  i$9(i parami) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141609);
    paramView = this.jlw;
    boolean bool;
    if (67 == paramInt)
    {
      bool = true;
      paramView.jlq = bool;
      if (!this.jlw.jlq) {
        break label86;
      }
      this.jlw.jls.removeCallbacks(this.jlw.jlr);
      this.jlw.jls.postDelayed(this.jlw.jlr, 1000L);
    }
    for (;;)
    {
      AppMethodBeat.o(141609);
      return false;
      bool = false;
      break;
      label86:
      this.jlw.jlr.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.9
 * JD-Core Version:    0.7.0.1
 */