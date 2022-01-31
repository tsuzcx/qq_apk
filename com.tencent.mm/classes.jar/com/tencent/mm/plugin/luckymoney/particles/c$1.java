package com.tencent.mm.plugin.luckymoney.particles;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class c$1
  implements View.OnAttachStateChangeListener
{
  c$1(c paramc) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    this.lSM.bfS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.c.1
 * JD-Core Version:    0.7.0.1
 */