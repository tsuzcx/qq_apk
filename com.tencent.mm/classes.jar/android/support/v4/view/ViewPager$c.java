package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class ViewPager$c
  extends a
{
  ViewPager$c(ViewPager paramViewPager) {}
  
  private boolean dt()
  {
    return (this.Hp.Gw != null) && (this.Hp.Gw.getCount() > 1);
  }
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setClassName(ViewPager.class.getName());
    parama.setScrollable(dt());
    if (this.Hp.canScrollHorizontally(1)) {
      parama.addAction(4096);
    }
    if (this.Hp.canScrollHorizontally(-1)) {
      parama.addAction(8192);
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(dt());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.Hp.Gw != null))
    {
      paramAccessibilityEvent.setItemCount(this.Hp.Gw.getCount());
      paramAccessibilityEvent.setFromIndex(this.Hp.Gx);
      paramAccessibilityEvent.setToIndex(this.Hp.Gx);
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
      if (this.Hp.canScrollHorizontally(1))
      {
        this.Hp.setCurrentItem(this.Hp.Gx + 1);
        return true;
      }
      return false;
    }
    if (this.Hp.canScrollHorizontally(-1))
    {
      this.Hp.setCurrentItem(this.Hp.Gx - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.view.ViewPager.c
 * JD-Core Version:    0.7.0.1
 */