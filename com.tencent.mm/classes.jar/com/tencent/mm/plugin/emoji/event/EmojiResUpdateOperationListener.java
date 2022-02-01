package com.tencent.mm.plugin.emoji.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cf;
import com.tencent.mm.autogen.a.cf.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public class EmojiResUpdateOperationListener
  extends IListener<cf>
{
  public EmojiResUpdateOperationListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161067);
    this.__eventId = cf.class.getName().hashCode();
    AppMethodBeat.o(161067);
  }
  
  private static boolean a(cf paramcf)
  {
    AppMethodBeat.i(108389);
    com.tencent.mm.plugin.emoji.mgr.h localh;
    if (paramcf.hCo.hCh == 37) {
      if ((paramcf.hCo.subType == 5) && (paramcf.hCo.hAf == 2))
      {
        localh = com.tencent.mm.plugin.emoji.mgr.h.dzH();
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      y.deleteFile(com.tencent.mm.kernel.h.baE().cachePath + "eggingfo.ini");
      y.ew(ah.v(new u(com.tencent.mm.plugin.emoji.mgr.h.getDataEmojiPath(), com.tencent.mm.plugin.emoji.mgr.h.xLj).mUri), true);
      localh.xLG = null;
      if (paramcf.hCo.hAf == 0) {
        Log.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(paramcf.hCo.hCh), Integer.valueOf(paramcf.hCo.subType) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.event.EmojiResUpdateOperationListener
 * JD-Core Version:    0.7.0.1
 */