package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements k.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(5301);
    if (paramm == null)
    {
      AppMethodBeat.o(5301);
      return;
    }
    int i = paramm.htj;
    if (paramm.obj == null)
    {
      AppMethodBeat.o(5301);
      return;
    }
    long l = ((Long)paramm.obj).longValue();
    if (l < 0L)
    {
      AppMethodBeat.o(5301);
      return;
    }
    ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", new Object[] { paramm });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5301);
      return;
      this.muL.ezf.a(65576, new b.d(this.muL, l, (byte)0));
      AppMethodBeat.o(5301);
      return;
      this.muL.ezf.a(65576, new b.b(this.muL, l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.1
 * JD-Core Version:    0.7.0.1
 */