package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public enum e$a
{
  public int ifE;
  public String ifF;
  
  static
  {
    AppMethodBeat.i(145944);
    ify = new a("AUTO", 0, 0, "auto");
    ifz = new a("MIC", 1, 1, "mic");
    ifA = new a("CAMCORDER", 2, 5, "camcorder");
    ifB = new a("VOICE_RECOGNITION", 3, 6, "voice_recognition");
    ifC = new a("VOICE_COMMUNICATION", 4, 7, "voice_communication");
    ifD = new a("UNPROCESSED", 5, 9, "unprocessed");
    ifG = new a[] { ify, ifz, ifA, ifB, ifC, ifD };
    AppMethodBeat.o(145944);
  }
  
  private e$a(int paramInt, String paramString)
  {
    this.ifE = paramInt;
    this.ifF = paramString;
  }
  
  public static a a(String paramString, a parama)
  {
    AppMethodBeat.i(145943);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(145943);
      return parama;
    }
    try
    {
      a locala = valueOf(paramString.toUpperCase(Locale.ENGLISH));
      AppMethodBeat.o(145943);
      return locala;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      d.e("Luggage.ILuggageRecorder.AudioSource", "valueOf(%s) e=[%s]", new Object[] { paramString, localIllegalArgumentException.getMessage() });
      AppMethodBeat.o(145943);
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.e.a
 * JD-Core Version:    0.7.0.1
 */