package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class x
{
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof n)) {
      ((n)paramViewParent).k(paramView, paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onStopNestedScroll(paramView);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStopNestedScroll");
          return;
        }
      }
    } while (!(paramViewParent instanceof m));
    ((m)paramViewParent).onStopNestedScroll(paramView);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof n)) {
      ((n)paramViewParent).a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    do
    {
      do
      {
        return;
      } while (paramInt5 != 0);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScroll");
          return;
        }
      }
    } while (!(paramViewParent instanceof m));
    ((m)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof n)) {
      ((n)paramViewParent).a(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    }
    do
    {
      do
      {
        return;
      } while (paramInt3 != 0);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreScroll");
          return;
        }
      }
    } while (!(paramViewParent instanceof m));
    ((m)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        return bool;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreFling");
      }
    }
    while (!(paramViewParent instanceof m))
    {
      boolean bool;
      return false;
    }
    return ((m)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        return paramBoolean;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedFling");
      }
    }
    while (!(paramViewParent instanceof m)) {
      return false;
    }
    return ((m)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof n)) {
      return ((n)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2);
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label71;
      }
      try
      {
        bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStartNestedScroll");
      }
    }
    label71:
    while (!(paramViewParent instanceof m))
    {
      boolean bool;
      return false;
    }
    return ((m)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
  }
  
  @Deprecated
  public static boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof n)) {
      ((n)paramViewParent).b(paramView1, paramView2, paramInt1, paramInt2);
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != 0);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
          return;
        }
        catch (AbstractMethodError paramView1)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScrollAccepted");
          return;
        }
      }
    } while (!(paramViewParent instanceof m));
    ((m)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.x
 * JD-Core Version:    0.7.0.1
 */