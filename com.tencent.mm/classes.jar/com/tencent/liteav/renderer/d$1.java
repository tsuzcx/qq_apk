package com.tencent.liteav.renderer;

class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt) {}
  
  public void run()
  {
    d.a(this.b, this.a);
    if (d.a(this.b) <= 0) {
      d.a(this.b, 1);
    }
    for (;;)
    {
      d.a(this.b, 0L);
      d.b(this.b, 0L);
      return;
      if (d.a(this.b) > 60) {
        d.a(this.b, 60);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.d.1
 * JD-Core Version:    0.7.0.1
 */