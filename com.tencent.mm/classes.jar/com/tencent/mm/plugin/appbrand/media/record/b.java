package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public int ifE;
  
  static
  {
    AppMethodBeat.i(117483);
    ipi = new b("AUTO", 0, 0);
    ipj = new b("MIC", 1, 1);
    ipk = new b("CAMCORDER", 2, 5);
    ipl = new b("VOICE_RECOGNITION", 3, 6);
    ipm = new b("VOICE_COMMUNICATION", 4, 7);
    ipn = new b("UNPROCESSED", 5, 9);
    ipo = new b[] { ipi, ipj, ipk, ipl, ipm, ipn };
    AppMethodBeat.o(117483);
  }
  
  private b(int paramInt)
  {
    this.ifE = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    AppMethodBeat.i(117482);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117482);
      return paramb;
    }
    paramString = valueOf(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(117482);
      return paramString;
    }
    AppMethodBeat.o(117482);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */