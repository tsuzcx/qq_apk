package com.tencent.maas.camerafun;

import com.tencent.maas.internal.NativeCallbackManager.Callback;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import java.lang.ref.WeakReference;

abstract class MJCamFunSessionCallback$BaseCallback<T>
  extends NativeCallbackManager.Callback
{
  private final WeakReference<MJCamFunSession> mjCamFunSessionWeakReference;
  
  public MJCamFunSessionCallback$BaseCallback(MJCamFunSession paramMJCamFunSession)
  {
    this.mjCamFunSessionWeakReference = new WeakReference(paramMJCamFunSession);
  }
  
  public MJCamFunSessionCallback$BaseCallback(MJCamFunSession paramMJCamFunSession, boolean paramBoolean)
  {
    super(paramBoolean);
    this.mjCamFunSessionWeakReference = new WeakReference(paramMJCamFunSession);
  }
  
  public final void invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    onInvoke((MJCamFunSession)this.mjCamFunSessionWeakReference.get(), paramCallbackArgs);
  }
  
  public abstract void onInvoke(MJCamFunSession paramMJCamFunSession, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSessionCallback.BaseCallback
 * JD-Core Version:    0.7.0.1
 */