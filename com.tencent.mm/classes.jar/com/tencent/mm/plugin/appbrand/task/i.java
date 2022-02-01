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
  int lvY;
  final String lwM;
  final Class<? extends Activity> lwN;
  final String lwO;
  private final Class lwP;
  final Class lwQ;
  final Class lwR;
  final Class lwS;
  final Class lwT;
  final LinkedHashMap<String, Integer> lwU;
  final LinkedHashMap<String, AppBrandRemoteTaskController> lwV;
  e lwW;
  long lwX;
  AtomicBoolean lwY;
  
  i(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5)
  {
    AppMethodBeat.i(48475);
    this.lwU = new LinkedHashMap();
    this.lwV = new LinkedHashMap();
    this.lwW = e.lwz;
    this.lvY = -1;
    this.lwX = 0L;
    this.lwY = new AtomicBoolean(false);
    this.lwM = paramClass.getName();
    this.lwN = paramClass;
    this.lwP = paramClass1;
    this.lwQ = paramClass2;
    this.lwR = paramClass3;
    this.lwO = aH(this.lwN);
    this.lwS = paramClass4;
    this.lwT = paramClass5;
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
  
  final Integer MU(String paramString)
  {
    AppMethodBeat.i(48479);
    paramString = (Integer)this.lwU.get(paramString);
    AppMethodBeat.o(48479);
    return paramString;
  }
  
  final AppBrandRemoteTaskController MV(String paramString)
  {
    AppMethodBeat.i(48480);
    paramString = (AppBrandRemoteTaskController)this.lwV.get(paramString);
    AppMethodBeat.o(48480);
    return paramString;
  }
  
  void MX()
  {
    AppMethodBeat.i(48477);
    tY(2);
    AppMethodBeat.o(48477);
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48478);
    this.lwU.put(paramString, Integer.valueOf(paramInt));
    this.lwV.put(paramString, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(48478);
  }
  
  protected boolean b(e parame)
  {
    return true;
  }
  
  public final e bnK()
  {
    return this.lwW;
  }
  
  public final Class bnL()
  {
    return this.lwS;
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
    this.lwW = parame;
    AppMethodBeat.o(48476);
  }
  
  final void tY(int paramInt)
  {
    AppMethodBeat.i(196135);
    if (this.lwP == null)
    {
      AppMethodBeat.o(196135);
      return;
    }
    j.bnM();
    try
    {
      Intent localIntent = new Intent(aj.getContext(), this.lwS);
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.bno();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      localIntent.putExtra("EXTRA_KEY_UI_CLASS", this.lwM);
      localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt);
      localIntent.addFlags(268435456);
      localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
      this.lwW.I(localIntent);
      if (!this.lwY.get()) {
        h.a(this.lwO, new m()
        {
          public final void adA()
          {
            AppMethodBeat.i(196132);
            h.b(i.this.lwO, this);
            long l;
            if (i.this.lwU.isEmpty())
            {
              l = (int)((SystemClock.elapsedRealtime() - i.this.lwX) / 1000L);
              if (l <= 0L) {
                break label238;
              }
              if (l > 60L) {
                break label121;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 6L, 1L, false);
              ad.i("MicroMsg.AppBrandUITask", "onDied: name = [%s], alive = [%d]seconds", new Object[] { i.this.lwO, Long.valueOf(l) });
            }
            for (;;)
            {
              i.this.lwY.set(false);
              AppMethodBeat.o(196132);
              return;
              label121:
              if (l <= 120L)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 7L, 1L, false);
                break;
              }
              if (l <= 300L)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 8L, 1L, false);
                break;
              }
              if (l <= 600L)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 9L, 1L, false);
                break;
              }
              if (l <= 1200L)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 10L, 1L, false);
                break;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(365L, 11L, 1L, false);
              break;
              label238:
              ad.e("MicroMsg.AppBrandUITask", "onDied: got a invalid time");
            }
          }
        });
      }
      for (;;)
      {
        this.lwY.set(true);
        XIPCInvoker.a(this.lwO, localIntent, c.class, new com.tencent.mm.ipcinvoker.e()
        {
          public final void adu()
          {
            AppMethodBeat.i(196133);
            ad.i("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", new Object[] { i.this.lwO });
            i.this.lwY.set(false);
            AppMethodBeat.o(196133);
          }
        });
        AppMethodBeat.o(196135);
        return;
        ad.i("MicroMsg.AppBrandUITask", "preload: had bound!");
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(196135);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */