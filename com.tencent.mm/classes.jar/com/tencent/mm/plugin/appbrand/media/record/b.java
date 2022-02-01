package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public int kXn;
  
  static
  {
    AppMethodBeat.i(146318);
    lrU = new b("AUTO", 0, 0);
    lrV = new b("MIC", 1, 1);
    lrW = new b("CAMCORDER", 2, 5);
    lrX = new b("VOICE_RECOGNITION", 3, 6);
    lrY = new b("VOICE_COMMUNICATION", 4, 7);
    lrZ = new b("UNPROCESSED", 5, 9);
    lsa = new b[] { lrU, lrV, lrW, lrX, lrY, lrZ };
    AppMethodBeat.o(146318);
  }
  
  private b(int paramInt)
  {
    this.kXn = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    AppMethodBeat.i(146317);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(146317);
      return paramb;
    }
    Object localObject = null;
    try
    {
      paramString = valueOf(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(146317);
        return paramString;
      }
      AppMethodBeat.o(146317);
      return paramb;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */