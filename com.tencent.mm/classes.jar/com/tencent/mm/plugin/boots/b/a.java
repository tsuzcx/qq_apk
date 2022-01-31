package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class a
  implements e
{
  public static a jRN;
  public com.tencent.mm.plugin.boots.b.a.a jRO;
  
  private void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    AppMethodBeat.i(90532);
    if (this.jRO != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.jRO.rS(paramInt1);
      paramInt1 = this.jRO.rR(paramInt1);
      if ((paramBoolean) && (locala.field_dau != paramInt1))
      {
        if (paramInt1 <= 255) {
          break label77;
        }
        paramInt1 = i;
      }
      label77:
      for (;;)
      {
        h.qsU.idkeyStat(paramInt2, paramInt1, 1L, false);
        AppMethodBeat.o(90532);
        return;
      }
    }
    ab.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    AppMethodBeat.o(90532);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> aWg()
  {
    AppMethodBeat.i(90533);
    if (this.jRO != null)
    {
      List localList = this.jRO.aWg();
      AppMethodBeat.o(90533);
      return localList;
    }
    AppMethodBeat.o(90533);
    return null;
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90531);
    e(paramInt1, true, paramInt2);
    AppMethodBeat.o(90531);
  }
  
  public final void rQ(int paramInt)
  {
    AppMethodBeat.i(90530);
    e(paramInt, false, 0);
    AppMethodBeat.o(90530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a
 * JD-Core Version:    0.7.0.1
 */