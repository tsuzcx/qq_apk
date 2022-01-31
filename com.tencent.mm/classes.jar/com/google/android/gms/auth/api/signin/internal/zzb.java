package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzabq;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb
  extends a<Void>
  implements zzabq
{
  private Semaphore zzaku = new Semaphore(0);
  private Set<GoogleApiClient> zzakv;
  
  public zzb(Context paramContext, Set<GoogleApiClient> paramSet)
  {
    super(paramContext);
    this.zzakv = paramSet;
  }
  
  protected void onStartLoading()
  {
    this.zzaku.drainPermits();
    forceLoad();
  }
  
  public Void zzrp()
  {
    Iterator localIterator = this.zzakv.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((GoogleApiClient)localIterator.next()).zza(this)) {
        break label71;
      }
      i += 1;
    }
    label71:
    for (;;)
    {
      break;
      try
      {
        this.zzaku.tryAcquire(i, 5L, TimeUnit.SECONDS);
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void zzrq()
  {
    this.zzaku.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzb
 * JD-Core Version:    0.7.0.1
 */