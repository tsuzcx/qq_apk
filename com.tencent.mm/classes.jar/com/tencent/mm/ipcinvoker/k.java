package com.tencent.mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k
{
  public static void EY(String paramString)
  {
    AppMethodBeat.i(158750);
    if (e.aYp().ET(paramString))
    {
      AppMethodBeat.o(158750);
      return;
    }
    n.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158748);
        e locale = e.aYp();
        String str = k.this;
        if (i.EW(str))
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
          AppMethodBeat.o(158748);
          return;
        }
        locale.ES(str);
        AppMethodBeat.o(158748);
      }
    });
    AppMethodBeat.o(158750);
  }
  
  public static void EZ(String paramString)
  {
    AppMethodBeat.i(158751);
    if (e.aYp().ET(paramString))
    {
      AppMethodBeat.o(158751);
      return;
    }
    n.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158749);
        e.aYp().EV(k.this);
        AppMethodBeat.o(158749);
      }
    });
    AppMethodBeat.o(158751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.k
 * JD-Core Version:    0.7.0.1
 */