package com.google.android.gms.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzaaf<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zzaAg = new zzaaf.1();
  private boolean zzK;
  private final Object zzaAh = new Object();
  protected final zzaaf.zza<R> zzaAi;
  protected final WeakReference<GoogleApiClient> zzaAj;
  private final ArrayList<PendingResult.zza> zzaAk = new ArrayList();
  private ResultCallback<? super R> zzaAl;
  private final AtomicReference<zzaby.zzb> zzaAm = new AtomicReference();
  private zzb zzaAn;
  private volatile boolean zzaAo;
  private boolean zzaAp;
  private zzs zzaAq;
  private volatile zzabx<R> zzaAr;
  private boolean zzaAs = false;
  private Status zzair;
  private R zzazt;
  private final CountDownLatch zztj = new CountDownLatch(1);
  
  @Deprecated
  zzaaf()
  {
    this.zzaAi = new zzaaf.zza(Looper.getMainLooper());
    this.zzaAj = new WeakReference(null);
  }
  
  @Deprecated
  public zzaaf(Looper paramLooper)
  {
    this.zzaAi = new zzaaf.zza(paramLooper);
    this.zzaAj = new WeakReference(null);
  }
  
  public zzaaf(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      this.zzaAi = new zzaaf.zza(localLooper);
      this.zzaAj = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (this.zzaAh)
    {
      if (!this.zzaAo)
      {
        zzac.zza(bool, "Result has already been consumed.");
        zzac.zza(isReady(), "Result is not ready.");
        Result localResult = this.zzazt;
        this.zzazt = null;
        this.zzaAl = null;
        this.zzaAo = true;
        zzvG();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzc(R paramR)
  {
    this.zzazt = paramR;
    this.zzaAq = null;
    this.zztj.countDown();
    this.zzair = this.zzazt.getStatus();
    if (this.zzK) {
      this.zzaAl = null;
    }
    for (;;)
    {
      paramR = this.zzaAk.iterator();
      while (paramR.hasNext()) {
        ((PendingResult.zza)paramR.next()).zzy(this.zzair);
      }
      if (this.zzaAl == null)
      {
        if ((this.zzazt instanceof Releasable)) {
          this.zzaAn = new zzb(null);
        }
      }
      else
      {
        this.zzaAi.zzvK();
        this.zzaAi.zza(this.zzaAl, get());
      }
    }
    this.zzaAk.clear();
  }
  
  public static void zzd(Result paramResult)
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
  
  private void zzvG()
  {
    zzaby.zzb localzzb = (zzaby.zzb)this.zzaAm.getAndSet(null);
    if (localzzb != null) {
      localzzb.zzc(this);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread");
      if (!this.zzaAo)
      {
        bool1 = true;
        label28:
        zzac.zza(bool1, "Result has already been consumed");
        if (this.zzaAr != null) {
          break label80;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        this.zztj.await();
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzC(Status.zzazy);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      zzac.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.zzaAo)
      {
        bool1 = true;
        label38:
        zzac.zza(bool1, "Result has already been consumed.");
        if (this.zzaAr != null) {
          break label108;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.zztj.await(paramLong, paramTimeUnit)) {
          zzC(Status.zzazA);
        }
        zzac.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label38;
        label108:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzC(Status.zzazy);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (this.zzaAh)
    {
      if ((this.zzK) || (this.zzaAo)) {
        return;
      }
      zzs localzzs = this.zzaAq;
      if (localzzs == null) {}
    }
    try
    {
      this.zzaAq.cancel();
      label42:
      zzd(this.zzazt);
      this.zzK = true;
      zzc(zzc(Status.zzazB));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      break label42;
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (this.zzaAh)
    {
      boolean bool = this.zzK;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.zztj.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    Object localObject = this.zzaAh;
    if (paramResultCallback == null) {}
    try
    {
      this.zzaAl = null;
      return;
    }
    finally {}
    if (!this.zzaAo)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (this.zzaAr != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (isReady()) {
      this.zzaAi.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzaAl = paramResultCallback;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    Object localObject = this.zzaAh;
    if (paramResultCallback == null) {}
    try
    {
      this.zzaAl = null;
      return;
    }
    finally {}
    if (!this.zzaAo)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
      if (this.zzaAr != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zza(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label90;
      }
      return;
      bool1 = false;
      break;
    }
    label90:
    if (isReady()) {
      this.zzaAi.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzaAl = paramResultCallback;
      this.zzaAi.zza(this, paramTimeUnit.toMillis(paramLong));
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.zzaAo)
    {
      bool1 = true;
      zzac.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (this.zzaAh)
      {
        if (this.zzaAr != null) {
          break label152;
        }
        bool1 = true;
        zzac.zza(bool1, "Cannot call then() twice.");
        if (this.zzaAl != null) {
          break label157;
        }
        bool1 = true;
        zzac.zza(bool1, "Cannot call then() if callbacks are set.");
        if (this.zzK) {
          break label162;
        }
        bool1 = bool2;
        zzac.zza(bool1, "Cannot call then() if result was canceled.");
        this.zzaAs = true;
        this.zzaAr = new zzabx(this.zzaAj);
        paramResultTransform = this.zzaAr.then(paramResultTransform);
        if (isReady())
        {
          this.zzaAi.zza(this.zzaAr, get());
          return paramResultTransform;
        }
        this.zzaAl = this.zzaAr;
      }
      bool1 = false;
      break;
      label152:
      bool1 = false;
      continue;
      label157:
      bool1 = false;
      continue;
      label162:
      bool1 = false;
    }
  }
  
  public final void zzC(Status paramStatus)
  {
    synchronized (this.zzaAh)
    {
      if (!isReady())
      {
        zzb(zzc(paramStatus));
        this.zzaAp = true;
      }
      return;
    }
  }
  
  public final void zza(PendingResult.zza paramzza)
  {
    if (paramzza != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Callback cannot be null.");
      synchronized (this.zzaAh)
      {
        if (isReady())
        {
          paramzza.zzy(this.zzair);
          return;
        }
        this.zzaAk.add(paramzza);
      }
    }
  }
  
  protected final void zza(zzs paramzzs)
  {
    synchronized (this.zzaAh)
    {
      this.zzaAq = paramzzs;
      return;
    }
  }
  
  public void zza(zzaby.zzb paramzzb)
  {
    this.zzaAm.set(paramzzb);
  }
  
  public final void zzb(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzaAh)
      {
        if ((!this.zzaAp) && (!this.zzK))
        {
          if ((!isReady()) || (!isReady()))
          {
            bool1 = true;
            zzac.zza(bool1, "Results have already been set");
            if (this.zzaAo) {
              break label91;
            }
            bool1 = bool2;
            zzac.zza(bool1, "Result has already been consumed");
            zzc(paramR);
          }
        }
        else
        {
          zzd(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label91:
      bool1 = false;
    }
  }
  
  public abstract R zzc(Status paramStatus);
  
  public boolean zzvF()
  {
    synchronized (this.zzaAh)
    {
      if (((GoogleApiClient)this.zzaAj.get() == null) || (!this.zzaAs)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public void zzvH()
  {
    setResultCallback(null);
  }
  
  public void zzvI()
  {
    if ((this.zzaAs) || (((Boolean)zzaAg.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaAs = bool;
      return;
    }
  }
  
  public Integer zzvr()
  {
    return null;
  }
  
  private final class zzb
  {
    private zzb() {}
    
    protected final void finalize()
    {
      zzaaf.zzd(zzaaf.zza(zzaaf.this));
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaf
 * JD-Core Version:    0.7.0.1
 */