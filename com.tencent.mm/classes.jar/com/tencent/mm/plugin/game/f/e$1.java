package com.tencent.mm.plugin.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class e$1
  implements k.a
{
  e$1(e parame) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(112326);
    if (e.a(this.nEk).Z(paramString))
    {
      paramm = g.b(paramString, 1, a.getDensity(null));
      e.a(this.nEk).f(paramString, paramm);
    }
    AppMethodBeat.o(112326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.1
 * JD-Core Version:    0.7.0.1
 */