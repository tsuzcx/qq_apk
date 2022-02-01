package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  a FcA;
  int Fcr;
  int Fcs;
  int bitrate;
  int frameCount = 0;
  int frameRate;
  boolean isStart = false;
  int lJm;
  int lJn;
  int nqW;
  int nqX;
  int targetHeight;
  int targetWidth;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.nqW = paramInt1;
    this.nqX = paramInt2;
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.lJm = 2;
    this.lJn = paramInt7;
    this.Fcr = paramInt8;
    this.Fcs = paramInt9;
  }
  
  final class a
    extends b
  {
    volatile int kUo;
    int lhU;
    final Object lik;
    boolean mjI;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.lik = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.lhU == -1)
      {
        this.lhU = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.lhU) });
      }
      this.kUo = 0;
      for (;;)
      {
        int i;
        synchronized (this.lik)
        {
          if (this.mjI) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.kUo), false);
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.kUo;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.kUo = i;
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
      this.kUo = MP4MuxerJNI.triggerEncodeForSegmentLock(this.kUo, true);
      Log.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */