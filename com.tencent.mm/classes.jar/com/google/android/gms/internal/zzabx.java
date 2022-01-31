package com.google.android.gms.internal;

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
import com.google.android.gms.common.internal.zzac;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class zzabx<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object zzaAh = new Object();
  private final WeakReference<GoogleApiClient> zzaAj;
  private ResultTransform<? super R, ? extends Result> zzaDl = null;
  private zzabx<? extends Result> zzaDm = null;
  private volatile ResultCallbacks<? super R> zzaDn = null;
  private PendingResult<R> zzaDo = null;
  private Status zzaDp = null;
  private final zzabx.zza zzaDq;
  private boolean zzaDr = false;
  
  public zzabx(WeakReference<GoogleApiClient> paramWeakReference)
  {
    zzac.zzb(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zzaAj = paramWeakReference;
    paramWeakReference = (GoogleApiClient)this.zzaAj.get();
    if (paramWeakReference != null) {}
    for (paramWeakReference = paramWeakReference.getLooper();; paramWeakReference = Looper.getMainLooper())
    {
      this.zzaDq = new zzabx.zza(this, paramWeakReference);
      return;
    }
  }
  
  private void zzE(Status paramStatus)
  {
    synchronized (this.zzaAh)
    {
      this.zzaDp = paramStatus;
      zzF(this.zzaDp);
      return;
    }
  }
  
  private void zzF(Status paramStatus)
  {
    synchronized (this.zzaAh)
    {
      if (this.zzaDl != null)
      {
        paramStatus = this.zzaDl.onFailure(paramStatus);
        zzac.zzb(paramStatus, "onFailure must not return null");
        this.zzaDm.zzE(paramStatus);
      }
      while (!zzxc()) {
        return;
      }
      this.zzaDn.onFailure(paramStatus);
    }
  }
  
  private void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResult = String.valueOf(paramResult);
      new StringBuilder(String.valueOf(paramResult).length() + 18).append("Unable to release ").append(paramResult);
    }
  }
  
  private void zzxa()
  {
    if ((this.zzaDl == null) && (this.zzaDn == null)) {}
    do
    {
      return;
      GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzaAj.get();
      if ((!this.zzaDr) && (this.zzaDl != null) && (localGoogleApiClient != null))
      {
        localGoogleApiClient.zza(this);
        this.zzaDr = true;
      }
      if (this.zzaDp != null)
      {
        zzF(this.zzaDp);
        return;
      }
    } while (this.zzaDo == null);
    this.zzaDo.setResultCallback(this);
  }
  
  private boolean zzxc()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zzaAj.get();
    return (this.zzaDn != null) && (localGoogleApiClient != null);
  }
  
  public void andFinally(ResultCallbacks<? super R> paramResultCallbacks)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaAh)
      {
        if (this.zzaDn == null)
        {
          bool1 = true;
          zzac.zza(bool1, "Cannot call andFinally() twice.");
          if (this.zzaDl != null) {
            break label65;
          }
          bool1 = bool2;
          zzac.zza(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zzaDn = paramResultCallbacks;
          zzxa();
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label65:
      bool1 = false;
    }
  }
  
  public void onResult(R paramR)
  {
    for (;;)
    {
      synchronized (this.zzaAh)
      {
        if (paramR.getStatus().isSuccess())
        {
          if (this.zzaDl != null)
          {
            zzabo.zzwv().submit(new zzabx.1(this, paramR));
            return;
          }
          if (!zzxc()) {
            continue;
          }
          this.zzaDn.onSuccess(paramR);
        }
      }
      zzE(paramR.getStatus());
      zzd(paramR);
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaAh)
      {
        if (this.zzaDl == null)
        {
          bool1 = true;
          zzac.zza(bool1, "Cannot call then() twice.");
          if (this.zzaDn != null) {
            break label83;
          }
          bool1 = bool2;
          zzac.zza(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zzaDl = paramResultTransform;
          paramResultTransform = new zzabx(this.zzaAj);
          this.zzaDm = paramResultTransform;
          zzxa();
          return paramResultTransform;
        }
      }
      boolean bool1 = false;
      continue;
      label83:
      bool1 = false;
    }
  }
  
  public void zza(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zzaAh)
    {
      this.zzaDo = paramPendingResult;
      zzxa();
      return;
    }
  }
  
  void zzxb()
  {
    this.zzaDn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzabx
 * JD-Core Version:    0.7.0.1
 */