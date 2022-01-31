package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.a;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.sdk.b.c;

final class g$6
  extends c<ux>
{
  g$6(g paramg)
  {
    AppMethodBeat.i(155623);
    this.__eventId = ux.class.getName().hashCode();
    AppMethodBeat.o(155623);
  }
  
  private boolean a(ux paramux)
  {
    AppMethodBeat.i(155624);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(155624);
      return false;
    }
    if (paramux.cLs.cut == 3)
    {
      this.ohw.ohj.iU(false);
      this.ohw.ohk.stop();
      this.ohw.ohk.yb(2);
      k.bLT();
      this.ohw.activity.finish();
    }
    AppMethodBeat.o(155624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.6
 * JD-Core Version:    0.7.0.1
 */