package com.tencent.maas.instamovie;

import com.tencent.maas.internal.NativeCallbackManager.Callback;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import java.lang.ref.WeakReference;

abstract class MJMovieSessionCallback$BaseCallback<T>
  extends NativeCallbackManager.Callback
{
  private final WeakReference<MJMovieSession> mjMovieSessionRef;
  
  public MJMovieSessionCallback$BaseCallback(MJMovieSession paramMJMovieSession)
  {
    this.mjMovieSessionRef = new WeakReference(paramMJMovieSession);
  }
  
  public MJMovieSessionCallback$BaseCallback(MJMovieSession paramMJMovieSession, boolean paramBoolean)
  {
    super(paramBoolean);
    this.mjMovieSessionRef = new WeakReference(paramMJMovieSession);
  }
  
  public final void invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    onInvoke((MJMovieSession)this.mjMovieSessionRef.get(), paramCallbackArgs);
  }
  
  public abstract void onInvoke(MJMovieSession paramMJMovieSession, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionCallback.BaseCallback
 * JD-Core Version:    0.7.0.1
 */