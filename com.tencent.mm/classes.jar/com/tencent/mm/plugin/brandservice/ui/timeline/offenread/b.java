package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class b
  extends c.a
{
  private List<c> pzI;
  private List<c> pzJ;
  boolean pzK = false;
  
  public b(List<c> paramList1, List<c> paramList2)
  {
    this.pzI = paramList1;
    this.pzJ = paramList2;
  }
  
  private static c n(List<c> paramList, int paramInt)
  {
    AppMethodBeat.i(195018);
    if (paramInt < paramList.size())
    {
      paramList = (c)paramList.get(paramInt);
      AppMethodBeat.o(195018);
      return paramList;
    }
    AppMethodBeat.o(195018);
    return null;
  }
  
  public final int aB()
  {
    AppMethodBeat.i(195014);
    if (this.pzI != null)
    {
      int i = this.pzI.size();
      AppMethodBeat.o(195014);
      return i;
    }
    AppMethodBeat.o(195014);
    return 0;
  }
  
  public final int aC()
  {
    AppMethodBeat.i(195015);
    if (this.pzJ != null)
    {
      int i = this.pzJ.size();
      AppMethodBeat.o(195015);
      return i;
    }
    AppMethodBeat.o(195015);
    return 0;
  }
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195016);
    c localc1 = n(this.pzI, paramInt1);
    c localc2 = n(this.pzJ, paramInt2);
    if ((localc1 != null) && (localc2 != null))
    {
      boolean bool = Util.isEqual(localc1.KJV, localc2.KJV);
      AppMethodBeat.o(195016);
      return bool;
    }
    AppMethodBeat.o(195016);
    return false;
  }
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195017);
    c localc1 = n(this.pzI, paramInt1);
    c localc2 = n(this.pzJ, paramInt2);
    if (((localc1 instanceof e)) && ((localc2 instanceof e)))
    {
      if (this.pzK)
      {
        AppMethodBeat.o(195017);
        return false;
      }
      AppMethodBeat.o(195017);
      return true;
    }
    if (localc1.pzL == localc2.pzL) {
      if ((localc1.iwv == null) || (!localc1.iwv.equalsIgnoreCase(localc2.iwv))) {
        break label132;
      }
    }
    label132:
    for (paramInt1 = 1; (paramInt1 == 0) || (localc1.oJs != localc2.oJs) || (localc1.weight != localc2.weight); paramInt1 = 0)
    {
      AppMethodBeat.o(195017);
      return false;
    }
    AppMethodBeat.o(195017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b
 * JD-Core Version:    0.7.0.1
 */