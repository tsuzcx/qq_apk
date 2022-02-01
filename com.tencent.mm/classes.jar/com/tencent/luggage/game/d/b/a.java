package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.e.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/jsapi/keyboard/KeyboardType;", "", "(Ljava/lang/String;I)V", "TEXT", "EMOJI", "Companion", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  public static final a emF;
  
  static
  {
    AppMethodBeat.i(220193);
    emG = new a("TEXT", 0);
    emH = new a("EMOJI", 1);
    emI = new a[] { emG, emH };
    emF = new a((byte)0);
    AppMethodBeat.o(220193);
  }
  
  private a() {}
  
  public static final a eX(String paramString)
  {
    AppMethodBeat.i(220190);
    paramString = (a)d.l(paramString, a.class);
    if (paramString == null)
    {
      paramString = emG;
      AppMethodBeat.o(220190);
      return paramString;
    }
    AppMethodBeat.o(220190);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/jsapi/keyboard/KeyboardType$Companion;", "", "()V", "convert", "Lcom/tencent/luggage/game/jsapi/keyboard/KeyboardType;", "name", "", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.a
 * JD-Core Version:    0.7.0.1
 */