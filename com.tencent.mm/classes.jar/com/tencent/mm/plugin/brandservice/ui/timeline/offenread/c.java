package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import androidx.recyclerview.widget.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c
  extends h.a
{
  private List<d> sJS;
  private List<d> sJT;
  boolean sJU = false;
  
  public c(List<d> paramList1, List<d> paramList2)
  {
    this.sJS = paramList1;
    this.sJT = paramList2;
  }
  
  private static d n(List<d> paramList, int paramInt)
  {
    AppMethodBeat.i(266255);
    if (paramInt < paramList.size())
    {
      paramList = (d)paramList.get(paramInt);
      AppMethodBeat.o(266255);
      return paramList;
    }
    AppMethodBeat.o(266255);
    return null;
  }
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266251);
    d locald1 = n(this.sJS, paramInt1);
    d locald2 = n(this.sJT, paramInt2);
    if ((locald1 != null) && (locald2 != null))
    {
      boolean bool = Util.isEqual(locald1.RKL, locald2.RKL);
      AppMethodBeat.o(266251);
      return bool;
    }
    AppMethodBeat.o(266251);
    return false;
  }
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266253);
    d locald1 = n(this.sJS, paramInt1);
    d locald2 = n(this.sJT, paramInt2);
    if (((locald1 instanceof f)) && ((locald2 instanceof f)))
    {
      if (this.sJU)
      {
        AppMethodBeat.o(266253);
        return false;
      }
      AppMethodBeat.o(266253);
      return true;
    }
    if (locald1.sJW == locald2.sJW) {
      if ((locald1.llI == null) || (!locald1.llI.equalsIgnoreCase(locald2.llI))) {
        break label156;
      }
    }
    label156:
    for (paramInt1 = 1; (paramInt1 == 0) || (locald1.rLi != locald2.rLi) || (locald1.weight != locald2.weight) || (locald1.sJV != locald2.sJV) || (locald1.RVp != locald2.RVp); paramInt1 = 0)
    {
      AppMethodBeat.o(266253);
      return false;
    }
    AppMethodBeat.o(266253);
    return true;
  }
  
  public final int jL()
  {
    AppMethodBeat.i(266247);
    if (this.sJS != null)
    {
      int i = this.sJS.size();
      AppMethodBeat.o(266247);
      return i;
    }
    AppMethodBeat.o(266247);
    return 0;
  }
  
  public final int jM()
  {
    AppMethodBeat.i(266249);
    if (this.sJT != null)
    {
      int i = this.sJT.size();
      AppMethodBeat.o(266249);
      return i;
    }
    AppMethodBeat.o(266249);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c
 * JD-Core Version:    0.7.0.1
 */