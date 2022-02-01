package com.tencent.mm.booter;

import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class KeepAliveService
  extends JobService
{
  public static long flY;
  
  static
  {
    AppMethodBeat.i(131881);
    if (d.kZ(23))
    {
      flY = 590000L;
      AppMethodBeat.o(131881);
      return;
    }
    flY = 50000L;
    AppMethodBeat.o(131881);
  }
  
  public static boolean Uo()
  {
    AppMethodBeat.i(131880);
    if (com.tencent.mm.kernel.a.Zc().getBoolean("keepaliveserviceswitch", false))
    {
      ac.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", new Object[] { Long.valueOf(flY) });
      try
      {
        JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(ai.getContext(), KeepAliveService.class));
        localBuilder.setMinimumLatency(0L);
        localBuilder.setOverrideDeadline(10L);
        localBuilder.setRequiredNetworkType(1);
        localBuilder.setRequiresDeviceIdle(false);
        localBuilder.setRequiresCharging(false);
        ((JobScheduler)ai.getContext().getSystemService("jobscheduler")).schedule(localBuilder.build());
        AppMethodBeat.o(131880);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + localException.getMessage());
        }
      }
    }
    AppMethodBeat.o(131880);
    return false;
  }
  
  public boolean onStartJob(final JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131878);
    ac.i("MicroMsg.KeepAliveService", "onStartJob()");
    if (ad.aMf() == null)
    {
      ac.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
      b.c(ai.getContext(), "jobservice", true);
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131876);
        ac.i("MicroMsg.KeepAliveService", "onStartJob() delay");
        KeepAliveService.Uo();
        try
        {
          KeepAliveService.this.jobFinished(paramJobParameters, false);
          AppMethodBeat.o(131876);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(131876);
        }
      }
    }, flY);
    ac.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
    h.JZN.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131877);
        oz localoz = new oz();
        com.tencent.mm.sdk.b.a.GpY.a(localoz, Looper.getMainLooper());
        ac.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
        AppMethodBeat.o(131877);
      }
    }, 60000L);
    AppMethodBeat.o(131878);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131879);
    ac.i("MicroMsg.KeepAliveService", "onStopJob()");
    AppMethodBeat.o(131879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService
 * JD-Core Version:    0.7.0.1
 */