package com.tencent.mm.plugin.appbrand.widget.f;

import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87522);
    a locala = this.juf;
    if ((locala.getAlpha() == 0.0F) || (locala.jue != null))
    {
      AppMethodBeat.o(87522);
      return;
    }
    locala.animate().cancel();
    ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
    locala.jue = localViewPropertyAnimator;
    localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
    AppMethodBeat.o(87522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a.1
 * JD-Core Version:    0.7.0.1
 */