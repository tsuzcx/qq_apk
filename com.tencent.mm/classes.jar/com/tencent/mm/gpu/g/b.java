package com.tencent.mm.gpu.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.e.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static b hjH;
  public String hjG;
  private int hjI;
  private e hjJ;
  private boolean hjK;
  public a.a hjL;
  
  static
  {
    AppMethodBeat.i(186227);
    hjH = new b();
    AppMethodBeat.o(186227);
  }
  
  private b()
  {
    AppMethodBeat.i(186224);
    this.hjG = "";
    this.hjI = 0;
    this.hjJ = null;
    this.hjK = false;
    this.hjL = new a.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(186223);
        b.a(b.this);
        if (b.b(b.this) == null)
        {
          b.a(b.this, paramAnonymouse);
          AppMethodBeat.o(186223);
          return;
        }
        long l1 = paramAnonymouse.hjt + 0L + paramAnonymouse.hjr + paramAnonymouse.hjs;
        long l2 = b.b(b.this).hjt + 0L + b.b(b.this).hjr + b.b(b.this).hjs;
        Log.i("MicroMsg.KeyBusinessMonitor", "name:%s,time:%d,now:%d,last:%d", new Object[] { b.c(b.this), Integer.valueOf(b.d(b.this)), Long.valueOf(l1), Long.valueOf(l2) });
        if ((l1 - l2) * 100.0D / l2 > 0.05D) {
          b.e(b.this);
        }
        if (!b.f(b.this))
        {
          b.g(b.this);
          AppMethodBeat.o(186223);
          return;
        }
        if (b.d(b.this) >= 4) {
          h.CyF.kvStat(20507, "finder");
        }
        b.a(b.this, paramAnonymouse);
        AppMethodBeat.o(186223);
      }
    };
    AppMethodBeat.o(186224);
  }
  
  public static b axB()
  {
    return hjH;
  }
  
  private void clear()
  {
    this.hjG = "";
    this.hjI = 0;
    this.hjK = false;
    this.hjJ = null;
  }
  
  public final void axC()
  {
    AppMethodBeat.i(186225);
    a.axy().a(this.hjL);
    clear();
    AppMethodBeat.o(186225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.g.b
 * JD-Core Version:    0.7.0.1
 */