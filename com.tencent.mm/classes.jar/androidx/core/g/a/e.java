package androidx.core.g.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class e
{
  public final Object Pr;
  
  public e()
  {
    AppMethodBeat.i(252184);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Pr = new b(this);
      AppMethodBeat.o(252184);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.Pr = new a(this);
      AppMethodBeat.o(252184);
      return;
    }
    this.Pr = null;
    AppMethodBeat.o(252184);
  }
  
  public e(Object paramObject)
  {
    this.Pr = paramObject;
  }
  
  public d bC(int paramInt)
  {
    return null;
  }
  
  public d bD(int paramInt)
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
    final e Ps;
    
    a(e parame)
    {
      this.Ps = parame;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      AppMethodBeat.i(252167);
      Object localObject = this.Ps.bC(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(252167);
        return null;
      }
      localObject = ((d)localObject).Ov;
      AppMethodBeat.o(252167);
      return localObject;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      return null;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(252169);
      boolean bool = this.Ps.performAction(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(252169);
      return bool;
    }
  }
  
  static final class b
    extends e.a
  {
    b(e parame)
    {
      super();
    }
    
    public final AccessibilityNodeInfo findFocus(int paramInt)
    {
      AppMethodBeat.i(252181);
      Object localObject = this.Ps.bD(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(252181);
        return null;
      }
      localObject = ((d)localObject).Ov;
      AppMethodBeat.o(252181);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.e
 * JD-Core Version:    0.7.0.1
 */