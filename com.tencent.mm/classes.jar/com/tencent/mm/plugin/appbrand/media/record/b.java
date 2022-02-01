package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public int mFN;
  
  static
  {
    AppMethodBeat.i(146318);
    ndg = new b("AUTO", 0, 0);
    ndh = new b("MIC", 1, 1);
    ndi = new b("CAMCORDER", 2, 5);
    ndj = new b("VOICE_RECOGNITION", 3, 6);
    ndk = new b("VOICE_COMMUNICATION", 4, 7);
    ndl = new b("UNPROCESSED", 5, 9);
    ndm = new b[] { ndg, ndh, ndi, ndj, ndk, ndl };
    AppMethodBeat.o(146318);
  }
  
  private b(int paramInt)
  {
    this.mFN = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.b
 * JD-Core Version:    0.7.0.1
 */