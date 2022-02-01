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
  final RecyclerView akA;
  final a arZ;
  
  public al(RecyclerView paramRecyclerView)
  {
    this.akA = paramRecyclerView;
    this.arZ = new a(this);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.akA.kN()))
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
    if ((!this.akA.kN()) && (this.akA.getLayoutManager() != null))
    {
      paramView = this.akA.getLayoutManager();
      RecyclerView.o localo = paramView.akA.aoV;
      RecyclerView.s locals = paramView.akA.apT;
      if ((paramView.akA.canScrollVertically(-1)) || (paramView.akA.canScrollHorizontally(-1)))
      {
        paramc.addAction(8192);
        paramc.setScrollable(true);
      }
      if ((paramView.akA.canScrollVertically(1)) || (paramView.akA.canScrollHorizontally(1)))
      {
        paramc.addAction(4096);
        paramc.setScrollable(true);
      }
      i = paramView.a(localo, locals);
      j = paramView.b(localo, locals);
      if (Build.VERSION.SDK_INT < 21) {
        break label198;
      }
      paramView = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false, 0));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramc.Op.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((c.b)paramView).Pb);
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
          } while (this.akA.kN());
          bool1 = bool2;
        } while (this.akA.getLayoutManager() == null);
        paramView = this.akA.getLayoutManager();
        bool1 = bool2;
      } while (paramView.akA == null);
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
    paramView.akA.a(i, paramInt, null);
    return true;
    if (paramView.akA.canScrollVertically(-1)) {}
    for (paramInt = -(paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (paramView.akA.canScrollHorizontally(-1))
      {
        i = -(paramView.mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!paramView.akA.canScrollVertically(1)) {
          break label256;
        }
      }
      label256:
      for (paramInt = paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (paramView.akA.canScrollHorizontally(1))
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
    final al asa;
    
    public a(al paramal)
    {
      this.asa = paramal;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      if ((!this.asa.akA.kN()) && (this.asa.akA.getLayoutManager() != null)) {
        this.asa.akA.getLayoutManager().a(paramView, paramc);
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
        } while (this.asa.akA.kN());
        bool1 = bool2;
      } while (this.asa.akA.getLayoutManager() == null);
      this.asa.akA.getLayoutManager();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.al
 * JD-Core Version:    0.7.0.1
 */