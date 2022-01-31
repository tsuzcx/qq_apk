package com.tencent.liteav.beauty.b;

class u$1
  implements Runnable
{
  u$1(u paramu) {}
  
  public void run()
  {
    synchronized (u.a(this.a))
    {
      u.b(this.a);
      u.a(this.a).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.u.1
 * JD-Core Version:    0.7.0.1
 */