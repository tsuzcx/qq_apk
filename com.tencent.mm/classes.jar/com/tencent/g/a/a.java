package com.tencent.g.a;

public abstract class a
  implements Runnable
{
  public abstract void bXC();
  
  public void run()
  {
    try
    {
      bXC();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.a.a
 * JD-Core Version:    0.7.0.1
 */