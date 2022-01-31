package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, Runnable paramRunnable) {}
  
  public final void run()
  {
    y.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
    y.cqL();
    au.DS().a(new b.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.2
 * JD-Core Version:    0.7.0.1
 */