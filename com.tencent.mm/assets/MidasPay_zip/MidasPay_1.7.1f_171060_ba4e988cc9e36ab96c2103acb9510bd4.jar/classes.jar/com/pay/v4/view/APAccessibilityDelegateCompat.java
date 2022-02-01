package com.pay.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.pay.v4.view.accessibility.APAccessibilityNodeInfoCompat;
import com.pay.v4.view.accessibility.APAccessibilityNodeProviderCompat;

public class APAccessibilityDelegateCompat
{
  private static final Object DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
  private static final AccessibilityDelegateImpl IMPL;
  final Object mBridge = IMPL.newAccessiblityDelegateBridge(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new AccessibilityDelegateJellyBeanImpl();
    } else if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new AccessibilityDelegateIcsImpl();
    } else {
      IMPL = new AccessibilityDelegateStubImpl();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public APAccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, paramView);
  }
  
  Object getBridge()
  {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, APAccessibilityNodeInfoCompat paramAPAccessibilityNodeInfoCompat)
  {
    IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, paramView, paramAPAccessibilityNodeInfoCompat);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, paramView, paramAccessibilityEvent);
  }
  
  static class AccessibilityDelegateIcsImpl
    extends APAccessibilityDelegateCompat.AccessibilityDelegateStubImpl
  {
    public boolean dispatchPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return APAccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public Object newAccessiblityDelegateBridge(final APAccessibilityDelegateCompat paramAPAccessibilityDelegateCompat)
    {
      APAccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new APAccessibilityDelegateCompatIcs.AccessibilityDelegateBridge()
      {
        public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramAPAccessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, Object paramAnonymousObject)
        {
          paramAPAccessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(paramAnonymousView, new APAccessibilityNodeInfoCompat(paramAnonymousObject));
        }
        
        public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramAPAccessibilityDelegateCompat.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          paramAPAccessibilityDelegateCompat.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public Object newAccessiblityDelegateDefaultImpl()
    {
      return APAccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
    }
    
    public void onInitializeAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      APAccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(Object paramObject, View paramView, APAccessibilityNodeInfoCompat paramAPAccessibilityNodeInfoCompat)
    {
      APAccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(paramObject, paramView, paramAPAccessibilityNodeInfoCompat.getInfo());
    }
    
    public void onPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      APAccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return APAccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(paramObject, paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public void sendAccessibilityEvent(Object paramObject, View paramView, int paramInt)
    {
      APAccessibilityDelegateCompatIcs.sendAccessibilityEvent(paramObject, paramView, paramInt);
    }
    
    public void sendAccessibilityEventUnchecked(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      APAccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(paramObject, paramView, paramAccessibilityEvent);
    }
  }
  
  static abstract interface AccessibilityDelegateImpl
  {
    public abstract boolean dispatchPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract APAccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object paramObject, View paramView);
    
    public abstract Object newAccessiblityDelegateBridge(APAccessibilityDelegateCompat paramAPAccessibilityDelegateCompat);
    
    public abstract Object newAccessiblityDelegateDefaultImpl();
    
    public abstract void onInitializeAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onInitializeAccessibilityNodeInfo(Object paramObject, View paramView, APAccessibilityNodeInfoCompat paramAPAccessibilityNodeInfoCompat);
    
    public abstract void onPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean onRequestSendAccessibilityEvent(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean performAccessibilityAction(Object paramObject, View paramView, int paramInt, Bundle paramBundle);
    
    public abstract void sendAccessibilityEvent(Object paramObject, View paramView, int paramInt);
    
    public abstract void sendAccessibilityEventUnchecked(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
  }
  
  static class AccessibilityDelegateJellyBeanImpl
    extends APAccessibilityDelegateCompat.AccessibilityDelegateIcsImpl
  {
    public APAccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object paramObject, View paramView)
    {
      paramObject = APAccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(paramObject, paramView);
      if (paramObject != null) {
        return new APAccessibilityNodeProviderCompat(paramObject);
      }
      return null;
    }
    
    public Object newAccessiblityDelegateBridge(final APAccessibilityDelegateCompat paramAPAccessibilityDelegateCompat)
    {
      APAccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new APAccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean()
      {
        public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramAPAccessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public Object getAccessibilityNodeProvider(View paramAnonymousView)
        {
          paramAnonymousView = paramAPAccessibilityDelegateCompat.getAccessibilityNodeProvider(paramAnonymousView);
          if (paramAnonymousView != null) {
            return paramAnonymousView.getProvider();
          }
          return null;
        }
        
        public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, Object paramAnonymousObject)
        {
          paramAPAccessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(paramAnonymousView, new APAccessibilityNodeInfoCompat(paramAnonymousObject));
        }
        
        public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return paramAPAccessibilityDelegateCompat.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return paramAPAccessibilityDelegateCompat.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
        
        public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          paramAPAccessibilityDelegateCompat.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          paramAPAccessibilityDelegateCompat.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public boolean performAccessibilityAction(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return APAccessibilityDelegateCompatJellyBean.performAccessibilityAction(paramObject, paramView, paramInt, paramBundle);
    }
  }
  
  static class AccessibilityDelegateStubImpl
    implements APAccessibilityDelegateCompat.AccessibilityDelegateImpl
  {
    public boolean dispatchPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return false;
    }
    
    public APAccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object paramObject, View paramView)
    {
      return null;
    }
    
    public Object newAccessiblityDelegateBridge(APAccessibilityDelegateCompat paramAPAccessibilityDelegateCompat)
    {
      return null;
    }
    
    public Object newAccessiblityDelegateDefaultImpl()
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void onInitializeAccessibilityNodeInfo(Object paramObject, View paramView, APAccessibilityNodeInfoCompat paramAPAccessibilityNodeInfoCompat) {}
    
    public void onPopulateAccessibilityEvent(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public boolean onRequestSendAccessibilityEvent(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return true;
    }
    
    public boolean performAccessibilityAction(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void sendAccessibilityEvent(Object paramObject, View paramView, int paramInt) {}
    
    public void sendAccessibilityEventUnchecked(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.APAccessibilityDelegateCompat
 * JD-Core Version:    0.7.0.1
 */