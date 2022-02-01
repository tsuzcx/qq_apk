package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.xweb.aj;

public final class aa
{
  private static Boolean pOO;
  private static Boolean pOP;
  private static Boolean pOQ;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(217410);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(217410);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(217409);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(217409);
  }
  
  private static boolean bYZ()
  {
    AppMethodBeat.i(217408);
    if (pOQ == null) {
      pOQ = Boolean.valueOf(((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vOD, false));
    }
    boolean bool = pOQ.booleanValue();
    AppMethodBeat.o(217408);
    return bool;
  }
  
  public static boolean f(ad paramad)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        AppMethodBeat.i(217405);
        bool2 = bYZ();
        if (pOO == null) {
          pOO = Boolean.valueOf(aj.iwL());
        }
        bool3 = pOO.booleanValue();
        bool4 = h(paramad);
        if ((bool2) && (bool3) && (bool4))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 0);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(217405);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(217405);
          bool1 = false;
        }
      }
    }
  }
  
  private static boolean h(g paramg)
  {
    AppMethodBeat.i(217406);
    if (pOP == null) {
      pOP = Boolean.valueOf(Boolean.parseBoolean(paramg.bBP().acx("nativeTrans")));
    }
    boolean bool = pOP.booleanValue();
    AppMethodBeat.o(217406);
    return bool;
  }
  
  public static boolean r(v paramv)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(217404);
        if (paramv == null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 6);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(217404);
          return bool1;
        }
        boolean bool2 = h(paramv);
        boolean bool3 = bYZ();
        if ((bool3) && (bool2))
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 4);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bYZ()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(217404);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1355, 5);
          continue;
        }
        AppMethodBeat.o(217404);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.aa
 * JD-Core Version:    0.7.0.1
 */