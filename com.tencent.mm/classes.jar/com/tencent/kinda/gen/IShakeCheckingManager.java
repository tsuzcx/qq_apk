package com.tencent.kinda.gen;

public abstract interface IShakeCheckingManager
{
  public abstract void playShakeMatch(boolean paramBoolean);
  
  public abstract void playShakeSound();
  
  public abstract void setDelayNotifyCallBackImpl(VoidCallback paramVoidCallback, int paramInt);
  
  public abstract void setOnShakeCallBackImpl(VoidCallback paramVoidCallback);
  
  public abstract void startCheck();
  
  public abstract void stopCheck();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.kinda.gen.IShakeCheckingManager
 * JD-Core Version:    0.7.0.1
 */