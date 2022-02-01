package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j gDW = new j();
  private static m gDX = new m();
  private static int gDY = -1;
  
  public static l aoZ()
  {
    if (gDY == -1) {
      if (!apa()) {
        break label48;
      }
    }
    label48:
    for (gDY = 1;; gDY = 2) {
      switch (gDY)
      {
      default: 
        return gDX;
      }
    }
    return gDW;
    return gDX;
  }
  
  public static boolean apa()
  {
    boolean bool = d.lf(19);
    ad.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bt.eGP()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream s(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new n((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void t(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      ad.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
    }
  }
  
  public abstract void C(Bitmap paramBitmap);
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.l
 * JD-Core Version:    0.7.0.1
 */