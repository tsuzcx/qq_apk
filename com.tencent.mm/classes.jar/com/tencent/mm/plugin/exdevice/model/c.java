package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  private static c oTB;
  private byte[] fiT;
  private final Map<Integer, Set<d>> gVL;
  private ap mHandler;
  public m oTC;
  a oTD;
  Vector<ae> oTE;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.gVL = new HashMap();
    this.fiT = new byte[0];
    this.oTE = new Vector();
    this.mHandler = new ap("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c bZl()
  {
    AppMethodBeat.i(23202);
    if (oTB == null) {
      oTB = new c();
    }
    c localc = oTB;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    ad.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.oTE.size()) });
    synchronized (this.fiT)
    {
      bZm();
      AppMethodBeat.o(23204);
      return;
    }
  }
  
  public final boolean a(final ae paramae)
  {
    AppMethodBeat.i(23201);
    this.mHandler.postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(23199);
        c localc = c.this;
        ae localae = paramae;
        if (localc.oTC == null)
        {
          ad.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.oTD == null) {
            break label106;
          }
          ad.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.oTD.bZn();
          new av(Looper.getMainLooper(), new c.1(localc), true).av(100L, 100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localae.a(localc.oTC, localc);
          AppMethodBeat.o(23199);
          return;
          label106:
          ad.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.oTE.add(localae);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void bZm()
  {
    AppMethodBeat.i(23203);
    ad.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.oTE.size()) });
    if (!this.oTE.isEmpty()) {
      a((ae)this.oTE.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void bZn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */