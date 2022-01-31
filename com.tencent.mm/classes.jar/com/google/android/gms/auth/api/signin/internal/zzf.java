package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzf
  extends a<Void>
  implements SignInConnectionListener
{
  private Semaphore zzet;
  private Set<GoogleApiClient> zzeu;
  
  public zzf(Context paramContext, Set<GoogleApiClient> paramSet)
  {
    super(paramContext);
    AppMethodBeat.i(50421);
    this.zzet = new Semaphore(0);
    this.zzeu = paramSet;
    AppMethodBeat.o(50421);
  }
  
  private final Void zzm()
  {
    AppMethodBeat.i(50422);
    Iterator localIterator = this.zzeu.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((GoogleApiClient)localIterator.next()).maybeSignIn(this)) {
        break label81;
      }
      i += 1;
    }
    label81:
    for (;;)
    {
      break;
      try
      {
        this.zzet.tryAcquire(i, 5L, TimeUnit.SECONDS);
        AppMethodBeat.o(50422);
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
  
  public final void onComplete()
  {
    AppMethodBeat.i(50424);
    this.zzet.release();
    AppMethodBeat.o(50424);
  }
  
  public final void onStartLoading()
  {
    AppMethodBeat.i(50423);
    this.zzet.drainPermits();
    forceLoad();
    AppMethodBeat.o(50423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzf
 * JD-Core Version:    0.7.0.1
 */