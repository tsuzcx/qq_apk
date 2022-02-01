package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  int bitrate;
  int frameCount = 0;
  int frameRate;
  int gnh;
  int gni;
  int hbX;
  int hbY;
  int iBi;
  int iBj;
  boolean isStart = false;
  int tFo;
  int tFp;
  a tFx;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.iBi = paramInt1;
    this.iBj = paramInt2;
    this.gnh = paramInt3;
    this.gni = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.hbX = 2;
    this.hbY = paramInt7;
    this.tFo = paramInt8;
    this.tFp = paramInt9;
  }
  
  final class a
    extends b
  {
    final Object gDG;
    int gDr;
    volatile int gqQ;
    boolean hCa;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.gDG = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.gDr == -1)
      {
        this.gDr = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.gDr) });
      }
      this.gqQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.gDG)
        {
          if (this.hCa) {
            break label193;
          }
          l = bt.GC();
          ad.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.gqQ), false);
          ad.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gqQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.gqQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89639);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bt.GC();
      this.gqQ = MP4MuxerJNI.triggerEncodeForSegmentLock(this.gqQ, true);
      ad.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */