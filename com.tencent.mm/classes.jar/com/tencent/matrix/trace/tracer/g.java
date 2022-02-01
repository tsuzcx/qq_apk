package com.tencent.matrix.trace.tracer;

public abstract class g
  extends com.tencent.matrix.trace.e.c
  implements c
{
  public volatile boolean fez = false;
  
  public final void aAa()
  {
    try
    {
      if (!this.fez)
      {
        this.fez = true;
        onAlive();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aAb()
  {
    try
    {
      if (this.fez)
      {
        this.fez = false;
        onDead();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void onAlive()
  {
    com.tencent.matrix.e.c.i("Matrix.Tracer", "[onAlive] %s", new Object[] { getClass().getName() });
  }
  
  protected void onDead()
  {
    com.tencent.matrix.e.c.i("Matrix.Tracer", "[onDead] %s", new Object[] { getClass().getName() });
  }
  
  public void onForeground(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.g
 * JD-Core Version:    0.7.0.1
 */