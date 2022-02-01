package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.e.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/jsapi/keyboard/KeyboardType;", "", "(Ljava/lang/String;I)V", "TEXT", "EMOJI", "Companion", "luggage-wxa-game-ext_release"})
public enum a
{
  public static final a.a cuQ;
  
  static
  {
    AppMethodBeat.i(247587);
    a locala1 = new a("TEXT", 0);
    cuN = locala1;
    a locala2 = new a("EMOJI", 1);
    cuO = locala2;
    cuP = new a[] { locala1, locala2 };
    cuQ = new a.a((byte)0);
    AppMethodBeat.o(247587);
  }
  
  private a() {}
  
  public static final a dM(String paramString)
  {
    AppMethodBeat.i(247593);
    a locala = (a)d.h(paramString, a.class);
    paramString = locala;
    if (locala == null) {
      paramString = cuN;
    }
    AppMethodBeat.o(247593);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.a
 * JD-Core Version:    0.7.0.1
 */