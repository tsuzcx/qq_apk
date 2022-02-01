package com.tencent.d.e.a.a;

public abstract class c
  implements Runnable
{
  public abstract void aTT();
  
  public abstract void fYs();
  
  public void run()
  {
    try
    {
      aTT();
      return;
    }
    catch (Throwable localThrowable)
    {
      fYs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */