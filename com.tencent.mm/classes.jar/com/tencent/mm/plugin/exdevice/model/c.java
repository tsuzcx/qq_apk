package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  private static c vdy;
  private byte[] iPP;
  private final Map<Integer, Set<d>> lCH;
  private MMHandler mHandler;
  a vdA;
  Vector<af> vdB;
  public m vdz;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.lCH = new HashMap();
    this.iPP = new byte[0];
    this.vdB = new Vector();
    this.mHandler = new MMHandler("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c cZa()
  {
    AppMethodBeat.i(23202);
    if (vdy == null) {
      vdy = new c();
    }
    c localc = vdy;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.vdB.size()) });
    synchronized (this.iPP)
    {
      cZb();
      AppMethodBeat.o(23204);
      return;
    }
  }
  
  public final boolean a(final af paramaf)
  {
    AppMethodBeat.i(23201);
    this.mHandler.postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(23199);
        c localc = c.this;
        af localaf = paramaf;
        if (localc.vdz == null)
        {
          Log.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.vdA == null) {
            break label103;
          }
          Log.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.vdA.cZc();
          new MTimerHandler(Looper.getMainLooper(), new c.1(localc), true).startTimer(100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localaf.a(localc.vdz, localc);
          AppMethodBeat.o(23199);
          return;
          label103:
          Log.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.vdB.add(localaf);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void cZb()
  {
    AppMethodBeat.i(23203);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.vdB.size()) });
    if (!this.vdB.isEmpty()) {
      a((af)this.vdB.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void cZc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */