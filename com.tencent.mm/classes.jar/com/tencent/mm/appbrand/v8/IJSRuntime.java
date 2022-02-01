package com.tencent.mm.appbrand.v8;

import com.tencent.mm.plugin.appbrand.jsruntime.h;

public abstract interface IJSRuntime
{
  public abstract String Cx();
  
  public abstract IJSRuntime.Config Nf();
  
  public abstract boolean Nk();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void b(Runnable paramRunnable, boolean paramBoolean);
  
  public abstract void cj(boolean paramBoolean);
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract m hv(int paramInt);
  
  public abstract void pause();
  
  public abstract void quit();
  
  public abstract void r(Runnable paramRunnable);
  
  public abstract void resume();
  
  public abstract void resumeLoopTasks();
  
  public abstract void s(Runnable paramRunnable);
  
  public abstract void setThreadPriority(int paramInt);
  
  public abstract void waitForDebugger(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */