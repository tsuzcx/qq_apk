package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class d$9$1
  implements b
{
  d$9$1(d.9 param9, boolean paramBoolean) {}
  
  public final void tT(int paramInt)
  {
    AppMethodBeat.i(18979);
    d.d(this.kUz.kUn, false);
    aw.aaz();
    z localz = c.Ru();
    d.c(this.kUz.kUn, System.currentTimeMillis());
    if (paramInt == 0)
    {
      localz.setLong(237569, d.l(this.kUz.kUn));
      if (this.kTr)
      {
        d.n(this.kUz.kUn);
        localz.setInt(237570, d.m(this.kUz.kUn));
      }
    }
    for (;;)
    {
      localz.dww();
      do
      {
        AppMethodBeat.o(18979);
        return;
        d.a(this.kUz.kUn, 0);
        break;
      } while (paramInt == 1);
      localz.setLong(237569, d.l(this.kUz.kUn));
      if (this.kTr)
      {
        d.a(this.kUz.kUn, 10);
        localz.setInt(237570, d.m(this.kUz.kUn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9.1
 * JD-Core Version:    0.7.0.1
 */