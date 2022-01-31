package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ai;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    if (System.currentTimeMillis() - this.ltx.ltq >= 500L)
    {
      this.ltx.lto = a.av(this.ltx.bER, this.ltx.ltm + this.ltx.ltn);
      ai.d(new b.1.1(this, i.bcm().FA(this.ltx.lto)));
      return;
    }
    ai.d(new b.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.1
 * JD-Core Version:    0.7.0.1
 */