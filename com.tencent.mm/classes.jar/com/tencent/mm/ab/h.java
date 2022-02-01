package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static volatile int ggu = 0;
  private static e ggv;
  private static volatile boolean sInitialized = false;
  
  public static void a(e parame)
  {
    ggv = parame;
  }
  
  public static c afB()
  {
    AppMethodBeat.i(158566);
    if (ggu == 1)
    {
      localObject = new l();
      AppMethodBeat.o(158566);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(158566);
    return localObject;
  }
  
  public static a afC()
  {
    AppMethodBeat.i(158569);
    if (ggu == 1)
    {
      localObject = new k();
      AppMethodBeat.o(158569);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(158569);
    return localObject;
  }
  
  public static int afD()
  {
    return ggu;
  }
  
  public static void initialize() {}
  
  public static c m(Map paramMap)
  {
    AppMethodBeat.i(158567);
    if (ggu == 1)
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(158567);
      return paramMap;
    }
    paramMap = new d(paramMap);
    AppMethodBeat.o(158567);
    return paramMap;
  }
  
  public static void ml(int paramInt)
  {
    ggu = paramInt;
    sInitialized = true;
  }
  
  public static JSONObject tT(String paramString)
  {
    AppMethodBeat.i(158565);
    if (ggu == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(158565);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(158565);
    return paramString;
  }
  
  public static c tU(String paramString)
  {
    AppMethodBeat.i(158568);
    if (ggu == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(158568);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158568);
    return paramString;
  }
  
  public static a tV(String paramString)
  {
    AppMethodBeat.i(158570);
    if (ggu == 1)
    {
      paramString = new k(paramString);
      AppMethodBeat.o(158570);
      return paramString;
    }
    paramString = new b(paramString);
    AppMethodBeat.o(158570);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.h
 * JD-Core Version:    0.7.0.1
 */