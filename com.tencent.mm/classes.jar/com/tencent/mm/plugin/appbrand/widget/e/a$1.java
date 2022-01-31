package com.tencent.mm.plugin.appbrand.widget.e;

import android.view.ViewPropertyAnimator;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    a locala = this.hBQ;
    if ((locala.getAlpha() == 0.0F) || (locala.hBP != null)) {
      return;
    }
    locala.animate().cancel();
    ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
    locala.hBP = localViewPropertyAnimator;
    localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a.1
 * JD-Core Version:    0.7.0.1
 */