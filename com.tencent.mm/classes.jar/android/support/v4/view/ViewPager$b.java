package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class ViewPager$b
  extends a
{
  ViewPager$b(ViewPager paramViewPager) {}
  
  private boolean dI()
  {
    return (this.Ha.mAdapter != null) && (this.Ha.mAdapter.getCount() > 1);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(dI());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.Ha.mAdapter != null))
    {
      paramAccessibilityEvent.setItemCount(this.Ha.mAdapter.getCount());
      paramAccessibilityEvent.setFromIndex(this.Ha.mCurItem);
      paramAccessibilityEvent.setToIndex(this.Ha.mCurItem);
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    paramb.setClassName(ViewPager.class.getName());
    paramb.setScrollable(dI());
    if (this.Ha.canScrollHorizontally(1)) {
      paramb.addAction(4096);
    }
    if (this.Ha.canScrollHorizontally(-1)) {
      paramb.addAction(8192);
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.Ha.canScrollHorizontally(1))
      {
        this.Ha.setCurrentItem(this.Ha.mCurItem + 1);
        return true;
      }
      return false;
    }
    if (this.Ha.canScrollHorizontally(-1))
    {
      this.Ha.setCurrentItem(this.Ha.mCurItem - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.view.ViewPager.b
 * JD-Core Version:    0.7.0.1
 */