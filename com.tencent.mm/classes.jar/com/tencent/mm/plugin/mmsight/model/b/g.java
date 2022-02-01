package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
{
  int bitrate;
  int frameCount = 0;
  int frameRate;
  int gNU;
  int gNV;
  int hCA;
  int hCz;
  boolean isStart = false;
  int jbj;
  int jbk;
  int uNJ;
  int uNK;
  a uNS;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.jbj = paramInt1;
    this.jbk = paramInt2;
    this.gNU = paramInt3;
    this.gNV = paramInt4;
    this.bitrate = paramInt5;
    this.frameRate = paramInt6;
    this.hCz = 2;
    this.hCA = paramInt7;
    this.uNJ = paramInt8;
    this.uNK = paramInt9;
  }
  
  final class a
    extends b
  {
    volatile int gRy;
    int hdS;
    final Object heh;
    boolean icB;
    
    private a()
    {
      AppMethodBeat.i(89638);
      this.heh = new Object();
      AppMethodBeat.o(89638);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89639);
      if (this.hdS == -1)
      {
        this.hdS = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ac.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hdS) });
      }
      this.gRy = 0;
      for (;;)
      {
        int i;
        synchronized (this.heh)
        {
          if (this.icB) {
            break label193;
          }
          l = bs.Gn();
          ac.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.gRy), false);
          ac.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gRy;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(10L);
          this.gRy = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89639);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bs.Gn();
      this.gRy = MP4MuxerJNI.triggerEncodeForSegmentLock(this.gRy, true);
      ac.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(89639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.g
 * JD-Core Version:    0.7.0.1
 */