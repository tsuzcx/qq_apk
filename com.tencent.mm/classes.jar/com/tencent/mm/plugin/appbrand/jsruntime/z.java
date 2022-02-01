package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.ah;

public final class z
{
  private static Boolean lBN;
  private static Boolean lBO;
  private static Boolean lBP;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(217135);
    ad.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(217135);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(217134);
    ad.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(217134);
  }
  
  private static boolean bqm()
  {
    AppMethodBeat.i(217133);
    if (lBP == null) {
      lBP = Boolean.valueOf(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBW, false));
    }
    boolean bool = lBP.booleanValue();
    AppMethodBeat.o(217133);
    return bool;
  }
  
  public static boolean f(aa paramaa)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        AppMethodBeat.i(217131);
        bool2 = bqm();
        if (lBN == null) {
          lBN = Boolean.valueOf(ah.gbj());
        }
        bool3 = lBN.booleanValue();
        bool4 = g(paramaa);
        if ((bool2) && (bool3) && (bool4))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 0);
          ad.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(217131);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(217131);
          bool1 = false;
        }
      }
    }
  }
  
  private static boolean g(d paramd)
  {
    AppMethodBeat.i(217132);
    if (lBO == null) {
      lBO = Boolean.valueOf(Boolean.parseBoolean(paramd.aVF().Le("nativeTrans")));
    }
    boolean bool = lBO.booleanValue();
    AppMethodBeat.o(217132);
    return bool;
  }
  
  public static boolean o(q paramq)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(217130);
        if (paramq == null)
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 6);
          ad.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(217130);
          return bool1;
        }
        boolean bool2 = g(paramq);
        boolean bool3 = bqm();
        if ((bool3) && (bool2))
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 4);
          ad.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bqm()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(217130);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          com.tencent.mm.plugin.report.service.g.yhR.dD(1355, 5);
          continue;
        }
        AppMethodBeat.o(217130);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.z
 * JD-Core Version:    0.7.0.1
 */