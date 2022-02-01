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
  private static volatile String lQA;
  private static e.a lQB;
  private static final Queue<d> lQx;
  private static final Queue<g> lQy;
  private static volatile String lQz;
  private static final ap mHandler;
  
  static
  {
    AppMethodBeat.i(47567);
    lQx = new ConcurrentLinkedQueue();
    lQy = new ConcurrentLinkedQueue();
    lQz = null;
    lQA = null;
    lQB = e.a.lQC;
    mHandler = new ap("NativeAppBrandPreloader");
    AppMethodBeat.o(47567);
  }
  
  public static void Sj(String paramString)
  {
    try
    {
      lQz = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static d Sk(String paramString)
  {
    AppMethodBeat.i(47563);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(lQz)))
    {
      AppMethodBeat.o(47563);
      return null;
    }
    hc(false);
    lQz = paramString;
    paramString = (d)lQx.poll();
    AppMethodBeat.o(47563);
    return paramString;
  }
  
  public static g Sl(String paramString)
  {
    AppMethodBeat.i(47564);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(lQA)))
    {
      AppMethodBeat.o(47564);
      return null;
    }
    lQA = paramString;
    paramString = (g)lQy.poll();
    AppMethodBeat.o(47564);
    return paramString;
  }
  
  public static void bsB()
  {
    AppMethodBeat.i(47561);
    ad.d("NativeAppBrandPreloader", "preload %b", new Object[] { Boolean.TRUE });
    try
    {
      reset();
      if (lQB == e.a.lQC)
      {
        Object localObject1;
        if (bu.flW())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.vCY;
          if (!com.tencent.mm.plugin.m.a.c.c.djY()) {}
        }
        else
        {
          long l = System.currentTimeMillis();
          FlutterMain.startInitialization(aj.getContext());
          FlutterMain.ensureInitializationComplete(aj.getContext(), new String[0]);
          localObject1 = com.tencent.mm.plugin.m.a.a.c.vCc.fJ(aj.getContext());
          ((a)localObject1).MCm.setInitialRoute("preload");
          if (!((a)localObject1).MCh.MCS)
          {
            System.loadLibrary("wechatlv");
            localObject1 = ((a)localObject1).MCh;
            aj.getContext().getAssets();
            ((DartExecutor)localObject1).a(new DartExecutor.a(FlutterMain.findAppBundlePath(aj.getContext()), "main", (byte)0));
          }
          ad.i("MicroMsg.NativeAppBrandPreloader", "[preloadFlutter] cost:" + (System.currentTimeMillis() - l));
        }
        if (bu.flW())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.vCY;
          if (!com.tencent.mm.plugin.m.a.c.c.djX()) {}
        }
        else
        {
          hc(true);
        }
        lQB = e.a.lQE;
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
    ad.d("MicroMsg.NativeAppBrandPreloader", "preloadNextRuntimeOnUiThreadForNativePageView");
    synchronized (mHandler)
    {
      if (lQx.size() <= 0)
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
          aq.o(local1, l);
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
      lQB = e.a.lQC;
      lQz = null;
      lQx.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.e
 * JD-Core Version:    0.7.0.1
 */