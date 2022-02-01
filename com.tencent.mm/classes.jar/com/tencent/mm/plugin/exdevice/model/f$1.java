package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class f$1
  implements au.b.a
{
  public f$1(long paramLong, Runnable paramRunnable) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23314);
    if (paramBoolean)
    {
      ae.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bu.fpO() - this.pjT) + " ms");
      c.al(paramString, 3);
      if (this.val$callback != null)
      {
        this.val$callback.run();
        AppMethodBeat.o(23314);
      }
    }
    else
    {
      ae.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
    }
    AppMethodBeat.o(23314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f.1
 * JD-Core Version:    0.7.0.1
 */