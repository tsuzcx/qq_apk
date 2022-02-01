package com.tencent.d.e.a.a;

public abstract class c
  implements Runnable
{
  public abstract void aJr();
  
  public abstract void fml();
  
  public void run()
  {
    try
    {
      aJr();
      return;
    }
    catch (Throwable localThrowable)
    {
      fml();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */