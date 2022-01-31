package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    g localg = this.hdN;
    if ((localg.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)localg.getParent();
      localg.animate().alpha(0.0F).withEndAction(new g.1.2(this, localg, localViewGroup)).withStartAction(new g.1.1(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g.1
 * JD-Core Version:    0.7.0.1
 */