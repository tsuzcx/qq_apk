package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder.ListenerKey<L> zzlj;
  
  protected UnregisterListenerMethod(ListenerHolder.ListenerKey<L> paramListenerKey)
  {
    this.zzlj = paramListenerKey;
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zzlj;
  }
  
  protected abstract void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.UnregisterListenerMethod
 * JD-Core Version:    0.7.0.1
 */