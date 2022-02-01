package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  private static c pwM;
  private byte[] fmn;
  private final Map<Integer, Set<d>> hwk;
  private ao mHandler;
  public m pwN;
  a pwO;
  Vector<ae> pwP;
  
  public c()
  {
    AppMethodBeat.i(23200);
    this.hwk = new HashMap();
    this.fmn = new byte[0];
    this.pwP = new Vector();
    this.mHandler = new ao("ExdeviceHandlerThread");
    AppMethodBeat.o(23200);
  }
  
  public static c cgu()
  {
    AppMethodBeat.i(23202);
    if (pwM == null) {
      pwM = new c();
    }
    c localc = pwM;
    AppMethodBeat.o(23202);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(23204);
    ac.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.pwP.size()) });
    synchronized (this.fmn)
    {
      cgv();
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
        if (localc.pwN == null)
        {
          ac.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
          if (localc.pwO == null) {
            break label106;
          }
          ac.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
          localc.pwO.cgw();
          new au(Looper.getMainLooper(), new c.1(localc), true).au(100L, 100L);
        }
        for (;;)
        {
          i = 0;
          if (i == 0) {
            break;
          }
          localae.a(localc.pwN, localc);
          AppMethodBeat.o(23199);
          return;
          label106:
          ac.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
        }
        localc.pwP.add(localae);
        AppMethodBeat.o(23199);
      }
    });
    AppMethodBeat.o(23201);
    return true;
  }
  
  final void cgv()
  {
    AppMethodBeat.i(23203);
    ac.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.pwP.size()) });
    if (!this.pwP.isEmpty()) {
      a((ae)this.pwP.remove(0));
    }
    AppMethodBeat.o(23203);
  }
  
  public static abstract interface a
  {
    public abstract void cgw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */