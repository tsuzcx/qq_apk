package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.n;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j hex = new j();
  private static m hey = new m();
  private static int hez = -1;
  
  public static l avQ()
  {
    if (hez == -1) {
      if (!avR()) {
        break label48;
      }
    }
    label48:
    for (hez = 1;; hez = 2) {
      switch (hez)
      {
      default: 
        return hey;
      }
    }
    return hex;
    return hey;
  }
  
  public static boolean avR()
  {
    boolean bool = d.kZ(19);
    ac.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bs.eWk()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream r(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new n((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void s(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      ac.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
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