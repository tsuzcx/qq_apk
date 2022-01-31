package com.tencent.e.e.a.a;

public abstract class c
  implements Runnable
{
  public abstract void dUF();
  
  public abstract void dUG();
  
  public void run()
  {
    try
    {
      dUF();
      return;
    }
    catch (Throwable localThrowable)
    {
      dUG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */