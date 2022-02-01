package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public int sKh;
  
  static
  {
    AppMethodBeat.i(146318);
    tik = new b("AUTO", 0, 0);
    til = new b("MIC", 1, 1);
    tim = new b("CAMCORDER", 2, 5);
    tin = new b("VOICE_RECOGNITION", 3, 6);
    tio = new b("VOICE_COMMUNICATION", 4, 7);
    tiq = new b("UNPROCESSED", 5, 9);
    tir = new b[] { tik, til, tim, tin, tio, tiq };
    AppMethodBeat.o(146318);
  }
  
  private b(int paramInt)
  {
    this.sKh = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */