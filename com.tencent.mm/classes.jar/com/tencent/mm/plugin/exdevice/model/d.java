package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class d
  implements com.tencent.mm.plugin.exdevice.j.d
{
  private static d ypr;
  private byte[] lrK;
  private MMHandler mHandler;
  private final Map<Integer, Set<com.tencent.mm.plugin.exdevice.j.d>> our;
  public m yps;
  a ypt;
  Vector<ai> ypu;
  
  public d()
  {
    AppMethodBeat.i(23200);
    this.our = new HashMap();
    this.lrK = new byte[0];
    this.ypu = new Vector();
    this.mHandler = new MMHandler("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static d dFr()
  {
    AppMethodBeat.i(23202);
    if (ypr == null) {
      ypr = new d();
    }
    d locald = ypr;
    AppMethodBeat.o(23202);
    return locald;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.ypu.size()) });
    synchronized (this.lrK)
    {
      dFs();
      AppMethodBeat.o(23204);
      return;
    }
  }
  
  public final boolean a(final ai paramai)
  {
    AppMethodBeat.i(23201);
    this.mHandler.postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(23199);
        d locald = d.this;
        ai localai = paramai;
        if (locald.yps == null)
        {
          Log.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (locald.ypt == null) {
            break label103;
          }
          Log.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          locald.ypt.dFt();
          new MTimerHandler(Looper.getMainLooper(), new d.1(locald), true).startTimer(100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localai.a(locald.yps, locald);
          AppMethodBeat.o(23199);
          return;
          label103:
          Log.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        locald.ypu.add(localai);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void dFs()
  {
    AppMethodBeat.i(23203);
    Log.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.ypu.size()) });
    if (!this.ypu.isEmpty()) {
      a((ai)this.ypu.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void dFt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */