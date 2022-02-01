package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static volatile int gAe = 0;
  private static e gAf;
  private static volatile boolean sInitialized = false;
  
  public static void a(e parame)
  {
    gAf = parame;
  }
  
  public static c ain()
  {
    AppMethodBeat.i(158566);
    if (gAe == 1)
    {
      localObject = new l();
      AppMethodBeat.o(158566);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(158566);
    return localObject;
  }
  
  public static a aio()
  {
    AppMethodBeat.i(158569);
    if (gAe == 1)
    {
      localObject = new k();
      AppMethodBeat.o(158569);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(158569);
    return localObject;
  }
  
  public static int aip()
  {
    return gAe;
  }
  
  public static void initialize() {}
  
  public static c m(Map paramMap)
  {
    AppMethodBeat.i(158567);
    if (gAe == 1)
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(158567);
      return paramMap;
    }
    paramMap = new d(paramMap);
    AppMethodBeat.o(158567);
    return paramMap;
  }
  
  public static void mK(int paramInt)
  {
    gAe = paramInt;
    sInitialized = true;
  }
  
  public static JSONObject wJ(String paramString)
  {
    AppMethodBeat.i(158565);
    if (gAe == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(158565);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(158565);
    return paramString;
  }
  
  public static c wK(String paramString)
  {
    AppMethodBeat.i(158568);
    if (gAe == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(158568);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158568);
    return paramString;
  }
  
  public static a wL(String paramString)
  {
    AppMethodBeat.i(158570);
    if (gAe == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.h
 * JD-Core Version:    0.7.0.1
 */