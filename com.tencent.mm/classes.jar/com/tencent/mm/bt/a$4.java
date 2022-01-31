package com.tencent.mm.bt;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.mm.api.p;
import com.tencent.mm.bo.a.e;

final class a$4
  implements Animation.AnimationListener
{
  a$4(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ((EditText)this.soH.soy.getTextEditView().findViewById(a.e.text_edit)).setText("");
    this.soH.soy.getTextEditView().setVisibility(8);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.soH.soy.getSelectedFeatureListener().aL(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bt.a.4
 * JD-Core Version:    0.7.0.1
 */