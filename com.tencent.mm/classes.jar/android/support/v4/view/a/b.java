package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public final class b
{
  public final Object Ir;
  
  public b()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Ir = new b(this);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Ir = new a(this);
      return;
    }
    this.Ir = null;
  }
  
  public b(Object paramObject)
  {
    this.Ir = paramObject;
  }
  
  static class a
    extends AccessibilityNodeProvider
  {
    final b Is;
    
    a(b paramb)
    {
      this.Is = paramb;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      return null;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return false;
    }
  }
  
  static final class b
    extends b.a
  {
    b(b paramb)
    {
      super();
    }
    
    public final AccessibilityNodeInfo findFocus(int paramInt)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a.b
 * JD-Core Version:    0.7.0.1
 */