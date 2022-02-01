package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  int bitrate;
  int frameCount = 0;
  int frameRate;
  int hXW;
  int hXX;
  boolean isStart = false;
  int jxn;
  int jxo;
  int targetHeight;
  int targetWidth;
  int wcW;
  int wcX;
  a wdf;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.jxn = paramInt1;
    this.jxo = paramInt2;
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.hXW = 2;
    this.hXX = paramInt7;
    this.wcW = paramInt8;
    this.wcX = paramInt9;
  }
  
  final class a
    extends b
  {
    volatile int hmE;
    int hyO;
    final Object hzd;
    boolean iyQ;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.hzd = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.hyO == -1)
      {
        this.hyO = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ae.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hyO) });
      }
      this.hmE = 0;
      for (;;)
      {
        int i;
        synchronized (this.hzd)
        {
          if (this.iyQ) {
            break label193;
          }
          l = bu.HQ();
          ae.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.hmE), false);
          ae.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hmE;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.hmE = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89639);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bu.HQ();
      this.hmE = MP4MuxerJNI.triggerEncodeForSegmentLock(this.hmE, true);
      ae.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */