package com.tencent.mm.media.editor.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "plugin-mediaeditor_release"})
public final class a
{
  public float aMu;
  public float aMv;
  private RectF gpq;
  float[] gpr;
  
  public a()
  {
    AppMethodBeat.i(93596);
    this.gpq = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.gpr = new float[2];
    this.aMv = 1.0F;
    this.aMu = 1.0F;
    AppMethodBeat.o(93596);
  }
  
  private static float k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(93595);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(93595);
    return paramFloat1;
  }
  
  public final void a(Matrix paramMatrix, final b<? super Matrix, y> paramb)
  {
    AppMethodBeat.i(93594);
    k.h(paramMatrix, "matrix");
    final float[] arrayOfFloat1 = new float[2];
    paramMatrix.mapPoints(arrayOfFloat1, this.gpr);
    float f1 = k(arrayOfFloat1[0], this.gpq.left, this.gpq.right);
    float f2 = k(arrayOfFloat1[1], this.gpq.top, this.gpq.bottom);
    float[] arrayOfFloat2 = new float[9];
    paramMatrix.getValues(arrayOfFloat2);
    double d1 = arrayOfFloat2[0];
    double d2 = arrayOfFloat2[3];
    double d3 = arrayOfFloat2[4];
    final float f3 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    final float f4 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
    final float f5 = k(f3, this.aMv, this.aMu);
    paramMatrix = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    k.g(paramMatrix, "animator");
    paramMatrix.setDuration(100L);
    paramMatrix.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f3, f5, f4, arrayOfFloat1, new float[] { f1, f2 }, paramb));
    paramMatrix.start();
    AppMethodBeat.o(93594);
  }
  
  public final void e(RectF paramRectF)
  {
    AppMethodBeat.i(93592);
    k.h(paramRectF, "<set-?>");
    this.gpq = paramRectF;
    AppMethodBeat.o(93592);
  }
  
  public final void k(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(93593);
    k.h(paramArrayOfFloat, "<set-?>");
    this.gpr = paramArrayOfFloat;
    AppMethodBeat.o(93593);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, b paramb) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(93591);
      Object localObject = this.gps;
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(93591);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = new Matrix();
      paramValueAnimator.setTranslate(-localObject.gpr[0], -localObject.gpr[1]);
      paramValueAnimator.postScale(a.l(f3, f5, f), a.l(f3, f5, f));
      paramValueAnimator.postRotate(f4);
      paramValueAnimator.postTranslate(a.l(arrayOfFloat1[0], this.gpx[0], f), a.l(arrayOfFloat1[1], this.gpx[1], f));
      localObject = paramb;
      if (localObject != null)
      {
        ((b)localObject).aA(paramValueAnimator);
        AppMethodBeat.o(93591);
        return;
      }
      AppMethodBeat.o(93591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.c.a
 * JD-Core Version:    0.7.0.1
 */