package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzch<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object zzfa;
  private final WeakReference<GoogleApiClient> zzfc;
  private ResultTransform<? super R, ? extends Result> zzmd;
  private zzch<? extends Result> zzme;
  private volatile ResultCallbacks<? super R> zzmf;
  private PendingResult<R> zzmg;
  private Status zzmh;
  private final zzcj zzmi;
  private boolean zzmj;
  
  public zzch(WeakReference<GoogleApiClient> paramWeakReference)
  {
    AppMethodBeat.i(11369);
    this.zzmd = null;
    this.zzme = null;
    this.zzmf = null;
    this.zzmg = null;
    this.zzfa = new Object();
    this.zzmh = null;
    this.zzmj = false;
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zzfc = paramWeakReference;
    paramWeakReference = (GoogleApiClient)this.zzfc.get();
    if (paramWeakReference != null) {}
    for (paramWeakReference = paramWeakReference.getLooper();; paramWeakReference = Looper.getMainLooper())
    {
      this.zzmi = new zzcj(this, paramWeakReference);
      AppMethodBeat.o(11369);
      return;
    }
  }
  
  private static void zzb(Result paramResult)
  {
    AppMethodBeat.i(11378);
    if ((paramResult instanceof Releasable)) {
      try
      {
        ((Releasable)paramResult).release();
        AppMethodBeat.o(11378);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramResult = String.valueOf(paramResult);
        new StringBuilder(String.valueOf(paramResult).length() + 18).append("Unable to release ").append(paramResult);
      }
    }
    AppMethodBeat.o(11378);
  }
  
  @GuardedBy("mSyncToken")
  private final void zzcb()
  {
    AppMethodBeat.i(11374);
    if ((this.zzmd == null) && (this.zzmf == null))
    {
      AppMethodBeat.o(11374);
      return;
    }
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzfc.get();
    if ((!this.zzmj) && (this.zzmd != null) && (localGoogleApiClient != null))
    {
      localGoogleApiClient.zza(this);
      this.zzmj = true;
    }
    if (this.zzmh != null)
    {
      zze(this.zzmh);
      AppMethodBeat.o(11374);
      return;
    }
    if (this.zzmg != null) {
      this.zzmg.setResultCallback(this);
    }
    AppMethodBeat.o(11374);
  }
  
  @GuardedBy("mSyncToken")
  private final boolean zzcd()
  {
    AppMethodBeat.i(11377);
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzfc.get();
    if ((this.zzmf != null) && (localGoogleApiClient != null))
    {
      AppMethodBeat.o(11377);
      return true;
    }
    AppMethodBeat.o(11377);
    return false;
  }
  
  private final void zzd(Status paramStatus)
  {
    AppMethodBeat.i(11375);
    synchronized (this.zzfa)
    {
      this.zzmh = paramStatus;
      zze(this.zzmh);
      AppMethodBeat.o(11375);
      return;
    }
  }
  
  private final void zze(Status paramStatus)
  {
    AppMethodBeat.i(11376);
    synchronized (this.zzfa)
    {
      if (this.zzmd != null)
      {
        paramStatus = this.zzmd.onFailure(paramStatus);
        Preconditions.checkNotNull(paramStatus, "onFailure must not return null");
        this.zzme.zzd(paramStatus);
      }
      while (!zzcd())
      {
        AppMethodBeat.o(11376);
        return;
      }
      this.zzmf.onFailure(paramStatus);
    }
  }
  
  public final void andFinally(ResultCallbacks<? super R> paramResultCallbacks)
  {
    boolean bool2 = true;
    AppMethodBeat.i(11371);
    synchronized (this.zzfa)
    {
      if (this.zzmf == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Preconditions.checkState(bool1, "Cannot call andFinally() twice.");
        if (this.zzmd != null) {
          break;
        }
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
        this.zzmf = paramResultCallbacks;
        zzcb();
        AppMethodBeat.o(11371);
        return;
      }
      bool1 = false;
    }
  }
  
  public final void onResult(R paramR)
  {
    AppMethodBeat.i(11372);
    for (;;)
    {
      synchronized (this.zzfa)
      {
        if (paramR.getStatus().isSuccess())
        {
          if (this.zzmd != null)
          {
            zzbw.zzbe().submit(new zzci(this, paramR));
            AppMethodBeat.o(11372);
            return;
          }
          if (!zzcd()) {
            continue;
          }
          this.zzmf.onSuccess(paramR);
        }
      }
      zzd(paramR.getStatus());
      zzb(paramR);
    }
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    AppMethodBeat.i(11370);
    synchronized (this.zzfa)
    {
      if (this.zzmd == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Preconditions.checkState(bool1, "Cannot call then() twice.");
        if (this.zzmf != null) {
          break;
        }
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
        this.zzmd = paramResultTransform;
        paramResultTransform = new zzch(this.zzfc);
        this.zzme = paramResultTransform;
        zzcb();
        AppMethodBeat.o(11370);
        return paramResultTransform;
      }
      bool1 = false;
    }
  }
  
  public final void zza(PendingResult<?> paramPendingResult)
  {
    AppMethodBeat.i(11373);
    synchronized (this.zzfa)
    {
      this.zzmg = paramPendingResult;
      zzcb();
      AppMethodBeat.o(11373);
      return;
    }
  }
  
  final void zzcc()
  {
    this.zzmf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzch
 * JD-Core Version:    0.7.0.1
 */