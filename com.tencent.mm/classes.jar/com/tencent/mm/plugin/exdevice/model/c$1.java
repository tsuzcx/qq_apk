package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  private long ftP = 10L;
  
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19090);
    if (this.lCT.lCQ == null)
    {
      long l = this.ftP;
      this.ftP = (l - 1L);
      if (l > 0L)
      {
        AppMethodBeat.o(19090);
        return true;
      }
    }
    ab.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[] { Long.valueOf(this.ftP) });
    if (this.ftP > 0L) {
      this.lCT.bpF();
    }
    AppMethodBeat.o(19090);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c.1
 * JD-Core Version:    0.7.0.1
 */