package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class d
{
  public final Object Pc;
  
  public d()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Pc = new b(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Pc = new a(this);
      return;
    }
    this.Pc = null;
  }
  
  public d(Object paramObject)
  {
    this.Pc = paramObject;
  }
  
  public c aP(int paramInt)
  {
    return null;
  }
  
  public c aQ(int paramInt)
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
    final d Pd;
    
    a(d paramd)
    {
      this.Pd = paramd;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      c localc = this.Pd.aP(paramInt);
      if (localc == null) {
        return null;
      }
      return localc.Op;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return this.Pd.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
  
  static final class b
    extends d.a
  {
    b(d paramd)
    {
      super();
    }
    
    public final AccessibilityNodeInfo findFocus(int paramInt)
    {
      c localc = this.Pd.aQ(paramInt);
      if (localc == null) {
        return null;
      }
      return localc.Op;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a.d
 * JD-Core Version:    0.7.0.1
 */