package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public int kvZ;
  
  static
  {
    AppMethodBeat.i(146318);
    kQv = new b("AUTO", 0, 0);
    kQw = new b("MIC", 1, 1);
    kQx = new b("CAMCORDER", 2, 5);
    kQy = new b("VOICE_RECOGNITION", 3, 6);
    kQz = new b("VOICE_COMMUNICATION", 4, 7);
    kQA = new b("UNPROCESSED", 5, 9);
    kQB = new b[] { kQv, kQw, kQx, kQy, kQz, kQA };
    AppMethodBeat.o(146318);
  }
  
  private b(int paramInt)
  {
    this.kvZ = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */