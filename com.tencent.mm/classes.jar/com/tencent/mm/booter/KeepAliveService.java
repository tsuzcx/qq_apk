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
import com.tencent.mm.f.a.qz;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class KeepAliveService
  extends JobService
{
  public static long iPA;
  
  static
  {
    AppMethodBeat.i(131881);
    if (d.qV(23))
    {
      iPA = 590000L;
      AppMethodBeat.o(131881);
      return;
    }
    iPA = 50000L;
    AppMethodBeat.o(131881);
  }
  
  public static boolean aqx()
  {
    AppMethodBeat.i(131880);
    if (com.tencent.mm.kernel.b.awd().getBoolean("keepaliveserviceswitch", false))
    {
      Log.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", new Object[] { Long.valueOf(iPA) });
      int i;
      do
      {
        JobScheduler localJobScheduler;
        try
        {
          Object localObject = new JobInfo.Builder(1, new ComponentName(MMApplicationContext.getContext(), KeepAliveService.class));
          ((JobInfo.Builder)localObject).setMinimumLatency(0L);
          ((JobInfo.Builder)localObject).setOverrideDeadline(10L);
          ((JobInfo.Builder)localObject).setRequiredNetworkType(1);
          ((JobInfo.Builder)localObject).setRequiresDeviceIdle(false);
          ((JobInfo.Builder)localObject).setRequiresCharging(false);
          localJobScheduler = (JobScheduler)MMApplicationContext.getContext().getSystemService("jobscheduler");
          if (localJobScheduler == null)
          {
            localObject = new Exception("Can not get JOB_SCHEDULER_SERVICE");
            AppMethodBeat.o(131880);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + localException1.getMessage());
          AppMethodBeat.o(131880);
          return true;
        }
        i = localJobScheduler.schedule(localException1.build());
      } while (i == 1);
      Exception localException2 = new Exception("scheduleCoreScheduleJob fail, result = ".concat(String.valueOf(i)));
      AppMethodBeat.o(131880);
      throw localException2;
    }
    AppMethodBeat.o(131880);
    return false;
  }
  
  public boolean onStartJob(final JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131878);
    Log.i("MicroMsg.KeepAliveService", "onStartJob()");
    if (af.btU() == null)
    {
      Log.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
      b.c(MMApplicationContext.getContext(), "jobservice", true);
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131876);
        Log.i("MicroMsg.KeepAliveService", "onStartJob() delay");
        KeepAliveService.aqx();
        try
        {
          KeepAliveService.this.jobFinished(paramJobParameters, false);
          AppMethodBeat.o(131876);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(131876);
        }
      }
    }, iPA);
    Log.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
    h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131877);
        qz localqz = new qz();
        EventCenter.instance.asyncPublish(localqz, Looper.getMainLooper());
        Log.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
        AppMethodBeat.o(131877);
      }
    }, 60000L);
    AppMethodBeat.o(131878);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(131879);
    Log.i("MicroMsg.KeepAliveService", "onStopJob()");
    AppMethodBeat.o(131879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService
 * JD-Core Version:    0.7.0.1
 */