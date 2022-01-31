package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb, long paramLong, b.a parama) {}
  
  public final void run()
  {
    g.DN().CX();
    y.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.access$000()), Long.valueOf(bk.co(this.dhV)) });
    b.uC();
    au.DS().a(new b.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.1
 * JD-Core Version:    0.7.0.1
 */