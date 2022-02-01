package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class d$11
  implements ValueAnimator.AnimatorUpdateListener
{
  d$11(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(176930);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ae.i("MicroMsg.FTS.PardusSearchLogic", "native onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
    d.h(this.tPD).getLayoutParams().height = i;
    d.h(this.tPD).requestLayout();
    AppMethodBeat.o(176930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d.11
 * JD-Core Version:    0.7.0.1
 */