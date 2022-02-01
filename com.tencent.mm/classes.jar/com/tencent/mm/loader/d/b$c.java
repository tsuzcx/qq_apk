package com.tencent.mm.loader.d;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "run"})
public final class b$c
  implements Runnable
{
  public b$c(b paramb, com.tencent.mm.loader.g.b paramb1, a parama, g paramg, b.a parama1) {}
  
  public final void run()
  {
    this.hhh.execute((Runnable)new Runnable()
    {
      public final void run()
      {
        this.hhl.hhg.a(this.hhl.hhi, this.hhl.hhj, (b.b)new b.b()
        {
          public final void a(f<?> paramAnonymous2f)
          {
            p.h(paramAnonymous2f, "resp");
            this.hhm.hhl.hhk.a(paramAnonymous2f);
          }
          
          public final void onError()
          {
            this.hhm.hhl.hhk.onError();
          }
        });
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.c
 * JD-Core Version:    0.7.0.1
 */