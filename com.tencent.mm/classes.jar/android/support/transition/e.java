package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
final class e
  extends View
  implements g
{
  ViewGroup AZ;
  View Ba;
  int Bb;
  private int Bc;
  private int Bd;
  Matrix Be;
  private final ViewTreeObserver.OnPreDrawListener Bf = new ViewTreeObserver.OnPreDrawListener()
  {
    public final boolean onPreDraw()
    {
      e.this.Be = e.this.mView.getMatrix();
      t.W(e.this);
      if ((e.this.AZ != null) && (e.this.Ba != null))
      {
        e.this.AZ.endViewTransition(e.this.Ba);
        t.W(e.this.AZ);
        e.this.AZ = null;
        e.this.Ba = null;
      }
      return true;
    }
  };
  private final Matrix mMatrix = new Matrix();
  final View mView;
  
  private e(View paramView)
  {
    super(paramView.getContext());
    this.mView = paramView;
    setLayerType(2, null);
  }
  
  static void D(View paramView)
  {
    paramView = E(paramView);
    if (paramView != null)
    {
      paramView.Bb -= 1;
      if (paramView.Bb <= 0)
      {
        Object localObject = paramView.getParent();
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          ((ViewGroup)localObject).endViewTransition(paramView);
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
  
  private static e E(View paramView)
  {
    return (e)paramView.getTag(2131300585);
  }
  
  static g a(View paramView, ViewGroup paramViewGroup)
  {
    e locale2 = E(paramView);
    e locale1 = locale2;
    if (locale2 == null)
    {
      if (!(paramViewGroup instanceof FrameLayout))
      {
        paramViewGroup = paramViewGroup.getParent();
        if ((paramViewGroup instanceof ViewGroup)) {}
      }
      for (paramViewGroup = null;; paramViewGroup = (FrameLayout)paramViewGroup)
      {
        if (paramViewGroup != null) {
          break label54;
        }
        return null;
        paramViewGroup = (ViewGroup)paramViewGroup;
        break;
      }
      label54:
      locale1 = new e(paramView);
      paramViewGroup.addView(locale1);
    }
    locale1.Bb += 1;
    return locale1;
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.AZ = paramViewGroup;
    this.Ba = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mView.setTag(2131300585, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.Bc = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.Bd = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.Bf);
    this.mView.setVisibility(4);
  }
  
  protected final void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.Bf);
    this.mView.setVisibility(0);
    this.mView.setTag(2131300585, null);
    super.onDetachedFromWindow();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    this.mMatrix.set(this.Be);
    this.mMatrix.postTranslate(this.Bc, this.Bd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.e
 * JD-Core Version:    0.7.0.1
 */