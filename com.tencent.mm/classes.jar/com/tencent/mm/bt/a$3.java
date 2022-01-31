package com.tencent.mm.bt;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.mm.api.p;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.view.footer.SelectColorBar;

final class a$3
  implements Animation.AnimationListener
{
  a$3(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.soH.soy.getTextEditView().setVisibility(0);
    paramAnimation = (EditText)this.soH.soy.getTextEditView().findViewById(a.e.text_edit);
    paramAnimation.requestFocus();
    paramAnimation.setSelection(paramAnimation.length());
    this.soH.soy.getSelectedFeatureListener().aL(true);
    ((SelectColorBar)this.soH.soy.findViewById(a.e.select_color_bar)).setSelectColor(paramAnimation.getCurrentTextColor());
    this.soH.soy.getActionBar().post(new a.3.1(this));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bt.a.3
 * JD-Core Version:    0.7.0.1
 */