package com.tencent.luggage.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;

final class a$1
  implements b
{
  a$1(a parama, WeakReference paramWeakReference) {}
  
  private static String a(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(130458);
    localObject = null;
    for (;;)
    {
      try
      {
        paramAppBrandRuntime = paramAppBrandRuntime.getFileSystem().adL(paramString);
        if (paramAppBrandRuntime == null) {
          continue;
        }
        paramAppBrandRuntime = paramAppBrandRuntime.bOF();
      }
      catch (Exception paramAppBrandRuntime)
      {
        Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramString });
        paramAppBrandRuntime = localObject;
        continue;
      }
      AppMethodBeat.o(130458);
      return paramAppBrandRuntime;
      Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramString });
      paramAppBrandRuntime = localObject;
    }
  }
  
  private static String b(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(130459);
    Object localObject = null;
    try
    {
      paramAppBrandRuntime = bl.h(paramAppBrandRuntime, paramString);
      AppMethodBeat.o(130459);
      return paramAppBrandRuntime;
    }
    catch (Exception paramAppBrandRuntime)
    {
      for (;;)
      {
        Log.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramString });
        paramAppBrandRuntime = localObject;
      }
    }
  }
  
  public final Typeface dB(String paramString)
  {
    localObject = null;
    AppMethodBeat.i(130456);
    Log.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(130456);
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
        Log.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramString });
        paramString = localObject;
      }
    }
    AppMethodBeat.o(130456);
    return paramString;
  }
  
  public final String dC(String paramString)
  {
    AppMethodBeat.i(130457);
    Log.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(130457);
      return null;
    }
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.csx.get();
    if (localAppBrandRuntime == null)
    {
      Log.e("MBFontManagerRegistry", "hy: runtime released");
      AppMethodBeat.o(130457);
      return null;
    }
    if (paramString.startsWith("wxfile://")) {}
    for (paramString = a(localAppBrandRuntime, paramString); paramString == null; paramString = b(localAppBrandRuntime, paramString))
    {
      AppMethodBeat.o(130457);
      return null;
    }
    AppMethodBeat.o(130457);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.1
 * JD-Core Version:    0.7.0.1
 */