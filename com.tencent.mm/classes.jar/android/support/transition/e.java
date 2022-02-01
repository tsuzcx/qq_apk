package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.u;
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
  ViewGroup Bf;
  View Bg;
  int Bh;
  private int Bi;
  private int Bj;
  Matrix Bk;
  private final ViewTreeObserver.OnPreDrawListener Bl = new ViewTreeObserver.OnPreDrawListener()
  {
    public final boolean onPreDraw()
    {
      e.this.Bk = e.this.mView.getMatrix();
      u.X(e.this);
      if ((e.this.Bf != null) && (e.this.Bg != null))
      {
        e.this.Bf.endViewTransition(e.this.Bg);
        u.X(e.this.Bf);
        e.this.Bf = null;
        e.this.Bg = null;
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
  
  static void E(View paramView)
  {
    paramView = F(paramView);
    if (paramView != null)
    {
      paramView.Bh -= 1;
      if (paramView.Bh <= 0)
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
  
  private static e F(View paramView)
  {
    return (e)paramView.getTag(2131302128);
  }
  
  static g a(View paramView, ViewGroup paramViewGroup)
  {
    e locale2 = F(paramView);
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
    locale1.Bh += 1;
    return locale1;
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.Bf = paramViewGroup;
    this.Bg = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mView.setTag(2131302128, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.Bi = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.Bj = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.Bl);
    this.mView.setVisibility(4);
  }
  
  protected final void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
    this.mView.setVisibility(0);
    this.mView.setTag(2131302128, null);
    super.onDetachedFromWindow();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    this.mMatrix.set(this.Bk);
    this.mMatrix.postTranslate(this.Bi, this.Bj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.e
 * JD-Core Version:    0.7.0.1
 */