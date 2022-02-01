package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class p
  implements f
{
  public int FbU;
  private int FbV;
  private int FbW;
  private int FbX;
  private int FbY;
  public volatile int frameCount;
  private boolean lhV;
  public boolean lhW;
  private int targetHeight;
  private int targetWidth;
  private long tick;
  private long urt;
  
  public p(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(89576);
    this.FbU = -1;
    this.frameCount = 0;
    this.urt = 0L;
    this.tick = 0L;
    this.FbV = -1;
    this.FbW = -1;
    this.FbX = -1;
    this.FbY = -1;
    this.lhV = paramBoolean1;
    this.FbV = paramInt1;
    this.targetWidth = paramInt2;
    this.targetHeight = paramInt3;
    this.lhW = paramBoolean2;
    Log.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(this.FbV), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89576);
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89581);
    Log.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.FbW = paramInt1;
    this.FbX = paramInt2;
    this.FbY = paramInt3;
    AppMethodBeat.o(89581);
  }
  
  public final int Xc(int paramInt)
  {
    AppMethodBeat.i(89577);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(89577);
      return -1;
    }
    this.FbU = paramInt;
    try
    {
      this.frameCount = 0;
      this.urt = 0L;
      AppMethodBeat.o(89577);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(89577);
    }
  }
  
  public final long aUC()
  {
    AppMethodBeat.i(89580);
    if (0L == this.urt)
    {
      Log.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(89580);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.urt;
    AppMethodBeat.o(89580);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89582);
    SightVideoJNI.releaseBigSightDataBufferLock(this.FbU);
    this.FbU = -1;
    try
    {
      this.frameCount = 0;
      this.urt = 0L;
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
    if (this.FbU < 0)
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
        m = this.FbV;
        bool1 = this.lhV;
        if (bool1) {
          break label348;
        }
        if ((this.FbW == -1) || (this.FbW == this.FbV)) {
          break label342;
        }
        bool1 = true;
        i = this.FbW;
        if (this.FbV <= 180)
        {
          i -= this.FbV;
          m = Math.max(0, i);
          if (m < 360) {
            break label518;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.FbU, m);
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
          if (this.lhW) {
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, k, paramInt2, true);
          }
          SightVideoJNI.writeYuvDataForMMSight(this.FbU, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          Log.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(Util.ticksToNow(this.tick)) });
          AppMethodBeat.o(89579);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(89579);
      }
      i += 360 - this.FbV;
      continue;
      label342:
      boolean bool1 = false;
      continue;
      label348:
      label487:
      label490:
      if (this.FbW == -1)
      {
        i = this.FbV;
      }
      else
      {
        i = this.FbW;
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
    if (0L == this.urt) {
      this.urt = System.currentTimeMillis();
    }
    AppMethodBeat.o(89578);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.urt = 0L;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */