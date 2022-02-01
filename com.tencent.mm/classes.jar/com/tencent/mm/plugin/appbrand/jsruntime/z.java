package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.ah;

public final class z
{
  private static Boolean leO;
  private static Boolean leP;
  private static Boolean leQ;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(205658);
    ac.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(205658);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(205657);
    ac.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(205657);
  }
  
  private static boolean bmB()
  {
    AppMethodBeat.i(205656);
    if (leQ == null) {
      leQ = Boolean.valueOf(((b)g.ab(b.class)).a(b.a.pWU, false));
    }
    boolean bool = leQ.booleanValue();
    AppMethodBeat.o(205656);
    return bool;
  }
  
  private static boolean f(d paramd)
  {
    AppMethodBeat.i(205655);
    if (leP == null) {
      leP = Boolean.valueOf(Boolean.parseBoolean(paramd.aSt().HM("nativeTrans")));
    }
    boolean bool = leP.booleanValue();
    AppMethodBeat.o(205655);
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
        AppMethodBeat.i(205654);
        bool2 = bmB();
        if (leO == null) {
          leO = Boolean.valueOf(ah.fJP());
        }
        bool3 = leO.booleanValue();
        bool4 = f(paramaa);
        if ((bool2) && (bool3) && (bool4))
        {
          h.wUl.dB(1355, 0);
          ac.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(205654);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          h.wUl.dB(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        h.wUl.dB(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          h.wUl.dB(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(205654);
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean o(q paramq)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(205653);
        if (paramq == null)
        {
          h.wUl.dB(1355, 6);
          ac.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(205653);
          return bool1;
        }
        boolean bool2 = f(paramq);
        boolean bool3 = bmB();
        if ((bool3) && (bool2))
        {
          h.wUl.dB(1355, 4);
          ac.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bmB()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(205653);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          h.wUl.dB(1355, 5);
          continue;
        }
        AppMethodBeat.o(205653);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.z
 * JD-Core Version:    0.7.0.1
 */