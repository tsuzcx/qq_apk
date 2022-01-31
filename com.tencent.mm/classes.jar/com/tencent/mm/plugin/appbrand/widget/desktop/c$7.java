package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class c$7
  extends AnimatorListenerAdapter
{
  c$7(c paramc, RecyclerView.v paramv, int paramInt, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133783);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
    AppMethodBeat.o(133783);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133782);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", new Object[] { Integer.valueOf(this.gxr) });
    this.acw.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.jed.B(this.acv);
    this.jed.acp.remove(this.acv);
    this.jed.hB();
    AppMethodBeat.o(133782);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(133781);
    this.jed.D(this.acv);
    AppMethodBeat.o(133781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.7
 * JD-Core Version:    0.7.0.1
 */