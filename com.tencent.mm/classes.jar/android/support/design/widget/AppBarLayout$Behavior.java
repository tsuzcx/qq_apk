package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v4.widget.h;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

public class AppBarLayout$Behavior
  extends HeaderBehavior<AppBarLayout>
{
  private int eA;
  private ValueAnimator eB;
  private int eC = -1;
  private boolean eD;
  private float eE;
  private WeakReference<View> eF;
  private AppBarLayout.Behavior.a eG;
  
  public AppBarLayout$Behavior() {}
  
  public AppBarLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    int n = ad();
    int j = paramAppBarLayout.getChildCount();
    int i = 0;
    View localView;
    label49:
    int i1;
    int m;
    int k;
    if (i < j)
    {
      localView = paramAppBarLayout.getChildAt(i);
      if ((localView.getTop() <= -n) && (localView.getBottom() >= -n)) {
        if (i >= 0)
        {
          localView = paramAppBarLayout.getChildAt(i);
          i1 = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).eN;
          if ((i1 & 0x11) == 17)
          {
            m = -localView.getTop();
            k = -localView.getBottom();
            j = k;
            if (i == paramAppBarLayout.getChildCount() - 1) {
              j = k + paramAppBarLayout.getTopInset();
            }
            if (!g(i1, 2)) {
              break label184;
            }
            i = j + q.X(localView);
            k = m;
            label144:
            if (n >= (i + k) / 2) {
              break label231;
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramCoordinatorLayout, paramAppBarLayout, android.support.v4.c.a.clamp(i, -paramAppBarLayout.getTotalScrollRange(), 0));
      return;
      i += 1;
      break;
      i = -1;
      break label49;
      label184:
      i = j;
      k = m;
      if (!g(i1, 5)) {
        break label144;
      }
      i = q.X(localView) + j;
      if (n < i)
      {
        k = i;
        i = j;
        break label144;
      }
      k = m;
      break label144;
      label231:
      i = k;
    }
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    int i = Math.abs(ad() - paramInt);
    float f = Math.abs(0.0F);
    if (f > 0.0F) {}
    int j;
    for (i = Math.round(i / f * 1000.0F) * 3;; i = (int)((i / paramAppBarLayout.getHeight() + 1.0F) * 150.0F))
    {
      j = ad();
      if (j != paramInt) {
        break;
      }
      if ((this.eB != null) && (this.eB.isRunning())) {
        this.eB.cancel();
      }
      return;
    }
    if (this.eB == null)
    {
      this.eB = new ValueAnimator();
      this.eB.setInterpolator(a.ep);
      this.eB.addUpdateListener(new AppBarLayout.Behavior.1(this, paramCoordinatorLayout, paramAppBarLayout));
    }
    for (;;)
    {
      this.eB.setDuration(Math.min(i, 600));
      this.eB.setIntValues(new int[] { j, paramInt });
      this.eB.start();
      return;
      this.eB.cancel();
    }
  }
  
  private static void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    int k = Math.abs(paramInt1);
    int m = paramAppBarLayout.getChildCount();
    int i = 0;
    Object localObject;
    label53:
    boolean bool;
    if (i < m)
    {
      localObject = paramAppBarLayout.getChildAt(i);
      if ((k >= ((View)localObject).getTop()) && (k <= ((View)localObject).getBottom())) {
        if (localObject != null)
        {
          i = ((AppBarLayout.LayoutParams)((View)localObject).getLayoutParams()).eN;
          if ((i & 0x1) == 0) {
            break label340;
          }
          k = q.X((View)localObject);
          if ((paramInt2 <= 0) || ((i & 0xC) == 0)) {
            break label291;
          }
          if (-paramInt1 < ((View)localObject).getBottom() - k - paramAppBarLayout.getTopInset()) {
            break label285;
          }
          bool = true;
        }
      }
    }
    for (;;)
    {
      label118:
      if (paramAppBarLayout.ex != bool)
      {
        paramAppBarLayout.ex = bool;
        paramAppBarLayout.refreshDrawableState();
        paramInt1 = 1;
        if (Build.VERSION.SDK_INT >= 11) {
          if (!paramBoolean)
          {
            if (paramInt1 == 0) {
              break label269;
            }
            localObject = paramCoordinatorLayout.hy.J(paramAppBarLayout);
            paramCoordinatorLayout.hA.clear();
            if (localObject != null) {
              paramCoordinatorLayout.hA.addAll((Collection)localObject);
            }
            paramCoordinatorLayout = paramCoordinatorLayout.hA;
            i = paramCoordinatorLayout.size();
            paramInt1 = 0;
          }
        }
      }
      for (;;)
      {
        label139:
        paramInt2 = j;
        if (paramInt1 < i)
        {
          localObject = ((CoordinatorLayout.d)((View)paramCoordinatorLayout.get(paramInt1)).getLayoutParams()).hP;
          if (!(localObject instanceof AppBarLayout.ScrollingViewBehavior)) {
            break label333;
          }
          paramInt2 = j;
          if (((AppBarLayout.ScrollingViewBehavior)localObject).ji != 0) {
            paramInt2 = 1;
          }
        }
        if (paramInt2 != 0) {
          paramAppBarLayout.jumpDrawablesToCurrentState();
        }
        label269:
        return;
        i += 1;
        break;
        localObject = null;
        break label53;
        label285:
        bool = false;
        break label118;
        label291:
        if ((i & 0x2) == 0) {
          break label340;
        }
        if (-paramInt1 >= ((View)localObject).getBottom() - k - paramAppBarLayout.getTopInset())
        {
          bool = true;
          break label118;
        }
        bool = false;
        break label118;
        paramInt1 = 0;
        break label139;
        label333:
        paramInt1 += 1;
      }
      label340:
      bool = false;
    }
  }
  
  private static boolean g(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  final int ad()
  {
    return super.ag() + this.eA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior
 * JD-Core Version:    0.7.0.1
 */