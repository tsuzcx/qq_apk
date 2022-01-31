package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

final class TextInputLayout$3
  extends AnimatorListenerAdapter
{
  TextInputLayout$3(TextInputLayout paramTextInputLayout, CharSequence paramCharSequence) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.mT.mr.setText(this.mU);
    this.mT.mr.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.3
 * JD-Core Version:    0.7.0.1
 */