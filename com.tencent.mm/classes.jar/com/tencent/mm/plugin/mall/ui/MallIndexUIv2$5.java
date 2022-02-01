package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.ArrayList;

final class MallIndexUIv2$5
  implements q.f
{
  MallIndexUIv2$5(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(249737);
    int i = 0;
    if (i < MallIndexUIv2.g(this.ERS).gaO.size())
    {
      t localt = (t)MallIndexUIv2.g(this.ERS).gaO.get(i);
      paramo.d(i, localt.title);
      if (localt.jumpType == 9) {
        h.IzE.a(23388, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      }
      for (;;)
      {
        i += 1;
        break;
        if (localt.jumpType == 5) {
          h.IzE.a(23388, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
        }
      }
    }
    AppMethodBeat.o(249737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.5
 * JD-Core Version:    0.7.0.1
 */