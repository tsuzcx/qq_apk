package com.tencent.liteav.basic.util;

class b$1
  implements Runnable
{
  b$1(b paramb, Runnable paramRunnable, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    this.a.run();
    this.b[0] = true;
    synchronized (b.a(this.c))
    {
      b.a(this.c).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.util.b.1
 * JD-Core Version:    0.7.0.1
 */