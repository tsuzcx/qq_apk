package com.tencent.mm.bs;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.view.footer.SelectColorBar;

final class a$3
  implements Animation.AnimationListener
{
  a$3(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(116307);
    this.whn.whc.getTextEditView().setVisibility(0);
    paramAnimation = (EditText)this.whn.whc.getTextEditView().findViewById(2131823497);
    paramAnimation.requestFocus();
    paramAnimation.setSelection(paramAnimation.length());
    this.whn.whc.getSelectedFeatureListener().bk(true);
    ((SelectColorBar)this.whn.whc.findViewById(2131823499)).setSelectColor(paramAnimation.getCurrentTextColor());
    this.whn.whc.getActionBar().post(new a.3.1(this));
    AppMethodBeat.o(116307);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bs.a.3
 * JD-Core Version:    0.7.0.1
 */