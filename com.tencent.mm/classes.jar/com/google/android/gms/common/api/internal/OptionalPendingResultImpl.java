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
    AppMethodBeat.i(60650);
    this.zzlo = ((BasePendingResult)paramPendingResult);
    AppMethodBeat.o(60650);
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    AppMethodBeat.i(60659);
    this.zzlo.addStatusListener(paramStatusListener);
    AppMethodBeat.o(60659);
  }
  
  public final R await()
  {
    AppMethodBeat.i(60653);
    Result localResult = this.zzlo.await();
    AppMethodBeat.o(60653);
    return localResult;
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(60654);
    paramTimeUnit = this.zzlo.await(paramLong, paramTimeUnit);
    AppMethodBeat.o(60654);
    return paramTimeUnit;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(60655);
    this.zzlo.cancel();
    AppMethodBeat.o(60655);
  }
  
  public final R get()
  {
    AppMethodBeat.i(60652);
    if (isDone())
    {
      localObject = await(0L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(60652);
      return localObject;
    }
    Object localObject = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    AppMethodBeat.o(60652);
    throw ((Throwable)localObject);
  }
  
  public final boolean isCanceled()
  {
    AppMethodBeat.i(60656);
    boolean bool = this.zzlo.isCanceled();
    AppMethodBeat.o(60656);
    return bool;
  }
  
  public final boolean isDone()
  {
    AppMethodBeat.i(60651);
    boolean bool = this.zzlo.isReady();
    AppMethodBeat.o(60651);
    return bool;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    AppMethodBeat.i(60657);
    this.zzlo.setResultCallback(paramResultCallback);
    AppMethodBeat.o(60657);
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(60658);
    this.zzlo.setResultCallback(paramResultCallback, paramLong, paramTimeUnit);
    AppMethodBeat.o(60658);
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    AppMethodBeat.i(60660);
    paramResultTransform = this.zzlo.then(paramResultTransform);
    AppMethodBeat.o(60660);
    return paramResultTransform;
  }
  
  public final Integer zzo()
  {
    AppMethodBeat.i(60661);
    Integer localInteger = this.zzlo.zzo();
    AppMethodBeat.o(60661);
    return localInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.OptionalPendingResultImpl
 * JD-Core Version:    0.7.0.1
 */