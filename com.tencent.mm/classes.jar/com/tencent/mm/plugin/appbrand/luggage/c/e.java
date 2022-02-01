package com.tencent.mm.plugin.appbrand.luggage.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
{
  private static final Queue<d> kPO;
  private static final Queue<g> kPP;
  private static volatile String kPQ;
  private static volatile String kPR;
  private static e.a kPS;
  private static final ap mHandler;
  
  static
  {
    AppMethodBeat.i(47567);
    kPO = new ConcurrentLinkedQueue();
    kPP = new ConcurrentLinkedQueue();
    kPQ = null;
    kPR = null;
    kPS = e.a.kPT;
    mHandler = new ap("NativeAppBrandPreloader");
    AppMethodBeat.o(47567);
  }
  
  public static d KA(String paramString)
  {
    AppMethodBeat.i(47563);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(kPQ)))
    {
      AppMethodBeat.o(47563);
      return null;
    }
    gw(false);
    kPQ = paramString;
    paramString = (d)kPO.poll();
    AppMethodBeat.o(47563);
    return paramString;
  }
  
  public static g KB(String paramString)
  {
    AppMethodBeat.i(47564);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(kPR)))
    {
      AppMethodBeat.o(47564);
      return null;
    }
    kPR = paramString;
    paramString = (g)kPP.poll();
    AppMethodBeat.o(47564);
    return paramString;
  }
  
  public static void Kz(String paramString)
  {
    try
    {
      kPQ = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void bhI()
  {
    AppMethodBeat.i(47561);
    ad.d("NativeAppBrandPreloader", "preload %b", new Object[] { Boolean.TRUE });
    try
    {
      reset();
      if (kPS == e.a.kPT)
      {
        Object localObject1;
        if (bu.eGR())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.tsc;
          if (!com.tencent.mm.plugin.m.a.c.c.cNe()) {}
        }
        else
        {
          long l = System.currentTimeMillis();
          FlutterMain.startInitialization(aj.getContext());
          FlutterMain.ensureInitializationComplete(aj.getContext(), new String[0]);
          localObject1 = com.tencent.mm.plugin.m.a.a.c.trh.fs(aj.getContext());
          ((a)localObject1).IYk.setInitialRoute("preload");
          if (!((a)localObject1).IYe.IYQ)
          {
            System.loadLibrary("wechatlv");
            localObject1 = ((a)localObject1).IYe;
            aj.getContext().getAssets();
            ((DartExecutor)localObject1).a(new DartExecutor.a(FlutterMain.findAppBundlePath(aj.getContext()), "main", (byte)0));
          }
          ad.i("MicroMsg.NativeAppBrandPreloader", "[preloadFlutter] cost:" + (System.currentTimeMillis() - l));
        }
        if (bu.eGR())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.tsc;
          if (!com.tencent.mm.plugin.m.a.c.c.cNd()) {}
        }
        else
        {
          gw(true);
        }
        kPS = e.a.kPV;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(47561);
    }
  }
  
  private static void gw(boolean paramBoolean)
  {
    AppMethodBeat.i(47562);
    ad.d("MicroMsg.NativeAppBrandPreloader", "preloadNextRuntimeOnUiThreadForNativePageView");
    synchronized (mHandler)
    {
      if (kPO.size() <= 0)
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
              ad.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localException, "preloadNextRuntimeOnUiThreadForNativePageView exception.", new Object[0]);
              AppMethodBeat.o(47556);
              return;
            }
            catch (Error localError)
            {
              ad.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localError, "preloadNextRuntimeOnUiThreadForNativePageView error.", new Object[0]);
              AppMethodBeat.o(47556);
            }
          }
        };
        if (paramBoolean)
        {
          l = 0L;
          aq.n(local1, l);
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
      kPS = e.a.kPT;
      kPQ = null;
      kPO.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.e
 * JD-Core Version:    0.7.0.1
 */