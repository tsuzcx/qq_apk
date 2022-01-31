package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class c
{
  public final Object Ib;
  
  public c()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Ib = new b(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Ib = new a(this);
      return;
    }
    this.Ib = null;
  }
  
  public c(Object paramObject)
  {
    this.Ib = paramObject;
  }
  
  public b ax(int paramInt)
  {
    return null;
  }
  
  public b ay(int paramInt)
  {
    return null;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  static class a
    extends AccessibilityNodeProvider
  {
    final c Ic;
    
    a(c paramc)
    {
      this.Ic = paramc;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      b localb = this.Ic.ax(paramInt);
      if (localb == null) {
        return null;
      }
      return localb.Hq;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return this.Ic.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
  
  static final class b
    extends c.a
  {
    b(c paramc)
    {
      super();
    }
    
    public final AccessibilityNodeInfo findFocus(int paramInt)
    {
      b localb = this.Ic.ay(paramInt);
      if (localb == null) {
        return null;
      }
      return localb.Hq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a.c
 * JD-Core Version:    0.7.0.1
 */