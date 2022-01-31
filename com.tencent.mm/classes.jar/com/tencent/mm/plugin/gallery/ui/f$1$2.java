package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.gallery.a.a;

final class f$1$2
  implements Animation.AnimationListener
{
  f$1$2(f.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    a.swap(f.d(this.kKw.kKu), f.e(this.kKw.kKu), f.f(this.kKw.kKu));
    if (f.a(this.kKw.kKu) != null)
    {
      if ((this.kKw.cbV > f.e(this.kKw.kKu)) && (this.kKw.cbV <= f.f(this.kKw.kKu))) {
        f.a(this.kKw.kKu).K(f.e(this.kKw.kKu), f.f(this.kKw.kKu), this.kKw.cbV - 1);
      }
    }
    else {
      return;
    }
    if ((this.kKw.cbV < f.e(this.kKw.kKu)) && (this.kKw.cbV >= f.f(this.kKw.kKu)))
    {
      f.a(this.kKw.kKu).K(f.e(this.kKw.kKu), f.f(this.kKw.kKu), this.kKw.cbV + 1);
      return;
    }
    if (f.e(this.kKw.kKu) == this.kKw.cbV)
    {
      f.a(this.kKw.kKu).K(f.e(this.kKw.kKu), f.f(this.kKw.kKu), f.f(this.kKw.kKu));
      return;
    }
    f.a(this.kKw.kKu).K(f.e(this.kKw.kKu), f.f(this.kKw.kKu), this.kKw.cbV);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1.2
 * JD-Core Version:    0.7.0.1
 */