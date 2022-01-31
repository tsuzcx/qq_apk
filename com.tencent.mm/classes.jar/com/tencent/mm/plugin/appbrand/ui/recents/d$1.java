package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$1(d paramd) {}
  
  public final boolean onPreDraw()
  {
    d.a(this.hgW).getViewTreeObserver().removeOnPreDrawListener(this);
    d.b(this.hgW);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.1
 * JD-Core Version:    0.7.0.1
 */