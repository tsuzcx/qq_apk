package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.support.v4.view.a.d;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class a
{
  private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
  private final View.AccessibilityDelegate mBridge = new a(this);
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public d getAccessibilityNodeProvider(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = DEFAULT_DELEGATE.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return new d(paramView);
      }
    }
    return null;
  }
  
  View.AccessibilityDelegate getBridge()
  {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(paramView, paramc.Rb);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return DEFAULT_DELEGATE.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    return false;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    DEFAULT_DELEGATE.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  static final class a
    extends View.AccessibilityDelegate
  {
    private final a Pb;
    
    a(a parama)
    {
      this.Pb = parama;
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.Pb.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      paramView = this.Pb.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return (AccessibilityNodeProvider)paramView.RM;
      }
      return null;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.Pb.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      this.Pb.onInitializeAccessibilityNodeInfo(paramView, c.a(paramAccessibilityNodeInfo));
    }
    
    public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.Pb.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.Pb.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return this.Pb.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    
    public final void sendAccessibilityEvent(View paramView, int paramInt)
    {
      this.Pb.sendAccessibilityEvent(paramView, paramInt);
    }
    
    public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.Pb.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a
 * JD-Core Version:    0.7.0.1
 */