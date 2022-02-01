package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcf
  extends TaskApiCall<A, ResultT>
{
  zzcf(TaskApiCall.Builder paramBuilder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    super(paramArrayOfFeature, paramBoolean, null);
  }
  
  protected final void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource)
  {
    AppMethodBeat.i(11367);
    TaskApiCall.Builder.zza(this.zzmc).accept(paramA, paramTaskCompletionSource);
    AppMethodBeat.o(11367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcf
 * JD-Core Version:    0.7.0.1
 */