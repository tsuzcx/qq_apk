package com.tencent.e.i;

public abstract class i
  implements f<Runnable>, Runnable
{
  protected abstract void aTT();
  
  public final void run()
  {
    aTU();
    try
    {
      aTT();
      return;
    }
    finally
    {
      cg(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.i.i
 * JD-Core Version:    0.7.0.1
 */