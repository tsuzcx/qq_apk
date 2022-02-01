package com.tencent.mm.loader.d;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "run"})
public final class b$c
  implements Runnable
{
  public b$c(b paramb, com.tencent.mm.loader.g.b paramb1, a parama, g paramg, b.a parama1) {}
  
  public final void run()
  {
    this.iab.execute((Runnable)new Runnable()
    {
      public final void run()
      {
        this.iaf.iaa.a(this.iaf.iac, this.iaf.iad, (b.b)new b.b()
        {
          public final void a(f<?> paramAnonymous2f)
          {
            p.h(paramAnonymous2f, "resp");
            this.iag.iaf.iae.a(paramAnonymous2f);
          }
          
          public final void onError()
          {
            this.iag.iaf.iae.onError();
          }
        });
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.c
 * JD-Core Version:    0.7.0.1
 */