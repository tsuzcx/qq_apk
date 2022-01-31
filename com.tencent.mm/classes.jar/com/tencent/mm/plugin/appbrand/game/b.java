package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.e.a.a.a.a;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.plugin.appbrand.service.c
{
  public b()
  {
    super(new a.a());
    AppMethodBeat.i(143109);
    AppMethodBeat.o(143109);
  }
  
  public final MBRuntime aAr()
  {
    e locale = this.bEO;
    if ((locale instanceof a)) {
      return ((a)locale).bBi.bzF.bzI;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b
 * JD-Core Version:    0.7.0.1
 */