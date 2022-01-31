package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.n.a;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.khy.khw.bMV, n.a.fast_faded_out);
    this.khy.khw.khi.startAnimation(localAnimation);
    this.khy.khw.khi.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.3.1
 * JD-Core Version:    0.7.0.1
 */