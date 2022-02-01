package com.tencent.mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.a.e;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.Map;

public final class i
{
  public static void tF(String paramString)
  {
    AppMethodBeat.i(158750);
    if (c.aeI().tC(paramString))
    {
      AppMethodBeat.o(158750);
      return;
    }
    l.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158748);
        c localc = c.aeI();
        String str = this.gdK;
        if (g.tE(str))
        {
          b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
          AppMethodBeat.o(158748);
          return;
        }
        localc.tA(str);
        AppMethodBeat.o(158748);
      }
    });
    AppMethodBeat.o(158750);
  }
  
  public static void tG(String paramString)
  {
    AppMethodBeat.i(158751);
    if (c.aeI().tC(paramString))
    {
      AppMethodBeat.o(158751);
      return;
    }
    l.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158749);
        c.aeI().tD(this.gdK);
        AppMethodBeat.o(158749);
      }
    });
    AppMethodBeat.o(158751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.i
 * JD-Core Version:    0.7.0.1
 */