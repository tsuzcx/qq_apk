package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class ab
{
  private static Class<?> cVS = null;
  private static Application cVT;
  private static String mPackageName = null;
  private static Resources sResources;
  
  public static void Mv()
  {
    boolean bool = true;
    AppMethodBeat.i(19470);
    ae.i("MicroMsg.SVGInit", "SVG initSVGPreload");
    e.a(new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(19468);
        ae.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(19468);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(19467);
        ae.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(19467);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(19466);
        ae.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(19466);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(19469);
        ae.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(19469);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(19465);
        ae.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(19465);
      }
    });
    e.Y(cVS);
    e.a(cVT, sResources, mPackageName);
    Object localObject1 = cVT;
    for (;;)
    {
      try
      {
        localObject1 = ((Application)localObject1).getBaseContext().getResources().getDrawable(2131689487);
        if (localObject1 != null)
        {
          i = 1;
          localObject1 = b.akR();
          if (i == 0)
          {
            ((b)localObject1).gGZ = bool;
            AppMethodBeat.o(19470);
            return;
          }
          bool = false;
          continue;
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.SVGInit", localThrowable, "not support get svg from application context", new Object[0]);
        return;
      }
      finally
      {
        b.akR().gGZ = true;
        AppMethodBeat.o(19470);
      }
    }
  }
  
  public static void Y(Class<?> paramClass)
  {
    cVS = paramClass;
  }
  
  public static void a(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(19471);
    e.c(paramApplication, mPackageName);
    cVT = paramApplication;
    sResources = paramResources;
    AppMethodBeat.o(19471);
  }
  
  public static void fz(String paramString)
  {
    mPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ab
 * JD-Core Version:    0.7.0.1
 */