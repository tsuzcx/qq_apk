package com.tencent.mm.plugin.expt.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements b
{
  private final String TAG = "WxIme.ImeSingleton";
  
  public final void aEW()
  {
    AppMethodBeat.i(252643);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEZ, -1);
    boolean bool5 = ((d)h.ae(d.class)).gJ(MMApplicationContext.getContext());
    boolean bool1;
    boolean bool2;
    if (i == 1)
    {
      boolean bool3 = ((d)h.ae(d.class)).eCG();
      if (!bool3)
      {
        ((d)h.ae(d.class)).gH(MMApplicationContext.getContext());
        if (!((d)h.ae(d.class)).eCC()) {
          ((d)h.ae(d.class)).eCB();
        }
      }
      boolean bool4 = ((d)h.ae(d.class)).eCH();
      bool1 = bool4;
      bool2 = bool3;
      if (!bool5)
      {
        ((d)h.ae(d.class)).eCI();
        bool2 = bool3;
        bool1 = bool4;
      }
    }
    for (;;)
    {
      Log.i("WxIme.ImeSingleton", "iniIme curImeEnable:%s enableIme:%s newState:%s filterEnableIme:%s inInputMethodList:%s", new Object[] { Boolean.valueOf(bool5), Integer.valueOf(i), Boolean.valueOf(((d)h.ae(d.class)).gJ(MMApplicationContext.getContext())), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(252643);
      return;
      if (i == 0) {
        ((d)h.ae(d.class)).gI(MMApplicationContext.getContext());
      }
      bool1 = false;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.j.c
 * JD-Core Version:    0.7.0.1
 */