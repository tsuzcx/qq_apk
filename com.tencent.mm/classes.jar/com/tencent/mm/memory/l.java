package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j fdL = new j();
  private static m fdM = new m();
  private static int fdN = -1;
  
  public static l XQ()
  {
    if (fdN == -1) {
      if (!XR()) {
        break label48;
      }
    }
    label48:
    for (fdN = 1;; fdN = 2) {
      switch (fdN)
      {
      default: 
        return fdM;
      }
    }
    return fdL;
    return fdM;
  }
  
  public static boolean XR()
  {
    boolean bool = d.fv(19);
    ab.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bo.dtZ()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream p(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new com.tencent.mm.sdk.platformtools.l((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void q(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      ab.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
    }
  }
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions);
  
  public abstract void u(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.l
 * JD-Core Version:    0.7.0.1
 */