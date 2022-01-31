package com.tencent.luggage.game.c;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.image.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static final b bzW;
  
  static
  {
    AppMethodBeat.i(140348);
    bzW = new b();
    AppMethodBeat.o(140348);
  }
  
  public static void a(MBRuntime paramMBRuntime, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(140347);
    ab.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    paramMBRuntime = (a)paramMBRuntime.getImageHandler();
    paramMBRuntime.a(new b.b(parami, paramMBRuntime, (byte)0), true);
    new b.c();
    paramMBRuntime.bKX = new b.a(paramBoolean);
    AppMethodBeat.o(140347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */