package com.tencent.liteav;

import com.tencent.liteav.capturer.a;

class b$7
  implements Runnable
{
  b$7(b paramb) {}
  
  public void run()
  {
    if (b.c(this.a) != -1)
    {
      b.a(this.a, b.c(this.a));
      b.b(this.a, -1);
    }
    if (b.d(this.a) != -1)
    {
      b.b(this.a).l = b.d(this.a);
      b.e(this.a).d(b.b(this.a).l);
      b.c(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.b.7
 * JD-Core Version:    0.7.0.1
 */