package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"ViewConstructor"})
final class e
  extends View
  implements g
{
  private int PR;
  private int PS;
  ViewGroup aqA;
  View aqB;
  int aqC;
  Matrix aqD;
  private final ViewTreeObserver.OnPreDrawListener aqE;
  private final Matrix aqj;
  final View mView;
  
  private e(View paramView)
  {
    super(paramView.getContext());
    AppMethodBeat.i(192288);
    this.aqj = new Matrix();
    this.aqE = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(192273);
        e.this.aqD = e.this.mView.getMatrix();
        w.G(e.this);
        if ((e.this.aqA != null) && (e.this.aqB != null))
        {
          e.this.aqA.endViewTransition(e.this.aqB);
          w.G(e.this.aqA);
          e.this.aqA = null;
          e.this.aqB = null;
        }
        AppMethodBeat.o(192273);
        return true;
      }
    };
    this.mView = paramView;
    setLayerType(2, null);
    AppMethodBeat.o(192288);
  }
  
  static g a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(192279);
    e locale2 = bD(paramView);
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
          break label64;
        }
        AppMethodBeat.o(192279);
        return null;
        paramViewGroup = (ViewGroup)paramViewGroup;
        break;
      }
      label64:
      locale1 = new e(paramView);
      paramViewGroup.addView(locale1);
    }
    locale1.aqC += 1;
    AppMethodBeat.o(192279);
    return locale1;
  }
  
  private static void a(View paramView, e parame)
  {
    AppMethodBeat.i(192317);
    paramView.setTag(m.a.ghost_view, parame);
    AppMethodBeat.o(192317);
  }
  
  static void bC(View paramView)
  {
    AppMethodBeat.i(192285);
    paramView = bD(paramView);
    if (paramView != null)
    {
      paramView.aqC -= 1;
      if (paramView.aqC <= 0)
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
    AppMethodBeat.o(192285);
  }
  
  private static e bD(View paramView)
  {
    AppMethodBeat.i(192320);
    paramView = (e)paramView.getTag(m.a.ghost_view);
    AppMethodBeat.o(192320);
    return paramView;
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.aqA = paramViewGroup;
    this.aqB = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(192298);
    super.onAttachedToWindow();
    a(this.mView, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.PR = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.PS = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.aqE);
    this.mView.setVisibility(4);
    AppMethodBeat.o(192298);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(192301);
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.aqE);
    this.mView.setVisibility(0);
    a(this.mView, null);
    super.onDetachedFromWindow();
    AppMethodBeat.o(192301);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192305);
    this.aqj.set(this.aqD);
    this.aqj.postTranslate(this.PR, this.PS);
    paramCanvas.setMatrix(this.aqj);
    this.mView.draw(paramCanvas);
    AppMethodBeat.o(192305);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(192310);
    super.setVisibility(paramInt);
    View localView = this.mView;
    if (paramInt == 0) {}
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      AppMethodBeat.o(192310);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.e
 * JD-Core Version:    0.7.0.1
 */