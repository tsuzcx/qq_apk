package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Vector;

final class c$2
  implements Runnable
{
  c$2(c paramc, ae paramae) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(19091);
    c localc = this.lCT;
    ae localae = this.lCU;
    if (localc.lCQ == null)
    {
      ab.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
      if (localc.lCR == null) {
        break label106;
      }
      ab.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
      localc.lCR.bpG();
      new ap(Looper.getMainLooper(), new c.1(localc), true).ag(100L, 100L);
    }
    for (;;)
    {
      i = 0;
      if (i == 0) {
        break;
      }
      localae.a(localc.lCQ, localc);
      AppMethodBeat.o(19091);
      return;
      label106:
      ab.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
    }
    localc.lCS.add(localae);
    AppMethodBeat.o(19091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c.2
 * JD-Core Version:    0.7.0.1
 */