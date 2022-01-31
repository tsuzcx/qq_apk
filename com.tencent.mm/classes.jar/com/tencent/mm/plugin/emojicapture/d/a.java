package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.PTBeauty;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.PTFilter.PTCopyFilter;
import com.tencent.ttpic.PTSmoothSkin;
import com.tencent.ttpic.baseutils.SourcePathUtil;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;

public final class a
{
  public static float jjQ = 180.0F;
  private boolean dBn = false;
  public PTSmoothSkin jjR;
  public PTFilter.PTCopyFilter jjS;
  public PTBeauty jjT;
  public PTFilter.PTCopyFilter jjU;
  public int jjV;
  public int jjW;
  public int jjX;
  public int jjY;
  public int jjZ;
  public int jka;
  private boolean[] jkb = new boolean[7];
  public byte[] jkc;
  public int jkd;
  public int jke;
  
  public final void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    int i = 1;
    int j = 0;
    if (this.jjT != null) {
      this.jjT.setBeautyParam(paramTYPE, paramInt);
    }
    switch (a.1.jkf[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (;;)
      {
        paramTYPE[0] = i;
        return;
        i = 0;
      }
    case 2: 
      paramTYPE = this.jkb;
      i = j;
      if (paramInt != 0) {
        i = 1;
      }
      paramTYPE[1] = i;
      return;
    case 3: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = k;; i = 0)
      {
        paramTYPE[2] = i;
        return;
      }
    case 4: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = m;; i = 0)
      {
        paramTYPE[3] = i;
        return;
      }
    case 5: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = n;; i = 0)
      {
        paramTYPE[4] = i;
        return;
      }
    case 6: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = i1;; i = 0)
      {
        paramTYPE[5] = i;
        return;
      }
    }
    paramTYPE = this.jkb;
    if (paramInt != 0) {}
    for (i = i2;; i = 0)
    {
      paramTYPE[6] = i;
      return;
    }
  }
  
  public final boolean aJX()
  {
    return ((this.jkb[0] | this.jkb[1] | this.jkb[2] | this.jkb[3] | this.jkb[4] | this.jkb[5] | this.jkb[6]) != 0) && (SourcePathUtil.isLoadBeautySo());
  }
  
  public final void clear()
  {
    y.i("MicroMsg.EmojiFilterProcess", "clear %s %d", new Object[] { this, Long.valueOf(Thread.currentThread().getId()) });
    try
    {
      if (this.jjR != null)
      {
        this.jjR.destroy();
        this.jjR = null;
      }
      if (this.jjT != null)
      {
        this.jjT.destroy();
        this.jjT = null;
      }
      if (this.jjS != null)
      {
        this.jjS.destroy();
        this.jjS = null;
      }
      if (this.jjU != null)
      {
        this.jjU.destroy();
        this.jjU = null;
      }
      PTFaceDetector.getInstance().destroy();
      GLES20.glDeleteTextures(4, new int[] { this.jjX, this.jjY, this.jjZ, this.jka }, 0);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.EmojiFilterProcess", localException, "clear error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void setupSmoothLevel(int paramInt)
  {
    if (this.jjR != null) {
      this.jjR.setBeautyLevel(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */