package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;

abstract interface c
{
  public abstract String LP();
  
  public abstract boolean Xw();
  
  public abstract void a(a parama);
  
  public abstract void b(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void cS(boolean paramBoolean);
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void loop();
  
  public abstract void pause();
  
  public abstract void quit();
  
  public abstract void resume();
  
  public abstract void resumeLoopTasks();
  
  public abstract void u(Runnable paramRunnable);
  
  public static abstract interface a
  {
    public abstract void b(V8ScriptException paramV8ScriptException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.c
 * JD-Core Version:    0.7.0.1
 */