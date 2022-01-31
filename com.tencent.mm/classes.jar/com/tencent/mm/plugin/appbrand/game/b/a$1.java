package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.a.b;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class a$1
  implements b
{
  public a$1(i parami) {}
  
  private static String f(i parami, String paramString)
  {
    try
    {
      parami = parami.Zl().rx(paramString);
      if (parami != null) {
        return parami.getAbsolutePath();
      }
      y.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramString });
      return null;
    }
    catch (Exception parami)
    {
      y.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramString });
    }
    return null;
  }
  
  private static String g(i parami, String paramString)
  {
    try
    {
      parami = aq.e(parami, paramString);
      return parami;
    }
    catch (Exception parami)
    {
      y.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramString });
    }
    return null;
  }
  
  public final Typeface bm(String paramString)
  {
    y.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      Typeface localTypeface = Typeface.createFromFile(paramString);
      return localTypeface;
    }
    catch (Exception localException)
    {
      y.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramString });
    }
    return null;
  }
  
  public final String bn(String paramString)
  {
    y.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      if (paramString.startsWith("wxfile://")) {}
      for (paramString = f(this.gaP, paramString); paramString != null; paramString = g(this.gaP, paramString)) {
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.1
 * JD-Core Version:    0.7.0.1
 */