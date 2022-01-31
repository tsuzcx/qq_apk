package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.HashSet;

final class a$1
  implements m.b
{
  a$1(a parama) {}
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    paramm = (String)paramObject;
    if (!a.Ea(paramm)) {
      y.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramm });
    }
    do
    {
      do
      {
        return;
        paramObject = ((j)g.r(j.class)).Fw().abf(paramm);
        if ((paramObject != null) && ((!a.F(paramObject)) || (paramObject.cua())))
        {
          y.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramm });
          return;
        }
        switch (paramInt)
        {
        case 4: 
        default: 
          return;
        }
      } while (a.b(this.kyt).containsKey(paramm));
      a.e(this.kyt).a(65556, new a.h(this.kyt, paramm));
      return;
    } while ((a.c(this.kyt).contains(paramm)) || (a.b(this.kyt).containsKey(paramm)));
    a.e(this.kyt).a(65556, new a.i(this.kyt, paramm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.1
 * JD-Core Version:    0.7.0.1
 */