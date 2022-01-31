package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.k;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class p
{
  private static Class<?> bxe = null;
  private static Application bxf;
  private static Resources bxg;
  private static String mPackageName = null;
  
  public static void a(Application paramApplication, Resources paramResources)
  {
    e.d(paramApplication, mPackageName);
    bxf = paramApplication;
    bxg = paramResources;
  }
  
  public static void cq(String paramString)
  {
    mPackageName = paramString;
  }
  
  public static void n(Class<?> paramClass)
  {
    bxe = paramClass;
  }
  
  public static void tb()
  {
    boolean bool = true;
    y.i("MicroMsg.SVGInit", "SVG initSVGPreload");
    e.a(new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        y.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        y.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        y.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        y.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
      }
    });
    e.n(bxe);
    e.a(bxf, bxg, mPackageName);
    Object localObject1 = bxf;
    for (;;)
    {
      try
      {
        localObject1 = ((Application)localObject1).getBaseContext().getResources().getDrawable(R.k.actionbar_icon);
        if (localObject1 != null)
        {
          i = 1;
          localObject1 = b.ED();
          if (i == 0)
          {
            ((b)localObject1).dNl = bool;
            return;
          }
          bool = false;
          continue;
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        y.printErrStackTrace("MicroMsg.SVGInit", localThrowable, "not support get svg from application context", new Object[0]);
        return;
      }
      finally
      {
        b.ED().dNl = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.p
 * JD-Core Version:    0.7.0.1
 */