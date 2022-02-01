package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends View
  implements g
{
  private final Matrix avQ;
  private int bwj;
  private int bwk;
  ViewGroup cfj;
  View cfk;
  int cfl;
  Matrix cfm;
  private final ViewTreeObserver.OnPreDrawListener cfn;
  final View mView;
  
  private e(View paramView)
  {
    super(paramView.getContext());
    AppMethodBeat.i(201585);
    this.avQ = new Matrix();
    this.cfn = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(201371);
        e.this.cfm = e.this.mView.getMatrix();
        z.Q(e.this);
        if ((e.this.cfj != null) && (e.this.cfk != null))
        {
          e.this.cfj.endViewTransition(e.this.cfk);
          z.Q(e.this.cfj);
          e.this.cfj = null;
          e.this.cfk = null;
        }
        AppMethodBeat.o(201371);
        return true;
      }
    };
    this.mView = paramView;
    setLayerType(2, null);
    AppMethodBeat.o(201585);
  }
  
  static g a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(201572);
    e locale2 = bX(paramView);
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
        AppMethodBeat.o(201572);
        return null;
        paramViewGroup = (ViewGroup)paramViewGroup;
        break;
      }
      label64:
      locale1 = new e(paramView);
      paramViewGroup.addView(locale1);
    }
    locale1.cfl += 1;
    AppMethodBeat.o(201572);
    return locale1;
  }
  
  private static void a(View paramView, e parame)
  {
    AppMethodBeat.i(201592);
    paramView.setTag(m.a.ghost_view, parame);
    AppMethodBeat.o(201592);
  }
  
  static void bW(View paramView)
  {
    AppMethodBeat.i(201579);
    paramView = bX(paramView);
    if (paramView != null)
    {
      paramView.cfl -= 1;
      if (paramView.cfl <= 0)
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
    AppMethodBeat.o(201579);
  }
  
  private static e bX(View paramView)
  {
    AppMethodBeat.i(201598);
    paramView = (e)paramView.getTag(m.a.ghost_view);
    AppMethodBeat.o(201598);
    return paramView;
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView)
  {
    this.cfj = paramViewGroup;
    this.cfk = paramView;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(201608);
    super.onAttachedToWindow();
    a(this.mView, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.bwj = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.bwk = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.cfn);
    this.mView.setVisibility(4);
    AppMethodBeat.o(201608);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(201615);
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.cfn);
    this.mView.setVisibility(0);
    a(this.mView, null);
    super.onDetachedFromWindow();
    AppMethodBeat.o(201615);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(201623);
    this.avQ.set(this.cfm);
    this.avQ.postTranslate(this.bwj, this.bwk);
    paramCanvas.setMatrix(this.avQ);
    this.mView.draw(paramCanvas);
    AppMethodBeat.o(201623);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(201630);
    super.setVisibility(paramInt);
    View localView = this.mView;
    if (paramInt == 0) {}
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      AppMethodBeat.o(201630);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.e
 * JD-Core Version:    0.7.0.1
 */