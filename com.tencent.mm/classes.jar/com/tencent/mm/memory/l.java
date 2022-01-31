package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j dPe = new j();
  private static m dPf = new m();
  private static int dPg = -1;
  
  public static l Fb()
  {
    if (dPg == -1) {
      if (!Fc()) {
        break label48;
      }
    }
    label48:
    for (dPg = 1;; dPg = 2) {
      switch (dPg)
      {
      default: 
        return dPf;
      }
    }
    return dPe;
    return dPf;
  }
  
  public static boolean Fc()
  {
    boolean bool = d.gF(19);
    y.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bk.csc()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream m(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new i((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void n(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      y.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
    }
  }
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger);
  
  public abstract void n(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.l
 * JD-Core Version:    0.7.0.1
 */