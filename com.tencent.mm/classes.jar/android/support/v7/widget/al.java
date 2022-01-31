package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public final class al
  extends a
{
  final RecyclerView adt;
  final a akL;
  
  public al(RecyclerView paramRecyclerView)
  {
    this.adt = paramRecyclerView;
    this.akL = new al.a(this);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.adt.js()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    paramb.setClassName(RecyclerView.class.getName());
    int i;
    int j;
    if ((!this.adt.js()) && (this.adt.getLayoutManager() != null))
    {
      paramView = this.adt.getLayoutManager();
      RecyclerView.o localo = paramView.adt.ahO;
      RecyclerView.s locals = paramView.adt.aiK;
      if ((paramView.adt.canScrollVertically(-1)) || (paramView.adt.canScrollHorizontally(-1)))
      {
        paramb.addAction(8192);
        paramb.setScrollable(true);
      }
      if ((paramView.adt.canScrollVertically(1)) || (paramView.adt.canScrollHorizontally(1)))
      {
        paramb.addAction(4096);
        paramb.setScrollable(true);
      }
      i = paramView.a(localo, locals);
      j = paramView.b(localo, locals);
      if (Build.VERSION.SDK_INT < 21) {
        break label198;
      }
      paramView = new b.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false, 0));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramb.Hq.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((b.b)paramView).Ia);
      }
      return;
      label198:
      if (Build.VERSION.SDK_INT >= 19) {
        paramView = new b.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false));
      } else {
        paramView = new b.b(null);
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
          } while (this.adt.js());
          bool1 = bool2;
        } while (this.adt.getLayoutManager() == null);
        paramView = this.adt.getLayoutManager();
        bool1 = bool2;
      } while (paramView.adt == null);
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
    paramView.adt.scrollBy(i, paramInt);
    return true;
    if (paramView.adt.canScrollVertically(-1)) {}
    for (paramInt = -(paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (paramView.adt.canScrollHorizontally(-1))
      {
        i = -(paramView.mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!paramView.adt.canScrollVertically(1)) {
          break label255;
        }
      }
      label255:
      for (paramInt = paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (paramView.adt.canScrollHorizontally(1))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.al
 * JD-Core Version:    0.7.0.1
 */