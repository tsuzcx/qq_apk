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
  int hVe;
  int hVf;
  boolean isStart = false;
  int jus;
  int jut;
  int targetHeight;
  int targetWidth;
  int vQS;
  int vQT;
  a vRb;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.jus = paramInt1;
    this.jut = paramInt2;
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.hVe = 2;
    this.hVf = paramInt7;
    this.vQS = paramInt8;
    this.vQT = paramInt9;
  }
  
  final class a
    extends b
  {
    volatile int hjQ;
    int hwa;
    final Object hwp;
    boolean ivX;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.hwp = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.hwa == -1)
      {
        this.hwa = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hwa) });
      }
      this.hjQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.hwp)
        {
          if (this.ivX) {
            break label193;
          }
          l = bt.HI();
          ad.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.hjQ), false);
          ad.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hjQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.hjQ = i;
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
      long l = bt.HI();
      this.hjQ = MP4MuxerJNI.triggerEncodeForSegmentLock(this.hjQ, true);
      ad.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */