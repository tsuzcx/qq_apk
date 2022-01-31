package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class s
{
  private static Class<?> bYU = null;
  private static Application bYV;
  private static String mPackageName = null;
  private static Resources sResources;
  
  public static void A(Class<?> paramClass)
  {
    bYU = paramClass;
  }
  
  public static void By()
  {
    boolean bool = true;
    AppMethodBeat.i(15396);
    ab.i("MicroMsg.SVGInit", "SVG initSVGPreload");
    e.a(new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(15394);
        ab.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(15394);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(15393);
        ab.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(15393);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(15392);
        ab.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(15392);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(15395);
        ab.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(15395);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(156056);
        ab.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(156056);
      }
    });
    e.A(bYU);
    e.a(bYV, sResources, mPackageName);
    Object localObject1 = bYV;
    for (;;)
    {
      try
      {
        localObject1 = ((Application)localObject1).getBaseContext().getResources().getDrawable(2131230734);
        if (localObject1 != null)
        {
          i = 1;
          localObject1 = b.SH();
          if (i == 0)
          {
            ((b)localObject1).eKV = bool;
            AppMethodBeat.o(15396);
            return;
          }
          bool = false;
          continue;
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.SVGInit", localThrowable, "not support get svg from application context", new Object[0]);
        return;
      }
      finally
      {
        b.SH().eKV = true;
        AppMethodBeat.o(15396);
      }
    }
  }
  
  public static void a(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(15397);
    e.d(paramApplication, mPackageName);
    bYV = paramApplication;
    sResources = paramResources;
    AppMethodBeat.o(15397);
  }
  
  public static void dC(String paramString)
  {
    mPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.s
 * JD-Core Version:    0.7.0.1
 */