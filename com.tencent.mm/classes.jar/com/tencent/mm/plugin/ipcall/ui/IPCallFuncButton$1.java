package com.tencent.mm.plugin.ipcall.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallFuncButton$1
  implements View.OnTouchListener
{
  IPCallFuncButton$1(IPCallFuncButton paramIPCallFuncButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(22180);
    if (!IPCallFuncButton.a(this.nTR))
    {
      AppMethodBeat.o(22180);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (!IPCallFuncButton.b(this.nTR)) {
        if (IPCallFuncButton.c(this.nTR) != null) {
          IPCallFuncButton.d(this.nTR).setImageDrawable(IPCallFuncButton.c(this.nTR));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(22180);
      return false;
      if (IPCallFuncButton.e(this.nTR))
      {
        IPCallFuncButton.d(this.nTR).setImageDrawable(IPCallFuncButton.f(this.nTR));
        IPCallFuncButton.a(this.nTR, false);
      }
      for (;;)
      {
        if (IPCallFuncButton.g(this.nTR) == null) {
          break label171;
        }
        IPCallFuncButton.g(this.nTR).iL(IPCallFuncButton.e(this.nTR));
        break;
        IPCallFuncButton.d(this.nTR).setImageDrawable(IPCallFuncButton.c(this.nTR));
        IPCallFuncButton.a(this.nTR, true);
      }
      label171:
      continue;
      if (((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) && (!IPCallFuncButton.b(this.nTR)))
      {
        if (IPCallFuncButton.f(this.nTR) != null) {
          IPCallFuncButton.d(this.nTR).setImageDrawable(IPCallFuncButton.f(this.nTR));
        }
        if (IPCallFuncButton.g(this.nTR) != null) {
          IPCallFuncButton.g(this.nTR).iL(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.1
 * JD-Core Version:    0.7.0.1
 */