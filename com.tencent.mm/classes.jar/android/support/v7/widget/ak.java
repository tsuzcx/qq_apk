package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public final class ak
  extends android.support.v4.view.a
{
  final RecyclerView acI;
  final android.support.v4.view.a aiv;
  
  public ak(RecyclerView paramRecyclerView)
  {
    this.acI = paramRecyclerView;
    this.aiv = new ak.a(this);
  }
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setClassName(RecyclerView.class.getName());
    int i;
    int j;
    if ((!this.acI.hM()) && (this.acI.getLayoutManager() != null))
    {
      paramView = this.acI.getLayoutManager();
      RecyclerView.o localo = paramView.acI.afy;
      RecyclerView.s locals = paramView.acI.agu;
      if ((paramView.acI.canScrollVertically(-1)) || (paramView.acI.canScrollHorizontally(-1)))
      {
        parama.addAction(8192);
        parama.setScrollable(true);
      }
      if ((paramView.acI.canScrollVertically(1)) || (paramView.acI.canScrollHorizontally(1)))
      {
        parama.addAction(4096);
        parama.setScrollable(true);
      }
      i = paramView.a(localo, locals);
      j = paramView.b(localo, locals);
      if (Build.VERSION.SDK_INT < 21) {
        break label198;
      }
      paramView = new a.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false, 0));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        parama.HJ.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((a.b)paramView).Iq);
      }
      return;
      label198:
      if (Build.VERSION.SDK_INT >= 19) {
        paramView = new a.b(AccessibilityNodeInfo.CollectionInfo.obtain(i, j, false));
      } else {
        paramView = new a.b(null);
      }
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.acI.hM()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
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
          } while (this.acI.hM());
          bool1 = bool2;
        } while (this.acI.getLayoutManager() == null);
        paramView = this.acI.getLayoutManager();
        paramBundle = paramView.acI.afy;
        paramBundle = paramView.acI.agu;
        bool1 = bool2;
      } while (paramView.acI == null);
      switch (paramInt)
      {
      default: 
        i = 0;
        paramInt = 0;
        if (paramInt != 0) {
          break label126;
        }
        bool1 = bool2;
      }
    } while (i == 0);
    label126:
    paramView.acI.scrollBy(i, paramInt);
    return true;
    if (paramView.acI.canScrollVertically(-1)) {}
    for (paramInt = -(paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (paramView.acI.canScrollHorizontally(-1))
      {
        i = -(paramView.mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!paramView.acI.canScrollVertically(1)) {
          break label271;
        }
      }
      label271:
      for (paramInt = paramView.mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (paramView.acI.canScrollHorizontally(1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.ak
 * JD-Core Version:    0.7.0.1
 */