package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

final class a$2
  implements m.b
{
  a$2(a parama) {}
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    paramm = (String)paramObject;
    if (!a.Ea(paramm)) {
      y.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramm });
    }
    do
    {
      return;
      paramObject = ((j)g.r(j.class)).Fw().abf(paramm);
      if ((paramObject != null) && (!a.F(paramObject)))
      {
        y.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramm });
        return;
      }
      switch (paramInt)
      {
      default: 
        return;
      case 2: 
        a.e(this.kyt).a(65556, new a.e(this.kyt, paramm));
        return;
      }
    } while (a.b(this.kyt).containsKey(paramm));
    a.e(this.kyt).a(65556, new a.h(this.kyt, paramm));
    return;
    a.e(this.kyt).a(65556, new a.d(this.kyt, paramm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.2
 * JD-Core Version:    0.7.0.1
 */