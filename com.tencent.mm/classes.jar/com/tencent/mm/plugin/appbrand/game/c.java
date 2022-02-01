package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.a.b;
import com.tencent.luggage.game.d.a.a.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime;
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
  
  public final MBRuntime bCX()
  {
    AppMethodBeat.i(226614);
    Object localObject = this.cBj;
    if ((localObject instanceof a))
    {
      localObject = ((a)localObject).cwa.getMagicBrush();
      AppMethodBeat.o(226614);
      return localObject;
    }
    AppMethodBeat.o(226614);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c
 * JD-Core Version:    0.7.0.1
 */