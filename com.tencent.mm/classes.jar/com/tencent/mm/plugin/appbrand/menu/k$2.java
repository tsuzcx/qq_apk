package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class k$2
  implements Runnable
{
  k$2(k paramk, AtomicBoolean paramAtomicBoolean, Context paramContext, t.a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(47640);
    this.kRP.set(t.a(this.val$context, this.kRQ, this.iIl, false));
    if (this.kRP.get()) {
      h.vKh.idkeyStat(443L, 1L, 1L, false);
    }
    if ((this.val$context == null) || (!this.kRP.get()))
    {
      AppMethodBeat.o(47640);
      return;
    }
    c.a(this.val$context, this.kRR, this.kRS, this.kRT, this.kRQ.appId, true);
    AppMethodBeat.o(47640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.k.2
 * JD-Core Version:    0.7.0.1
 */