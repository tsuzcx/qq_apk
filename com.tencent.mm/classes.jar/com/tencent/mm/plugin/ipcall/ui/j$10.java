package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.b.b;
import com.tencent.mm.plugin.ipcall.a.b.c;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

final class j$10
  implements IPCallFuncButton.a
{
  j$10(j paramj) {}
  
  public final void hb(boolean paramBoolean)
  {
    a locala;
    if (i.bck().bcc())
    {
      y.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      locala = i.bch();
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (int i = locala.lqG.um(412);; i = locala.lqG.um(413))
    {
      if (i < 0) {
        y.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + i);
      }
      i.bcj().lqp.setMute(paramBoolean);
      h.nFQ.f(12057, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.10
 * JD-Core Version:    0.7.0.1
 */