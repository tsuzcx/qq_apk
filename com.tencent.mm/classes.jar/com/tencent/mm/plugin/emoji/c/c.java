package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.bm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class c
  extends com.tencent.mm.sdk.b.c<bm>
{
  public c()
  {
    AppMethodBeat.i(161067);
    this.__eventId = bm.class.getName().hashCode();
    AppMethodBeat.o(161067);
  }
  
  private static boolean a(bm parambm)
  {
    AppMethodBeat.i(108389);
    h localh;
    if (parambm.dbk.dbd == 37) {
      if ((parambm.dbk.subType == 5) && (parambm.dbk.cZu == 2))
      {
        localh = h.ccb();
        ac.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      i.deleteFile(g.agR().cachePath + "eggingfo.ini");
      i.cU(q.B(new com.tencent.mm.vfs.e(h.getDataEmojiPath(), h.oZd).mUri), true);
      localh.oZy = null;
      if (parambm.dbk.cZu == 0) {
        ac.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambm.dbk.dbd), Integer.valueOf(parambm.dbk.subType) });
      }
      AppMethodBeat.o(108389);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */