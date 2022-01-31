package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

final class CollectMainUI$b
{
  boolean kSK;
  LinkedList<CollectMainUI.a> kSL;
  
  private CollectMainUI$b(CollectMainUI paramCollectMainUI)
  {
    AppMethodBeat.i(41283);
    this.kSL = new LinkedList();
    AppMethodBeat.o(41283);
  }
  
  private void a(CollectMainUI.a parama)
  {
    AppMethodBeat.i(41286);
    this.kSK = true;
    CollectMainUI.l(this.kSz);
    CollectMainUI.o(this.kSz).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.j(this.kSz).getWidth(), CollectMainUI.j(this.kSz).getHeight()));
    if (this.kSz.kRX) {
      CollectMainUI.o(this.kSz).setPadding(0, CollectMainUI.biz(), 0, 0);
    }
    final AnimationSet localAnimationSet;
    int j;
    for (;;)
    {
      CollectMainUI.p(this.kSz).setText(j.b(this.kSz.getContext(), parama.elx, CollectMainUI.p(this.kSz).getTextSize()));
      a.b.c(CollectMainUI.q(this.kSz), parama.username);
      CollectMainUI.r(this.kSz).setText(e.e(parama.kNS, parama.cpp));
      CollectMainUI.o(this.kSz).setVisibility(0);
      localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
      j = 0;
      int i = 0;
      while (i < CollectMainUI.s(this.kSz).size())
      {
        if (((CollectMainUI.a)CollectMainUI.s(this.kSz).get(i)).cnJ.equals(parama.cnJ)) {
          j = i;
        }
        i += 1;
      }
      CollectMainUI.o(this.kSz).setPadding(0, CollectMainUI.biA(), 0, 0);
    }
    localAnimationSet.addAnimation(new TranslateAnimation(0.0F, CollectMainUI.access$1600(), 0.0F, tR(j)));
    localAnimationSet.setDuration(300L);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setAnimationListener(new CollectMainUI.b.1(this, parama));
    parama = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    parama.setDuration(300L);
    parama.setInterpolator(new LinearInterpolator());
    parama.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(41281);
        localAnimationSet.setStartOffset(1700L);
        CollectMainUI.o(CollectMainUI.b.this.kSz).startAnimation(localAnimationSet);
        AppMethodBeat.o(41281);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(41282);
        CollectMainUI.o(CollectMainUI.b.this.kSz).setVisibility(0);
        AppMethodBeat.o(41282);
      }
    });
    CollectMainUI.o(this.kSz).startAnimation(parama);
    AppMethodBeat.o(41286);
  }
  
  private int tR(int paramInt)
  {
    AppMethodBeat.i(41284);
    float f2 = 0.0F + CollectMainUI.j(this.kSz).getHeight() / 2;
    float f1 = f2;
    if (CollectMainUI.n(this.kSz).getVisibility() == 0) {
      f1 = f2 + CollectMainUI.n(this.kSz).getHeight();
    }
    f2 = CollectMainUI.aTi() * paramInt + CollectMainUI.aTi() / 2;
    int[] arrayOfInt = new int[2];
    CollectMainUI.j(this.kSz).getLocationInWindow(arrayOfInt);
    paramInt = (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.biy()));
    AppMethodBeat.o(41284);
    return paramInt;
  }
  
  public final void biD()
  {
    AppMethodBeat.i(41285);
    if (!this.kSK)
    {
      if (!this.kSL.isEmpty())
      {
        a((CollectMainUI.a)this.kSL.poll());
        AppMethodBeat.o(41285);
      }
    }
    else {
      ab.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.kSL.size());
    }
    AppMethodBeat.o(41285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.b
 * JD-Core Version:    0.7.0.1
 */