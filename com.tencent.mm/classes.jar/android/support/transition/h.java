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
  ViewGroup qM;
  View qN;
  int qO;
  private int qP;
  private int qQ;
  Matrix qR;
  private final ViewTreeObserver.OnPreDrawListener qS = new h.1(this);
  
  h(View paramView)
  {
    super(paramView.getContext());
    this.mView = paramView;
    setLayerType(2, null);
  }
  
  private static void a(View paramView, h paramh)
  {
    paramView.setTag(z.a.ghost_view, paramh);
  }
  
  static h w(View paramView)
  {
    return (h)paramView.getTag(z.a.ghost_view);
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.qM = paramViewGroup;
    this.qN = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this.mView, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.qP = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.qQ = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.qS);
    this.mView.setVisibility(4);
  }
  
  protected final void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.qS);
    this.mView.setVisibility(0);
    a(this.mView, null);
    super.onDetachedFromWindow();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    this.mMatrix.set(this.qR);
    this.mMatrix.postTranslate(this.qP, this.qQ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.h
 * JD-Core Version:    0.7.0.1
 */