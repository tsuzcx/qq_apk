package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.a.a;
import android.support.v4.view.t;
import android.support.v4.widget.u;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class FloatingActionButton$Behavior
  extends CoordinatorLayout.Behavior<FloatingActionButton>
{
  private Rect hV;
  private FloatingActionButton.a jt;
  private boolean ju;
  
  public FloatingActionButton$Behavior()
  {
    this.ju = true;
  }
  
  public FloatingActionButton$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton_Behavior_Layout);
    this.ju = paramContext.getBoolean(0, true);
    paramContext.recycle();
  }
  
  private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramAppBarLayout, paramFloatingActionButton)) {
      return false;
    }
    if (this.hV == null) {
      this.hV = new Rect();
    }
    Rect localRect = this.hV;
    u.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
    if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
      paramFloatingActionButton.b(this.jt);
    }
    for (;;)
    {
      return true;
      paramFloatingActionButton.a(this.jt);
    }
  }
  
  private boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
  {
    int j = 0;
    Object localObject1 = paramCoordinatorLayout.o(paramFloatingActionButton);
    int k = ((List)localObject1).size();
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      localObject2 = (View)((List)localObject1).get(i);
      if ((localObject2 instanceof AppBarLayout)) {
        if (!a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramFloatingActionButton)) {
          break label194;
        }
      }
    }
    else
    {
      label65:
      paramCoordinatorLayout.e(paramFloatingActionButton, paramInt);
      localObject1 = paramFloatingActionButton.jn;
      if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
      {
        localObject2 = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - ((CoordinatorLayout.d)localObject2).rightMargin) {
          break label203;
        }
        paramInt = ((Rect)localObject1).right;
      }
    }
    for (;;)
    {
      label130:
      if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - ((CoordinatorLayout.d)localObject2).bottomMargin) {
        i = ((Rect)localObject1).bottom;
      }
      for (;;)
      {
        if (i != 0) {
          t.q(paramFloatingActionButton, i);
        }
        if (paramInt != 0) {
          t.s(paramFloatingActionButton, paramInt);
        }
        return true;
        if ((p((View)localObject2)) && (b((View)localObject2, paramFloatingActionButton))) {
          break label65;
        }
        label194:
        i += 1;
        break;
        label203:
        if (paramFloatingActionButton.getLeft() > ((CoordinatorLayout.d)localObject2).leftMargin) {
          break label252;
        }
        paramInt = -((Rect)localObject1).left;
        break label130;
        i = j;
        if (paramFloatingActionButton.getTop() <= ((CoordinatorLayout.d)localObject2).topMargin) {
          i = -((Rect)localObject1).top;
        }
      }
      label252:
      paramInt = 0;
    }
  }
  
  private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
    if (!this.ju) {
      return false;
    }
    if (locald.iP != paramView.getId()) {
      return false;
    }
    return paramFloatingActionButton.getUserSetVisibility() == 0;
  }
  
  private boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramView, paramFloatingActionButton)) {
      return false;
    }
    CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
    int i = paramView.getTop();
    int j = paramFloatingActionButton.getHeight() / 2;
    if (i < locald.topMargin + j) {
      paramFloatingActionButton.b(this.jt);
    }
    for (;;)
    {
      return true;
      paramFloatingActionButton.a(this.jt);
    }
  }
  
  private static boolean p(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.d)) {
      return ((CoordinatorLayout.d)paramView).iM instanceof BottomSheetBehavior;
    }
    return false;
  }
  
  public final void a(CoordinatorLayout.d paramd)
  {
    if (paramd.iR == 0) {
      paramd.iR = 80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton.Behavior
 * JD-Core Version:    0.7.0.1
 */