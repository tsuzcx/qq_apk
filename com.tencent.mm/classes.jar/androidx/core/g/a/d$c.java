package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$c
{
  final Object bvI;
  
  private d$c(Object paramObject)
  {
    this.bvI = paramObject;
  }
  
  public static c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195980);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localc = new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
      AppMethodBeat.o(195980);
      return localc;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localc = new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1));
      AppMethodBeat.o(195980);
      return localc;
    }
    c localc = new c(null);
    AppMethodBeat.o(195980);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.a.d.c
 * JD-Core Version:    0.7.0.1
 */