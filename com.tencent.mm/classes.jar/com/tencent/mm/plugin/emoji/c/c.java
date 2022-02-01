package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

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
    if (parambp.dnG.dnz == 37) {
      if ((parambp.dnG.subType == 5) && (parambp.dnG.dlO == 2))
      {
        localh = h.chV();
        ae.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      o.deleteFile(g.ajR().cachePath + "eggingfo.ini");
      o.dd(w.B(new k(h.getDataEmojiPath(), h.pJr).mUri), true);
      localh.pJM = null;
      if (parambp.dnG.dlO == 0) {
        ae.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambp.dnG.dnz), Integer.valueOf(parambp.dnG.subType) });
      }
      AppMethodBeat.o(108389);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */