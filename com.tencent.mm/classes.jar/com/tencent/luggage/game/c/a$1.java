package com.tencent.luggage.game.c;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.lang.ref.WeakReference;

final class a$1
  implements b
{
  a$1(a parama, WeakReference paramWeakReference) {}
  
  private static String a(i parami, String paramString)
  {
    AppMethodBeat.i(140335);
    localObject = null;
    for (;;)
    {
      try
      {
        parami = parami.wX().zg(paramString);
        if (parami == null) {
          continue;
        }
        parami = parami.getAbsolutePath();
      }
      catch (Exception parami)
      {
        ab.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramString });
        parami = localObject;
        continue;
      }
      AppMethodBeat.o(140335);
      return parami;
      ab.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramString });
      parami = localObject;
    }
  }
  
  private static String b(i parami, String paramString)
  {
    AppMethodBeat.i(140336);
    Object localObject = null;
    try
    {
      parami = ax.g(parami, paramString);
      AppMethodBeat.o(140336);
      return parami;
    }
    catch (Exception parami)
    {
      for (;;)
      {
        ab.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramString });
        parami = localObject;
      }
    }
  }
  
  public final Typeface bJ(String paramString)
  {
    localObject = null;
    AppMethodBeat.i(140333);
    ab.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140333);
      return null;
    }
    try
    {
      Typeface localTypeface = Typeface.createFromFile(paramString);
      paramString = localTypeface;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramString });
        paramString = localObject;
      }
    }
    AppMethodBeat.o(140333);
    return paramString;
  }
  
  public final String bK(String paramString)
  {
    AppMethodBeat.i(140334);
    ab.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140334);
      return null;
    }
    i locali = (i)this.bzU.get();
    if (locali == null)
    {
      ab.e("MBFontManagerRegistry", "hy: runtime released");
      AppMethodBeat.o(140334);
      return null;
    }
    if (paramString.startsWith("wxfile://")) {}
    for (paramString = a(locali, paramString); paramString == null; paramString = b(locali, paramString))
    {
      AppMethodBeat.o(140334);
      return null;
    }
    AppMethodBeat.o(140334);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.c.a.1
 * JD-Core Version:    0.7.0.1
 */