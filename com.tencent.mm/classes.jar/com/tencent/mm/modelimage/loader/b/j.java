package com.tencent.mm.modelimage.loader.b;

import java.util.concurrent.Executor;

public abstract interface j
  extends Executor
{
  public abstract boolean aFF();
  
  public abstract boolean isShutdown();
  
  public abstract void pause();
  
  public abstract void remove(Object paramObject);
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.b.j
 * JD-Core Version:    0.7.0.1
 */