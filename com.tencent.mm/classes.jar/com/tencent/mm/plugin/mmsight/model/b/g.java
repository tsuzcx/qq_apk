package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  int bitrate;
  int frameCount = 0;
  int frameRate;
  int iSU;
  int iSV;
  boolean isStart = false;
  int kxW;
  int kxX;
  int targetHeight;
  int targetWidth;
  int zwX;
  int zwY;
  a zxg;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.kxW = paramInt1;
    this.kxX = paramInt2;
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.iSU = 2;
    this.iSV = paramInt7;
    this.zwX = paramInt8;
    this.zwY = paramInt9;
  }
  
  final class a
    extends b
  {
    volatile int ifA;
    int isP;
    final Object ite;
    boolean jue;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.ite = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.isP == -1)
      {
        this.isP = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.isP) });
      }
      this.ifA = 0;
      for (;;)
      {
        int i;
        synchronized (this.ite)
        {
          if (this.jue) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.ifA), false);
          Log.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.ifA;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.ifA = i;
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
      this.ifA = MP4MuxerJNI.triggerEncodeForSegmentLock(this.ifA, true);
      Log.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */