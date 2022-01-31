package com.tencent.mm.plugin.address.ui;

import android.view.View;
import com.tencent.mm.cb.a;

final class MMScrollView$1
  implements Runnable
{
  MMScrollView$1(MMScrollView paramMMScrollView, View paramView) {}
  
  public final void run()
  {
    this.fuW.scrollTo(0, this.val$view.getTop() - a.fromDPToPix(this.fuW.getContext(), 10));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.MMScrollView.1
 * JD-Core Version:    0.7.0.1
 */