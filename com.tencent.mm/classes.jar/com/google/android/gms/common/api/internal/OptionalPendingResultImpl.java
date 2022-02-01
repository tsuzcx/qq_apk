package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result>
  extends OptionalPendingResult<R>
{
  private final BasePendingResult<R> zzlo;
  
  public OptionalPendingResultImpl(PendingResult<R> paramPendingResult)
  {
    AppMethodBeat.i(11142);
    this.zzlo = ((BasePendingResult)paramPendingResult);
    AppMethodBeat.o(11142);
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    AppMethodBeat.i(11151);
    this.zzlo.addStatusListener(paramStatusListener);
    AppMethodBeat.o(11151);
  }
  
  public final R await()
  {
    AppMethodBeat.i(11145);
    Result localResult = this.zzlo.await();
    AppMethodBeat.o(11145);
    return localResult;
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11146);
    paramTimeUnit = this.zzlo.await(paramLong, paramTimeUnit);
    AppMethodBeat.o(11146);
    return paramTimeUnit;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(11147);
    this.zzlo.cancel();
    AppMethodBeat.o(11147);
  }
  
  public final R get()
  {
    AppMethodBeat.i(11144);
    if (isDone())
    {
      localObject = await(0L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(11144);
      return localObject;
    }
    Object localObject = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    AppMethodBeat.o(11144);
    throw ((Throwable)localObject);
  }
  
  public final boolean isCanceled()
  {
    AppMethodBeat.i(11148);
    boolean bool = this.zzlo.isCanceled();
    AppMethodBeat.o(11148);
    return bool;
  }
  
  public final boolean isDone()
  {
    AppMethodBeat.i(11143);
    boolean bool = this.zzlo.isReady();
    AppMethodBeat.o(11143);
    return bool;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    AppMethodBeat.i(11149);
    this.zzlo.setResultCallback(paramResultCallback);
    AppMethodBeat.o(11149);
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11150);
    this.zzlo.setResultCallback(paramResultCallback, paramLong, paramTimeUnit);
    AppMethodBeat.o(11150);
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    AppMethodBeat.i(11152);
    paramResultTransform = this.zzlo.then(paramResultTransform);
    AppMethodBeat.o(11152);
    return paramResultTransform;
  }
  
  public final Integer zzo()
  {
    AppMethodBeat.i(11153);
    Integer localInteger = this.zzlo.zzo();
    AppMethodBeat.o(11153);
    return localInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.OptionalPendingResultImpl
 * JD-Core Version:    0.7.0.1
 */