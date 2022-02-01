package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;

public class a
  implements com.tencent.mm.ak.g
{
  private static a fYz;
  
  private a()
  {
    AppMethodBeat.i(175991);
    com.tencent.mm.kernel.g.agi().a(1223, this);
    AppMethodBeat.o(175991);
  }
  
  public static a adX()
  {
    AppMethodBeat.i(175990);
    if (fYz == null) {}
    try
    {
      if (fYz == null) {
        fYz = new a();
      }
      a locala = fYz;
      AppMethodBeat.o(175990);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(175990);
    }
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175993);
    ac.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
    paramString1 = new c(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    AppMethodBeat.o(175993);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(175992);
    ac.i("MicroMsg.GameMsgReportService", "onSceneEnd, errType : %d, errCode : %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(175992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.a
 * JD-Core Version:    0.7.0.1
 */