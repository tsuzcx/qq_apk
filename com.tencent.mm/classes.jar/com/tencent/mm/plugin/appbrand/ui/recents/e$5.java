package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class e$5
  implements ViewTreeObserver.OnPreDrawListener
{
  e$5(e parame, Runnable paramRunnable) {}
  
  public final boolean onPreDraw()
  {
    e.p(this.hhH).getViewTreeObserver().removeOnPreDrawListener(this);
    this.hhI.run();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.5
 * JD-Core Version:    0.7.0.1
 */