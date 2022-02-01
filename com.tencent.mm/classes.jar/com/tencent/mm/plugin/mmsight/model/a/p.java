package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class p
  implements f
{
  public volatile int frameCount;
  private int gNU;
  private int gNV;
  private boolean hdT;
  public boolean hdU;
  private long oPI;
  private long uMd;
  public int uNm;
  private int uNn;
  private int uNo;
  private int uNp;
  private int uNq;
  
  public p(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(89576);
    this.uNm = -1;
    this.frameCount = 0;
    this.oPI = 0L;
    this.uMd = 0L;
    this.uNn = -1;
    this.uNo = -1;
    this.uNp = -1;
    this.uNq = -1;
    this.hdT = paramBoolean1;
    this.uNn = paramInt1;
    this.gNU = paramInt2;
    this.gNV = paramInt3;
    this.hdU = paramBoolean2;
    ac.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(this.uNn), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(89576);
  }
  
  public final int IQ(int paramInt)
  {
    AppMethodBeat.i(89577);
    if (paramInt < 0)
    {
      ac.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(89577);
      return -1;
    }
    this.uNm = paramInt;
    try
    {
      this.frameCount = 0;
      this.oPI = 0L;
      AppMethodBeat.o(89577);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(89577);
    }
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89581);
    ac.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNo = paramInt1;
    this.uNp = paramInt2;
    this.uNq = paramInt3;
    AppMethodBeat.o(89581);
  }
  
  public final long aqI()
  {
    AppMethodBeat.i(89580);
    if (0L == this.oPI)
    {
      ac.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(89580);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.oPI;
    AppMethodBeat.o(89580);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89582);
    SightVideoJNI.releaseBigSightDataBufferLock(this.uNm);
    this.uNm = -1;
    try
    {
      this.frameCount = 0;
      this.oPI = 0L;
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
    this.uMd = bs.Gn();
    if (this.uNm < 0)
    {
      ac.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
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
        m = this.uNn;
        bool1 = this.hdT;
        if (bool1) {
          break label348;
        }
        if ((this.uNo == -1) || (this.uNo == this.uNn)) {
          break label342;
        }
        bool1 = true;
        i = this.uNo;
        if (this.uNn <= 180)
        {
          i -= this.uNn;
          m = Math.max(0, i);
          if (m < 360) {
            break label518;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.uNm, m);
          if (!bool1) {
            break label383;
          }
          if ((m != 0) && (m != 180)) {
            break label374;
          }
          i = this.gNU;
          if (!bool1) {
            break label423;
          }
          if ((m != 0) && (m != 180)) {
            break label414;
          }
          j = this.gNV;
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
          if (this.hdU) {
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, k, paramInt2, true);
          }
          SightVideoJNI.writeYuvDataForMMSight(this.uNm, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          ac.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(bs.aO(this.uMd)) });
          AppMethodBeat.o(89579);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(89579);
      }
      i += 360 - this.uNn;
      continue;
      label342:
      boolean bool1 = false;
      continue;
      label348:
      label487:
      label490:
      if (this.uNo == -1)
      {
        i = this.uNn;
      }
      else
      {
        i = this.uNo;
        continue;
        label374:
        i = this.gNV;
        continue;
        label383:
        if ((m == 0) || (m == 180))
        {
          i = this.gNV;
        }
        else
        {
          i = this.gNU;
          continue;
          j = this.gNU;
          continue;
          if ((m == 0) || (m == 180))
          {
            j = this.gNU;
          }
          else
          {
            j = this.gNV;
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
    if (0L == this.oPI) {
      this.oPI = System.currentTimeMillis();
    }
    AppMethodBeat.o(89578);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.oPI = 0L;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */