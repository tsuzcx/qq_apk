package com.tencent.mm.media.editor.c;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class a$a
  implements ValueAnimator.AnimatorUpdateListener
{
  a$a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(12900);
    Object localObject = this.eTo;
    j.p(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(12900);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = new Matrix();
    paramValueAnimator.setTranslate(-localObject.eTn[0], -localObject.eTn[1]);
    paramValueAnimator.postScale(a.j(this.eTp, this.eTq, f), a.j(this.eTp, this.eTq, f));
    paramValueAnimator.postRotate(this.eTr);
    paramValueAnimator.postTranslate(a.j(this.eTs[0], this.eTt[0], f), a.j(this.eTs[1], this.eTt[1], f));
    localObject = this.eTu;
    if (localObject != null)
    {
      ((b)localObject).S(paramValueAnimator);
      AppMethodBeat.o(12900);
      return;
    }
    AppMethodBeat.o(12900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.editor.c.a.a
 * JD-Core Version:    0.7.0.1
 */