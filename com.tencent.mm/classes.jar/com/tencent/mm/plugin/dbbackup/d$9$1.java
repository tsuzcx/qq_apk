package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class d$9$1
  implements b
{
  d$9$1(d.9 param9, boolean paramBoolean) {}
  
  public final void pC(int paramInt)
  {
    d.d(this.iNz.iNn, false);
    au.Hx();
    z localz = c.Dz();
    d.c(this.iNz.iNn, System.currentTimeMillis());
    if (paramInt == 0)
    {
      localz.setLong(237569, d.l(this.iNz.iNn));
      if (this.iMt)
      {
        d.n(this.iNz.iNn);
        localz.setInt(237570, d.m(this.iNz.iNn));
      }
    }
    for (;;)
    {
      localz.mC(false);
      do
      {
        return;
        d.a(this.iNz.iNn, 0);
        break;
      } while (paramInt == 1);
      localz.setLong(237569, d.l(this.iNz.iNn));
      if (this.iMt)
      {
        d.a(this.iNz.iNn, 10);
        localz.setInt(237570, d.m(this.iNz.iNn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.9.1
 * JD-Core Version:    0.7.0.1
 */