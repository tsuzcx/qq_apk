package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(74542);
    Animation localAnimation = AnimationUtils.loadAnimation(this.mCi.mCh.cup, 2131034182);
    this.mCi.mCh.mBX.startAnimation(localAnimation);
    this.mCi.mCh.mBX.setVisibility(8);
    AppMethodBeat.o(74542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.3.1
 * JD-Core Version:    0.7.0.1
 */