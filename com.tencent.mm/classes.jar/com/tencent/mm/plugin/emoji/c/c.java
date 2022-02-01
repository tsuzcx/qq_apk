package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.bm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.platformtools.ad;
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
    if (parambm.ddO.ddH == 37) {
      if ((parambm.ddO.subType == 5) && (parambm.ddO.dbV == 2))
      {
        localh = h.bUO();
        ad.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      i.deleteFile(g.afB().cachePath + "eggingfo.ini");
      i.cO(q.B(new com.tencent.mm.vfs.e(h.getDataEmojiPath(), h.ovD).mUri), true);
      localh.ovY = null;
      if (parambm.ddO.dbV == 0) {
        ad.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambm.ddO.ddH), Integer.valueOf(parambm.ddO.subType) });
      }
      AppMethodBeat.o(108389);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */