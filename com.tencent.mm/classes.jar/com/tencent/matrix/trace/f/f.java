package com.tencent.matrix.trace.f;

public abstract class f
  extends com.tencent.matrix.trace.e.c
  implements d
{
  public volatile boolean dfl = false;
  
  public final void Yk()
  {
    try
    {
      if (!this.dfl)
      {
        this.dfl = true;
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
  
  public final void Yl()
  {
    try
    {
      if (this.dfl)
      {
        this.dfl = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.f
 * JD-Core Version:    0.7.0.1
 */