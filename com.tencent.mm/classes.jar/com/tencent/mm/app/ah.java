package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import java.util.concurrent.TimeUnit;

public final class ah
{
  private static final PeriodRecorder REPORT_FREQ_LIMIT;
  private static final long hhO;
  long hhP;
  private long hhQ;
  private boolean hhR;
  private boolean hhS;
  private final int[] hhT;
  private final int[] hhU;
  final Runnable hhV;
  private final Runnable hhW;
  private final Runnable hhX;
  final Application.ActivityLifecycleCallbacks hhY;
  Application hhh;
  boolean mInstalled;
  final Handler mMainHandler;
  String mProcessName;
  
  static
  {
    AppMethodBeat.i(239204);
    REPORT_FREQ_LIMIT = new PeriodRecorder("StartupCostReporter_kvstat", TimeUnit.HOURS.toMillis(16L), true, true);
    hhO = TimeUnit.SECONDS.toMillis(1L);
    AppMethodBeat.o(239204);
  }
  
  private ah()
  {
    AppMethodBeat.i(239151);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.hhh = null;
    this.mProcessName = "";
    this.hhP = 0L;
    this.hhQ = 0L;
    this.mInstalled = false;
    this.hhR = true;
    this.hhS = false;
    this.hhT = new int[] { 0, 0 };
    this.hhU = new int[] { 0, 0 };
    this.hhV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239077);
        if (ah.a(ah.this) == 0) {
          ah.b(ah.this);
        }
        AppMethodBeat.o(239077);
      }
    };
    this.hhW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239076);
        aa.a("MicroMsg.StartupCostReporter", "[tomys] Switch out too long, skip report this time.", new Object[0]);
        ah.a(ah.this, true);
        AppMethodBeat.o(239076);
      }
    };
    this.hhX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239080);
        aa.a("MicroMsg.StartupCostReporter", "[tomys] All activity was destroyed, next startup may be warm.", new Object[0]);
        ah.a(ah.this, false);
        ah.b(ah.this);
        AppMethodBeat.o(239080);
      }
    };
    this.hhY = new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(239073);
        ah.a(ah.this, paramAnonymousActivity);
        AppMethodBeat.o(239073);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(239096);
        ah.e(ah.this, paramAnonymousActivity);
        AppMethodBeat.o(239096);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(239081);
        ah.c(ah.this, paramAnonymousActivity);
        AppMethodBeat.o(239081);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(239078);
        ah.b(ah.this, paramAnonymousActivity);
        AppMethodBeat.o(239078);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(239090);
        ah.d(ah.this, paramAnonymousActivity);
        AppMethodBeat.o(239090);
      }
    };
    AppMethodBeat.o(239151);
  }
  
  public static ah aCT()
  {
    return a.hic;
  }
  
  static long aCU()
  {
    AppMethodBeat.i(239154);
    long l = SystemClock.uptimeMillis();
    AppMethodBeat.o(239154);
    return l;
  }
  
  private int aCV()
  {
    synchronized (this.hhU)
    {
      int i = this.hhU[0];
      return i;
    }
  }
  
  private int dW(boolean paramBoolean)
  {
    synchronized (this.hhT)
    {
      int[] arrayOfInt2 = this.hhT;
      if (paramBoolean)
      {
        i = 1;
        i = arrayOfInt2[i];
        return i;
      }
      int i = 0;
    }
  }
  
  private static boolean r(Activity paramActivity)
  {
    AppMethodBeat.i(239157);
    paramActivity = paramActivity.getClass().getName();
    if (paramActivity.startsWith("com.tencent.mm.splash."))
    {
      AppMethodBeat.o(239157);
      return false;
    }
    if (paramActivity.equals("com.tencent.mm.app.WeChatSplashActivity"))
    {
      AppMethodBeat.o(239157);
      return false;
    }
    if (paramActivity.equals("com.tencent.mm.app.WeChatSplashFallbackActivity"))
    {
      AppMethodBeat.o(239157);
      return false;
    }
    AppMethodBeat.o(239157);
    return true;
  }
  
  static final class a
  {
    static final ah hic;
    
    static
    {
      AppMethodBeat.i(239030);
      hic = new ah((byte)0);
      AppMethodBeat.o(239030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ah
 * JD-Core Version:    0.7.0.1
 */