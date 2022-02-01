package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f$1
  implements ay.b.a
{
  public f$1(long paramLong, Runnable paramRunnable) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23314);
    if (paramBoolean)
    {
      Log.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (Util.nowMilliSecond() - this.qze) + " ms");
      c.ap(paramString, 3);
      if (this.val$callback != null)
      {
        this.val$callback.run();
        AppMethodBeat.o(23314);
      }
    }
    else
    {
      Log.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
    }
    AppMethodBeat.o(23314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.f.1
 * JD-Core Version:    0.7.0.1
 */