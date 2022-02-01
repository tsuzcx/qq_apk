package com.tencent.luggage.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;

public class a
{
  public static final a ekq;
  
  static
  {
    AppMethodBeat.i(130461);
    ekq = new a();
    AppMethodBeat.o(130461);
  }
  
  public void a(MBRuntime paramMBRuntime, final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130460);
    paramAppBrandRuntime = new WeakReference(paramAppBrandRuntime);
    paramMBRuntime = (i)paramMBRuntime.avr();
    paramAppBrandRuntime = new b()
    {
      private static String a(AppBrandRuntime paramAnonymousAppBrandRuntime, String paramAnonymousString)
      {
        AppMethodBeat.i(130458);
        localObject = null;
        for (;;)
        {
          try
          {
            paramAnonymousAppBrandRuntime = paramAnonymousAppBrandRuntime.getFileSystem().Wm(paramAnonymousString);
            if (paramAnonymousAppBrandRuntime == null) {
              continue;
            }
            paramAnonymousAppBrandRuntime = ah.v(paramAnonymousAppBrandRuntime.jKT());
          }
          catch (Exception paramAnonymousAppBrandRuntime)
          {
            Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
            continue;
          }
          AppMethodBeat.o(130458);
          return paramAnonymousAppBrandRuntime;
          Log.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramAnonymousString });
          paramAnonymousAppBrandRuntime = localObject;
        }
      }
      
      private static String b(AppBrandRuntime paramAnonymousAppBrandRuntime, String paramAnonymousString)
      {
        AppMethodBeat.i(130459);
        Object localObject = null;
        try
        {
          paramAnonymousAppBrandRuntime = bl.h(paramAnonymousAppBrandRuntime, paramAnonymousString);
          AppMethodBeat.o(130459);
          return paramAnonymousAppBrandRuntime;
        }
        catch (Exception paramAnonymousAppBrandRuntime)
        {
          for (;;)
          {
            Log.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
          }
        }
      }
      
      public final Typeface eM(String paramAnonymousString)
      {
        localObject = null;
        AppMethodBeat.i(130456);
        Log.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramAnonymousString });
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(130456);
          return null;
        }
        try
        {
          Typeface localTypeface = Typeface.createFromFile(paramAnonymousString);
          paramAnonymousString = localTypeface;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramAnonymousString });
            paramAnonymousString = localObject;
          }
        }
        AppMethodBeat.o(130456);
        return paramAnonymousString;
      }
      
      public final String eN(String paramAnonymousString)
      {
        AppMethodBeat.i(130457);
        Log.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramAnonymousString });
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(130457);
          return null;
        }
        AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)paramAppBrandRuntime.get();
        if (localAppBrandRuntime == null)
        {
          Log.e("MBFontManagerRegistry", "hy: runtime released");
          AppMethodBeat.o(130457);
          return null;
        }
        if (paramAnonymousString.startsWith("wxfile://")) {}
        for (paramAnonymousString = a(localAppBrandRuntime, paramAnonymousString); paramAnonymousString == null; paramAnonymousString = b(localAppBrandRuntime, paramAnonymousString))
        {
          AppMethodBeat.o(130457);
          return null;
        }
        AppMethodBeat.o(130457);
        return paramAnonymousString;
      }
    };
    paramMBRuntime.eJi = paramAppBrandRuntime;
    if (paramMBRuntime.eJB != null) {
      paramMBRuntime.eJB.eJi = paramAppBrandRuntime;
    }
    AppMethodBeat.o(130460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.a
 * JD-Core Version:    0.7.0.1
 */