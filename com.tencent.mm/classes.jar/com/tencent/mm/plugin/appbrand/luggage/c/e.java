package com.tencent.mm.plugin.appbrand.luggage.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
{
  private static final Queue<d> lUY;
  private static final Queue<g> lUZ;
  private static volatile String lVa;
  private static volatile String lVb;
  private static e.a lVc;
  private static final aq mHandler;
  
  static
  {
    AppMethodBeat.i(47567);
    lUY = new ConcurrentLinkedQueue();
    lUZ = new ConcurrentLinkedQueue();
    lVa = null;
    lVb = null;
    lVc = e.a.lVd;
    mHandler = new aq("NativeAppBrandPreloader");
    AppMethodBeat.o(47567);
  }
  
  public static void SS(String paramString)
  {
    try
    {
      lVa = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static d ST(String paramString)
  {
    AppMethodBeat.i(47563);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(lVa)))
    {
      AppMethodBeat.o(47563);
      return null;
    }
    hc(false);
    lVa = paramString;
    paramString = (d)lUY.poll();
    AppMethodBeat.o(47563);
    return paramString;
  }
  
  public static g SU(String paramString)
  {
    AppMethodBeat.i(47564);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(lVb)))
    {
      AppMethodBeat.o(47564);
      return null;
    }
    lVb = paramString;
    paramString = (g)lUZ.poll();
    AppMethodBeat.o(47564);
    return paramString;
  }
  
  public static void btm()
  {
    AppMethodBeat.i(47561);
    ae.d("NativeAppBrandPreloader", "preload %b", new Object[] { Boolean.TRUE });
    try
    {
      reset();
      if (lVc == e.a.lVd)
      {
        Object localObject1;
        if (bv.fpR())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.vPc;
          if (!com.tencent.mm.plugin.m.a.c.c.dmX()) {}
        }
        else
        {
          long l = System.currentTimeMillis();
          FlutterMain.startInitialization(ak.getContext());
          FlutterMain.ensureInitializationComplete(ak.getContext(), new String[0]);
          localObject1 = com.tencent.mm.plugin.m.a.a.c.vOg.fP(ak.getContext());
          ((a)localObject1).MZr.setInitialRoute("preload");
          if (!((a)localObject1).MZm.MZX)
          {
            System.loadLibrary("wechatlv");
            localObject1 = ((a)localObject1).MZm;
            ak.getContext().getAssets();
            ((DartExecutor)localObject1).a(new DartExecutor.a(FlutterMain.findAppBundlePath(ak.getContext()), "main", (byte)0));
          }
          ae.i("MicroMsg.NativeAppBrandPreloader", "[preloadFlutter] cost:" + (System.currentTimeMillis() - l));
        }
        if (bv.fpR())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.vPc;
          if (!com.tencent.mm.plugin.m.a.c.c.dmW()) {}
        }
        else
        {
          hc(true);
        }
        lVc = e.a.lVf;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(47561);
    }
  }
  
  private static void hc(boolean paramBoolean)
  {
    AppMethodBeat.i(47562);
    ae.d("MicroMsg.NativeAppBrandPreloader", "preloadNextRuntimeOnUiThreadForNativePageView");
    synchronized (mHandler)
    {
      if (lUY.size() <= 0)
      {
        Runnable local1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47556);
            try
            {
              e.access$000();
              e.access$100();
              AppMethodBeat.o(47556);
              return;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localException, "preloadNextRuntimeOnUiThreadForNativePageView exception.", new Object[0]);
              AppMethodBeat.o(47556);
              return;
            }
            catch (Error localError)
            {
              ae.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localError, "preloadNextRuntimeOnUiThreadForNativePageView error.", new Object[0]);
              AppMethodBeat.o(47556);
            }
          }
        };
        if (paramBoolean)
        {
          l = 0L;
          ar.o(local1, l);
        }
      }
      else
      {
        AppMethodBeat.o(47562);
        return;
      }
      long l = 3000L;
    }
  }
  
  private static void reset()
  {
    try
    {
      AppMethodBeat.i(47560);
      lVc = e.a.lVd;
      lVa = null;
      lUY.clear();
      AppMethodBeat.o(47560);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.e
 * JD-Core Version:    0.7.0.1
 */