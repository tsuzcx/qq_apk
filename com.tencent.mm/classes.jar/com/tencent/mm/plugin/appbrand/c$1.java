package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.e.a;
import com.tencent.mm.plugin.appbrand.permission.e.b;

final class c$1
  implements e.b
{
  c$1(c paramc, c.a parama, m paramm) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(101709);
    if ((this.gOR.gOO == null) || (!this.gOR.gOO.isRunning()))
    {
      AppMethodBeat.o(101709);
      return;
    }
    if (parama.ret == 0)
    {
      this.gOP.proceed();
      AppMethodBeat.o(101709);
      return;
    }
    if (TextUtils.isEmpty(parama.bjm)) {}
    for (parama = "fail:internal error";; parama = parama.bjm)
    {
      this.gOP.BI(this.gOQ.j(parama, null));
      AppMethodBeat.o(101709);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.1
 * JD-Core Version:    0.7.0.1
 */