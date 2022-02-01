package com.tencent.mm.plugin.expt.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements b
{
  private final String TAG = "WxIme.ImeSingleton";
  
  public final void aXY()
  {
    AppMethodBeat.i(299424);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUx, -1);
      if (h.ax(d.class) == null)
      {
        Log.e("WxIme.ImeSingleton", "initIme IWxImeEnterService is null");
        AppMethodBeat.o(299424);
        return;
      }
      boolean bool5 = ((d)h.ax(d.class)).ic(MMApplicationContext.getContext());
      boolean bool1;
      boolean bool2;
      if (i == 1)
      {
        boolean bool3 = ((d)h.ax(d.class)).fKJ();
        if (!bool3)
        {
          ((d)h.ax(d.class)).ia(MMApplicationContext.getContext());
          if (!((d)h.ax(d.class)).fKF()) {
            ((d)h.ax(d.class)).fKE();
          }
        }
        boolean bool4 = ((d)h.ax(d.class)).fKK();
        bool1 = bool4;
        bool2 = bool3;
        if (!bool5)
        {
          ((d)h.ax(d.class)).fKL();
          bool2 = bool3;
          bool1 = bool4;
        }
      }
      for (;;)
      {
        Log.i("WxIme.ImeSingleton", "iniIme curImeEnable:%s enableIme:%s newState:%s filterEnableIme:%s inInputMethodList:%s", new Object[] { Boolean.valueOf(bool5), Integer.valueOf(i), Boolean.valueOf(((d)h.ax(d.class)).ic(MMApplicationContext.getContext())), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(299424);
        return;
        if (i == 0) {
          ((d)h.ax(d.class)).ib(MMApplicationContext.getContext());
        }
        bool1 = false;
        bool2 = false;
      }
      return;
    }
    finally
    {
      Log.printErrStackTrace("WxIme.ImeSingleton", localThrowable, "", new Object[0]);
      AppMethodBeat.o(299424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.trigger.c
 * JD-Core Version:    0.7.0.1
 */