package com.tencent.mm.gpu.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  private static b gwT;
  public String gwS;
  private int gwU;
  private e gwV;
  private boolean gwW;
  public a.a gwX;
  
  static
  {
    AppMethodBeat.i(209695);
    gwT = new b();
    AppMethodBeat.o(209695);
  }
  
  private b()
  {
    AppMethodBeat.i(209692);
    this.gwS = "";
    this.gwU = 0;
    this.gwV = null;
    this.gwW = false;
    this.gwX = new a.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(209691);
        b.a(b.this);
        if (b.b(b.this) == null)
        {
          b.a(b.this, paramAnonymouse);
          AppMethodBeat.o(209691);
          return;
        }
        long l1 = paramAnonymouse.gwF + 0L + paramAnonymouse.gwD + paramAnonymouse.gwE;
        long l2 = b.b(b.this).gwF + 0L + b.b(b.this).gwD + b.b(b.this).gwE;
        ae.i("MicroMsg.KeyBusinessMonitor", "name:%s,time:%d,now:%d,last:%d", new Object[] { b.c(b.this), Integer.valueOf(b.d(b.this)), Long.valueOf(l1), Long.valueOf(l2) });
        if ((l1 - l2) * 100.0D / l2 > 0.05D) {
          b.e(b.this);
        }
        if (!b.f(b.this))
        {
          b.g(b.this);
          AppMethodBeat.o(209691);
          return;
        }
        if (b.d(b.this) >= 4) {
          g.yxI.kvStat(20507, "finder");
        }
        b.a(b.this, paramAnonymouse);
        AppMethodBeat.o(209691);
      }
    };
    AppMethodBeat.o(209692);
  }
  
  public static b ahp()
  {
    return gwT;
  }
  
  private void clear()
  {
    this.gwS = "";
    this.gwU = 0;
    this.gwW = false;
    this.gwV = null;
  }
  
  public final void ahq()
  {
    AppMethodBeat.i(209693);
    a.ahm().a(this.gwX);
    clear();
    AppMethodBeat.o(209693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.g.b
 * JD-Core Version:    0.7.0.1
 */