package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.g.w;
import com.google.android.material.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class ExpandableBehavior
  extends CoordinatorLayout.Behavior<View>
{
  private int currentState = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean bm(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      if (this.currentState != 0)
      {
        paramBoolean = bool;
        if (this.currentState != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
    }
    do
    {
      return paramBoolean;
      paramBoolean = bool;
    } while (this.currentState != 1);
    return true;
  }
  
  protected abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public final boolean a(final CoordinatorLayout paramCoordinatorLayout, final View paramView, final int paramInt)
  {
    if (!w.ah(paramView))
    {
      List localList = paramCoordinatorLayout.x(paramView);
      int i = localList.size();
      paramInt = 0;
      if (paramInt >= i) {
        break label126;
      }
      View localView = (View)localList.get(paramInt);
      if (!a(paramCoordinatorLayout, paramView, localView)) {
        break label119;
      }
      paramCoordinatorLayout = (b)localView;
      label61:
      if ((paramCoordinatorLayout != null) && (bm(paramCoordinatorLayout.wT()))) {
        if (!paramCoordinatorLayout.wT()) {
          break label131;
        }
      }
    }
    label131:
    for (paramInt = 1;; paramInt = 2)
    {
      this.currentState = paramInt;
      paramInt = this.currentState;
      paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(240640);
          paramView.getViewTreeObserver().removeOnPreDrawListener(this);
          if (ExpandableBehavior.a(ExpandableBehavior.this) == paramInt) {
            ExpandableBehavior.this.a((View)paramCoordinatorLayout, paramView, paramCoordinatorLayout.wT(), false);
          }
          AppMethodBeat.o(240640);
          return false;
        }
      });
      return false;
      label119:
      paramInt += 1;
      break;
      label126:
      paramCoordinatorLayout = null;
      break label61;
    }
  }
  
  public abstract boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (b)paramView2;
    if (bm(paramCoordinatorLayout.wT()))
    {
      if (paramCoordinatorLayout.wT()) {}
      for (int i = 1;; i = 2)
      {
        this.currentState = i;
        return a((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.wT(), true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior
 * JD-Core Version:    0.7.0.1
 */