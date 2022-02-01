package com.pay.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class APAccessibilityNodeProviderCompat
{
  private static final AccessibilityNodeProviderImpl IMPL = new AccessibilityNodeProviderStubImpl();
  private final Object mProvider;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityNodeProviderKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeProviderJellyBeanImpl();
      return;
    }
  }
  
  public APAccessibilityNodeProviderCompat()
  {
    this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
  }
  
  public APAccessibilityNodeProviderCompat(Object paramObject)
  {
    this.mProvider = paramObject;
  }
  
  public APAccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  public List<APAccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  public APAccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return this.mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  static abstract interface AccessibilityNodeProviderImpl
  {
    public abstract Object newAccessibilityNodeProviderBridge(APAccessibilityNodeProviderCompat paramAPAccessibilityNodeProviderCompat);
  }
  
  static class AccessibilityNodeProviderJellyBeanImpl
    extends APAccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
  {
    public Object newAccessibilityNodeProviderBridge(final APAccessibilityNodeProviderCompat paramAPAccessibilityNodeProviderCompat)
    {
      APAccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new APAccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge()
      {
        public Object createAccessibilityNodeInfo(int paramAnonymousInt)
        {
          APAccessibilityNodeInfoCompat localAPAccessibilityNodeInfoCompat = paramAPAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
          if (localAPAccessibilityNodeInfoCompat == null) {
            return null;
          }
          return localAPAccessibilityNodeInfoCompat.getInfo();
        }
        
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = paramAPAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((APAccessibilityNodeInfoCompat)paramAnonymousString.get(paramAnonymousInt)).getInfo());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramAPAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  static class AccessibilityNodeProviderKitKatImpl
    extends APAccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
  {
    public Object newAccessibilityNodeProviderBridge(final APAccessibilityNodeProviderCompat paramAPAccessibilityNodeProviderCompat)
    {
      APAccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new APAccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge()
      {
        public Object createAccessibilityNodeInfo(int paramAnonymousInt)
        {
          APAccessibilityNodeInfoCompat localAPAccessibilityNodeInfoCompat = paramAPAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
          if (localAPAccessibilityNodeInfoCompat == null) {
            return null;
          }
          return localAPAccessibilityNodeInfoCompat.getInfo();
        }
        
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = paramAPAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((APAccessibilityNodeInfoCompat)paramAnonymousString.get(paramAnonymousInt)).getInfo());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public Object findFocus(int paramAnonymousInt)
        {
          APAccessibilityNodeInfoCompat localAPAccessibilityNodeInfoCompat = paramAPAccessibilityNodeProviderCompat.findFocus(paramAnonymousInt);
          if (localAPAccessibilityNodeInfoCompat == null) {
            return null;
          }
          return localAPAccessibilityNodeInfoCompat.getInfo();
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramAPAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  static class AccessibilityNodeProviderStubImpl
    implements APAccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
  {
    public Object newAccessibilityNodeProviderBridge(APAccessibilityNodeProviderCompat paramAPAccessibilityNodeProviderCompat)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityNodeProviderCompat
 * JD-Core Version:    0.7.0.1
 */