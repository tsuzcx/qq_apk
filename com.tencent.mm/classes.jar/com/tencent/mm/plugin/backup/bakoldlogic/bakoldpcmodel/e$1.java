package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  extends b.a
{
  e$1(e parame) {}
  
  public final void run()
  {
    s locals = new s();
    if (this.hPx)
    {
      locals.hQm = this.dbSize;
      locals.hQK = (this.hPz - this.dbSize);
      locals.hQJ = this.hPy;
      e locale = this.hOl;
      e.a(6, 0, locals);
      com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
      y.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).auT();
      return;
    }
    if ((this.dbSize > this.hPz) && (this.hPz > 0L))
    {
      locals.hQm = this.dbSize;
      locals.hQK = (this.hPz - this.dbSize);
    }
    e.a(6, 14, locals);
    y.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.1
 * JD-Core Version:    0.7.0.1
 */