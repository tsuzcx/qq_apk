package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.hp.net.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class a
  implements e
{
  public static a pkM;
  public com.tencent.mm.plugin.boots.b.a.a pkN;
  
  private void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    AppMethodBeat.i(117371);
    if (this.pkN != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.pkN.CP(paramInt1);
      paramInt1 = this.pkN.CO(paramInt1);
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
        h.CyF.idkeyStat(paramInt2, paramInt1, 1L, false);
        AppMethodBeat.o(117371);
        return;
      }
    }
    Log.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    AppMethodBeat.o(117371);
  }
  
  public final void CN(int paramInt)
  {
    AppMethodBeat.i(117369);
    d(paramInt, false, 0);
    AppMethodBeat.o(117369);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(196769);
    paramString1 = new c(paramString1, paramString2, paramString3, paramf);
    g.azz().a(paramString1, 0);
    AppMethodBeat.o(196769);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> ckR()
  {
    AppMethodBeat.i(117372);
    if (this.pkN != null)
    {
      List localList = this.pkN.ckR();
      AppMethodBeat.o(117372);
      return localList;
    }
    AppMethodBeat.o(117372);
    return null;
  }
  
  public final void fb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117370);
    d(paramInt1, true, paramInt2);
    AppMethodBeat.o(117370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a
 * JD-Core Version:    0.7.0.1
 */