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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  int mCE;
  final Class mDA;
  final Class mDC;
  final LinkedHashMap<String, Integer> mDD;
  final LinkedHashMap<String, AppBrandRemoteTaskController> mDE;
  e mDF;
  long mDG;
  AtomicBoolean mDH;
  final String mDu;
  final Class<? extends Activity> mDv;
  final String mDw;
  private final Class mDx;
  final Class mDy;
  final Class mDz;
  
  i(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5)
  {
    AppMethodBeat.i(48475);
    this.mDD = new LinkedHashMap();
    this.mDE = new LinkedHashMap();
    this.mDF = e.mDg;
    this.mCE = -1;
    this.mDG = 0L;
    this.mDH = new AtomicBoolean(false);
    this.mDu = paramClass.getName();
    this.mDv = paramClass;
    this.mDx = paramClass1;
    this.mDy = paramClass2;
    this.mDz = paramClass3;
    this.mDw = aH(this.mDv);
    this.mDA = paramClass4;
    this.mDC = paramClass5;
    AppMethodBeat.o(48475);
  }
  
  private static String aH(Class<?> paramClass)
  {
    AppMethodBeat.i(48481);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(48481);
      return null;
    }
    try
    {
      paramClass = localPackageManager.getActivityInfo(new ComponentName(ak.getContext(), paramClass), 128).processName;
      AppMethodBeat.o(48481);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(48481);
    }
    return null;
  }
  
  void OC()
  {
    AppMethodBeat.i(48477);
    vA(2);
    AppMethodBeat.o(48477);
  }
  
  final Integer Vu(String paramString)
  {
    AppMethodBeat.i(48479);
    paramString = (Integer)this.mDD.get(paramString);
    AppMethodBeat.o(48479);
    return paramString;
  }
  
  final AppBrandRemoteTaskController Vv(String paramString)
  {
    AppMethodBeat.i(48480);
    paramString = (AppBrandRemoteTaskController)this.mDE.get(paramString);
    AppMethodBeat.o(48480);
    return paramString;
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48478);
    this.mDD.put(paramString, Integer.valueOf(paramInt));
    this.mDE.put(paramString, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(48478);
  }
  
  protected boolean b(e parame)
  {
    return true;
  }
  
  public final e bzF()
  {
    return this.mDF;
  }
  
  public final Class bzG()
  {
    return this.mDA;
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
    this.mDF = parame;
    AppMethodBeat.o(48476);
  }
  
  final void vA(int paramInt)
  {
    AppMethodBeat.i(223012);
    if (this.mDx == null)
    {
      AppMethodBeat.o(223012);
      return;
    }
    j.bzH();
    try
    {
      Intent localIntent = new Intent(ak.getContext(), this.mDA);
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.bzi();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      localIntent.putExtra("EXTRA_KEY_UI_CLASS", this.mDu);
      localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt);
      localIntent.addFlags(268435456);
      localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
      this.mDF.K(localIntent);
      if (!this.mDH.get()) {
        h.a(this.mDw, new m()
        {
          public final void ahR()
          {
            AppMethodBeat.i(223009);
            h.b(i.this.mDw, this);
            long l;
            if (i.this.mDD.isEmpty())
            {
              l = (int)((SystemClock.elapsedRealtime() - i.this.mDG) / 1000L);
              if (l < 0L) {
                break label238;
              }
              if (l > 60L) {
                break label121;
              }
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 6L, 1L, false);
              ae.i("MicroMsg.AppBrandUITask", "onDied: name = [%s], alive = [%d]seconds", new Object[] { i.this.mDw, Long.valueOf(l) });
            }
            for (;;)
            {
              i.this.mDH.set(false);
              AppMethodBeat.o(223009);
              return;
              label121:
              if (l <= 120L)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 7L, 1L, false);
                break;
              }
              if (l <= 300L)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 8L, 1L, false);
                break;
              }
              if (l <= 600L)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 9L, 1L, false);
                break;
              }
              if (l <= 1200L)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 10L, 1L, false);
                break;
              }
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(365L, 11L, 1L, false);
              break;
              label238:
              ae.e("MicroMsg.AppBrandUITask", "onDied: name = [%s], got a invalid time", new Object[] { i.this.mDw });
            }
          }
        });
      }
      for (;;)
      {
        this.mDH.set(true);
        XIPCInvoker.a(this.mDw, localIntent, c.class, new com.tencent.mm.ipcinvoker.e()
        {
          public final void ahL()
          {
            AppMethodBeat.i(223010);
            ae.i("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", new Object[] { i.this.mDw });
            i.this.mDH.set(false);
            AppMethodBeat.o(223010);
          }
        });
        AppMethodBeat.o(223012);
        return;
        ae.i("MicroMsg.AppBrandUITask", "preload: name = [%s], had bound!", new Object[] { this.mDw });
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(223012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */