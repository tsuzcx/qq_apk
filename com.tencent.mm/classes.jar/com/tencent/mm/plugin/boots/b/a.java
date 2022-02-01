package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class a
  implements e
{
  public static a mQX;
  public com.tencent.mm.plugin.boots.b.a.a mQY;
  
  private void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    AppMethodBeat.i(117371);
    if (this.mQY != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.mQY.xy(paramInt1);
      paramInt1 = this.mQY.xx(paramInt1);
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
        h.vKh.idkeyStat(paramInt2, paramInt1, 1L, false);
        AppMethodBeat.o(117371);
        return;
      }
    }
    ad.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    AppMethodBeat.o(117371);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> bBI()
  {
    AppMethodBeat.i(117372);
    if (this.mQY != null)
    {
      List localList = this.mQY.bBI();
      AppMethodBeat.o(117372);
      return localList;
    }
    AppMethodBeat.o(117372);
    return null;
  }
  
  public final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117370);
    d(paramInt1, true, paramInt2);
    AppMethodBeat.o(117370);
  }
  
  public final void xw(int paramInt)
  {
    AppMethodBeat.i(117369);
    d(paramInt, false, 0);
    AppMethodBeat.o(117369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a
 * JD-Core Version:    0.7.0.1
 */