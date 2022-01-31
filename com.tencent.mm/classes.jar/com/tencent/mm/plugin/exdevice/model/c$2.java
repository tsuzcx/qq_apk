package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;

final class c$2
  implements Runnable
{
  c$2(c paramc, ae paramae) {}
  
  public final void run()
  {
    int i = 1;
    c localc = this.jtu;
    ae localae = this.jtv;
    if (localc.jtr == null)
    {
      y.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
      if (localc.jts == null) {
        break label94;
      }
      y.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
      localc.jts.aLs();
      new am(Looper.getMainLooper(), new c.1(localc), true).S(100L, 100L);
    }
    for (;;)
    {
      i = 0;
      if (i == 0) {
        break;
      }
      localae.a(localc.jtr, localc);
      return;
      label94:
      y.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
    }
    localc.jtt.add(localae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c.2
 * JD-Core Version:    0.7.0.1
 */