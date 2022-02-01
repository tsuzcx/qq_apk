package com.tencent.mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class PathExtractor
{
  private long fTS;
  private String filePath;
  
  static
  {
    AppMethodBeat.i(145549);
    System.loadLibrary("fontdecode");
    AppMethodBeat.o(145549);
  }
  
  public PathExtractor(String paramString)
  {
    AppMethodBeat.i(145544);
    this.filePath = paramString;
    this.fTS = nInit(paramString);
    if (this.fTS != 0L)
    {
      ad.i("MicroMsg.PathExtractor", "create for %s, %d", new Object[] { paramString, Long.valueOf(this.fTS) });
      AppMethodBeat.o(145544);
      return;
    }
    ad.e("MicroMsg.PathExtractor", "create for %s failed", new Object[] { paramString });
    AppMethodBeat.o(145544);
  }
  
  private static native boolean nExtractPath(long paramLong, char paramChar, Path paramPath, int[] paramArrayOfInt);
  
  private static native void nFinalize(long paramLong);
  
  private static native void nGetMetrics(long paramLong, Metrics paramMetrics);
  
  private static native long nInit(String paramString);
  
  private static native void nSetTextSize(long paramLong, int paramInt);
  
  public final void a(Metrics paramMetrics)
  {
    AppMethodBeat.i(145546);
    if (paramMetrics == null)
    {
      ad.w("MicroMsg.PathExtractor", "metrics is null");
      AppMethodBeat.o(145546);
      return;
    }
    nGetMetrics(this.fTS, paramMetrics);
    paramMetrics.height *= 0.015625F;
    paramMetrics.ascender *= 0.015625F;
    paramMetrics.descender *= 0.015625F;
    AppMethodBeat.o(145546);
  }
  
  public final boolean a(char paramChar, Path paramPath, RectF paramRectF)
  {
    AppMethodBeat.i(145547);
    int[] arrayOfInt = new int[4];
    try
    {
      bool = nExtractPath(this.fTS, paramChar, paramPath, arrayOfInt);
      if (bool)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.015625F, 0.015625F);
        paramPath.transform(localMatrix);
        paramRectF.set(arrayOfInt[0] * 0.015625F, arrayOfInt[3] * 0.015625F, arrayOfInt[2] * 0.015625F, arrayOfInt[1] * 0.015625F);
        ad.i("MicroMsg.PathExtractor", "load path for ".concat(String.valueOf(paramChar)));
        AppMethodBeat.o(145547);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.PathExtractor", "extract path error %c", new Object[] { Character.valueOf(paramChar) });
        boolean bool = false;
      }
      ad.w("MicroMsg.PathExtractor", "not such char ".concat(String.valueOf(paramChar)));
      AppMethodBeat.o(145547);
    }
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(145548);
    try
    {
      nFinalize(this.fTS);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(145548);
    }
  }
  
  public final boolean isValid()
  {
    return this.fTS != 0L;
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(145545);
    ad.i("MicroMsg.PathExtractor", "set text size %d, %d", new Object[] { Long.valueOf(this.fTS), Integer.valueOf(paramInt) });
    nSetTextSize(this.fTS, paramInt);
    AppMethodBeat.o(145545);
  }
  
  @Keep
  public static class Metrics
  {
    public float ascender;
    public float descender;
    public float height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.fontdecode.PathExtractor
 * JD-Core Version:    0.7.0.1
 */