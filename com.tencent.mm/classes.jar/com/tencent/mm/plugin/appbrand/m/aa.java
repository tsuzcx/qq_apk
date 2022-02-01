package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.ah;

public final class aa
{
  private static Boolean mNW;
  private static Boolean mNX;
  private static Boolean mNY;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(204369);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(204369);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(204368);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(204368);
  }
  
  private static boolean bMI()
  {
    AppMethodBeat.i(204367);
    if (mNY == null) {
      mNY = Boolean.valueOf(((b)g.af(b.class)).a(b.a.seT, false));
    }
    boolean bool = mNY.booleanValue();
    AppMethodBeat.o(204367);
    return bool;
  }
  
  public static boolean f(ac paramac)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        AppMethodBeat.i(204365);
        bool2 = bMI();
        if (mNW == null) {
          mNW = Boolean.valueOf(ah.htd());
        }
        bool3 = mNW.booleanValue();
        bool4 = g(paramac);
        if ((bool2) && (bool3) && (bool4))
        {
          h.CyF.dN(1355, 0);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(204365);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          h.CyF.dN(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        h.CyF.dN(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          h.CyF.dN(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(204365);
          bool1 = false;
        }
      }
    }
  }
  
  private static boolean g(d paramd)
  {
    AppMethodBeat.i(204366);
    if (mNX == null) {
      mNX = Boolean.valueOf(Boolean.parseBoolean(paramd.bqZ().UN("nativeTrans")));
    }
    boolean bool = mNX.booleanValue();
    AppMethodBeat.o(204366);
    return bool;
  }
  
  public static boolean q(s params)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(204364);
        if (params == null)
        {
          h.CyF.dN(1355, 6);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(204364);
          return bool1;
        }
        boolean bool2 = g(params);
        boolean bool3 = bMI();
        if ((bool3) && (bool2))
        {
          h.CyF.dN(1355, 4);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bMI()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(204364);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          h.CyF.dN(1355, 5);
          continue;
        }
        AppMethodBeat.o(204364);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.aa
 * JD-Core Version:    0.7.0.1
 */