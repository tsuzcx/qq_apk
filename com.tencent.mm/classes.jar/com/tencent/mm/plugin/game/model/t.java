package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class t
  implements f
{
  public t()
  {
    AppMethodBeat.i(111336);
    g.Rc().a(1223, this);
    AppMethodBeat.o(111336);
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(111337);
    ab.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
    paramString1 = new at(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    g.Rc().a(paramString1, 0);
    AppMethodBeat.o(111337);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.t
 * JD-Core Version:    0.7.0.1
 */