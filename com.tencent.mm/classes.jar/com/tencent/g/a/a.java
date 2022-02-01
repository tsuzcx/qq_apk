package com.tencent.g.a;

public abstract class a
  implements Runnable
{
  public abstract void byO();
  
  public void run()
  {
    try
    {
      byO();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.a.a
 * JD-Core Version:    0.7.0.1
 */