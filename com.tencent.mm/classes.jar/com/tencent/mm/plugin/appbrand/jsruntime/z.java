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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.af;

public final class z
{
  private static Boolean kDw;
  private static Boolean kDx;
  private static Boolean kDy;
  
  public static void a(i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(192563);
    ad.i("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransServiceId. ntrans:' + typeof ntrans + ' componentId :" + paramInt2 + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + paramInt1 + "; }", null);
    AppMethodBeat.o(192563);
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    AppMethodBeat.i(192562);
    ad.i("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", new Object[] { Integer.valueOf(paramInt), paramString, Log.getStackTraceString(new Throwable()) });
    parami.evaluateJavascript("console.log('initNativeTransComponentId. ntrans:' + typeof ntrans + ' componentId :" + paramInt + "')", null);
    parami.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + paramInt + "; }", null);
    AppMethodBeat.o(192562);
  }
  
  private static boolean bfH()
  {
    AppMethodBeat.i(192561);
    if (kDy == null) {
      kDy = Boolean.valueOf(((b)g.ab(b.class)).a(b.a.psL, false));
    }
    boolean bool = kDy.booleanValue();
    AppMethodBeat.o(192561);
    return bool;
  }
  
  private static boolean f(d paramd)
  {
    AppMethodBeat.i(192560);
    if (kDx == null) {
      kDx = Boolean.valueOf(Boolean.parseBoolean(paramd.aLC().DI("nativeTrans")));
    }
    boolean bool = kDx.booleanValue();
    AppMethodBeat.o(192560);
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
        AppMethodBeat.i(192559);
        bool2 = bfH();
        if (kDw == null) {
          kDw = Boolean.valueOf(af.frn());
        }
        bool3 = kDw.booleanValue();
        bool4 = f(paramaa);
        if ((bool2) && (bool3) && (bool4))
        {
          h.vKh.dB(1355, 0);
          ad.i("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!bool2) || (!bool3) || (!bool4)) {
            break label196;
          }
          AppMethodBeat.o(192559);
          return bool1;
        }
        if ((bool2) && (!bool3))
        {
          h.vKh.dB(1355, 1);
          continue;
        }
        if (!bool2) {
          break label170;
        }
      }
      finally {}
      if (!bool4) {
        h.vKh.dB(1355, 2);
      } else {
        label170:
        if ((bool2) && (!bool4) && (!bool3))
        {
          h.vKh.dB(1355, 3);
          continue;
          label196:
          AppMethodBeat.o(192559);
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
        AppMethodBeat.i(192558);
        if (paramq == null)
        {
          h.vKh.dB(1355, 6);
          ad.i("Luggage.NativeTransLogic", "isServiceOpen component null");
          AppMethodBeat.o(192558);
          return bool1;
        }
        boolean bool2 = f(paramq);
        boolean bool3 = bfH();
        if ((bool3) && (bool2))
        {
          h.vKh.dB(1355, 4);
          ad.i("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", new Object[] { Boolean.valueOf(bfH()), Boolean.valueOf(bool2) });
          if ((bool2) && (bool3))
          {
            AppMethodBeat.o(192558);
            bool1 = true;
          }
        }
        else
        {
          if ((!bool3) || (bool2)) {
            continue;
          }
          h.vKh.dB(1355, 5);
          continue;
        }
        AppMethodBeat.o(192558);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.z
 * JD-Core Version:    0.7.0.1
 */