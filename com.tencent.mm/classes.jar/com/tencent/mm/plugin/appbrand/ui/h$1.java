package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(133089);
    h localh = this.iOy;
    if ((localh.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)localh.getParent();
      localh.animate().alpha(0.0F).withEndAction(new h.1.2(this, localh, localViewGroup)).withStartAction(new h.1.1(this)).start();
    }
    AppMethodBeat.o(133089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.1
 * JD-Core Version:    0.7.0.1
 */