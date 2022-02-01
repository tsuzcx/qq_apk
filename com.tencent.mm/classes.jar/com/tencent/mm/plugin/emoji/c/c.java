package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class c
  extends com.tencent.mm.sdk.b.c<bp>
{
  public c()
  {
    AppMethodBeat.i(161067);
    this.__eventId = bp.class.getName().hashCode();
    AppMethodBeat.o(161067);
  }
  
  private static boolean a(bp parambp)
  {
    AppMethodBeat.i(108389);
    h localh;
    if (parambp.dmE.dmx == 37) {
      if ((parambp.dmE.subType == 5) && (parambp.dmE.dkM == 2))
      {
        localh = h.cgF();
        ad.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      i.deleteFile(g.ajC().cachePath + "eggingfo.ini");
      i.cZ(q.B(new com.tencent.mm.vfs.e(h.getDataEmojiPath(), h.pCN).mUri), true);
      localh.pDi = null;
      if (parambp.dmE.dkM == 0) {
        ad.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambp.dmE.dmx), Integer.valueOf(parambp.dmE.subType) });
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