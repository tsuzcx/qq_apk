package com.tencent.mm.plugin.ipcall;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    if (!i.bck().bcd())
    {
      y.i("MicroMsg.IPCallManager", "timeout! still not accept!");
      if (this.lor.da(9, 12)) {
        this.lor.d(9, null, ae.getContext().getString(R.l.callout_failed_network), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.3
 * JD-Core Version:    0.7.0.1
 */