package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements am.a
{
  private long edM = 10L;
  
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    if (this.jtu.jtr == null)
    {
      long l = this.edM;
      this.edM = (l - 1L);
      if (l > 0L) {
        return true;
      }
    }
    y.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[] { Long.valueOf(this.edM) });
    if (this.edM > 0L) {
      this.jtu.aLr();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c.1
 * JD-Core Version:    0.7.0.1
 */