package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class am
{
  private float[] atr;
  
  public void a(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193310);
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      a((View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity()) {
      paramMatrix.preConcat(paramView);
    }
    AppMethodBeat.o(193310);
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193313);
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      b((View)localObject, paramMatrix);
      paramMatrix.postTranslate(((View)localObject).getScrollX(), ((View)localObject).getScrollY());
    }
    paramMatrix.postTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      localObject = new Matrix();
      if (paramView.invert((Matrix)localObject)) {
        paramMatrix.postConcat((Matrix)localObject);
      }
    }
    AppMethodBeat.o(193313);
  }
  
  public float bO(View paramView)
  {
    AppMethodBeat.i(193301);
    Float localFloat = (Float)paramView.getTag(m.a.save_non_transition_alpha);
    if (localFloat != null)
    {
      f = paramView.getAlpha() / localFloat.floatValue();
      AppMethodBeat.o(193301);
      return f;
    }
    float f = paramView.getAlpha();
    AppMethodBeat.o(193301);
    return f;
  }
  
  public void bP(View paramView)
  {
    AppMethodBeat.i(193303);
    if (paramView.getTag(m.a.save_non_transition_alpha) == null) {
      paramView.setTag(m.a.save_non_transition_alpha, Float.valueOf(paramView.getAlpha()));
    }
    AppMethodBeat.o(193303);
  }
  
  public void bQ(View paramView)
  {
    AppMethodBeat.i(193306);
    if (paramView.getVisibility() == 0) {
      paramView.setTag(m.a.save_non_transition_alpha, null);
    }
    AppMethodBeat.o(193306);
  }
  
  public void c(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193328);
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      paramView.setPivotX(paramView.getWidth() / 2);
      paramView.setPivotY(paramView.getHeight() / 2);
      paramView.setTranslationX(0.0F);
      paramView.setTranslationY(0.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      paramView.setRotation(0.0F);
      AppMethodBeat.o(193328);
      return;
    }
    float[] arrayOfFloat2 = this.atr;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
    {
      arrayOfFloat1 = new float[9];
      this.atr = arrayOfFloat1;
    }
    paramMatrix.getValues(arrayOfFloat1);
    float f1 = arrayOfFloat1[3];
    float f2 = (float)Math.sqrt(1.0F - f1 * f1);
    if (arrayOfFloat1[0] < 0.0F) {}
    for (int i = -1;; i = 1)
    {
      float f3 = i * f2;
      f1 = (float)Math.toDegrees(Math.atan2(f1, f3));
      f2 = arrayOfFloat1[0] / f3;
      f3 = arrayOfFloat1[4] / f3;
      float f4 = arrayOfFloat1[2];
      float f5 = arrayOfFloat1[5];
      paramView.setPivotX(0.0F);
      paramView.setPivotY(0.0F);
      paramView.setTranslationX(f4);
      paramView.setTranslationY(f5);
      paramView.setRotation(f1);
      paramView.setScaleX(f2);
      paramView.setScaleY(f3);
      AppMethodBeat.o(193328);
      return;
    }
  }
  
  public void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193329);
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
    AppMethodBeat.o(193329);
  }
  
  public void n(View paramView, float paramFloat)
  {
    AppMethodBeat.i(193298);
    Float localFloat = (Float)paramView.getTag(m.a.save_non_transition_alpha);
    if (localFloat != null)
    {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
      AppMethodBeat.o(193298);
      return;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(193298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.am
 * JD-Core Version:    0.7.0.1
 */