package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.preload.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  int mxH;
  final Class myA;
  final Class myB;
  final Class myC;
  final Class myD;
  final LinkedHashMap<String, Integer> myE;
  final LinkedHashMap<String, AppBrandRemoteTaskController> myF;
  e myG;
  long myH;
  AtomicBoolean myI;
  final String myw;
  final Class<? extends Activity> myx;
  final String myy;
  private final Class myz;
  
  i(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5)
  {
    AppMethodBeat.i(48475);
    this.myE = new LinkedHashMap();
    this.myF = new LinkedHashMap();
    this.myG = e.myi;
    this.mxH = -1;
    this.myH = 0L;
    this.myI = new AtomicBoolean(false);
    this.myw = paramClass.getName();
    this.myx = paramClass;
    this.myz = paramClass1;
    this.myA = paramClass2;
    this.myB = paramClass3;
    this.myy = aH(this.myx);
    this.myC = paramClass4;
    this.myD = paramClass5;
    AppMethodBeat.o(48475);
  }
  
  private static String aH(Class<?> paramClass)
  {
    AppMethodBeat.i(48481);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(48481);
      return null;
    }
    try
    {
      paramClass = localPackageManager.getActivityInfo(new ComponentName(aj.getContext(), paramClass), 128).processName;
      AppMethodBeat.o(48481);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(48481);
    }
    return null;
  }
  
  void OE()
  {
    AppMethodBeat.i(48477);
    vv(2);
    AppMethodBeat.o(48477);
  }
  
  final Integer UJ(String paramString)
  {
    AppMethodBeat.i(48479);
    paramString = (Integer)this.myE.get(paramString);
    AppMethodBeat.o(48479);
    return paramString;
  }
  
  final AppBrandRemoteTaskController UK(String paramString)
  {
    AppMethodBeat.i(48480);
    paramString = (AppBrandRemoteTaskController)this.myF.get(paramString);
    AppMethodBeat.o(48480);
    return paramString;
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48478);
    this.myE.put(paramString, Integer.valueOf(paramInt));
    this.myF.put(paramString, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(48478);
  }
  
  protected boolean b(e parame)
  {
    return true;
  }
  
  public final e byK()
  {
    return this.myG;
  }
  
  public final Class byL()
  {
    return this.myC;
  }
  
  final void l(e parame)
  {
    AppMethodBeat.i(48476);
    if (!b(parame))
    {
      parame = new IllegalStateException("AppBrandUITask not support this type. [" + parame.name() + "]");
      AppMethodBeat.o(48476);
      throw parame;
    }
    this.myG = parame;
    AppMethodBeat.o(48476);
  }
  
  final void vv(int paramInt)
  {
    AppMethodBeat.i(188791);
    if (this.myz == null)
    {
      AppMethodBeat.o(188791);
      return;
    }
    j.byM();
    try
    {
      Intent localIntent = new Intent(aj.getContext(), this.myC);
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.byp();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      localIntent.putExtra("EXTRA_KEY_UI_CLASS", this.myw);
      localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt);
      localIntent.addFlags(268435456);
      localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
      this.myG.K(localIntent);
      if (!this.myI.get()) {
        h.a(this.myy, new m()
        {
          public final void ahC()
          {
            AppMethodBeat.i(188788);
            h.b(i.this.myy, this);
            long l;
            if (i.this.myE.isEmpty())
            {
              l = (int)((SystemClock.elapsedRealtime() - i.this.myH) / 1000L);
              if (l < 0L) {
                break label238;
              }
              if (l > 60L) {
                break label121;
              }
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 6L, 1L, false);
              ad.i("MicroMsg.AppBrandUITask", "onDied: name = [%s], alive = [%d]seconds", new Object[] { i.this.myy, Long.valueOf(l) });
            }
            for (;;)
            {
              i.this.myI.set(false);
              AppMethodBeat.o(188788);
              return;
              label121:
              if (l <= 120L)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 7L, 1L, false);
                break;
              }
              if (l <= 300L)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 8L, 1L, false);
                break;
              }
              if (l <= 600L)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 9L, 1L, false);
                break;
              }
              if (l <= 1200L)
              {
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 10L, 1L, false);
                break;
              }
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(365L, 11L, 1L, false);
              break;
              label238:
              ad.e("MicroMsg.AppBrandUITask", "onDied: name = [%s], got a invalid time", new Object[] { i.this.myy });
            }
          }
        });
      }
      for (;;)
      {
        this.myI.set(true);
        XIPCInvoker.a(this.myy, localIntent, c.class, new com.tencent.mm.ipcinvoker.e()
        {
          public final void ahw()
          {
            AppMethodBeat.i(188789);
            ad.i("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", new Object[] { i.this.myy });
            i.this.myI.set(false);
            AppMethodBeat.o(188789);
          }
        });
        AppMethodBeat.o(188791);
        return;
        ad.i("MicroMsg.AppBrandUITask", "preload: name = [%s], had bound!", new Object[] { this.myy });
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(188791);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */