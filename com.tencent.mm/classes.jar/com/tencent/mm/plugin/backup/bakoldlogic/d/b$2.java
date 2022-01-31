package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(18009);
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
    ab.dsI();
    aw.RO().a(new b.2.1(this));
    AppMethodBeat.o(18009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.2
 * JD-Core Version:    0.7.0.1
 */