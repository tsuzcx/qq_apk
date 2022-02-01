package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.a.b;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends com.tencent.mm.plugin.appbrand.service.c
{
  public c()
  {
    super(a.class);
    AppMethodBeat.i(45083);
    AppMethodBeat.o(45083);
  }
  
  public final MBRuntime coI()
  {
    AppMethodBeat.i(318385);
    Object localObject = this.esM;
    if ((localObject instanceof a))
    {
      localObject = ((a)localObject).eml.getMagicBrush();
      AppMethodBeat.o(318385);
      return localObject;
    }
    AppMethodBeat.o(318385);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c
 * JD-Core Version:    0.7.0.1
 */