package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  extends b.a
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(17838);
    s locals = new s();
    if (this.jIZ)
    {
      locals.jJO = this.dbSize;
      locals.jKm = (this.jJb - this.dbSize);
      locals.jKl = this.jJa;
      e locale = this.jHN;
      e.a(6, 0, locals);
      com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
      ab.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).aUv();
      AppMethodBeat.o(17838);
      return;
    }
    if ((this.dbSize > this.jJb) && (this.jJb > 0L))
    {
      locals.jJO = this.dbSize;
      locals.jKm = (this.jJb - this.dbSize);
    }
    e.a(6, 14, locals);
    ab.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
    AppMethodBeat.o(17838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.1
 * JD-Core Version:    0.7.0.1
 */