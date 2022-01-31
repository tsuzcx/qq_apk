package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.y;

final class f$1$1
  implements Animation.AnimationListener
{
  f$1$1(f.1 param1, int paramInt, RecyclerView.v paramv) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.kKv == 2)
    {
      f.b(this.kKw.kKu, f.a(this.kKw.kKu, this.hsg.id()));
      this.kKw.cbV = f.c(this.kKw.kKu);
      y.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(this.kKw.cbV) });
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1.1
 * JD-Core Version:    0.7.0.1
 */