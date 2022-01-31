package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.b.b;
import com.tencent.mm.plugin.ipcall.a.b.c;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

final class j$10
  implements IPCallFuncButton.a
{
  j$10(j paramj) {}
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(22408);
    a locala;
    if (i.bJr().bJj())
    {
      ab.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      locala = i.bJo();
      if (!paramBoolean) {
        break label128;
      }
    }
    label128:
    for (int i = locala.nOc.setAppCmd(412);; i = locala.nOc.setAppCmd(413))
    {
      if (i < 0) {
        ab.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      i.bJq().nNL.setMute(paramBoolean);
      h.qsU.e(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(22408);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.10
 * JD-Core Version:    0.7.0.1
 */