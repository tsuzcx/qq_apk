package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  private static c qgW;
  private byte[] fGy;
  private final Map<Integer, Set<d>> hRs;
  private aq mHandler;
  public m qgX;
  a qgY;
  Vector<ae> qgZ;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.hRs = new HashMap();
    this.fGy = new byte[0];
    this.qgZ = new Vector();
    this.mHandler = new aq("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c cmo()
  {
    AppMethodBeat.i(23202);
    if (qgW == null) {
      qgW = new c();
    }
    c localc = qgW;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.qgZ.size()) });
    synchronized (this.fGy)
    {
      cmp();
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
        if (localc.qgX == null)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.qgY == null) {
            break label106;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.qgY.cmq();
          new aw(Looper.getMainLooper(), new c.1(localc), true).ay(100L, 100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localae.a(localc.qgX, localc);
          AppMethodBeat.o(23199);
          return;
          label106:
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.qgZ.add(localae);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void cmp()
  {
    AppMethodBeat.i(23203);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.qgZ.size()) });
    if (!this.qgZ.isEmpty()) {
      a((ae)this.qgZ.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void cmq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */