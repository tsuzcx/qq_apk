package com.tencent.mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class PathExtractor
{
  private long eze;
  private String filePath;
  
  static
  {
    AppMethodBeat.i(114793);
    System.loadLibrary("fontdecode");
    AppMethodBeat.o(114793);
  }
  
  public PathExtractor(String paramString)
  {
    AppMethodBeat.i(114788);
    this.filePath = paramString;
    this.eze = nInit(paramString);
    if (this.eze != 0L)
    {
      ab.i("MicroMsg.PathExtractor", "create for %s, %d", new Object[] { paramString, Long.valueOf(this.eze) });
      AppMethodBeat.o(114788);
      return;
    }
    ab.e("MicroMsg.PathExtractor", "create for %s failed", new Object[] { paramString });
    AppMethodBeat.o(114788);
  }
  
  private static native boolean nExtractPath(long paramLong, char paramChar, Path paramPath, int[] paramArrayOfInt);
  
  private static native void nFinalize(long paramLong);
  
  private static native void nGetMetrics(long paramLong, Metrics paramMetrics);
  
  private static native long nInit(String paramString);
  
  private static native void nSetTextSize(long paramLong, int paramInt);
  
  public final void a(Metrics paramMetrics)
  {
    AppMethodBeat.i(114790);
    if (paramMetrics == null)
    {
      ab.w("MicroMsg.PathExtractor", "metrics is null");
      AppMethodBeat.o(114790);
      return;
    }
    nGetMetrics(this.eze, paramMetrics);
    paramMetrics.height *= 0.015625F;
    paramMetrics.ascender *= 0.015625F;
    paramMetrics.descender *= 0.015625F;
    AppMethodBeat.o(114790);
  }
  
  public final boolean a(char paramChar, Path paramPath, RectF paramRectF)
  {
    AppMethodBeat.i(114791);
    int[] arrayOfInt = new int[4];
    try
    {
      bool = nExtractPath(this.eze, paramChar, paramPath, arrayOfInt);
      if (bool)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.015625F, 0.015625F);
        paramPath.transform(localMatrix);
        paramRectF.set(arrayOfInt[0] * 0.015625F, arrayOfInt[3] * 0.015625F, arrayOfInt[2] * 0.015625F, arrayOfInt[1] * 0.015625F);
        ab.i("MicroMsg.PathExtractor", "load path for ".concat(String.valueOf(paramChar)));
        AppMethodBeat.o(114791);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.PathExtractor", "extract path error %c", new Object[] { Character.valueOf(paramChar) });
        boolean bool = false;
      }
      ab.w("MicroMsg.PathExtractor", "not such char ".concat(String.valueOf(paramChar)));
      AppMethodBeat.o(114791);
    }
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(114792);
    try
    {
      nFinalize(this.eze);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(114792);
    }
  }
  
  public final boolean isValid()
  {
    return this.eze != 0L;
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(114789);
    ab.i("MicroMsg.PathExtractor", "set text size %d, %d", new Object[] { Long.valueOf(this.eze), Integer.valueOf(paramInt) });
    nSetTextSize(this.eze, paramInt);
    AppMethodBeat.o(114789);
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