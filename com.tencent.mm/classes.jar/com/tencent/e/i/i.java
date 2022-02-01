package com.tencent.e.i;

public abstract class i
  implements f<Runnable>, Runnable
{
  protected abstract void byO();
  
  public final void run()
  {
    byP();
    try
    {
      byO();
      return;
    }
    finally
    {
      co(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.i.i
 * JD-Core Version:    0.7.0.1
 */