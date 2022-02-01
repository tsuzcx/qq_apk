package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.hp.net.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class a
  implements e
{
  public static a smV;
  public com.tencent.mm.plugin.boots.b.a.a smW;
  
  public static a cyn()
  {
    AppMethodBeat.i(196062);
    if (smV == null) {
      smV = new a();
    }
    a locala = smV;
    AppMethodBeat.o(196062);
    return locala;
  }
  
  private void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    AppMethodBeat.i(117371);
    if (this.smW != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.smW.Gu(paramInt1);
      paramInt1 = this.smW.Gt(paramInt1);
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(paramInt2, paramInt1, 1L, false);
        AppMethodBeat.o(117371);
        return;
      }
    }
    Log.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
    AppMethodBeat.o(117371);
  }
  
  public final void Gs(int paramInt)
  {
    AppMethodBeat.i(117369);
    e(paramInt, false, 0);
    AppMethodBeat.o(117369);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(196066);
    paramString1 = new c(paramString1, paramString2, paramString3, paramf);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(196066);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> cym()
  {
    AppMethodBeat.i(117372);
    if (this.smW != null)
    {
      List localList = this.smW.cym();
      AppMethodBeat.o(117372);
      return localList;
    }
    AppMethodBeat.o(117372);
    return null;
  }
  
  public final void fA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117370);
    e(paramInt1, true, paramInt2);
    AppMethodBeat.o(117370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a
 * JD-Core Version:    0.7.0.1
 */