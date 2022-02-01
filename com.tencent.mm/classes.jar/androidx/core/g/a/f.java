package androidx.core.g.a;

import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private final AccessibilityRecord bvL;
  
  @Deprecated
  private f(Object paramObject)
  {
    AppMethodBeat.i(195973);
    this.bvL = ((AccessibilityRecord)paramObject);
    AppMethodBeat.o(195973);
  }
  
  @Deprecated
  public static f EZ()
  {
    AppMethodBeat.i(195985);
    f localf = new f(AccessibilityRecord.obtain());
    AppMethodBeat.o(195985);
    return localf;
  }
  
  public static void a(AccessibilityRecord paramAccessibilityRecord, View paramView, int paramInt)
  {
    AppMethodBeat.i(195995);
    if (Build.VERSION.SDK_INT >= 16) {
      paramAccessibilityRecord.setSource(paramView, paramInt);
    }
    AppMethodBeat.o(195995);
  }
  
  @Deprecated
  public final void aH(boolean paramBoolean)
  {
    AppMethodBeat.i(196008);
    this.bvL.setScrollable(paramBoolean);
    AppMethodBeat.o(196008);
  }
  
  @Deprecated
  public final void eA(int paramInt)
  {
    AppMethodBeat.i(196026);
    this.bvL.setFromIndex(paramInt);
    AppMethodBeat.o(196026);
  }
  
  @Deprecated
  public final void eB(int paramInt)
  {
    AppMethodBeat.i(196039);
    this.bvL.setToIndex(paramInt);
    AppMethodBeat.o(196039);
  }
  
  @Deprecated
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196065);
    if (this == paramObject)
    {
      AppMethodBeat.o(196065);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(196065);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.bvL == null)
    {
      if (paramObject.bvL != null)
      {
        AppMethodBeat.o(196065);
        return false;
      }
    }
    else if (!this.bvL.equals(paramObject.bvL))
    {
      AppMethodBeat.o(196065);
      return false;
    }
    AppMethodBeat.o(196065);
    return true;
  }
  
  @Deprecated
  public final void ez(int paramInt)
  {
    AppMethodBeat.i(196019);
    this.bvL.setItemCount(paramInt);
    AppMethodBeat.o(196019);
  }
  
  @Deprecated
  public final int hashCode()
  {
    AppMethodBeat.i(196052);
    if (this.bvL == null)
    {
      AppMethodBeat.o(196052);
      return 0;
    }
    int i = this.bvL.hashCode();
    AppMethodBeat.o(196052);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.a.f
 * JD-Core Version:    0.7.0.1
 */