package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f$1
  implements as.b.a
{
  public f$1(long paramLong, Runnable paramRunnable) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23314);
    if (paramBoolean)
    {
      ad.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bt.flT() - this.pdn) + " ms");
      c.ak(paramString, 3);
      if (this.val$callback != null)
      {
        this.val$callback.run();
        AppMethodBeat.o(23314);
      }
    }
    else
    {
      ad.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
    }
    AppMethodBeat.o(23314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f.1
 * JD-Core Version:    0.7.0.1
 */