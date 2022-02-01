package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PendingResultUtil
{
  private static final StatusConverter zzun;
  
  static
  {
    AppMethodBeat.i(11850);
    zzun = new zzk();
    AppMethodBeat.o(11850);
  }
  
  public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT)
  {
    AppMethodBeat.i(11848);
    paramPendingResult = toTask(paramPendingResult, new zzm(paramT));
    AppMethodBeat.o(11848);
    return paramPendingResult;
  }
  
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter)
  {
    AppMethodBeat.i(11847);
    paramPendingResult = toTask(paramPendingResult, paramResultConverter, zzun);
    AppMethodBeat.o(11847);
    return paramPendingResult;
  }
  
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter, StatusConverter paramStatusConverter)
  {
    AppMethodBeat.i(11846);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zzl(paramPendingResult, localTaskCompletionSource, paramResultConverter, paramStatusConverter));
    paramPendingResult = localTaskCompletionSource.getTask();
    AppMethodBeat.o(11846);
    return paramPendingResult;
  }
  
  public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult)
  {
    AppMethodBeat.i(11849);
    paramPendingResult = toTask(paramPendingResult, new zzn());
    AppMethodBeat.o(11849);
    return paramPendingResult;
  }
  
  public static abstract interface ResultConverter<R extends Result, T>
  {
    public abstract T convert(R paramR);
  }
  
  public static abstract interface StatusConverter
  {
    public abstract ApiException convert(Status paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.PendingResultUtil
 * JD-Core Version:    0.7.0.1
 */