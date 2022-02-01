package com.tencent.mm.live.c;

import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class au$b
  implements Runnable
{
  au$b(au paramau) {}
  
  public final void run()
  {
    AppMethodBeat.i(216197);
    ViewPropertyAnimator localViewPropertyAnimator = au.b(this.gZH).animate().translationY(0.0F);
    localViewPropertyAnimator.setListener(null);
    localViewPropertyAnimator.start();
    AppMethodBeat.o(216197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.au.b
 * JD-Core Version:    0.7.0.1
 */