package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.ab.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class o$2
  implements Runnable
{
  o$2(o paramo, AtomicBoolean paramAtomicBoolean, Context paramContext, ab.a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(47640);
    this.tjY.set(ab.a(this.val$context, this.tjZ, this.qyT, false));
    if (this.tjY.get()) {
      h.OAn.idkeyStat(443L, 1L, 1L, false);
    }
    if ((this.val$context == null) || (!this.tjY.get()))
    {
      AppMethodBeat.o(47640);
      return;
    }
    c.a(this.val$context, this.tka, this.tkb, this.tkc, this.tjZ.appId, true);
    AppMethodBeat.o(47640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o.2
 * JD-Core Version:    0.7.0.1
 */