package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class RegisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder<L> zzls;
  
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder)
  {
    this.zzls = paramListenerHolder;
  }
  
  public void clearListener()
  {
    this.zzls.clear();
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zzls.getListenerKey();
  }
  
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.RegisterListenerMethod
 * JD-Core Version:    0.7.0.1
 */