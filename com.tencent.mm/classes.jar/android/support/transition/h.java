package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

@SuppressLint({"ViewConstructor"})
final class h
  extends View
  implements j
{
  private final Matrix mMatrix = new Matrix();
  final View mView;
  ViewGroup rJ;
  View rK;
  int rL;
  private int rM;
  private int rN;
  Matrix rO;
  private final ViewTreeObserver.OnPreDrawListener rP = new h.1(this);
  
  h(View paramView)
  {
    super(paramView.getContext());
    this.mView = paramView;
    setLayerType(2, null);
  }
  
  static h z(View paramView)
  {
    return (h)paramView.getTag(2131820626);
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.rJ = paramViewGroup;
    this.rK = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mView.setTag(2131820626, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.rM = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.rN = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.rP);
    this.mView.setVisibility(4);
  }
  
  protected final void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.rP);
    this.mView.setVisibility(0);
    this.mView.setTag(2131820626, null);
    super.onDetachedFromWindow();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    this.mMatrix.set(this.rO);
    this.mMatrix.postTranslate(this.rM, this.rN);
    paramCanvas.setMatrix(this.mMatrix);
    this.mView.draw(paramCanvas);
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    View localView = this.mView;
    if (paramInt == 0) {}
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.h
 * JD-Core Version:    0.7.0.1
 */