package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends Result>
  extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zzez = new zzo();
  private zza mResultGuardian;
  private Status mStatus;
  private R zzdm;
  private final Object zzfa = new Object();
  private final CallbackHandler<R> zzfb;
  private final WeakReference<GoogleApiClient> zzfc;
  private final CountDownLatch zzfd = new CountDownLatch(1);
  private final ArrayList<PendingResult.StatusListener> zzfe = new ArrayList();
  private ResultCallback<? super R> zzff;
  private final AtomicReference<zzcn> zzfg = new AtomicReference();
  private volatile boolean zzfh;
  private boolean zzfi;
  private boolean zzfj;
  private ICancelToken zzfk;
  private volatile zzch<R> zzfl;
  private boolean zzfm = false;
  
  @Deprecated
  BasePendingResult()
  {
    this.zzfb = new CallbackHandler(Looper.getMainLooper());
    this.zzfc = new WeakReference(null);
  }
  
  @Deprecated
  protected BasePendingResult(Looper paramLooper)
  {
    this.zzfb = new CallbackHandler(paramLooper);
    this.zzfc = new WeakReference(null);
  }
  
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      this.zzfb = new CallbackHandler(localLooper);
      this.zzfc = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  protected BasePendingResult(CallbackHandler<R> paramCallbackHandler)
  {
    this.zzfb = ((CallbackHandler)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null"));
    this.zzfc = new WeakReference(null);
  }
  
  private final R get()
  {
    boolean bool = true;
    synchronized (this.zzfa)
    {
      if (!this.zzfh)
      {
        Preconditions.checkState(bool, "Result has already been consumed.");
        Preconditions.checkState(isReady(), "Result is not ready.");
        Result localResult = this.zzdm;
        this.zzdm = null;
        this.zzff = null;
        this.zzfh = true;
        ??? = (zzcn)this.zzfg.getAndSet(null);
        if (??? != null) {
          ((zzcn)???).zzc(this);
        }
        return localResult;
      }
      bool = false;
    }
  }
  
  private final void zza(R paramR)
  {
    this.zzdm = paramR;
    this.zzfk = null;
    this.zzfd.countDown();
    this.mStatus = this.zzdm.getStatus();
    if (this.zzfi) {
      this.zzff = null;
    }
    for (;;)
    {
      paramR = (ArrayList)this.zzfe;
      int j = paramR.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramR.get(i);
        i += 1;
        ((PendingResult.StatusListener)localObject).onComplete(this.mStatus);
      }
      if (this.zzff == null)
      {
        if ((this.zzdm instanceof Releasable)) {
          this.mResultGuardian = new zza(null);
        }
      }
      else
      {
        this.zzfb.removeMessages(2);
        this.zzfb.zza(this.zzff, get());
      }
    }
    this.zzfe.clear();
  }
  
  public static void zzb(Result paramResult)
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
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    if (paramStatusListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Callback cannot be null.");
      synchronized (this.zzfa)
      {
        if (isReady())
        {
          paramStatusListener.onComplete(this.mStatus);
          return;
        }
        this.zzfe.add(paramStatusListener);
      }
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool1;
    if (!this.zzfh) {
      bool1 = true;
    }
    for (;;)
    {
      Preconditions.checkState(bool1, "Result has already been consumed");
      if (this.zzfl == null)
      {
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        this.zzfd.await();
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzb(Status.RESULT_INTERRUPTED);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    if (paramLong > 0L) {
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
    }
    boolean bool1;
    if (!this.zzfh) {
      bool1 = true;
    }
    for (;;)
    {
      Preconditions.checkState(bool1, "Result has already been consumed.");
      if (this.zzfl == null)
      {
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!this.zzfd.await(paramLong, paramTimeUnit)) {
          zzb(Status.RESULT_TIMEOUT);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzb(Status.RESULT_INTERRUPTED);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (this.zzfa)
    {
      if ((this.zzfi) || (this.zzfh)) {
        return;
      }
      ICancelToken localICancelToken = this.zzfk;
      if (localICancelToken == null) {}
    }
    try
    {
      this.zzfk.cancel();
      label42:
      zzb(this.zzdm);
      this.zzfi = true;
      zza(createFailedResult(Status.RESULT_CANCELED));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      break label42;
    }
  }
  
  protected abstract R createFailedResult(Status paramStatus);
  
  public boolean isCanceled()
  {
    synchronized (this.zzfa)
    {
      boolean bool = this.zzfi;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return this.zzfd.getCount() == 0L;
  }
  
  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    synchronized (this.zzfa)
    {
      this.zzfk = paramICancelToken;
      return;
    }
  }
  
  public final void setResult(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.zzfa)
      {
        if ((!this.zzfj) && (!this.zzfi))
        {
          if ((!isReady()) || (!isReady()))
          {
            bool1 = true;
            Preconditions.checkState(bool1, "Results have already been set");
            if (this.zzfh) {
              break label91;
            }
            bool1 = bool2;
            Preconditions.checkState(bool1, "Result has already been consumed");
            zza(paramR);
          }
        }
        else
        {
          zzb(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label91:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    Object localObject = this.zzfa;
    if (paramResultCallback == null) {}
    try
    {
      this.zzff = null;
      return;
    }
    finally {}
    if (!this.zzfh)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Result has already been consumed.");
      if (this.zzfl != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label82;
      }
      return;
      bool1 = false;
      break;
    }
    label82:
    if (isReady()) {
      this.zzfb.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzff = paramResultCallback;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    Object localObject = this.zzfa;
    if (paramResultCallback == null) {}
    try
    {
      this.zzff = null;
      return;
    }
    finally {}
    if (!this.zzfh)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Result has already been consumed.");
      if (this.zzfl != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
      if (!isCanceled()) {
        break label90;
      }
      return;
      bool1 = false;
      break;
    }
    label90:
    if (isReady()) {
      this.zzfb.zza(paramResultCallback, get());
    }
    for (;;)
    {
      return;
      this.zzff = paramResultCallback;
      paramResultCallback = this.zzfb;
      paramLong = paramTimeUnit.toMillis(paramLong);
      paramResultCallback.sendMessageDelayed(paramResultCallback.obtainMessage(2, this), paramLong);
    }
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.zzfh)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (this.zzfa)
      {
        if (this.zzfl != null) {
          break label152;
        }
        bool1 = true;
        Preconditions.checkState(bool1, "Cannot call then() twice.");
        if (this.zzff != null) {
          break label157;
        }
        bool1 = true;
        Preconditions.checkState(bool1, "Cannot call then() if callbacks are set.");
        if (this.zzfi) {
          break label162;
        }
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot call then() if result was canceled.");
        this.zzfm = true;
        this.zzfl = new zzch(this.zzfc);
        paramResultTransform = this.zzfl.then(paramResultTransform);
        if (isReady())
        {
          this.zzfb.zza(this.zzfl, get());
          return paramResultTransform;
        }
        this.zzff = this.zzfl;
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
  
  public final void zza(zzcn paramzzcn)
  {
    this.zzfg.set(paramzzcn);
  }
  
  public final void zzb(Status paramStatus)
  {
    synchronized (this.zzfa)
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        this.zzfj = true;
      }
      return;
    }
  }
  
  public final Integer zzo()
  {
    return null;
  }
  
  public final boolean zzw()
  {
    synchronized (this.zzfa)
    {
      if (((GoogleApiClient)this.zzfc.get() == null) || (!this.zzfm)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
  }
  
  public final void zzx()
  {
    if ((this.zzfm) || (((Boolean)zzez.get()).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzfm = bool;
      return;
    }
  }
  
  public static class CallbackHandler<R extends Result>
    extends Handler
  {
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
      AppMethodBeat.i(11056);
      AppMethodBeat.o(11056);
    }
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(11058);
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
        AppMethodBeat.o(11058);
        return;
      case 1: 
        Object localObject = (Pair)paramMessage.obj;
        paramMessage = (ResultCallback)((Pair)localObject).first;
        localObject = (Result)((Pair)localObject).second;
        try
        {
          paramMessage.onResult((Result)localObject);
          AppMethodBeat.o(11058);
          return;
        }
        catch (RuntimeException paramMessage)
        {
          BasePendingResult.zzb((Result)localObject);
          AppMethodBeat.o(11058);
          throw paramMessage;
        }
      }
      ((BasePendingResult)paramMessage.obj).zzb(Status.RESULT_TIMEOUT);
      AppMethodBeat.o(11058);
    }
    
    public final void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      AppMethodBeat.i(11057);
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
      AppMethodBeat.o(11057);
    }
  }
  
  final class zza
  {
    private zza() {}
    
    protected final void finalize()
    {
      AppMethodBeat.i(11059);
      BasePendingResult.zzb(BasePendingResult.zza(BasePendingResult.this));
      super.finalize();
      AppMethodBeat.o(11059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BasePendingResult
 * JD-Core Version:    0.7.0.1
 */