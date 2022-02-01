package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class p
  implements f
{
  public volatile int frameCount;
  private boolean gDs;
  public boolean gDt;
  private int gnh;
  private int gni;
  private long omi;
  private long tDI;
  public int tER;
  private int tES;
  private int tET;
  private int tEU;
  private int tEV;
  
  public p(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(89576);
    this.tER = -1;
    this.frameCount = 0;
    this.omi = 0L;
    this.tDI = 0L;
    this.tES = -1;
    this.tET = -1;
    this.tEU = -1;
    this.tEV = -1;
    this.gDs = paramBoolean1;
    this.tES = paramInt1;
    this.gnh = paramInt2;
    this.gni = paramInt3;
    this.gDt = paramBoolean2;
    ad.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(this.tES), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89576);
  }
  
  public final int GU(int paramInt)
  {
    AppMethodBeat.i(89577);
    if (paramInt < 0)
    {
      ad.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(89577);
      return -1;
    }
    this.tER = paramInt;
    try
    {
      this.frameCount = 0;
      this.omi = 0L;
      AppMethodBeat.o(89577);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(89577);
    }
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89581);
    ad.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tET = paramInt1;
    this.tEU = paramInt2;
    this.tEV = paramInt3;
    AppMethodBeat.o(89581);
  }
  
  public final long ajJ()
  {
    AppMethodBeat.i(89580);
    if (0L == this.omi)
    {
      ad.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(89580);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.omi;
    AppMethodBeat.o(89580);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89582);
    SightVideoJNI.releaseBigSightDataBufferLock(this.tER);
    this.tER = -1;
    try
    {
      this.frameCount = 0;
      this.omi = 0L;
      AppMethodBeat.o(89582);
      return;
    }
    finally
    {
      AppMethodBeat.o(89582);
    }
  }
  
  public final void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89579);
    this.tDI = bt.GC();
    if (this.tER < 0)
    {
      ad.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
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
        m = this.tES;
        bool1 = this.gDs;
        if (bool1) {
          break label348;
        }
        if ((this.tET == -1) || (this.tET == this.tES)) {
          break label342;
        }
        bool1 = true;
        i = this.tET;
        if (this.tES <= 180)
        {
          i -= this.tES;
          m = Math.max(0, i);
          if (m < 360) {
            break label518;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.tER, m);
          if (!bool1) {
            break label383;
          }
          if ((m != 0) && (m != 180)) {
            break label374;
          }
          i = this.gnh;
          if (!bool1) {
            break label423;
          }
          if ((m != 0) && (m != 180)) {
            break label414;
          }
          j = this.gni;
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
          if (this.gDt) {
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, k, paramInt2, true);
          }
          SightVideoJNI.writeYuvDataForMMSight(this.tER, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          ad.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(bt.aS(this.tDI)) });
          AppMethodBeat.o(89579);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(89579);
      }
      i += 360 - this.tES;
      continue;
      label342:
      boolean bool1 = false;
      continue;
      label348:
      label487:
      label490:
      if (this.tET == -1)
      {
        i = this.tES;
      }
      else
      {
        i = this.tET;
        continue;
        label374:
        i = this.gni;
        continue;
        label383:
        if ((m == 0) || (m == 180))
        {
          i = this.gni;
        }
        else
        {
          i = this.gnh;
          continue;
          j = this.gnh;
          continue;
          if ((m == 0) || (m == 180))
          {
            j = this.gnh;
          }
          else
          {
            j = this.gni;
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
    if (0L == this.omi) {
      this.omi = System.currentTimeMillis();
    }
    AppMethodBeat.o(89578);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.omi = 0L;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */