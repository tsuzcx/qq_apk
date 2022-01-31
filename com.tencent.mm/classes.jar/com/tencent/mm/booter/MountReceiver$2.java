package com.tencent.mm.booter;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class MountReceiver$2
  implements Runnable
{
  MountReceiver$2(MountReceiver paramMountReceiver) {}
  
  public final void run()
  {
    y.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[] { MountReceiver.a(this.dhH), Boolean.valueOf(au.DK()) });
    if (!au.DK()) {
      return;
    }
    g.DP().DD();
    au.Hx();
    c.DB();
    MountReceiver.c(this.dhH).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver.2
 * JD-Core Version:    0.7.0.1
 */