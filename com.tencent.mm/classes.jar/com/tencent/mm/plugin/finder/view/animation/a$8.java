package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$8
  extends AnimatorListenerAdapter
{
  a$8(a parama, a.a parama1, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(168660);
    this.bVa.setListener(null);
    this.bVb.setAlpha(1.0F);
    this.bVb.setTranslationX(0.0F);
    this.bVb.setTranslationY(0.0F);
    this.GGj.r(this.GGk.bVd);
    this.GGj.bUP.remove(this.GGk.bVd);
    this.GGj.IX();
    AppMethodBeat.o(168660);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.8
 * JD-Core Version:    0.7.0.1
 */