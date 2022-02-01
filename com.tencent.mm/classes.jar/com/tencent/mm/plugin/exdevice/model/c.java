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
  private static c qar;
  private byte[] fEu;
  private final Map<Integer, Set<d>> hOz;
  private ap mHandler;
  public m qas;
  a qat;
  Vector<ae> qau;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.hOz = new HashMap();
    this.fEu = new byte[0];
    this.qau = new Vector();
    this.mHandler = new ap("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c ckY()
  {
    AppMethodBeat.i(23202);
    if (qar == null) {
      qar = new c();
    }
    c localc = qar;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    ad.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.qau.size()) });
    synchronized (this.fEu)
    {
      ckZ();
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
        if (localc.qas == null)
        {
          ad.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.qat == null) {
            break label106;
          }
          ad.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.qat.cla();
          new av(Looper.getMainLooper(), new c.1(localc), true).az(100L, 100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localae.a(localc.qas, localc);
          AppMethodBeat.o(23199);
          return;
          label106:
          ad.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.qau.add(localae);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void ckZ()
  {
    AppMethodBeat.i(23203);
    ad.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.qau.size()) });
    if (!this.qau.isEmpty()) {
      a((ae)this.qau.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void cla();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */