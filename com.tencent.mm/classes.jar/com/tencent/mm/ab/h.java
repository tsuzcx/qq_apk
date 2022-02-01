package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static e hpA;
  private static volatile int hpz = 0;
  private static volatile boolean sInitialized = false;
  
  public static JSONObject FE(String paramString)
  {
    AppMethodBeat.i(158565);
    if (hpz == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(158565);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(158565);
    return paramString;
  }
  
  public static c FF(String paramString)
  {
    AppMethodBeat.i(158568);
    if (hpz == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(158568);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158568);
    return paramString;
  }
  
  public static a FG(String paramString)
  {
    AppMethodBeat.i(158570);
    if (hpz == 1)
    {
      paramString = new k(paramString);
      AppMethodBeat.o(158570);
      return paramString;
    }
    paramString = new b(paramString);
    AppMethodBeat.o(158570);
    return paramString;
  }
  
  public static void a(e parame)
  {
    hpA = parame;
  }
  
  public static c ayS()
  {
    AppMethodBeat.i(158566);
    if (hpz == 1)
    {
      localObject = new l();
      AppMethodBeat.o(158566);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(158566);
    return localObject;
  }
  
  public static a ayT()
  {
    AppMethodBeat.i(158569);
    if (hpz == 1)
    {
      localObject = new k();
      AppMethodBeat.o(158569);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(158569);
    return localObject;
  }
  
  public static int ayU()
  {
    return hpz;
  }
  
  public static void initialize() {}
  
  public static void qa(int paramInt)
  {
    hpz = paramInt;
    sInitialized = true;
  }
  
  public static c v(Map paramMap)
  {
    AppMethodBeat.i(158567);
    if (hpz == 1)
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(158567);
      return paramMap;
    }
    paramMap = new d(paramMap);
    AppMethodBeat.o(158567);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ab.h
 * JD-Core Version:    0.7.0.1
 */