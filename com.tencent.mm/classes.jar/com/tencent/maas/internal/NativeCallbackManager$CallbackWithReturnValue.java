package com.tencent.maas.internal;

public abstract class NativeCallbackManager$CallbackWithReturnValue
{
  public final boolean callOnce;
  
  public NativeCallbackManager$CallbackWithReturnValue()
  {
    this.callOnce = true;
  }
  
  public NativeCallbackManager$CallbackWithReturnValue(boolean paramBoolean)
  {
    this.callOnce = paramBoolean;
  }
  
  public abstract Object invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.internal.NativeCallbackManager.CallbackWithReturnValue
 * JD-Core Version:    0.7.0.1
 */