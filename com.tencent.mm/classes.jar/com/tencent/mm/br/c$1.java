package com.tencent.mm.br;

import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;

final class c$1
  extends a
{
  c$1(String paramString, p paramp) {}
  
  public final void execute(g paramg)
  {
    String str = this.soo;
    p localp = this.sop;
    d.a(str, c.som, c.son);
    paramg = localp;
    if (localp == null) {
      paramg = new p(c.Xh(str));
    }
    p.a("plugin." + str, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.br.c.1
 * JD-Core Version:    0.7.0.1
 */