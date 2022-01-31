package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

final class a$2
  implements n.b
{
  a$2(a parama) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(136651);
    paramn = (String)paramObject;
    if (!a.Pk(paramn))
    {
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramn });
      AppMethodBeat.o(136651);
      return;
    }
    paramObject = ((j)g.E(j.class)).YA().arq(paramn);
    if ((paramObject != null) && (!a.G(paramObject)))
    {
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramn });
      AppMethodBeat.o(136651);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136651);
      return;
      if (!a.b(this.mUg).containsKey(paramn))
      {
        a.e(this.mUg).a(65556, new a.h(this.mUg, paramn));
        AppMethodBeat.o(136651);
        return;
        a.e(this.mUg).a(65556, new a.e(this.mUg, paramn));
        AppMethodBeat.o(136651);
        return;
        a.e(this.mUg).a(65556, new a.d(this.mUg, paramn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.2
 * JD-Core Version:    0.7.0.1
 */