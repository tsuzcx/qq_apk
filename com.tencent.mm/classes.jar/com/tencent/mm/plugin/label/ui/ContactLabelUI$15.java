package com.tencent.mm.plugin.label.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactLabelUI$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ContactLabelUI$15(ContactLabelUI paramContactLabelUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(226562);
    Log.i("MicroMsg.Label.ContactLabelUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue()) });
    AppMethodBeat.o(226562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.15
 * JD-Core Version:    0.7.0.1
 */