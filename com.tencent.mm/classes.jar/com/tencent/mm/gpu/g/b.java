package com.tencent.mm.gpu.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private static b gum;
  public String gul;
  private int gun;
  private e guo;
  private boolean gup;
  public a.a guq;
  
  static
  {
    AppMethodBeat.i(219573);
    gum = new b();
    AppMethodBeat.o(219573);
  }
  
  private b()
  {
    AppMethodBeat.i(219570);
    this.gul = "";
    this.gun = 0;
    this.guo = null;
    this.gup = false;
    this.guq = new a.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(219569);
        b.a(b.this);
        if (b.b(b.this) == null)
        {
          b.a(b.this, paramAnonymouse);
          AppMethodBeat.o(219569);
          return;
        }
        long l1 = paramAnonymouse.gtY + 0L + paramAnonymouse.gtW + paramAnonymouse.gtX;
        long l2 = b.b(b.this).gtY + 0L + b.b(b.this).gtW + b.b(b.this).gtX;
        ad.i("MicroMsg.KeyBusinessMonitor", "name:%s,time:%d,now:%d,last:%d", new Object[] { b.c(b.this), Integer.valueOf(b.d(b.this)), Long.valueOf(l1), Long.valueOf(l2) });
        if ((l1 - l2) * 100.0D / l2 > 0.05D) {
          b.e(b.this);
        }
        if (!b.f(b.this))
        {
          b.g(b.this);
          AppMethodBeat.o(219569);
          return;
        }
        if (b.d(b.this) >= 4) {
          g.yhR.kvStat(20507, "finder");
        }
        b.a(b.this, paramAnonymouse);
        AppMethodBeat.o(219569);
      }
    };
    AppMethodBeat.o(219570);
  }
  
  public static b aha()
  {
    return gum;
  }
  
  private void clear()
  {
    this.gul = "";
    this.gun = 0;
    this.gup = false;
    this.guo = null;
  }
  
  public final void ahb()
  {
    AppMethodBeat.i(219571);
    a.agX().a(this.guq);
    clear();
    AppMethodBeat.o(219571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.g.b
 * JD-Core Version:    0.7.0.1
 */