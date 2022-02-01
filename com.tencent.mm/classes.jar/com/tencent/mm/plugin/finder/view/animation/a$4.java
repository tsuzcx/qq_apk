package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$4
  extends AnimatorListenerAdapter
{
  a$4(a parama, RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(168653);
    this.bUV.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.GGj.A(this.bUU);
    this.GGj.bUO.remove(this.bUU);
    this.GGj.IX();
    AppMethodBeat.o(168653);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(168652);
    this.GGj.C(this.bUU);
    AppMethodBeat.o(168652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.4
 * JD-Core Version:    0.7.0.1
 */