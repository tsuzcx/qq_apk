package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class q
  implements f
{
  public volatile int frameCount;
  private boolean isQ;
  public boolean isR;
  private long qPn;
  private int targetHeight;
  private int targetWidth;
  private long tick;
  public int zwA;
  private int zwB;
  private int zwC;
  private int zwD;
  private int zwE;
  
  public q(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(89576);
    this.zwA = -1;
    this.frameCount = 0;
    this.qPn = 0L;
    this.tick = 0L;
    this.zwB = -1;
    this.zwC = -1;
    this.zwD = -1;
    this.zwE = -1;
    this.isQ = paramBoolean1;
    this.zwB = paramInt1;
    this.targetWidth = paramInt2;
    this.targetHeight = paramInt3;
    this.isR = paramBoolean2;
    Log.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(this.zwB), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89576);
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89581);
    Log.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.zwC = paramInt1;
    this.zwD = paramInt2;
    this.zwE = paramInt3;
    AppMethodBeat.o(89581);
  }
  
  public final int QO(int paramInt)
  {
    AppMethodBeat.i(89577);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(89577);
      return -1;
    }
    this.zwA = paramInt;
    try
    {
      this.frameCount = 0;
      this.qPn = 0L;
      AppMethodBeat.o(89577);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(89577);
    }
  }
  
  public final long aMm()
  {
    AppMethodBeat.i(89580);
    if (0L == this.qPn)
    {
      Log.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(89580);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.qPn;
    AppMethodBeat.o(89580);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89582);
    SightVideoJNI.releaseBigSightDataBufferLock(this.zwA);
    this.zwA = -1;
    try
    {
      this.frameCount = 0;
      this.qPn = 0L;
      AppMethodBeat.o(89582);
      return;
    }
    finally
    {
      AppMethodBeat.o(89582);
    }
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89579);
    this.tick = Util.currentTicks();
    if (this.zwA < 0)
    {
      Log.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
      AppMethodBeat.o(89579);
      return;
    }
    label414:
    label423:
    label454:
    label461:
    for (;;)
    {
      int m;
      int i;
      int j;
      int k;
      boolean bool2;
      try
      {
        this.frameCount += 1;
        m = this.zwB;
        bool1 = this.isQ;
        if (bool1) {
          break label348;
        }
        if ((this.zwC == -1) || (this.zwC == this.zwB)) {
          break label342;
        }
        bool1 = true;
        i = this.zwC;
        if (this.zwB <= 180)
        {
          i -= this.zwB;
          m = Math.max(0, i);
          if (m < 360) {
            break label518;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.zwA, m);
          if (!bool1) {
            break label383;
          }
          if ((m != 0) && (m != 180)) {
            break label374;
          }
          i = this.targetWidth;
          if (!bool1) {
            break label423;
          }
          if ((m != 0) && (m != 180)) {
            break label414;
          }
          j = this.targetHeight;
          if (!bool1) {
            break label461;
          }
          if ((m != 0) && (m != 180)) {
            break label454;
          }
          k = paramInt2;
          if (!bool1) {
            break label490;
          }
          if ((m != 0) && (m != 180)) {
            break label487;
          }
          paramInt2 = paramInt3;
          if ((k != i) || (paramInt2 != j)) {
            break label512;
          }
          bool2 = false;
          if (this.isR) {
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, k, paramInt2, true);
          }
          SightVideoJNI.writeYuvDataForMMSight(this.zwA, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          Log.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(Util.ticksToNow(this.tick)) });
          AppMethodBeat.o(89579);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(89579);
      }
      i += 360 - this.zwB;
      continue;
      label342:
      boolean bool1 = false;
      continue;
      label348:
      label487:
      label490:
      if (this.zwC == -1)
      {
        i = this.zwB;
      }
      else
      {
        i = this.zwC;
        continue;
        label374:
        i = this.targetHeight;
        continue;
        label383:
        if ((m == 0) || (m == 180))
        {
          i = this.targetHeight;
        }
        else
        {
          i = this.targetWidth;
          continue;
          j = this.targetWidth;
          continue;
          if ((m == 0) || (m == 180))
          {
            j = this.targetWidth;
          }
          else
          {
            j = this.targetHeight;
            continue;
            k = paramInt3;
            continue;
            if ((m == 0) || (m == 180))
            {
              k = paramInt3;
            }
            else
            {
              k = paramInt2;
              continue;
              continue;
              if ((m == 0) || (m != 180))
              {
                paramInt2 = paramInt3;
                continue;
                bool2 = true;
                continue;
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(89578);
    if (0L == this.qPn) {
      this.qPn = System.currentTimeMillis();
    }
    AppMethodBeat.o(89578);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.qPn = 0L;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.q
 * JD-Core Version:    0.7.0.1
 */