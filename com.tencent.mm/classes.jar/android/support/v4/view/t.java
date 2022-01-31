package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class t
{
  static final c Hy = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Hy = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      Hy = new a();
      return;
    }
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof k)) {
      ((k)paramViewParent).i(paramView, paramInt);
    }
    while (paramInt != 0) {
      return;
    }
    Hy.a(paramViewParent, paramView);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof k)) {
      ((k)paramViewParent).h(paramInt4, paramInt5);
    }
    while (paramInt5 != 0) {
      return;
    }
    Hy.a(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof k)) {
      ((k)paramViewParent).a(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    }
    while (paramInt3 != 0) {
      return;
    }
    Hy.a(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    return Hy.a(paramViewParent, paramView, paramFloat1, paramFloat2);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return Hy.a(paramViewParent, paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof k)) {
      return ((k)paramViewParent).c(paramView1, paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      return Hy.a(paramViewParent, paramView1, paramView2, paramInt1);
    }
    return false;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof k)) {
      ((k)paramViewParent).h(paramView2, paramInt1);
    }
    while (paramInt2 != 0) {
      return;
    }
    Hy.b(paramViewParent, paramView1, paramView2, paramInt1);
  }
  
  static class a
    extends t.c
  {}
  
  static final class b
    extends t.a
  {
    public final void a(ViewParent paramViewParent, View paramView)
    {
      try
      {
        paramViewParent.onStopNestedScroll(paramView);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStopNestedScroll");
      }
    }
    
    public final void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      try
      {
        paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScroll");
      }
    }
    
    public final void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      try
      {
        paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreScroll");
      }
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
    {
      try
      {
        boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        return bool;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreFling");
      }
      return false;
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      try
      {
        paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        return paramBoolean;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedFling");
      }
      return false;
    }
    
    public final boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      try
      {
        boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStartNestedScroll");
      }
      return false;
    }
    
    public final void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      try
      {
        paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
        return;
      }
      catch (AbstractMethodError paramView1)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScrollAccepted");
      }
    }
  }
  
  static class c
  {
    public void a(ViewParent paramViewParent, View paramView)
    {
      if ((paramViewParent instanceof j)) {
        ((j)paramViewParent).onStopNestedScroll(paramView);
      }
    }
    
    public void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((paramViewParent instanceof j)) {
        ((j)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      if ((paramViewParent instanceof j)) {
        ((j)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    
    public boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
    {
      if ((paramViewParent instanceof j)) {
        return ((j)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
      }
      return false;
    }
    
    public boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      if ((paramViewParent instanceof j)) {
        return ((j)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      }
      return false;
    }
    
    public boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      if ((paramViewParent instanceof j)) {
        return ((j)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt);
      }
      return false;
    }
    
    public void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
    {
      if ((paramViewParent instanceof j)) {
        ((j)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.t
 * JD-Core Version:    0.7.0.1
 */