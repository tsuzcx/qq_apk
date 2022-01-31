package com.tencent.matrix.trace.f;

public abstract class f
  extends com.tencent.matrix.trace.e.c
  implements d
{
  private volatile boolean bRn = false;
  
  public void onForeground(boolean paramBoolean) {}
  
  public final void zA()
  {
    try
    {
      if (!this.bRn)
      {
        this.bRn = true;
        zy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zB()
  {
    try
    {
      if (this.bRn)
      {
        this.bRn = false;
        zz();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void zy()
  {
    com.tencent.matrix.g.c.i("Matrix.Tracer", "[onAlive] %s", new Object[] { getClass().getName() });
  }
  
  protected void zz()
  {
    com.tencent.matrix.g.c.i("Matrix.Tracer", "[onDead] %s", new Object[] { getClass().getName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.f
 * JD-Core Version:    0.7.0.1
 */