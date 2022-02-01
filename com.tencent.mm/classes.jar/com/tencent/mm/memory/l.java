package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.FileSeekingInputStream;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static j itB = new j();
  private static m itC = new m();
  private static int itD = -1;
  
  public static l aRY()
  {
    if (itD == -1) {
      if (!aRZ()) {
        break label48;
      }
    }
    label48:
    for (itD = 1;; itD = 2) {
      switch (itD)
      {
      default: 
        return itC;
      }
    }
    return itB;
    return itC;
  }
  
  public static boolean aRZ()
  {
    boolean bool = d.oD(19);
    Log.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(Util.isART()), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected static InputStream u(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new FileSeekingInputStream((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void v(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.reset();
      return;
    }
    catch (Exception paramInputStream)
    {
      Log.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
    }
  }
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions);
  
  public abstract void x(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.l
 * JD-Core Version:    0.7.0.1
 */