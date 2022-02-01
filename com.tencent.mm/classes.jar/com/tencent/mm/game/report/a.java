package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  implements i
{
  private static a hhk;
  
  private a()
  {
    AppMethodBeat.i(175991);
    g.azz().a(1223, this);
    AppMethodBeat.o(175991);
  }
  
  public static a axd()
  {
    AppMethodBeat.i(175990);
    if (hhk == null) {}
    try
    {
      if (hhk == null) {
        hhk = new a();
      }
      a locala = hhk;
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
    Log.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
    paramString1 = new d(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    g.azz().a(paramString1, 0);
    AppMethodBeat.o(175993);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(175992);
    Log.i("MicroMsg.GameMsgReportService", "onSceneEnd, errType : %d, errCode : %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(175992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.a
 * JD-Core Version:    0.7.0.1
 */