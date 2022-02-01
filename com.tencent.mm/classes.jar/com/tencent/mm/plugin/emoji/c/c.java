package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bw;
import com.tencent.mm.f.a.bw.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class c
  extends IListener<bw>
{
  public c()
  {
    AppMethodBeat.i(161067);
    this.__eventId = bw.class.getName().hashCode();
    AppMethodBeat.o(161067);
  }
  
  private static boolean a(bw parambw)
  {
    AppMethodBeat.i(108389);
    com.tencent.mm.plugin.emoji.e.h localh;
    if (parambw.fxJ.fxC == 37) {
      if ((parambw.fxJ.subType == 5) && (parambw.fxJ.fvK == 2))
      {
        localh = com.tencent.mm.plugin.emoji.e.h.cUA();
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      u.deleteFile(com.tencent.mm.kernel.h.aHG().cachePath + "eggingfo.ini");
      u.deleteDir(new q(com.tencent.mm.plugin.emoji.e.h.getDataEmojiPath(), com.tencent.mm.plugin.emoji.e.h.uCN).getPath());
      localh.uDo = null;
      if (parambw.fxJ.fvK == 0) {
        Log.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambw.fxJ.fxC), Integer.valueOf(parambw.fxJ.subType) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */