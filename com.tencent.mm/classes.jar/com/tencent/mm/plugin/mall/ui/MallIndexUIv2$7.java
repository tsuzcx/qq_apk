package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.ArrayList;

final class MallIndexUIv2$7
  implements u.g
{
  MallIndexUIv2$7(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(262408);
    int i = 0;
    if (i < MallIndexUIv2.k(this.KMs).size())
    {
      t localt = (t)MallIndexUIv2.k(this.KMs).get(i);
      params.c(i, localt.title);
      if (localt.jumpType == 9) {
        h.OAn.b(23388, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      }
      for (;;)
      {
        i += 1;
        break;
        if (localt.jumpType == 5) {
          h.OAn.b(23388, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
        }
      }
    }
    AppMethodBeat.o(262408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.7
 * JD-Core Version:    0.7.0.1
 */