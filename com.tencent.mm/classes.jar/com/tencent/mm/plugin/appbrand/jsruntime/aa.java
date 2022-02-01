package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.ah;

public final class aa
{
  private static Boolean lGm;
  private static Boolean lGn;
  private static Boolean lGo;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(217744);
    ae.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(217744);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(217743);
    ae.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(217743);
  }
  
  private static boolean bqW()
  {
    AppMethodBeat.i(217742);
    if (lGo == null) {
      lGo = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qJr, false));
    }
    boolean bool = lGo.booleanValue();
    AppMethodBeat.o(217742);
    return bool;
  }
  
  public static boolean f(z paramz)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        AppMethodBeat.i(217740);
        bool2 = bqW();
        if (lGm == null) {
          lGm = Boolean.valueOf(ah.gfL());
        }
        bool3 = lGm.booleanValue();
        bool4 = g(paramz);
        if ((bool2) && (bool3) && (bool4))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 0);
          ae.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(217740);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(217740);
          bool1 = false;
        }
      }
    }
  }
  
  private static boolean g(d paramd)
  {
    AppMethodBeat.i(217741);
    if (lGn == null) {
      lGn = Boolean.valueOf(Boolean.parseBoolean(paramd.aWe().LE("nativeTrans")));
    }
    boolean bool = lGn.booleanValue();
    AppMethodBeat.o(217741);
    return bool;
  }
  
  public static boolean o(r paramr)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(217739);
        if (paramr == null)
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 6);
          ae.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(217739);
          return bool1;
        }
        boolean bool2 = g(paramr);
        boolean bool3 = bqW();
        if ((bool3) && (bool2))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 4);
          ae.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bqW()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(217739);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(1355, 5);
          continue;
        }
        AppMethodBeat.o(217739);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.aa
 * JD-Core Version:    0.7.0.1
 */