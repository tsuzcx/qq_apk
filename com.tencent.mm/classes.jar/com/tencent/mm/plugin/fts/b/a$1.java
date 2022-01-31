package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.HashSet;

final class a$1
  implements n.b
{
  a$1(a parama) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(136650);
    paramn = (String)paramObject;
    if (!a.Pk(paramn))
    {
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramn });
      AppMethodBeat.o(136650);
      return;
    }
    paramObject = ((j)g.E(j.class)).YA().arq(paramn);
    if ((paramObject != null) && ((!a.G(paramObject)) || (paramObject.dwz())))
    {
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramn });
      AppMethodBeat.o(136650);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136650);
      return;
      if (!a.b(this.mUg).containsKey(paramn))
      {
        a.e(this.mUg).a(65556, new a.h(this.mUg, paramn));
        AppMethodBeat.o(136650);
        return;
        if ((!a.c(this.mUg).contains(paramn)) && (!a.b(this.mUg).containsKey(paramn))) {
          a.e(this.mUg).a(65556, new a.i(this.mUg, paramn));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.1
 * JD-Core Version:    0.7.0.1
 */