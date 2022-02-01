package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

final class c$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(250414);
    try
    {
      String str = c.lt(false);
      int i = 0;
      if (i < 3)
      {
        int j = c.aoU(str);
        if (j == 0)
        {
          AppMethodBeat.o(250414);
          return;
        }
        switch (j)
        {
        }
        do
        {
          i += 1;
          break;
          Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file empty");
          u.deleteFile(str);
          Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
        } while (-1 != c.ls(true));
        Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
        AppMethodBeat.o(250414);
        return;
      }
      AppMethodBeat.o(250414);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", localException, "[loadTask]", new Object[0]);
      AppMethodBeat.o(250414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.1
 * JD-Core Version:    0.7.0.1
 */