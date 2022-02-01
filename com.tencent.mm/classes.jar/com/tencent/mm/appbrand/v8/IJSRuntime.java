package com.tencent.mm.appbrand.v8;

import com.tencent.mm.plugin.appbrand.m.h;

public abstract interface IJSRuntime
{
  public abstract String LP();
  
  public abstract IJSRuntime.Config Xr();
  
  public abstract boolean Xw();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void cS(boolean paramBoolean);
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract m iP(int paramInt);
  
  public abstract void pause();
  
  public abstract void quit();
  
  public abstract void r(Runnable paramRunnable);
  
  public abstract void resume();
  
  public abstract void resumeLoopTasks();
  
  public abstract void s(Runnable paramRunnable);
  
  public abstract void setThreadPriority(int paramInt);
  
  public abstract void t(Runnable paramRunnable);
  
  public abstract void waitForDebugger(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */