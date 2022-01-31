package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.u.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class MenuDelegate_SendToDesktop$2
  implements Runnable
{
  MenuDelegate_SendToDesktop$2(MenuDelegate_SendToDesktop paramMenuDelegate_SendToDesktop, AtomicBoolean paramAtomicBoolean, Context paramContext, u.a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(155929);
    this.iqH.set(u.a(this.val$context, this.iqI, this.gSl, false));
    if (this.iqH.get()) {
      h.qsU.idkeyStat(443L, 1L, 1L, false);
    }
    if ((this.val$context == null) || (!this.iqH.get()))
    {
      AppMethodBeat.o(155929);
      return;
    }
    c.a(this.val$context, this.iqJ, this.iqK, this.iqL, this.iqI.appId, true);
    AppMethodBeat.o(155929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.2
 * JD-Core Version:    0.7.0.1
 */