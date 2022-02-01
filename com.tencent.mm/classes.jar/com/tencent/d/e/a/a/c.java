package com.tencent.d.e.a.a;

public abstract class c
  implements Runnable
{
  public abstract void aQi();
  
  public abstract void fCC();
  
  public void run()
  {
    try
    {
      aQi();
      return;
    }
    catch (Throwable localThrowable)
    {
      fCC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */