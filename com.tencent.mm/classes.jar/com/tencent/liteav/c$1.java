package com.tencent.liteav;

import com.tencent.liteav.videoencoder.b;

class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if ((this.a != 0) && (this.b != 0))
    {
      c.a(this.d).a = this.a;
      c.a(this.d).b = this.b;
      if (c.b(this.d) != null) {
        c.b(this.d).a(this.a, this.b);
      }
    }
    if ((this.c != 0) && (c.c(this.d) != null))
    {
      c.a(this.d).c = this.c;
      c.c(this.d).a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.c.1
 * JD-Core Version:    0.7.0.1
 */