package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class al
  extends a
{
  final a auJ;
  final RecyclerView mRecyclerView;
  
  public al(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
    this.auJ = new a(this);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.mRecyclerView.lt()))
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
    if ((!this.mRecyclerView.lt()) && (this.mRecyclerView.getLayoutManager() != null)) {
      this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(paramc);
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!this.mRecyclerView.lt()) && (this.mRecyclerView.getLayoutManager() != null)) {
      return this.mRecyclerView.getLayoutManager().performAccessibilityAction(paramInt, paramBundle);
    }
    return false;
  }
  
  public static final class a
    extends a
  {
    final al auK;
    
    public a(al paramal)
    {
      this.auK = paramal;
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramc);
      if ((!this.auK.mRecyclerView.lt()) && (this.auK.mRecyclerView.getLayoutManager() != null)) {
        this.auK.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramc);
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      if ((!this.auK.mRecyclerView.lt()) && (this.auK.mRecyclerView.getLayoutManager() != null)) {
        return this.auK.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.al
 * JD-Core Version:    0.7.0.1
 */