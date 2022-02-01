package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class c
{
  private static boolean ruy;
  
  static
  {
    AppMethodBeat.i(140616);
    ruy = false;
    AppMethodBeat.o(140616);
  }
  
  public static void cpt()
  {
    AppMethodBeat.i(140604);
    if (!MMHandlerThread.isMainThread())
    {
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(319435);
          c.cpt();
          AppMethodBeat.o(319435);
        }
      });
      AppMethodBeat.o(140604);
      return;
    }
    Log.v("MicroMsg.AppBrandMainProcessService", "tryBind: ");
    if (!ruy)
    {
      j.b(MMApplicationContext.getMainProcessName(), new a((byte)0));
      ruy = true;
    }
    k.EY(MMApplicationContext.getMainProcessName());
    AppMethodBeat.o(140604);
  }
  
  public static boolean isLive()
  {
    AppMethodBeat.i(319398);
    boolean bool = j.EX(MMApplicationContext.getMainProcessName());
    AppMethodBeat.o(319398);
    return bool;
  }
  
  static final class a
    implements p
  {
    public final void onDisconnect()
    {
      AppMethodBeat.i(319436);
      Log.i("MicroMsg.AppBrandMainProcessService", "onDisconnect: [%s] disconnected, reconnect immediately", new Object[] { MMApplicationContext.getMainProcessName() });
      c.cpt();
      AppMethodBeat.o(319436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.c
 * JD-Core Version:    0.7.0.1
 */