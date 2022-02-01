package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class d
{
  public final Object RZ;
  
  public d()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.RZ = new b(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.RZ = new a(this);
      return;
    }
    this.RZ = null;
  }
  
  public d(Object paramObject)
  {
    this.RZ = paramObject;
  }
  
  public c aQ(int paramInt)
  {
    return null;
  }
  
  public c aR(int paramInt)
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
    final d Sa;
    
    a(d paramd)
    {
      this.Sa = paramd;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      c localc = this.Sa.aQ(paramInt);
      if (localc == null) {
        return null;
      }
      return localc.Ro;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return this.Sa.performAction(paramInt1, paramInt2, paramBundle);
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
      c localc = this.Sa.aR(paramInt);
      if (localc == null) {
        return null;
      }
      return localc.Ro;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a.d
 * JD-Core Version:    0.7.0.1
 */