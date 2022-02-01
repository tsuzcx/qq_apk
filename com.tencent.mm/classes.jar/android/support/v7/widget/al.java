package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public final class al
  extends a
{
  final RecyclerView alu;
  final a asU;
  
  public al(RecyclerView paramRecyclerView)
  {
    this.alu = paramRecyclerView;
    this.asU = new a(this);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.alu.kV()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramc);
    paramc.setClassName(RecyclerView.class.getName());
    int i;
    int j;
    if ((!this.alu.kV()) && (this.alu.getLayoutManager() != null))
    {
      paramView = this.alu.getLayoutManager();
      RecyclerView.o localo = paramView.alu.apR;
      RecyclerView.t localt = paramView.alu.aqO;
      if ((paramView.alu.canScrollVertically(-1)) || (paramView.alu.canScrollHorizontally(-1)))
      {
        paramc.addAction(8192);
        paramc.setScrollable(true);
      }
      if ((paramView.alu.canScrollVertically(1)) || (paramView.alu.canScrollHorizontally(1)))
      {
        paramc.addAction(4096);
        paramc.setScrollable(true);
      }
      i = paramView.a(localo, localt);
      j = paramView.b(localo, localt);
      if (Build.VERSION.SDK_INT < 21) {
        break label198;
      }
      paramView = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false, 0));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramc.Pm.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((c.b)paramView).PW);
      }
      return;
      label198:
      if (Build.VERSION.SDK_INT >= 19) {
        paramView = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false));
      } else {
        paramView = new c.b(null);
      }
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (this.alu.kV());
          bool1 = bool2;
        } while (this.alu.getLayoutManager() == null);
        paramView = this.alu.getLayoutManager();
        bool1 = bool2;
      } while (paramView.alu == null);
      switch (paramInt)
      {
      default: 
        i = 0;
        paramInt = 0;
        if (paramInt != 0) {
          break label110;
        }
        bool1 = bool2;
      }
    } while (i == 0);
    label110:
    paramView.alu.a(i, paramInt, null);
    return true;
    if (paramView.alu.canScrollVertically(-1)) {}
    for (paramInt = -(paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (paramView.alu.canScrollHorizontally(-1))
      {
        i = -(paramView.mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!paramView.alu.canScrollVertically(1)) {
          break label256;
        }
      }
      label256:
      for (paramInt = paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (paramView.alu.canScrollHorizontally(1))
        {
          i = paramView.mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight();
          break;
        }
        int j = 0;
        paramInt = i;
        i = j;
        break;
      }
    }
  }
  
  public static final class a
    extends a
  {
    final al asV;
    
    public a(al paramal)
    {
      this.asV = paramal;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      if ((!this.asV.alu.kV()) && (this.asV.alu.getLayoutManager() != null)) {
        this.asV.alu.getLayoutManager().a(paramView, paramc);
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      boolean bool2 = false;
      boolean bool1;
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.asV.alu.kV());
        bool1 = bool2;
      } while (this.asV.alu.getLayoutManager() == null);
      this.asV.alu.getLayoutManager();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.al
 * JD-Core Version:    0.7.0.1
 */