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
  private static c rxS;
  private byte[] glH;
  private final Map<Integer, Set<d>> iMA;
  private MMHandler mHandler;
  public m rxT;
  a rxU;
  Vector<ae> rxV;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.iMA = new HashMap();
    this.glH = new byte[0];
    this.rxV = new Vector();
    this.mHandler = new MMHandler("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c cKq()
  {
    AppMethodBeat.i(23202);
    if (rxS == null) {
      rxS = new c();
    }
    c localc = rxS;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.rxV.size()) });
    synchronized (this.glH)
    {
      cKr();
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
        if (localc.rxT == null)
        {
          Log.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.rxU == null) {
            break label103;
          }
          Log.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.rxU.cKs();
          new MTimerHandler(Looper.getMainLooper(), new c.1(localc), true).startTimer(100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localae.a(localc.rxT, localc);
          AppMethodBeat.o(23199);
          return;
          label103:
          Log.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.rxV.add(localae);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void cKr()
  {
    AppMethodBeat.i(23203);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.rxV.size()) });
    if (!this.rxV.isEmpty()) {
      a((ae)this.rxV.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void cKs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */