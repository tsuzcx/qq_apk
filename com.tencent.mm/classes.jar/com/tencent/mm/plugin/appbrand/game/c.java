package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.a.b;
import com.tencent.luggage.game.d.a.a.a.b;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends com.tencent.mm.plugin.appbrand.service.c
{
  public c()
  {
    super(new a.b());
    AppMethodBeat.i(45083);
    AppMethodBeat.o(45083);
  }
  
  public final d getMagicBrush()
  {
    AppMethodBeat.i(45084);
    Object localObject = this.coU;
    if ((localObject instanceof a))
    {
      localObject = ((a)localObject).ckb.getMagicBrush();
      AppMethodBeat.o(45084);
      return localObject;
    }
    AppMethodBeat.o(45084);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c
 * JD-Core Version:    0.7.0.1
 */