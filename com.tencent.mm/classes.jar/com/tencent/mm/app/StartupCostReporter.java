package com.tencent.mm.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import androidx.annotation.Keep;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.sdk.platformtools.StartupILogsReport;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

@SuppressLint({"NewApi"})
@Keep
public final class StartupCostReporter
{
  private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS;
  private static String CURRENT_PROCESS_NAME;
  private static final int IDKEY_ID = 1557;
  private static final int IDKEY_KEY_INSTALL_FAILURE = 51;
  private static final int IDKEY_KEY_REPORT_COUNT = 50;
  private static final PeriodRecorder REPORT_FREQ_LIMIT;
  private static final String TAG = "MicroMsg.StartupCostReporter";
  private static Application sApp;
  private static final Map<Activity, Boolean> sCreatedActivities;
  private static final Map<Activity, Boolean> sCreatedNonIgnoredActivities;
  private static boolean sInstalled;
  private static boolean sProcessStartWithUI;
  private static long sStartupBeginTs;
  
  static
  {
    AppMethodBeat.i(186194);
    CURRENT_PROCESS_NAME = null;
    REPORT_FREQ_LIMIT = new PeriodRecorder("StartupCostReporter_kvstat", TimeUnit.HOURS.toMillis(8L), true, true);
    sCreatedActivities = new WeakHashMap(8);
    sCreatedNonIgnoredActivities = new WeakHashMap(8);
    sApp = null;
    sInstalled = false;
    sStartupBeginTs = -1L;
    sProcessStartWithUI = false;
    ACTIVITY_LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(final Activity paramAnonymousActivity, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(186147);
        StartupCostReporter.sCreatedActivities.put(paramAnonymousActivity, Boolean.FALSE);
        if (!StartupCostReporter.access$200(paramAnonymousActivity)) {
          StartupCostReporter.sCreatedNonIgnoredActivities.put(paramAnonymousActivity, Boolean.FALSE);
        }
        if (StartupCostReporter.sCreatedNonIgnoredActivities.size() == 1)
        {
          if (!StartupCostReporter.access$400()) {
            StartupCostReporter.access$502(SystemClock.elapsedRealtime());
          }
          paramAnonymousBundle = paramAnonymousActivity.getWindow();
          if (paramAnonymousBundle == null)
          {
            AppMethodBeat.o(186147);
            return;
          }
          paramAnonymousBundle = paramAnonymousBundle.getDecorView();
          paramAnonymousBundle.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(186151);
              paramAnonymousBundle.getViewTreeObserver().removeOnPreDrawListener(this);
              final boolean bool = StartupCostReporter.access$400();
              long l1 = SystemClock.elapsedRealtime();
              final long l2 = StartupCostReporter.sStartupBeginTs;
              h.ZvG.d(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186160);
                  StartupCostReporter.access$600(StartupCostReporter.2.1.this.val$activity, bool, l2, this.feb);
                  AppMethodBeat.o(186160);
                }
              }, "StartupCostReporter");
              AppMethodBeat.o(186151);
              return true;
            }
          });
        }
        AppMethodBeat.o(186147);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(186171);
        StartupCostReporter.sCreatedActivities.remove(paramAnonymousActivity);
        if (!StartupCostReporter.access$200(paramAnonymousActivity)) {
          StartupCostReporter.sCreatedNonIgnoredActivities.remove(paramAnonymousActivity);
        }
        if (StartupCostReporter.sCreatedActivities.size() == 0) {
          StartupCostReporter.access$700();
        }
        AppMethodBeat.o(186171);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    };
    AppMethodBeat.o(186194);
  }
  
  private StartupCostReporter()
  {
    AppMethodBeat.i(186184);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(186184);
    throw localUnsupportedOperationException;
  }
  
  @Keep
  public static void checkColdStartup()
  {
    AppMethodBeat.i(186172);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186158);
        if (StartupCostReporter.sCreatedActivities.size() > 0) {
          StartupCostReporter.access$102(true);
        }
        AppMethodBeat.o(186158);
      }
    });
    AppMethodBeat.o(186172);
  }
  
  private static void clearColdStartupFlag()
  {
    sProcessStartWithUI = false;
  }
  
  private static void doCostReportOnDemand(int paramInt, long paramLong)
  {
    AppMethodBeat.i(186180);
    long l = paramInt & 0xFFFFFFFF;
    if (REPORT_FREQ_LIMIT.isExpired("rpt_" + CURRENT_PROCESS_NAME + "_" + l))
    {
      x.ff(1557, 50);
      StartupILogsReport.reportNumericValue(d.fcb.getApplication(), paramInt, Long.valueOf(paramLong));
      x.a("MicroMsg.StartupCostReporter", "[+] doKVStatNumReport, content: %s,%s,%s", new Object[] { Long.valueOf(l), CURRENT_PROCESS_NAME, Long.valueOf(paramLong) });
      AppMethodBeat.o(186180);
      return;
    }
    x.a("MicroMsg.StartupCostReporter", "[+] Hit report freq limit, skip reporting this time. content: %s,%s,%s", new Object[] { Long.valueOf(l), CURRENT_PROCESS_NAME, Long.valueOf(paramLong) });
    AppMethodBeat.o(186180);
  }
  
  @Keep
  public static void install(Application paramApplication)
  {
    AppMethodBeat.i(186168);
    if (sInstalled)
    {
      AppMethodBeat.o(186168);
      return;
    }
    try
    {
      sApp = paramApplication;
      CURRENT_PROCESS_NAME = Util.getProcessNameByPid(paramApplication, Process.myPid());
      paramApplication.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
      sInstalled = true;
      markStartupBegin();
      if (!sInstalled) {
        x.ff(1557, 51);
      }
      AppMethodBeat.o(186168);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramApplication.unregisterActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
        sInstalled = false;
        x.a("MicroMsg.StartupCostReporter", localThrowable, "[-] [%s] installed failed.", new Object[] { CURRENT_PROCESS_NAME });
      }
    }
  }
  
  private static boolean isColdStartup()
  {
    return sProcessStartWithUI;
  }
  
  private static boolean isIgonredActivity(Activity paramActivity)
  {
    AppMethodBeat.i(186182);
    if ((SplashActivity.class.isInstance(paramActivity)) || (com.tencent.mm.splash.i.hug().isInstance(paramActivity)))
    {
      AppMethodBeat.o(186182);
      return true;
    }
    AppMethodBeat.o(186182);
    return false;
  }
  
  private static void markStartupBegin()
  {
    AppMethodBeat.i(186176);
    sStartupBeginTs = SystemClock.elapsedRealtime();
    AppMethodBeat.o(186176);
  }
  
  private static void reportDurationToUIShown(Activity paramActivity, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186177);
    if (!sInstalled)
    {
      AppMethodBeat.o(186177);
      return;
    }
    if (isIgonredActivity(paramActivity))
    {
      paramActivity = paramActivity.getClass().getName();
      x.b("MicroMsg.StartupCostReporter", "[!] [%s] [%s] Ignored activity, skip this time.", new Object[] { CURRENT_PROCESS_NAME, paramActivity });
      AppMethodBeat.o(186177);
      return;
    }
    paramLong1 = paramLong2 - paramLong1;
    paramActivity = paramActivity.getClass().getName();
    if (paramBoolean)
    {
      x.a("MicroMsg.StartupCostReporter", "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, cold-startup, cost: %s ms.", new Object[] { CURRENT_PROCESS_NAME, paramActivity, Long.valueOf(paramLong1) });
      doCostReportOnDemand(65539, paramLong1);
      AppMethodBeat.o(186177);
      return;
    }
    x.a("MicroMsg.StartupCostReporter", "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, warm-startup, cost: %s ms.", new Object[] { CURRENT_PROCESS_NAME, paramActivity, Long.valueOf(paramLong1) });
    doCostReportOnDemand(65540, paramLong1);
    AppMethodBeat.o(186177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.StartupCostReporter
 * JD-Core Version:    0.7.0.1
 */