package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.hp.net.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class a
  implements e
{
  public static a ntn;
  public com.tencent.mm.plugin.boots.b.a.a nto;
  
  private void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    AppMethodBeat.i(117371);
    if (this.nto != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.nto.yq(paramInt1);
      paramInt1 = this.nto.yp(paramInt1);
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
        h.wUl.idkeyStat(paramInt2, paramInt1, 1L, false);
        AppMethodBeat.o(117371);
        return;
      }
    }
    ac.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    AppMethodBeat.o(117371);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(189684);
    paramString1 = new c(paramString1, paramString2, paramString3, paramf);
    g.agi().a(paramString1, 0);
    AppMethodBeat.o(189684);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> bIG()
  {
    AppMethodBeat.i(117372);
    if (this.nto != null)
    {
      List localList = this.nto.bIG();
      AppMethodBeat.o(117372);
      return localList;
    }
    AppMethodBeat.o(117372);
    return null;
  }
  
  public final void eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117370);
    d(paramInt1, true, paramInt2);
    AppMethodBeat.o(117370);
  }
  
  public final void yo(int paramInt)
  {
    AppMethodBeat.i(117369);
    d(paramInt, false, 0);
    AppMethodBeat.o(117369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a
 * JD-Core Version:    0.7.0.1
 */