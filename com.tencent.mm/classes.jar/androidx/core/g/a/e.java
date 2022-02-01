package androidx.core.g.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class e
{
  public final Object bvJ;
  
  public e()
  {
    AppMethodBeat.i(195967);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.bvJ = new c(this);
      AppMethodBeat.o(195967);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.bvJ = new b(this);
      AppMethodBeat.o(195967);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.bvJ = new a(this);
      AppMethodBeat.o(195967);
      return;
    }
    this.bvJ = null;
    AppMethodBeat.o(195967);
  }
  
  public e(Object paramObject)
  {
    this.bvJ = paramObject;
  }
  
  public static List<d> EY()
  {
    return null;
  }
  
  public d ex(int paramInt)
  {
    return null;
  }
  
  public d ey(int paramInt)
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
    final e bvK;
    
    a(e parame)
    {
      this.bvK = parame;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      AppMethodBeat.i(195977);
      Object localObject = this.bvK.ex(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(195977);
        return null;
      }
      localObject = ((d)localObject).buO;
      AppMethodBeat.o(195977);
      return localObject;
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      AppMethodBeat.i(195987);
      paramString = e.EY();
      if (paramString == null)
      {
        AppMethodBeat.o(195987);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = paramString.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localArrayList.add(((d)paramString.get(paramInt)).buO);
        paramInt += 1;
      }
      AppMethodBeat.o(195987);
      return localArrayList;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(195998);
      boolean bool = this.bvK.performAction(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(195998);
      return bool;
    }
  }
  
  static class b
    extends e.a
  {
    b(e parame)
    {
      super();
    }
    
    public AccessibilityNodeInfo findFocus(int paramInt)
    {
      AppMethodBeat.i(195961);
      Object localObject = this.bvK.ey(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(195961);
        return null;
      }
      localObject = ((d)localObject).buO;
      AppMethodBeat.o(195961);
      return localObject;
    }
  }
  
  static final class c
    extends e.b
  {
    c(e parame)
    {
      super();
    }
    
    public final void addExtraDataToAccessibilityNodeInfo(int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(195959);
      d.a(paramAccessibilityNodeInfo);
      AppMethodBeat.o(195959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.a.e
 * JD-Core Version:    0.7.0.1
 */