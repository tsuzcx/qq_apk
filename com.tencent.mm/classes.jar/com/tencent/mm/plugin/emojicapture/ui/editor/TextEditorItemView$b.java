package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import a.k;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

public final class TextEditorItemView$b
  implements ValueAnimator.AnimatorUpdateListener
{
  public TextEditorItemView$b(TextEditorItemView paramTextEditorItemView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    g.j(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new k("null cannot be cast to non-null type kotlin.Float");
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (f < 0.01F) {
      TextEditorItemView.a(this.jqJ, false);
    }
    for (;;)
    {
      this.jqJ.invalidate();
      return;
      TextEditorItemView.a(this.jqJ, true);
      TextEditorItemView.d(this.jqJ).setAlpha((int)(f * 255.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView.b
 * JD-Core Version:    0.7.0.1
 */