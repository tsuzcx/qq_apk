package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class p
  implements f
{
  public int KXD;
  private int KXE;
  private int KXF;
  private int KXG;
  private int KXH;
  public volatile int frameCount;
  private boolean nME;
  public boolean nMF;
  private int nxO;
  private int nxP;
  private long tick;
  private long xxO;
  
  public p(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(89576);
    this.KXD = -1;
    this.frameCount = 0;
    this.xxO = 0L;
    this.tick = 0L;
    this.KXE = -1;
    this.KXF = -1;
    this.KXG = -1;
    this.KXH = -1;
    this.nME = paramBoolean1;
    this.KXE = paramInt1;
    this.nxO = paramInt2;
    this.nxP = paramInt3;
    this.nMF = paramBoolean2;
    Log.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(this.KXE), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89576);
  }
  
  public final int abe(int paramInt)
  {
    AppMethodBeat.i(89577);
    if (paramInt < 0)
    {
      Log.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(89577);
      return -1;
    }
    this.KXD = paramInt;
    try
    {
      this.frameCount = 0;
      this.xxO = 0L;
      AppMethodBeat.o(89577);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(89577);
    }
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89581);
    Log.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.KXF = paramInt1;
    this.KXG = paramInt2;
    this.KXH = paramInt3;
    AppMethodBeat.o(89581);
  }
  
  public final long bpj()
  {
    AppMethodBeat.i(89580);
    if (0L == this.xxO)
    {
      Log.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(89580);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.xxO;
    AppMethodBeat.o(89580);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89582);
    SightVideoJNI.releaseBigSightDataBufferLock(this.KXD);
    this.KXD = -1;
    try
    {
      this.frameCount = 0;
      this.xxO = 0L;
      AppMethodBeat.o(89582);
      return;
    }
    finally
    {
      AppMethodBeat.o(89582);
    }
  }
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89579);
    this.tick = Util.currentTicks();
    if (this.KXD < 0)
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
        m = this.KXE;
        bool1 = this.nME;
        if (bool1) {
          break label348;
        }
        if ((this.KXF == -1) || (this.KXF == this.KXE)) {
          break label342;
        }
        bool1 = true;
        i = this.KXF;
        if (this.KXE <= 180)
        {
          i -= this.KXE;
          m = Math.max(0, i);
          if (m < 360) {
            break label518;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.KXD, m);
          if (!bool1) {
            break label383;
          }
          if ((m != 0) && (m != 180)) {
            break label374;
          }
          i = this.nxO;
          if (!bool1) {
            break label423;
          }
          if ((m != 0) && (m != 180)) {
            break label414;
          }
          j = this.nxP;
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
          if (this.nMF) {
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, k, paramInt2, true);
          }
          SightVideoJNI.writeYuvDataForMMSight(this.KXD, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          Log.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(Util.ticksToNow(this.tick)) });
          AppMethodBeat.o(89579);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(89579);
      }
      i += 360 - this.KXE;
      continue;
      label342:
      boolean bool1 = false;
      continue;
      label348:
      label487:
      label490:
      if (this.KXF == -1)
      {
        i = this.KXE;
      }
      else
      {
        i = this.KXF;
        continue;
        label374:
        i = this.nxP;
        continue;
        label383:
        if ((m == 0) || (m == 180))
        {
          i = this.nxP;
        }
        else
        {
          i = this.nxO;
          continue;
          j = this.nxO;
          continue;
          if ((m == 0) || (m == 180))
          {
            j = this.nxO;
          }
          else
          {
            j = this.nxP;
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
    if (0L == this.xxO) {
      this.xxO = System.currentTimeMillis();
    }
    AppMethodBeat.o(89578);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.xxO = 0L;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */