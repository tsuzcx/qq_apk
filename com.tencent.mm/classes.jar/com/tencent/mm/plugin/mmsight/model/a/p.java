package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class p
  implements f
{
  private int eRu;
  private int eRv;
  private boolean fdl;
  public volatile int frameCount;
  private long mwM;
  private long oIA;
  public int oJG;
  private int oJH;
  private int oJI;
  private int oJJ;
  private int oJK;
  
  public p(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76663);
    this.oJG = -1;
    this.frameCount = 0;
    this.mwM = 0L;
    this.oIA = 0L;
    this.oJH = -1;
    this.oJI = -1;
    this.oJJ = -1;
    this.oJK = -1;
    this.fdl = paramBoolean;
    this.oJH = paramInt1;
    this.eRu = paramInt2;
    this.eRv = paramInt3;
    ab.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.oJH), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(76663);
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140134);
    ab.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.oJI = paramInt1;
    this.oJJ = paramInt2;
    this.oJK = paramInt3;
    AppMethodBeat.o(140134);
  }
  
  public final long UQ()
  {
    AppMethodBeat.i(76665);
    if (0L == this.mwM)
    {
      ab.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      AppMethodBeat.o(76665);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.mwM;
    AppMethodBeat.o(76665);
    return l1 - l2;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(76666);
    SightVideoJNI.releaseBigSightDataBufferLock(this.oJG);
    this.oJG = -1;
    try
    {
      this.frameCount = 0;
      this.mwM = 0L;
      AppMethodBeat.o(76666);
      return;
    }
    finally
    {
      AppMethodBeat.o(76666);
    }
  }
  
  public final void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140133);
    this.oIA = bo.yB();
    if (this.oJG < 0)
    {
      ab.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
      AppMethodBeat.o(140133);
      return;
    }
    label399:
    label408:
    label439:
    label446:
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
        m = this.oJH;
        bool1 = this.fdl;
        if (bool1) {
          break label333;
        }
        if ((this.oJI == -1) || (this.oJI == this.oJH)) {
          break label327;
        }
        bool1 = true;
        i = this.oJI;
        if (this.oJH <= 180)
        {
          i -= this.oJH;
          m = Math.max(0, i);
          if (m < 360) {
            break label503;
          }
          i = 0;
          m = i;
          SightVideoJNI.setRotateForBufId(this.oJG, m);
          if (!bool1) {
            break label368;
          }
          if ((m != 0) && (m != 180)) {
            break label359;
          }
          i = this.eRu;
          if (!bool1) {
            break label408;
          }
          if ((m != 0) && (m != 180)) {
            break label399;
          }
          j = this.eRv;
          if (!bool1) {
            break label446;
          }
          if ((m != 0) && (m != 180)) {
            break label439;
          }
          k = paramInt2;
          if (!bool1) {
            break label475;
          }
          if ((m != 0) && (m != 180)) {
            break label472;
          }
          paramInt2 = paramInt3;
          if ((k != i) || (paramInt2 != j)) {
            break label497;
          }
          bool2 = false;
          SightVideoJNI.writeYuvDataForMMSight(this.oJG, paramArrayOfByte, paramInt1, i, j, bool1, bool2, k, paramInt2);
          ab.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[] { Long.valueOf(bo.av(this.oIA)) });
          AppMethodBeat.o(140133);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(140133);
      }
      i += 360 - this.oJH;
      continue;
      label327:
      boolean bool1 = false;
      continue;
      label333:
      label472:
      label475:
      if (this.oJI == -1)
      {
        i = this.oJH;
      }
      else
      {
        i = this.oJI;
        continue;
        label359:
        i = this.eRv;
        continue;
        label368:
        if ((m == 0) || (m == 180))
        {
          i = this.eRv;
        }
        else
        {
          i = this.eRu;
          continue;
          j = this.eRu;
          continue;
          if ((m == 0) || (m == 180))
          {
            j = this.eRu;
          }
          else
          {
            j = this.eRv;
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
                label497:
                bool2 = true;
                continue;
                label503:
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
    AppMethodBeat.i(140132);
    if (0L == this.mwM) {
      this.mwM = System.currentTimeMillis();
    }
    AppMethodBeat.o(140132);
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.mwM = 0L;
      return;
    }
    finally {}
  }
  
  public final int zt(int paramInt)
  {
    AppMethodBeat.i(76664);
    if (paramInt < 0)
    {
      ab.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      AppMethodBeat.o(76664);
      return -1;
    }
    this.oJG = paramInt;
    try
    {
      this.frameCount = 0;
      this.mwM = 0L;
      AppMethodBeat.o(76664);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(76664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */