package com.tencent.mm.plugin.appbrand.luggage.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
{
  private static final Queue<d> lrn;
  private static final Queue<g> lro;
  private static volatile String lrp;
  private static volatile String lrq;
  private static e.a lrr;
  private static final ao mHandler;
  
  static
  {
    AppMethodBeat.i(47567);
    lrn = new ConcurrentLinkedQueue();
    lro = new ConcurrentLinkedQueue();
    lrp = null;
    lrq = null;
    lrr = e.a.lrs;
    mHandler = new ao("NativeAppBrandPreloader");
    AppMethodBeat.o(47567);
  }
  
  public static void OG(String paramString)
  {
    try
    {
      lrp = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static d OH(String paramString)
  {
    AppMethodBeat.i(47563);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals(lrp)))
    {
      AppMethodBeat.o(47563);
      return null;
    }
    gT(false);
    lrp = paramString;
    paramString = (d)lrn.poll();
    AppMethodBeat.o(47563);
    return paramString;
  }
  
  public static g OI(String paramString)
  {
    AppMethodBeat.i(47564);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals(lrq)))
    {
      AppMethodBeat.o(47564);
      return null;
    }
    lrq = paramString;
    paramString = (g)lro.poll();
    AppMethodBeat.o(47564);
    return paramString;
  }
  
  public static void boC()
  {
    AppMethodBeat.i(47561);
    ac.d("NativeAppBrandPreloader", "preload %b", new Object[] { Boolean.TRUE });
    try
    {
      reset();
      if (lrr == e.a.lrs)
      {
        Object localObject1;
        if (bt.eWm())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.uAv;
          if (!com.tencent.mm.plugin.m.a.c.c.daL()) {}
        }
        else
        {
          long l = System.currentTimeMillis();
          FlutterMain.startInitialization(ai.getContext());
          FlutterMain.ensureInitializationComplete(ai.getContext(), new String[0]);
          localObject1 = com.tencent.mm.plugin.m.a.a.c.uzz.fE(ai.getContext());
          ((a)localObject1).KLp.setInitialRoute("preload");
          if (!((a)localObject1).KLk.KLV)
          {
            System.loadLibrary("wechatlv");
            localObject1 = ((a)localObject1).KLk;
            ai.getContext().getAssets();
            ((DartExecutor)localObject1).a(new DartExecutor.a(FlutterMain.findAppBundlePath(ai.getContext()), "main", (byte)0));
          }
          ac.i("MicroMsg.NativeAppBrandPreloader", "[preloadFlutter] cost:" + (System.currentTimeMillis() - l));
        }
        if (bt.eWm())
        {
          localObject1 = com.tencent.mm.plugin.m.a.c.c.uAv;
          if (!com.tencent.mm.plugin.m.a.c.c.daK()) {}
        }
        else
        {
          gT(true);
        }
        lrr = e.a.lru;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(47561);
    }
  }
  
  private static void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(47562);
    ac.d("MicroMsg.NativeAppBrandPreloader", "preloadNextRuntimeOnUiThreadForNativePageView");
    synchronized (mHandler)
    {
      if (lrn.size() <= 0)
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
              ac.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localException, "preloadNextRuntimeOnUiThreadForNativePageView exception.", new Object[0]);
              AppMethodBeat.o(47556);
              return;
            }
            catch (Error localError)
            {
              ac.printErrStackTrace("MicroMsg.NativeAppBrandPreloader", localError, "preloadNextRuntimeOnUiThreadForNativePageView error.", new Object[0]);
              AppMethodBeat.o(47556);
            }
          }
        };
        if (paramBoolean)
        {
          l = 0L;
          ap.n(local1, l);
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
      lrr = e.a.lrs;
      lrp = null;
      lrn.clear();
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