package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;

public final class i
{
  public static void qq(String paramString)
  {
    AppMethodBeat.i(158750);
    if (c.ads().qn(paramString))
    {
      AppMethodBeat.o(158750);
      return;
    }
    l.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158748);
        c localc = c.ads();
        String str = this.fZe;
        if (g.qp(str))
        {
          b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
          AppMethodBeat.o(158748);
          return;
        }
        localc.ql(str);
        AppMethodBeat.o(158748);
      }
    });
    AppMethodBeat.o(158750);
  }
  
  public static void qr(String paramString)
  {
    AppMethodBeat.i(158751);
    if (c.ads().qn(paramString))
    {
      AppMethodBeat.o(158751);
      return;
    }
    l.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158749);
        c.ads().qo(this.fZe);
        AppMethodBeat.o(158749);
      }
    });
    AppMethodBeat.o(158751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.i
 * JD-Core Version:    0.7.0.1
 */