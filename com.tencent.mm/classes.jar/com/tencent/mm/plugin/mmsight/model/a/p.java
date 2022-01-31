package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.y;

public class p
  implements f
{
  int eIB;
  int eIC;
  volatile int frameCount = 0;
  long ibp = 0L;
  boolean mhL;
  long mit = 0L;
  int mkq = -1;
  int mkr = -1;
  int mks = -1;
  int mkt = -1;
  int mku = -1;
  
  public p(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mhL = paramBoolean;
    this.mkr = paramInt1;
    this.eIB = paramInt2;
    this.eIC = paramInt3;
    y.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mkr), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public final long bjH()
  {
    if (0L == this.ibp)
    {
      y.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
      return 0L;
    }
    return System.currentTimeMillis() - this.ibp;
  }
  
  public final void stop()
  {
    try
    {
      this.frameCount = 0;
      this.ibp = 0L;
      return;
    }
    finally {}
  }
  
  public final int ue(int paramInt)
  {
    if (paramInt < 0)
    {
      y.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
      return -1;
    }
    this.mkq = paramInt;
    try
    {
      this.frameCount = 0;
      this.ibp = 0L;
      return 0;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.p
 * JD-Core Version:    0.7.0.1
 */