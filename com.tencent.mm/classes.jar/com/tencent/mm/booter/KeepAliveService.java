package com.tencent.mm.booter;

import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ah;

public class KeepAliveService
  extends JobService
{
  public static long dYR;
  
  static
  {
    AppMethodBeat.i(57765);
    if (com.tencent.mm.compatible.util.d.fv(23))
    {
      dYR = 590000L;
      AppMethodBeat.o(57765);
      return;
    }
    dYR = 50000L;
    AppMethodBeat.o(57765);
  }
  
  public static boolean Ij()
  {
    AppMethodBeat.i(57764);
    if (a.Mu().getBoolean("keepaliveserviceswitch", false))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", new Object[] { Long.valueOf(dYR) });
      try
      {
        JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(ah.getContext(), KeepAliveService.class));
        localBuilder.setMinimumLatency(0L);
        localBuilder.setOverrideDeadline(10L);
        localBuilder.setRequiredNetworkType(1);
        localBuilder.setRequiresDeviceIdle(false);
        localBuilder.setRequiresCharging(false);
        ((JobScheduler)ah.getContext().getSystemService("jobscheduler")).schedule(localBuilder.build());
        AppMethodBeat.o(57764);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + localException.getMessage());
        }
      }
    }
    AppMethodBeat.o(57764);
    return false;
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(57762);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.KeepAliveService", "onStartJob()");
    if (com.tencent.mm.network.ab.anF() == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
      b.c(ah.getContext(), "jobservice", true);
    }
    new Handler().postDelayed(new KeepAliveService.1(this, paramJobParameters), dYR);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
    com.tencent.mm.sdk.g.d.ysm.s(new KeepAliveService.2(this), 60000L);
    AppMethodBeat.o(57762);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    AppMethodBeat.i(57763);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.KeepAliveService", "onStopJob()");
    AppMethodBeat.o(57763);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.KeepAliveService
 * JD-Core Version:    0.7.0.1
 */