package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    ViewParent localViewParent = this.hcH.getParent();
    if (!(localViewParent instanceof ViewGroup)) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.hcH.animate();
    localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
    localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
    localViewPropertyAnimator.setListener(new b.1.1(this, localViewParent));
    localViewPropertyAnimator.alpha(0.0F).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.1
 * JD-Core Version:    0.7.0.1
 */