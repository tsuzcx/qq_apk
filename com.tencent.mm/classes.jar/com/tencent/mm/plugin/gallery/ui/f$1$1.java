package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1$1
  implements Animation.AnimationListener
{
  f$1$1(f.1 param1, int paramInt, RecyclerView.v paramv) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(21570);
    if (this.ngV == 2)
    {
      f.b(this.ngW.ngU, f.a(this.ngW.ngU, this.jiE.jN()));
      this.ngW.cKB = f.c(this.ngW.ngU);
      ab.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(this.ngW.cKB) });
    }
    AppMethodBeat.o(21570);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.1.1
 * JD-Core Version:    0.7.0.1
 */