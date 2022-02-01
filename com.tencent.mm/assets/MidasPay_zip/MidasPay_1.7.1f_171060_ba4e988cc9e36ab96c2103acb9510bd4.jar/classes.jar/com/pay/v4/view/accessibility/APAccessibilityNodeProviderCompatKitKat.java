package com.pay.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class APAccessibilityNodeProviderCompatKitKat
{
  public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge)
  {
    new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)this.val$bridge.createAccessibilityNodeInfo(paramAnonymousInt);
      }
      
      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return this.val$bridge.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
      }
      
      public AccessibilityNodeInfo findFocus(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)this.val$bridge.findFocus(paramAnonymousInt);
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return this.val$bridge.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
  
  static abstract interface AccessibilityNodeInfoBridge
  {
    public abstract Object createAccessibilityNodeInfo(int paramInt);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);
    
    public abstract Object findFocus(int paramInt);
    
    public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityNodeProviderCompatKitKat
 * JD-Core Version:    0.7.0.1
 */