package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class g$a
  implements Runnable
{
  volatile int eUK;
  boolean fZn;
  int fdk;
  final Object fdy;
  
  private g$a(g paramg)
  {
    AppMethodBeat.i(76724);
    this.fdy = new Object();
    AppMethodBeat.o(76724);
  }
  
  public final void run()
  {
    AppMethodBeat.i(76725);
    if (this.fdk == -1)
    {
      this.fdk = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      ab.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.fdk) });
    }
    this.eUK = 0;
    for (;;)
    {
      int i;
      synchronized (this.fdy)
      {
        if (this.fZn) {
          break label193;
        }
        l = bo.yB();
        ab.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
        i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eUK), false);
        ab.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        int j = this.eUK;
        if (i != j) {}
      }
      try
      {
        Thread.sleep(10L);
        this.eUK = i;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(76725);
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
        }
      }
    }
    label193:
    long l = bo.yB();
    this.eUK = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eUK, true);
    ab.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Long.valueOf(Thread.currentThread().getId()) });
    AppMethodBeat.o(76725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g.a
 * JD-Core Version:    0.7.0.1
 */