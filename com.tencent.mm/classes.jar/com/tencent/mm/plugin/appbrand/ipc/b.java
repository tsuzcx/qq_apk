package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
{
  private static boolean oqE;
  
  static
  {
    AppMethodBeat.i(140616);
    oqE = false;
    AppMethodBeat.o(140616);
  }
  
  public static void bPe()
  {
    AppMethodBeat.i(140604);
    if (!MMHandlerThread.isMainThread())
    {
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208892);
          b.bPe();
          AppMethodBeat.o(208892);
        }
      });
      AppMethodBeat.o(140604);
      return;
    }
    Log.v("MicroMsg.AppBrandMainProcessService", "tryBind: ");
    if (!oqE)
    {
      j.b(MMApplicationContext.getMainProcessName(), new a((byte)0));
      oqE = true;
    }
    k.Mq(MMApplicationContext.getMainProcessName());
    AppMethodBeat.o(140604);
  }
  
  public static boolean isLive()
  {
    AppMethodBeat.i(209084);
    boolean bool = j.Mp(MMApplicationContext.getMainProcessName());
    AppMethodBeat.o(209084);
    return bool;
  }
  
  static final class a
    implements p
  {
    public final void aFw()
    {
      AppMethodBeat.i(208499);
      Log.i("MicroMsg.AppBrandMainProcessService", "onDisconnect: [%s] disconnected, reconnect immediately", new Object[] { MMApplicationContext.getMainProcessName() });
      b.bPe();
      AppMethodBeat.o(208499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */