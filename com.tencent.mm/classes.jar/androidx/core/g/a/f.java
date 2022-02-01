package androidx.core.g.a;

import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private final AccessibilityRecord Pt;
  
  @Deprecated
  private f(Object paramObject)
  {
    AppMethodBeat.i(252190);
    this.Pt = ((AccessibilityRecord)paramObject);
    AppMethodBeat.o(252190);
  }
  
  @Deprecated
  public static f hw()
  {
    AppMethodBeat.i(252191);
    f localf = new f(AccessibilityRecord.obtain());
    AppMethodBeat.o(252191);
    return localf;
  }
  
  @Deprecated
  public final void ab(boolean paramBoolean)
  {
    AppMethodBeat.i(252193);
    this.Pt.setScrollable(paramBoolean);
    AppMethodBeat.o(252193);
  }
  
  @Deprecated
  public final void bE(int paramInt)
  {
    AppMethodBeat.i(252194);
    this.Pt.setItemCount(paramInt);
    AppMethodBeat.o(252194);
  }
  
  @Deprecated
  public final void bF(int paramInt)
  {
    AppMethodBeat.i(252196);
    this.Pt.setFromIndex(paramInt);
    AppMethodBeat.o(252196);
  }
  
  @Deprecated
  public final void bG(int paramInt)
  {
    AppMethodBeat.i(252198);
    this.Pt.setToIndex(paramInt);
    AppMethodBeat.o(252198);
  }
  
  @Deprecated
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(252201);
    if (this == paramObject)
    {
      AppMethodBeat.o(252201);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(252201);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.Pt == null)
    {
      if (paramObject.Pt != null)
      {
        AppMethodBeat.o(252201);
        return false;
      }
    }
    else if (!this.Pt.equals(paramObject.Pt))
    {
      AppMethodBeat.o(252201);
      return false;
    }
    AppMethodBeat.o(252201);
    return true;
  }
  
  @Deprecated
  public final int hashCode()
  {
    AppMethodBeat.i(252199);
    if (this.Pt == null)
    {
      AppMethodBeat.o(252199);
      return 0;
    }
    int i = this.Pt.hashCode();
    AppMethodBeat.o(252199);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.f
 * JD-Core Version:    0.7.0.1
 */