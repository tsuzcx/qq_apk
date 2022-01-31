package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjn
  extends zzjq
{
  private final zzem zzapy;
  private final AlarmManager zzyi;
  private Integer zzyj;
  
  protected zzjn(zzjr paramzzjr)
  {
    super(paramzzjr);
    AppMethodBeat.i(69399);
    this.zzyi = ((AlarmManager)getContext().getSystemService("alarm"));
    this.zzapy = new zzjo(this, paramzzjr.zzla(), paramzzjr);
    AppMethodBeat.o(69399);
  }
  
  private final int getJobId()
  {
    AppMethodBeat.i(69403);
    if (this.zzyj == null)
    {
      str = String.valueOf(getContext().getPackageName());
      if (str.length() == 0) {
        break label63;
      }
    }
    label63:
    for (String str = "measurement".concat(str);; str = new String("measurement"))
    {
      this.zzyj = Integer.valueOf(str.hashCode());
      int i = this.zzyj.intValue();
      AppMethodBeat.o(69403);
      return i;
    }
  }
  
  private final PendingIntent zzek()
  {
    AppMethodBeat.i(69405);
    Object localObject = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
    ((Intent)localObject).setAction("com.google.android.gms.measurement.UPLOAD");
    localObject = PendingIntent.getBroadcast(getContext(), 0, (Intent)localObject, 0);
    AppMethodBeat.o(69405);
    return localObject;
  }
  
  @TargetApi(24)
  private final void zzkl()
  {
    AppMethodBeat.i(69401);
    JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
    zzge().zzit().zzg("Cancelling job. JobID", Integer.valueOf(getJobId()));
    localJobScheduler.cancel(getJobId());
    AppMethodBeat.o(69401);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(69404);
    zzch();
    this.zzyi.cancel(zzek());
    this.zzapy.cancel();
    if (Build.VERSION.SDK_INT >= 24) {
      zzkl();
    }
    AppMethodBeat.o(69404);
  }
  
  public final void zzh(long paramLong)
  {
    AppMethodBeat.i(69402);
    zzch();
    if (!zzgb.zza(getContext())) {
      zzge().zzis().log("Receiver not registered/enabled");
    }
    if (!zzjc.zza(getContext(), false)) {
      zzge().zzis().log("Service not registered/enabled");
    }
    cancel();
    long l = zzbt().elapsedRealtime();
    if ((paramLong < Math.max(0L, ((Long)zzew.zzahf.get()).longValue())) && (!this.zzapy.zzef()))
    {
      zzge().zzit().log("Scheduling upload with DelayedRunnable");
      this.zzapy.zzh(paramLong);
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      zzge().zzit().log("Scheduling upload with JobScheduler");
      Object localObject = new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService");
      JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
      localObject = new JobInfo.Builder(getJobId(), (ComponentName)localObject);
      ((JobInfo.Builder)localObject).setMinimumLatency(paramLong);
      ((JobInfo.Builder)localObject).setOverrideDeadline(paramLong << 1);
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      ((JobInfo.Builder)localObject).setExtras(localPersistableBundle);
      localObject = ((JobInfo.Builder)localObject).build();
      zzge().zzit().zzg("Scheduling job. JobID", Integer.valueOf(getJobId()));
      localJobScheduler.schedule((JobInfo)localObject);
      AppMethodBeat.o(69402);
      return;
    }
    zzge().zzit().log("Scheduling upload with AlarmManager");
    this.zzyi.setInexactRepeating(2, l + paramLong, Math.max(((Long)zzew.zzaha.get()).longValue(), paramLong), zzek());
    AppMethodBeat.o(69402);
  }
  
  protected final boolean zzhf()
  {
    AppMethodBeat.i(69400);
    this.zzyi.cancel(zzek());
    if (Build.VERSION.SDK_INT >= 24) {
      zzkl();
    }
    AppMethodBeat.o(69400);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjn
 * JD-Core Version:    0.7.0.1
 */