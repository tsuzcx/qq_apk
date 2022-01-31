package com.tencent.mm.bj;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$b
  implements Runnable
{
  volatile int eUK;
  boolean fZn;
  int fdk;
  Object fdy;
  
  private h$b(h paramh)
  {
    AppMethodBeat.i(50947);
    this.fdy = new Object();
    AppMethodBeat.o(50947);
  }
  
  public final void run()
  {
    AppMethodBeat.i(50948);
    if (this.fdk == -1)
    {
      this.fdk = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      ab.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.fdk) });
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
        ab.i("MicroMsg.VideoTranscoder", "try trigger encode");
        i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.eUK), false);
        ab.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        int j = this.eUK;
        if (i != j) {}
      }
      try
      {
        Thread.sleep(5L);
        this.eUK = i;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(50948);
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.VideoTranscoder", "thread sleep error");
        }
      }
    }
    label193:
    long l = bo.yB();
    this.eUK = MP4MuxerJNI.triggerEncodeForSegmentLock(this.eUK, true);
    ab.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Long.valueOf(Thread.currentThread().getId()) });
    AppMethodBeat.o(50948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bj.h.b
 * JD-Core Version:    0.7.0.1
 */