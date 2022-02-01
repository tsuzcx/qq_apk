package android.support.design.transformation;

import android.content.Context;
import android.support.design.c.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
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
  
  private boolean s(boolean paramBoolean)
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
  
  public final boolean a(final CoordinatorLayout paramCoordinatorLayout, final View paramView, final int paramInt)
  {
    if (!t.ay(paramView))
    {
      paramCoordinatorLayout = paramCoordinatorLayout.s(paramView);
      int i = paramCoordinatorLayout.size();
      paramInt = 0;
      if (paramInt >= i) {
        break label122;
      }
      View localView = (View)paramCoordinatorLayout.get(paramInt);
      if (!a(paramView, localView)) {
        break label115;
      }
      paramCoordinatorLayout = (b)localView;
      label57:
      if ((paramCoordinatorLayout != null) && (s(paramCoordinatorLayout.bd()))) {
        if (!paramCoordinatorLayout.bd()) {
          break label127;
        }
      }
    }
    label115:
    label122:
    label127:
    for (paramInt = 1;; paramInt = 2)
    {
      this.currentState = paramInt;
      paramInt = this.currentState;
      paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          paramView.getViewTreeObserver().removeOnPreDrawListener(this);
          if (ExpandableBehavior.a(ExpandableBehavior.this) == paramInt) {
            ExpandableBehavior.this.a((View)paramCoordinatorLayout, paramView, paramCoordinatorLayout.bd(), false);
          }
          return false;
        }
      });
      return false;
      paramInt += 1;
      break;
      paramCoordinatorLayout = null;
      break label57;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (b)paramView2;
    if (s(paramCoordinatorLayout.bd()))
    {
      if (paramCoordinatorLayout.bd()) {}
      for (int i = 1;; i = 2)
      {
        this.currentState = i;
        return a((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.bd(), true);
      }
    }
    return false;
  }
  
  public abstract boolean a(View paramView1, View paramView2);
  
  protected abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.transformation.ExpandableBehavior
 * JD-Core Version:    0.7.0.1
 */