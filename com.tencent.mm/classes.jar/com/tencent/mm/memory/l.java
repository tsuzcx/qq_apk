package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.p;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j hzt = new j();
  private static m hzu = new m();
  private static int hzv = -1;
  
  public static l ayS()
  {
    if (hzv == -1) {
      if (!ayT()) {
        break label48;
      }
    }
    label48:
    for (hzv = 1;; hzv = 2) {
      switch (hzv)
      {
      default: 
        return hzu;
      }
    }
    return hzt;
    return hzu;
  }
  
  public static boolean ayT()
  {
    boolean bool = d.lA(19);
    ae.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bu.fpP()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream v(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new p((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void w(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      ae.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
    }
  }
  
  public abstract void D(Bitmap paramBitmap);
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.l
 * JD-Core Version:    0.7.0.1
 */