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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

final class CollectMainUI$b
{
  boolean iLZ;
  LinkedList<CollectMainUI.a> iMa = new LinkedList();
  
  private CollectMainUI$b(CollectMainUI paramCollectMainUI) {}
  
  public final void aFo()
  {
    if (!this.iLZ)
    {
      if (!this.iMa.isEmpty())
      {
        Object localObject = (CollectMainUI.a)this.iMa.poll();
        this.iLZ = true;
        CollectMainUI.l(this.iLP);
        CollectMainUI.o(this.iLP).setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.j(this.iLP).getWidth(), CollectMainUI.j(this.iLP).getHeight()));
        if (this.iLP.iLq) {
          CollectMainUI.o(this.iLP).setPadding(0, CollectMainUI.aFk(), 0, 0);
        }
        final AnimationSet localAnimationSet;
        int j;
        for (;;)
        {
          CollectMainUI.p(this.iLP).setText(j.a(this.iLP.mController.uMN, ((CollectMainUI.a)localObject).dtK, CollectMainUI.p(this.iLP).getTextSize()));
          a.b.a(CollectMainUI.q(this.iLP), ((CollectMainUI.a)localObject).username);
          CollectMainUI.r(this.iLP).setText(e.d(((CollectMainUI.a)localObject).iHP, ((CollectMainUI.a)localObject).bHY));
          CollectMainUI.o(this.iLP).setVisibility(0);
          localAnimationSet = new AnimationSet(false);
          localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
          j = 0;
          int i = 0;
          while (i < CollectMainUI.s(this.iLP).size())
          {
            if (((CollectMainUI.a)CollectMainUI.s(this.iLP).get(i)).bMY.equals(((CollectMainUI.a)localObject).bMY)) {
              j = i;
            }
            i += 1;
          }
          CollectMainUI.o(this.iLP).setPadding(0, CollectMainUI.aFl(), 0, 0);
        }
        float f3 = CollectMainUI.aDL();
        float f2 = 0.0F + CollectMainUI.j(this.iLP).getHeight() / 2;
        float f1 = f2;
        if (CollectMainUI.n(this.iLP).getVisibility() == 0) {
          f1 = f2 + CollectMainUI.n(this.iLP).getHeight();
        }
        f2 = j * CollectMainUI.aFi() + CollectMainUI.aFi() / 2;
        int[] arrayOfInt = new int[2];
        CollectMainUI.j(this.iLP).getLocationInWindow(arrayOfInt);
        localAnimationSet.addAnimation(new TranslateAnimation(0.0F, f3, 0.0F, (int)(f1 + f2 + (arrayOfInt[1] - CollectMainUI.aFj()))));
        localAnimationSet.setDuration(300L);
        localAnimationSet.setInterpolator(new DecelerateInterpolator());
        localAnimationSet.setAnimationListener(new CollectMainUI.b.1(this, (CollectMainUI.a)localObject));
        localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject).setDuration(300L);
        ((ScaleAnimation)localObject).setInterpolator(new LinearInterpolator());
        ((ScaleAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            localAnimationSet.setStartOffset(1700L);
            CollectMainUI.o(CollectMainUI.b.this.iLP).startAnimation(localAnimationSet);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            CollectMainUI.o(CollectMainUI.b.this.iLP).setVisibility(0);
          }
        });
        CollectMainUI.o(this.iLP).startAnimation((Animation)localObject);
      }
      return;
    }
    y.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.iMa.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.b
 * JD-Core Version:    0.7.0.1
 */