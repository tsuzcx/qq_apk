package com.tencent.widget.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;

@TargetApi(9)
public final class OverscrollHelper
{
  static final float jdField_a_of_type_Float = 1.0F;
  static final String jdField_a_of_type_JavaLangString = "OverscrollHelper";
  
  public static void a(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    int i;
    int k;
    int j;
    PullToRefreshBase.Mode localMode;
    switch (ltl.a[paramPullToRefreshBase.a().ordinal()])
    {
    default: 
      i = paramPullToRefreshBase.getScrollY();
      k = paramInt3;
      j = paramInt4;
      if ((paramPullToRefreshBase.e()) && (!paramPullToRefreshBase.f()))
      {
        localMode = paramPullToRefreshBase.b();
        if ((!localMode.permitsPullToRefresh()) || (paramBoolean) || (k == 0)) {
          break label316;
        }
        j += k;
        Log.d("OverscrollHelper", "OverScroll. DeltaX: " + paramInt1 + ", ScrollX: " + paramInt2 + ", DeltaY: " + paramInt3 + ", ScrollY: " + paramInt4 + ", NewY: " + j + ", ScrollRange: " + paramInt5 + ", CurrentScroll: " + i);
        if (j >= 0 - paramInt6) {
          break label231;
        }
        if (localMode.showHeaderLoadingLayout())
        {
          if (i == 0) {
            paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
          }
          paramPullToRefreshBase.c((int)((j + i) * paramFloat));
        }
      }
      break;
    }
    label231:
    while ((!paramBoolean) || (PullToRefreshBase.State.OVERSCROLLING != paramPullToRefreshBase.a()))
    {
      do
      {
        do
        {
          return;
          i = paramPullToRefreshBase.getScrollX();
          k = paramInt1;
          j = paramInt2;
          break;
          if (j <= paramInt5 + paramInt6) {
            break label282;
          }
        } while (!localMode.showFooterLoadingLayout());
        if (i == 0) {
          paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
        }
        paramPullToRefreshBase.c((int)((j + i - paramInt5) * paramFloat));
        return;
      } while ((Math.abs(j) > paramInt6) && (Math.abs(j - paramInt5) > paramInt6));
      paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
      return;
    }
    label282:
    label316:
    paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
  }
  
  public static void a(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }
  
  public static void a(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
  
  static boolean a(View paramView)
  {
    return paramView.getOverScrollMode() != 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.OverscrollHelper
 * JD-Core Version:    0.7.0.1
 */