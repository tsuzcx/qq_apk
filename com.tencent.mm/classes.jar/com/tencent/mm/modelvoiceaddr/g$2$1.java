package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ah.p;
import com.tencent.mm.sdk.platformtools.y;

final class g$2$1
  implements Runnable
{
  g$2$1(g.2 param2) {}
  
  public final void run()
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.h(this.eMd.eMb)), Long.valueOf(System.currentTimeMillis()) });
    if ((g.i(this.eMd.eMb)) || (g.k(this.eMd.eMb) == null) || (g.h(this.eMd.eMb) == 0)) {
      y.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
    }
    do
    {
      return;
      com.tencent.mm.kernel.g.Dk().a(235, this.eMd.eMb);
    } while ((((c)g.k(this.eMd.eMb)).Tu()) && (com.tencent.mm.kernel.g.Dk().a(g.k(this.eMd.eMb), 0)));
    this.eMd.eMb.bA(13, 131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.2.1
 * JD-Core Version:    0.7.0.1
 */