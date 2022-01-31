package com.tencent.mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.mm.sdk.platformtools.y;

public class PathExtractor
{
  private long dBN;
  private String filePath;
  
  static
  {
    System.loadLibrary("fontdecode");
  }
  
  public PathExtractor(String paramString)
  {
    this.filePath = paramString;
    this.dBN = nInit(paramString);
    if (this.dBN != 0L)
    {
      y.i("MicroMsg.PathExtractor", "create for %s, %d", new Object[] { paramString, Long.valueOf(this.dBN) });
      return;
    }
    y.e("MicroMsg.PathExtractor", "create for %s failed", new Object[] { paramString });
  }
  
  private static native boolean nExtractPath(long paramLong, char paramChar, Path paramPath, int[] paramArrayOfInt);
  
  private static native void nFinalize(long paramLong);
  
  private static native void nGetMetrics(long paramLong, Metrics paramMetrics);
  
  private static native long nInit(String paramString);
  
  private static native void nSetTextSize(long paramLong, int paramInt);
  
  public final void a(Metrics paramMetrics)
  {
    if (paramMetrics == null)
    {
      y.w("MicroMsg.PathExtractor", "metrics is null");
      return;
    }
    nGetMetrics(this.dBN, paramMetrics);
    paramMetrics.height *= 0.015625F;
    paramMetrics.ascender *= 0.015625F;
    paramMetrics.descender *= 0.015625F;
  }
  
  public final boolean a(char paramChar, Path paramPath, RectF paramRectF)
  {
    int[] arrayOfInt = new int[4];
    try
    {
      bool = nExtractPath(this.dBN, paramChar, paramPath, arrayOfInt);
      if (bool)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.015625F, 0.015625F);
        paramPath.transform(localMatrix);
        paramRectF.set(arrayOfInt[0] * 0.015625F, arrayOfInt[3] * 0.015625F, arrayOfInt[2] * 0.015625F, arrayOfInt[1] * 0.015625F);
        y.i("MicroMsg.PathExtractor", "load path for " + paramChar);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PathExtractor", "extract path error %c", new Object[] { Character.valueOf(paramChar) });
        boolean bool = false;
      }
      y.w("MicroMsg.PathExtractor", "not such char " + paramChar);
    }
    return false;
  }
  
  protected void finalize()
  {
    try
    {
      nFinalize(this.dBN);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final boolean isValid()
  {
    return this.dBN != 0L;
  }
  
  public final void setTextSize(int paramInt)
  {
    y.i("MicroMsg.PathExtractor", "set text size %d, %d", new Object[] { Long.valueOf(this.dBN), Integer.valueOf(paramInt) });
    nSetTextSize(this.dBN, paramInt);
  }
  
  @Keep
  public static class Metrics
  {
    public float ascender;
    public float descender;
    public float height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.fontdecode.PathExtractor
 * JD-Core Version:    0.7.0.1
 */