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

public abstract class k
{
  private static i nNv = new i();
  private static l nNw = new l();
  private static int nNx = -1;
  
  protected static InputStream E(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new FileSeekingInputStream((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  protected static void F(InputStream paramInputStream)
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
  
  public static k bvO()
  {
    if (nNx == -1) {
      if (!bvP()) {
        break label48;
      }
    }
    label48:
    for (nNx = 1;; nNx = 2) {
      switch (nNx)
      {
      default: 
        return nNw;
      }
    }
    return nNv;
    return nNw;
  }
  
  public static boolean bvP()
  {
    boolean bool = d.rb(19);
    Log.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(Util.isART()), Boolean.valueOf(bool) });
    return bool;
  }
  
  public abstract void N(Bitmap paramBitmap);
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.k
 * JD-Core Version:    0.7.0.1
 */