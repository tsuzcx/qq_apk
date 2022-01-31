package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.LinkedList;

class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public void run()
  {
    while ((a.b(this.a) != null) && (!a.b(this.a).isEmpty()) && (!a.c(this.a)))
    {
      this.a.c();
      com.tencent.liteav.basic.f.b localb1 = a.d(this.a);
      if (localb1 != null) {
        if ((localb1 != null) && (a.e(this.a) != null))
        {
          a.e(this.a).b(localb1);
          while (!a.f(this.a).isEmpty())
          {
            com.tencent.liteav.basic.f.b localb2 = (com.tencent.liteav.basic.f.b)a.f(this.a).getFirst();
            if (localb2.g > localb1.h) {
              break;
            }
            a.e(this.a).c(localb2);
            a.f(this.a).removeFirst();
          }
        }
      }
    }
    long l1 = TXCTimeUtil.getTimeTick();
    if (l1 > a.g(this.a) + 200L)
    {
      a.b(this.a, a.h(this.a) + this.a.d());
      a.i(this.a);
      long l2 = this.a.e();
      a.c(this.a, a.j(this.a) + l2);
      a.k(this.a);
      if (a.l(this.a) > 0L) {
        a.d(this.a, a.j(this.a) / a.l(this.a));
      }
      if (l2 > a.m(this.a)) {
        a.e(this.a, l2);
      }
      a.a(this.a, l1);
    }
    if (a.n(this.a)) {
      a.o(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.b.a.4
 * JD-Core Version:    0.7.0.1
 */