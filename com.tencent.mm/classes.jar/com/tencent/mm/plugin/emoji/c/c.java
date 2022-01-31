package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;

public final class c
  extends com.tencent.mm.sdk.b.c<bi>
{
  public c()
  {
    AppMethodBeat.i(52815);
    this.__eventId = bi.class.getName().hashCode();
    AppMethodBeat.o(52815);
  }
  
  private static boolean a(bi parambi)
  {
    AppMethodBeat.i(52816);
    com.tencent.mm.plugin.emoji.e.j localj;
    if (parambi.coR.coJ == 37) {
      if ((parambi.coR.subType == 5) && (parambi.coR.coO == 2))
      {
        localj = com.tencent.mm.plugin.emoji.e.j.bli();
        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      com.tencent.mm.vfs.e.deleteFile(g.RL().cachePath + "eggingfo.ini");
      com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(new b(com.tencent.mm.plugin.emoji.e.j.getDataEmojiPath(), com.tencent.mm.plugin.emoji.e.j.lgb).mUri), true);
      localj.lgt = null;
      if (parambi.coR.coO == 0) {
        ab.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambi.coR.coJ), Integer.valueOf(parambi.coR.subType) });
      }
      AppMethodBeat.o(52816);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */