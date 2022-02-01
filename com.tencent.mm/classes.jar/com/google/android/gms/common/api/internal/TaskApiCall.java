package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class TaskApiCall<A extends Api.AnyClient, ResultT>
{
  private final Feature[] zzlz;
  private final boolean zzma;
  
  @Deprecated
  public TaskApiCall()
  {
    this.zzlz = null;
    this.zzma = false;
  }
  
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zzlz = paramArrayOfFeature;
    this.zzma = paramBoolean;
  }
  
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder()
  {
    return new Builder(null);
  }
  
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource);
  
  public boolean shouldAutoResolveMissingFeatures()
  {
    return this.zzma;
  }
  
  public final Feature[] zzca()
  {
    return this.zzlz;
  }
  
  public static class Builder<A extends Api.AnyClient, ResultT>
  {
    private Feature[] zzlz;
    private boolean zzma = true;
    private BiConsumer<A, TaskCompletionSource<ResultT>> zzmb;
    
    public TaskApiCall<A, ResultT> build()
    {
      AppMethodBeat.i(11155);
      if (this.zzmb == null)
      {
        localObject = new IllegalArgumentException("execute parameter required");
        AppMethodBeat.o(11155);
        throw ((Throwable)localObject);
      }
      Object localObject = new zzcf(this, this.zzlz, this.zzma);
      AppMethodBeat.o(11155);
      return localObject;
    }
    
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> paramBiConsumer)
    {
      this.zzmb = paramBiConsumer;
      return this;
    }
    
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zzma = paramBoolean;
      return this;
    }
    
    public Builder<A, ResultT> setFeatures(Feature[] paramArrayOfFeature)
    {
      this.zzlz = paramArrayOfFeature;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.TaskApiCall
 * JD-Core Version:    0.7.0.1
 */