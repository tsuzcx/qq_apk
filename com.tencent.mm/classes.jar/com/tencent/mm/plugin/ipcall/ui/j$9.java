package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.b.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class j$9
  implements IPCallFuncButton.a
{
  j$9(j paramj) {}
  
  public final void hb(boolean paramBoolean)
  {
    y.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.plugin.ipcall.a.i.bck().bcb())
    {
      this.lAg.lAa = paramBoolean;
      this.lAg.lAb = paramBoolean;
      com.tencent.mm.plugin.ipcall.a.i.bcj().gV(paramBoolean);
      h.nFQ.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    while ((com.tencent.mm.plugin.ipcall.a.i.bcq().amn()) || (com.tencent.mm.plugin.ipcall.a.i.bck().bcd())) {
      return;
    }
    com.tencent.mm.plugin.ipcall.a.i.bcq().kg(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.9
 * JD-Core Version:    0.7.0.1
 */