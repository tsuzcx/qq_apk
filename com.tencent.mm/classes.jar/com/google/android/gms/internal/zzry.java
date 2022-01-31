package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzry
  extends zzsa
{
  private final zzsi zzadG;
  
  public zzry(zzsc paramzzsc, zzsd paramzzsd)
  {
    super(paramzzsc);
    zzac.zzw(paramzzsd);
    this.zzadG = paramzzsd.zzj(paramzzsc);
  }
  
  void onServiceConnected()
  {
    zzmR();
    this.zzadG.onServiceConnected();
  }
  
  public void setLocalDispatchPeriod(final int paramInt)
  {
    zzob();
    zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zznU().zzg(new Runnable()
    {
      public void run()
      {
        zzry.zza(zzry.this).zzx(paramInt * 1000L);
      }
    });
  }
  
  public void start()
  {
    this.zzadG.start();
  }
  
  public void zzW(boolean paramBoolean)
  {
    zza("Network connectivity status changed", Boolean.valueOf(paramBoolean));
    zznU().zzg(new zzry.2(this, paramBoolean));
  }
  
  public long zza(zzse paramzzse)
  {
    zzob();
    zzac.zzw(paramzzse);
    zzmR();
    long l = this.zzadG.zza(paramzzse, true);
    if (l == 0L) {
      this.zzadG.zzc(paramzzse);
    }
    return l;
  }
  
  public void zza(zzsu paramzzsu)
  {
    zzob();
    zznU().zzg(new zzry.6(this, paramzzsu));
  }
  
  public void zza(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    zzob();
    zzb("Hit delivery requested", paramzzsz);
    zznU().zzg(new zzry.4(this, paramzzsz));
  }
  
  public void zza(final String paramString, final Runnable paramRunnable)
  {
    zzac.zzh(paramString, "campaign param can't be empty");
    zznU().zzg(new Runnable()
    {
      public void run()
      {
        zzry.zza(zzry.this).zzbX(paramString);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
  }
  
  protected void zzmS()
  {
    this.zzadG.initialize();
  }
  
  public void zznK()
  {
    zzob();
    zznU().zzg(new zzry.5(this));
  }
  
  public void zznL()
  {
    zzob();
    Context localContext = getContext();
    if ((zzth.zzak(localContext)) && (zzti.zzal(localContext)))
    {
      Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localIntent.setComponent(new ComponentName(localContext, "com.google.android.gms.analytics.AnalyticsService"));
      localContext.startService(localIntent);
      return;
    }
    zza(null);
  }
  
  public boolean zznM()
  {
    zzob();
    Future localFuture = zznU().zzc(new zzry.7(this));
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzd("syncDispatchLocalHits interrupted", localInterruptedException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      zze("syncDispatchLocalHits failed", localExecutionException);
      return false;
    }
    catch (TimeoutException localTimeoutException)
    {
      zzd("syncDispatchLocalHits timed out", localTimeoutException);
    }
    return false;
  }
  
  public void zznN()
  {
    zzob();
    zzh.zzmR();
    this.zzadG.zznN();
  }
  
  public void zznO()
  {
    zzbP("Radio powered up");
    zznL();
  }
  
  void zznP()
  {
    zzmR();
    this.zzadG.zznP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzry
 * JD-Core Version:    0.7.0.1
 */