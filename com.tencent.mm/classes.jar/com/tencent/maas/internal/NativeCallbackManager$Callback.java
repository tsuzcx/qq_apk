package com.tencent.maas.internal;

public abstract class NativeCallbackManager$Callback
{
  public final boolean callOnce;
  
  public NativeCallbackManager$Callback()
  {
    this.callOnce = true;
  }
  
  public NativeCallbackManager$Callback(boolean paramBoolean)
  {
    this.callOnce = paramBoolean;
  }
  
  public abstract void invoke(NativeCallbackManager.CallbackArgs paramCallbackArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.internal.NativeCallbackManager.Callback
 * JD-Core Version:    0.7.0.1
 */