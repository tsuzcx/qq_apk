package com.tencent.map.tools.sheet.listener;

public abstract class ModuleUncaughtListener
{
  private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;
  
  public ModuleUncaughtListener(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.mUncaughtExceptionHandler = paramUncaughtExceptionHandler;
  }
  
  public abstract boolean onModuleSDKCrashed(Throwable paramThrowable);
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (this.mUncaughtExceptionHandler != null) {
      this.mUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.sheet.listener.ModuleUncaughtListener
 * JD-Core Version:    0.7.0.1
 */