package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PendingResultUtil
{
  private static final PendingResultUtil.StatusConverter zzun;
  
  static
  {
    AppMethodBeat.i(61358);
    zzun = new zzk();
    AppMethodBeat.o(61358);
  }
  
  public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT)
  {
    AppMethodBeat.i(61356);
    paramPendingResult = toTask(paramPendingResult, new zzm(paramT));
    AppMethodBeat.o(61356);
    return paramPendingResult;
  }
  
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, PendingResultUtil.ResultConverter<R, T> paramResultConverter)
  {
    AppMethodBeat.i(61355);
    paramPendingResult = toTask(paramPendingResult, paramResultConverter, zzun);
    AppMethodBeat.o(61355);
    return paramPendingResult;
  }
  
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, PendingResultUtil.ResultConverter<R, T> paramResultConverter, PendingResultUtil.StatusConverter paramStatusConverter)
  {
    AppMethodBeat.i(61354);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zzl(paramPendingResult, localTaskCompletionSource, paramResultConverter, paramStatusConverter));
    paramPendingResult = localTaskCompletionSource.getTask();
    AppMethodBeat.o(61354);
    return paramPendingResult;
  }
  
  public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult)
  {
    AppMethodBeat.i(61357);
    paramPendingResult = toTask(paramPendingResult, new zzn());
    AppMethodBeat.o(61357);
    return paramPendingResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.PendingResultUtil
 * JD-Core Version:    0.7.0.1
 */