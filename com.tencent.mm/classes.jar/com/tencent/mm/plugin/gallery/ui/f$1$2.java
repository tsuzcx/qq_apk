package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.a;

final class f$1$2
  implements Animation.AnimationListener
{
  f$1$2(f.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(21571);
    a.swap(f.d(this.ngW.ngU), f.e(this.ngW.ngU), f.f(this.ngW.ngU));
    if (f.a(this.ngW.ngU) != null)
    {
      if ((this.ngW.cKB > f.e(this.ngW.ngU)) && (this.ngW.cKB <= f.f(this.ngW.ngU)))
      {
        f.a(this.ngW.ngU).W(f.e(this.ngW.ngU), f.f(this.ngW.ngU), this.ngW.cKB - 1);
        AppMethodBeat.o(21571);
        return;
      }
      if ((this.ngW.cKB < f.e(this.ngW.ngU)) && (this.ngW.cKB >= f.f(this.ngW.ngU)))
      {
        f.a(this.ngW.ngU).W(f.e(this.ngW.ngU), f.f(this.ngW.ngU), this.ngW.cKB + 1);
        AppMethodBeat.o(21571);
        return;
      }
      if (f.e(this.ngW.ngU) == this.ngW.cKB)
      {
        f.a(this.ngW.ngU).W(f.e(this.ngW.ngU), f.f(this.ngW.ngU), f.f(this.ngW.ngU));
        AppMethodBeat.o(21571);
        return;
      }
      f.a(this.ngW.ngU).W(f.e(this.ngW.ngU), f.f(this.ngW.ngU), this.ngW.cKB);
    }
    AppMethodBeat.o(21571);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1.2
 * JD-Core Version:    0.7.0.1
 */