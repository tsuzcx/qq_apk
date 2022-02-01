package com.tencent.kinda.gen;

public abstract interface KTimerService
{
  public abstract void dispatchAfterImpl(float paramFloat, VoidCallback paramVoidCallback);
  
  public abstract void initIntervalAndCheckedCallbackImpl(float paramFloat, VoidCallback paramVoidCallback);
  
  public abstract double now();
  
  public abstract void startTimeCheck();
  
  public abstract void stopTimeCheck();
  
  public abstract void throttleImpl(float paramFloat, VoidCallback paramVoidCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.KTimerService
 * JD-Core Version:    0.7.0.1
 */