package com.tencent.maas.instamovie;

import com.tencent.maas.MJMaasCore;
import com.tencent.maas.internal.NativeCallbackManager.Callback;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import java.lang.ref.WeakReference;

abstract class MJMaasCoreCallback$BaseCallback<T>
  extends NativeCallbackManager.Callback
{
  private final WeakReference<MJMaasCore> massCoreRef;
  
  public MJMaasCoreCallback$BaseCallback(MJMaasCore paramMJMaasCore)
  {
    this.massCoreRef = new WeakReference(paramMJMaasCore);
  }
  
  public MJMaasCoreCallback$BaseCallback(MJMaasCore paramMJMaasCore, boolean paramBoolean)
  {
    super(paramBoolean);
    this.massCoreRef = new WeakReference(paramMJMaasCore);
  }
  
  public final void invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    onInvoke((MJMaasCore)this.massCoreRef.get(), paramCallbackArgs);
  }
  
  public abstract void onInvoke(MJMaasCore paramMJMaasCore, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.BaseCallback
 * JD-Core Version:    0.7.0.1
 */