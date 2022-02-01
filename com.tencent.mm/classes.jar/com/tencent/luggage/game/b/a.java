package com.tencent.luggage.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.lang.ref.WeakReference;

public class a
{
  public static final a ciy;
  
  static
  {
    AppMethodBeat.i(130461);
    ciy = new a();
    AppMethodBeat.o(130461);
  }
  
  public void a(MBRuntime paramMBRuntime, final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130460);
    paramAppBrandRuntime = new WeakReference(paramAppBrandRuntime);
    paramMBRuntime = (i)paramMBRuntime.Hp();
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
            paramAnonymousAppBrandRuntime = paramAnonymousAppBrandRuntime.Fl().MP(paramAnonymousString);
            if (paramAnonymousAppBrandRuntime == null) {
              continue;
            }
            paramAnonymousAppBrandRuntime = w.B(paramAnonymousAppBrandRuntime.fTh());
          }
          catch (Exception paramAnonymousAppBrandRuntime)
          {
            ae.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
            continue;
          }
          AppMethodBeat.o(130458);
          return paramAnonymousAppBrandRuntime;
          ae.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramAnonymousString });
          paramAnonymousAppBrandRuntime = localObject;
        }
      }
      
      private static String b(AppBrandRuntime paramAnonymousAppBrandRuntime, String paramAnonymousString)
      {
        AppMethodBeat.i(130459);
        Object localObject = null;
        try
        {
          paramAnonymousAppBrandRuntime = bg.h(paramAnonymousAppBrandRuntime, paramAnonymousString);
          AppMethodBeat.o(130459);
          return paramAnonymousAppBrandRuntime;
        }
        catch (Exception paramAnonymousAppBrandRuntime)
        {
          for (;;)
          {
            ae.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
          }
        }
      }
      
      public final Typeface cL(String paramAnonymousString)
      {
        localObject = null;
        AppMethodBeat.i(130456);
        ae.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramAnonymousString });
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
            ae.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramAnonymousString });
            paramAnonymousString = localObject;
          }
        }
        AppMethodBeat.o(130456);
        return paramAnonymousString;
      }
      
      public final String cM(String paramAnonymousString)
      {
        AppMethodBeat.i(130457);
        ae.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramAnonymousString });
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(130457);
          return null;
        }
        AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)paramAppBrandRuntime.get();
        if (localAppBrandRuntime == null)
        {
          ae.e("MBFontManagerRegistry", "hy: runtime released");
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
    paramMBRuntime.cyS = paramAppBrandRuntime;
    if (paramMBRuntime.czl != null) {
      paramMBRuntime.czl.cyS = paramAppBrandRuntime;
    }
    AppMethodBeat.o(130460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.b.a
 * JD-Core Version:    0.7.0.1
 */