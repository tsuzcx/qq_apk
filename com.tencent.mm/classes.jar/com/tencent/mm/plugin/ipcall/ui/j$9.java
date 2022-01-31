package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.b.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ab;

final class j$9
  implements IPCallFuncButton.a
{
  j$9(j paramj) {}
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(22407);
    ab.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (i.bJr().bJi())
    {
      this.nXs.nXm = paramBoolean;
      this.nXs.nXn = paramBoolean;
      i.bJq().iE(paramBoolean);
      com.tencent.mm.plugin.report.service.h.qsU.e(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(22407);
      return;
    }
    if ((!i.bJx().Dt()) && (!i.bJr().bJk())) {
      i.bJx().nf(paramBoolean);
    }
    AppMethodBeat.o(22407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.9
 * JD-Core Version:    0.7.0.1
 */