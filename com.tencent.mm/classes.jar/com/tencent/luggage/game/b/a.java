package com.tencent.luggage.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;

public class a
{
  public static final a cbh;
  
  static
  {
    AppMethodBeat.i(130461);
    cbh = new a();
    AppMethodBeat.o(130461);
  }
  
  public void a(MBRuntime paramMBRuntime, final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130460);
    paramAppBrandRuntime = new WeakReference(paramAppBrandRuntime);
    paramMBRuntime = (h)paramMBRuntime.Gd();
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
            paramAnonymousAppBrandRuntime = paramAnonymousAppBrandRuntime.Ee().EP(paramAnonymousString);
            if (paramAnonymousAppBrandRuntime == null) {
              continue;
            }
            paramAnonymousAppBrandRuntime = q.B(paramAnonymousAppBrandRuntime.fhU());
          }
          catch (Exception paramAnonymousAppBrandRuntime)
          {
            ad.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
            continue;
          }
          AppMethodBeat.o(130458);
          return paramAnonymousAppBrandRuntime;
          ad.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramAnonymousString });
          paramAnonymousAppBrandRuntime = localObject;
        }
      }
      
      private static String b(AppBrandRuntime paramAnonymousAppBrandRuntime, String paramAnonymousString)
      {
        AppMethodBeat.i(130459);
        Object localObject = null;
        try
        {
          paramAnonymousAppBrandRuntime = be.h(paramAnonymousAppBrandRuntime, paramAnonymousString);
          AppMethodBeat.o(130459);
          return paramAnonymousAppBrandRuntime;
        }
        catch (Exception paramAnonymousAppBrandRuntime)
        {
          for (;;)
          {
            ad.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramAnonymousString });
            paramAnonymousAppBrandRuntime = localObject;
          }
        }
      }
      
      public final Typeface ca(String paramAnonymousString)
      {
        localObject = null;
        AppMethodBeat.i(130456);
        ad.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramAnonymousString });
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
            ad.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramAnonymousString });
            paramAnonymousString = localObject;
          }
        }
        AppMethodBeat.o(130456);
        return paramAnonymousString;
      }
      
      public final String cb(String paramAnonymousString)
      {
        AppMethodBeat.i(130457);
        ad.i("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramAnonymousString });
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(130457);
          return null;
        }
        AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)paramAppBrandRuntime.get();
        if (localAppBrandRuntime == null)
        {
          ad.e("MBFontManagerRegistry", "hy: runtime released");
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
    paramMBRuntime.cqy = paramAppBrandRuntime;
    if (paramMBRuntime.cqP != null) {
      paramMBRuntime.cqP.cqy = paramAppBrandRuntime;
    }
    AppMethodBeat.o(130460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.a
 * JD-Core Version:    0.7.0.1
 */