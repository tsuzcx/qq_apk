package com.tencent.mm.bs;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;

final class a$4
  implements Animation.AnimationListener
{
  a$4(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(116309);
    ((EditText)this.whn.whc.getTextEditView().findViewById(2131823497)).setText("");
    this.whn.whc.getTextEditView().setVisibility(8);
    AppMethodBeat.o(116309);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(116308);
    this.whn.whc.getSelectedFeatureListener().bk(false);
    AppMethodBeat.o(116308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bs.a.4
 * JD-Core Version:    0.7.0.1
 */