package com.tencent.matrix.trace.f;

public abstract class f
  extends com.tencent.matrix.trace.e.c
  implements d
{
  public volatile boolean cBX = false;
  
  public final void Ig()
  {
    try
    {
      if (!this.cBX)
      {
        this.cBX = true;
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
  
  public final void Ih()
  {
    try
    {
      if (this.cBX)
      {
        this.cBX = false;
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
    com.tencent.matrix.g.c.i("Matrix.Tracer", "[onAlive] %s", new Object[] { getClass().getName() });
  }
  
  protected void onDead()
  {
    com.tencent.matrix.g.c.i("Matrix.Tracer", "[onDead] %s", new Object[] { getClass().getName() });
  }
  
  public void onForeground(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.f.f
 * JD-Core Version:    0.7.0.1
 */