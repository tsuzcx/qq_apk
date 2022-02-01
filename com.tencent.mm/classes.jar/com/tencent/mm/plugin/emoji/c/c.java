package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.br.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c
  extends IListener<br>
{
  public c()
  {
    AppMethodBeat.i(161067);
    this.__eventId = br.class.getName().hashCode();
    AppMethodBeat.o(161067);
  }
  
  private static boolean a(br parambr)
  {
    AppMethodBeat.i(108389);
    h localh;
    if (parambr.dEV.dEO == 37) {
      if ((parambr.dEV.subType == 5) && (parambr.dEV.dDe == 2))
      {
        localh = h.cFT();
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      s.deleteFile(g.aAh().cachePath + "eggingfo.ini");
      s.dy(aa.z(new o(h.getDataEmojiPath(), h.qZM).mUri), true);
      localh.ran = null;
      if (parambr.dEV.dDe == 0) {
        Log.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambr.dEV.dEO), Integer.valueOf(parambr.dEV.subType) });
      }
      AppMethodBeat.o(108389);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */