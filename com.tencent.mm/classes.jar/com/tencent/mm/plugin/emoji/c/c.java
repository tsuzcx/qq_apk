package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.h.a.bg;
import com.tencent.mm.h.a.bg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class c
  extends com.tencent.mm.sdk.b.c<bg>
{
  public c()
  {
    this.udX = bg.class.getName().hashCode();
  }
  
  private static boolean a(bg parambg)
  {
    h localh;
    if (parambg.bHC.bHv == 37) {
      if ((parambg.bHC.brC == 5) && (parambg.bHC.bHz == 2))
      {
        localh = h.aHx();
        y.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
      }
    }
    try
    {
      com.tencent.mm.vfs.e.deleteFile(g.DP().cachePath + "eggingfo.ini");
      com.tencent.mm.vfs.e.K(j.n(new b(h.getDataEmojiPath(), h.iWP).mUri), true);
      localh.iXg = null;
      if (parambg.bHC.bHz == 0) {
        y.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", new Object[] { Integer.valueOf(parambg.bHC.bHv), Integer.valueOf(parambg.bHC.brC) });
      }
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */