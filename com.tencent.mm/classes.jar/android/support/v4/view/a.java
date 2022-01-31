package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class a
{
  private static final b EB;
  private static final View.AccessibilityDelegate EC;
  final View.AccessibilityDelegate ED = EB.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (EB = new a();; EB = new b())
    {
      EC = new View.AccessibilityDelegate();
      return;
    }
  }
  
  public static b K(View paramView)
  {
    return EB.a(EC, paramView);
  }
  
  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    EC.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    EC.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, android.support.v4.view.a.a parama)
  {
    EC.onInitializeAccessibilityNodeInfo(paramView, parama.HJ);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return EC.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    EC.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    EC.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return EC.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return EB.a(EC, paramView, paramInt, paramBundle);
  }
  
  static final class a
    extends a.b
  {
    public final b a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
    {
      paramAccessibilityDelegate = paramAccessibilityDelegate.getAccessibilityNodeProvider(paramView);
      if (paramAccessibilityDelegate != null) {
        return new b(paramAccessibilityDelegate);
      }
      return null;
    }
    
    public final View.AccessibilityDelegate a(final a parama)
    {
      new View.AccessibilityDelegate()
      {
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramAnonymousView)
        {
          paramAnonymousView = a.K(paramAnonymousView);
          if (paramAnonymousView != null) {
            return (AccessibilityNodeProvider)paramAnonymousView.Ir;
          }
          return null;
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          parama.a(paramAnonymousView, android.support.v4.view.a.a.a(paramAnonymousAccessibilityNodeInfo));
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return parama.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          a.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          a.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      };
    }
    
    public final boolean a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
    {
      return paramAccessibilityDelegate.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
  }
  
  static class b
  {
    public b a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
    {
      return null;
    }
    
    public View.AccessibilityDelegate a(final a parama)
    {
      new View.AccessibilityDelegate()
      {
        public final boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          parama.a(paramAnonymousView, android.support.v4.view.a.a.a(paramAnonymousAccessibilityNodeInfo));
        }
        
        public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public final void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          a.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public final void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          a.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      };
    }
    
    public boolean a(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a
 * JD-Core Version:    0.7.0.1
 */