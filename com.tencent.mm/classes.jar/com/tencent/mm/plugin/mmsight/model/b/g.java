package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i.b;

public final class g
{
  int KYa;
  int KYb;
  a KYj;
  int bitrate;
  int frameCount = 0;
  int frameRate;
  boolean isStart = false;
  int nxO;
  int nxP;
  int oBO;
  int oBP;
  int qpD;
  int qpE;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.qpD = paramInt1;
    this.qpE = paramInt2;
    this.nxO = paramInt3;
    this.nxP = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.oBO = 2;
    this.oBP = paramInt7;
    this.KYa = paramInt8;
    this.KYb = paramInt9;
  }
  
  final class a
    extends b
  {
    int nMD;
    final Object nMT;
    volatile int nzX;
    boolean pdf;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.nMT = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.nMD == -1)
      {
        this.nMD = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.nMD) });
      }
      this.nzX = 0;
      for (;;)
      {
        int i;
        synchronized (this.nMT)
        {
          if (this.pdf) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.nzX), false);
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.nzX;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.nzX = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89639);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = Util.currentTicks();
      this.nzX = MP4MuxerJNI.triggerEncodeForSegmentLock(this.nzX, true);
      Log.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */