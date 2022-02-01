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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  int lXS;
  final String lYG;
  final Class<? extends Activity> lYH;
  final String lYI;
  private final Class lYJ;
  final Class lYK;
  final Class lYL;
  final Class lYM;
  final Class lYN;
  final LinkedHashMap<String, Integer> lYO;
  final LinkedHashMap<String, AppBrandRemoteTaskController> lYP;
  e lYQ;
  long lYR;
  AtomicBoolean lYS;
  
  i(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5)
  {
    AppMethodBeat.i(48475);
    this.lYO = new LinkedHashMap();
    this.lYP = new LinkedHashMap();
    this.lYQ = e.lYt;
    this.lXS = -1;
    this.lYR = 0L;
    this.lYS = new AtomicBoolean(false);
    this.lYG = paramClass.getName();
    this.lYH = paramClass;
    this.lYJ = paramClass1;
    this.lYK = paramClass2;
    this.lYL = paramClass3;
    this.lYI = aH(this.lYH);
    this.lYM = paramClass4;
    this.lYN = paramClass5;
    AppMethodBeat.o(48475);
  }
  
  private static String aH(Class<?> paramClass)
  {
    AppMethodBeat.i(48481);
    PackageManager localPackageManager = ai.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(48481);
      return null;
    }
    try
    {
      paramClass = localPackageManager.getActivityInfo(new ComponentName(ai.getContext(), paramClass), 128).processName;
      AppMethodBeat.o(48481);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(48481);
    }
    return null;
  }
  
  void MV()
  {
    AppMethodBeat.i(48477);
    uQ(2);
    AppMethodBeat.o(48477);
  }
  
  final Integer Rd(String paramString)
  {
    AppMethodBeat.i(48479);
    paramString = (Integer)this.lYO.get(paramString);
    AppMethodBeat.o(48479);
    return paramString;
  }
  
  final AppBrandRemoteTaskController Re(String paramString)
  {
    AppMethodBeat.i(48480);
    paramString = (AppBrandRemoteTaskController)this.lYP.get(paramString);
    AppMethodBeat.o(48480);
    return paramString;
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48478);
    this.lYO.put(paramString, Integer.valueOf(paramInt));
    this.lYP.put(paramString, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(48478);
  }
  
  protected boolean b(e parame)
  {
    return true;
  }
  
  public final e buG()
  {
    return this.lYQ;
  }
  
  public final Class buH()
  {
    return this.lYM;
  }
  
  final void i(e parame)
  {
    AppMethodBeat.i(48476);
    if (!b(parame))
    {
      parame = new IllegalStateException("AppBrandUITask not support this type. [" + parame.name() + "]");
      AppMethodBeat.o(48476);
      throw parame;
    }
    this.lYQ = parame;
    AppMethodBeat.o(48476);
  }
  
  final void uQ(int paramInt)
  {
    AppMethodBeat.i(186980);
    if (this.lYJ == null)
    {
      AppMethodBeat.o(186980);
      return;
    }
    j.buI();
    try
    {
      Intent localIntent = new Intent(ai.getContext(), this.lYM);
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.buk();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      localIntent.putExtra("EXTRA_KEY_UI_CLASS", this.lYG);
      localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt);
      localIntent.addFlags(268435456);
      localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
      this.lYQ.I(localIntent);
      if (!this.lYS.get()) {
        h.a(this.lYI, new m()
        {
          public final void aeQ()
          {
            AppMethodBeat.i(186977);
            h.b(i.this.lYI, this);
            long l;
            if (i.this.lYO.isEmpty())
            {
              l = (int)((SystemClock.elapsedRealtime() - i.this.lYR) / 1000L);
              if (l <= 0L) {
                break label238;
              }
              if (l > 60L) {
                break label121;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 6L, 1L, false);
              ac.i("MicroMsg.AppBrandUITask", "onDied: name = [%s], alive = [%d]seconds", new Object[] { i.this.lYI, Long.valueOf(l) });
            }
            for (;;)
            {
              i.this.lYS.set(false);
              AppMethodBeat.o(186977);
              return;
              label121:
              if (l <= 120L)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 7L, 1L, false);
                break;
              }
              if (l <= 300L)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 8L, 1L, false);
                break;
              }
              if (l <= 600L)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 9L, 1L, false);
                break;
              }
              if (l <= 1200L)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 10L, 1L, false);
                break;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(365L, 11L, 1L, false);
              break;
              label238:
              ac.e("MicroMsg.AppBrandUITask", "onDied: got a invalid time");
            }
          }
        });
      }
      for (;;)
      {
        this.lYS.set(true);
        XIPCInvoker.a(this.lYI, localIntent, c.class, new com.tencent.mm.ipcinvoker.e()
        {
          public final void aeK()
          {
            AppMethodBeat.i(186978);
            ac.i("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", new Object[] { i.this.lYI });
            i.this.lYS.set(false);
            AppMethodBeat.o(186978);
          }
        });
        AppMethodBeat.o(186980);
        return;
        ac.i("MicroMsg.AppBrandUITask", "preload: had bound!");
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */