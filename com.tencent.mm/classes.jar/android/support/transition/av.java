package android.support.transition;

import android.graphics.Matrix;
import android.view.View;

class av
  implements ba
{
  private float[] uA;
  
  public at J(View paramView)
  {
    return ar.I(paramView);
  }
  
  public be K(View paramView)
  {
    return new bc(paramView.getWindowToken());
  }
  
  public float L(View paramView)
  {
    Float localFloat = (Float)paramView.getTag(2131820664);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void M(View paramView)
  {
    if (paramView.getTag(2131820664) == null) {
      paramView.setTag(2131820664, Float.valueOf(paramView.getAlpha()));
    }
  }
  
  public void N(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.setTag(2131820664, null);
    }
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
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
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
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
  }
  
  public void c(View paramView, Matrix paramMatrix)
  {
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      paramView.setPivotX(paramView.getWidth() / 2);
      paramView.setPivotY(paramView.getHeight() / 2);
      paramView.setTranslationX(0.0F);
      paramView.setTranslationY(0.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      paramView.setRotation(0.0F);
      return;
    }
    float[] arrayOfFloat2 = this.uA;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
    {
      arrayOfFloat1 = new float[9];
      this.uA = arrayOfFloat1;
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
      return;
    }
  }
  
  public void d(View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(2131820664);
    if (localFloat != null)
    {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
      return;
    }
    paramView.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.av
 * JD-Core Version:    0.7.0.1
 */