package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$b
{
  final Object bvI;
  
  private d$b(Object paramObject)
  {
    this.bvI = paramObject;
  }
  
  public static b a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(195979);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localb = new b(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3));
      AppMethodBeat.o(195979);
      return localb;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localb = new b(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
      AppMethodBeat.o(195979);
      return localb;
    }
    b localb = new b(null);
    AppMethodBeat.o(195979);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.a.d.b
 * JD-Core Version:    0.7.0.1
 */