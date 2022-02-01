package com.tencent.d.e.a.a;

public abstract class c
  implements Runnable
{
  public abstract void byO();
  
  public abstract void ioc();
  
  public void run()
  {
    try
    {
      byO();
      return;
    }
    catch (Throwable localThrowable)
    {
      ioc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */