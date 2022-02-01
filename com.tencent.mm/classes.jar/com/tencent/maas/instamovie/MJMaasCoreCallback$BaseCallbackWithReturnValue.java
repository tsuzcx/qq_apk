package com.tencent.maas.instamovie;

import com.tencent.maas.MJMaasCore;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import com.tencent.maas.internal.NativeCallbackManager.CallbackWithReturnValue;
import java.lang.ref.WeakReference;

abstract class MJMaasCoreCallback$BaseCallbackWithReturnValue<T>
  extends NativeCallbackManager.CallbackWithReturnValue
{
  private final WeakReference<MJMaasCore> massCoreRef;
  
  public MJMaasCoreCallback$BaseCallbackWithReturnValue(MJMaasCore paramMJMaasCore)
  {
    this.massCoreRef = new WeakReference(paramMJMaasCore);
  }
  
  public MJMaasCoreCallback$BaseCallbackWithReturnValue(MJMaasCore paramMJMaasCore, boolean paramBoolean)
  {
    super(paramBoolean);
    this.massCoreRef = new WeakReference(paramMJMaasCore);
  }
  
  public final Object invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    return onInvokeWithReturnValue((MJMaasCore)this.massCoreRef.get(), paramCallbackArgs);
  }
  
  public abstract Object onInvokeWithReturnValue(MJMaasCore paramMJMaasCore, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.BaseCallbackWithReturnValue
 * JD-Core Version:    0.7.0.1
 */