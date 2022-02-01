package com.tencent.h.a;

public abstract class a
  implements Runnable
{
  public abstract void boF();
  
  public void run()
  {
    try
    {
      boF();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.a.a
 * JD-Core Version:    0.7.0.1
 */