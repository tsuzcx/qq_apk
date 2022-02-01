package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.ao;

public final class aa
{
  private static Boolean sTn;
  private static Boolean sTo;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(319116);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(319116);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(319111);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, android.util.Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(319111);
  }
  
  public static boolean f(ad paramad)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      try
      {
        AppMethodBeat.i(319101);
        if (sTn == null) {
          sTn = Boolean.valueOf(ao.aJB(2009));
        }
        bool2 = sTn.booleanValue();
        bool3 = g(paramad);
        if ((bool2) && (bool3))
        {
          h.OAn.kJ(1355, 0);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.TRUE, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((!bool2) || (!bool3)) {
            break label168;
          }
          AppMethodBeat.o(319101);
          return bool1;
        }
        if (!bool2)
        {
          h.OAn.kJ(1355, 1);
          continue;
        }
        if (bool3) {
          break label147;
        }
      }
      finally {}
      h.OAn.kJ(1355, 2);
      continue;
      label147:
      if ((!bool3) && (!bool2))
      {
        h.OAn.kJ(1355, 3);
        continue;
        label168:
        AppMethodBeat.o(319101);
        bool1 = false;
      }
    }
  }
  
  private static boolean g(g paramg)
  {
    AppMethodBeat.i(319105);
    if (sTo == null) {
      sTo = Boolean.valueOf(Boolean.parseBoolean(paramg.cbl().UX("nativeTrans")));
    }
    boolean bool = sTo.booleanValue();
    AppMethodBeat.o(319105);
    return bool;
  }
  
  public static boolean r(y paramy)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(319098);
        if (paramy == null)
        {
          h.OAn.kJ(1355, 6);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(319098);
          return bool1;
        }
        boolean bool2 = g(paramy);
        if (bool2)
        {
          h.OAn.kJ(1355, 4);
          com.tencent.mm.sdk.platformtools.Log.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.TRUE, Boolean.valueOf(bool2) });
          if (bool2)
          {
            AppMethodBeat.o(319098);
            bool1 = true;
          }
        }
        else
        {
          if (bool2) {
            continue;
          }
          h.OAn.kJ(1355, 5);
          continue;
        }
        AppMethodBeat.o(319098);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.aa
 * JD-Core Version:    0.7.0.1
 */