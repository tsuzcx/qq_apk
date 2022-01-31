package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static volatile int eGG = 0;
  private static volatile boolean eGH = false;
  private static e eGI;
  
  public static a QA()
  {
    AppMethodBeat.i(117629);
    if (eGG == 1)
    {
      localObject = new k();
      AppMethodBeat.o(117629);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(117629);
    return localObject;
  }
  
  public static int QB()
  {
    return eGG;
  }
  
  public static c Qz()
  {
    AppMethodBeat.i(117626);
    if (eGG == 1)
    {
      localObject = new l();
      AppMethodBeat.o(117626);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(117626);
    return localObject;
  }
  
  public static void a(e parame)
  {
    eGI = parame;
  }
  
  public static void initialize() {}
  
  public static void jJ(int paramInt)
  {
    eGG = paramInt;
    eGH = true;
  }
  
  public static c k(Map paramMap)
  {
    AppMethodBeat.i(117627);
    if (eGG == 1)
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(117627);
      return paramMap;
    }
    paramMap = new d(paramMap);
    AppMethodBeat.o(117627);
    return paramMap;
  }
  
  public static JSONObject mo(String paramString)
  {
    AppMethodBeat.i(117625);
    if (eGG == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(117625);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(117625);
    return paramString;
  }
  
  public static c mp(String paramString)
  {
    AppMethodBeat.i(117628);
    if (eGG == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(117628);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(117628);
    return paramString;
  }
  
  public static a mq(String paramString)
  {
    AppMethodBeat.i(117630);
    if (eGG == 1)
    {
      paramString = new k(paramString);
      AppMethodBeat.o(117630);
      return paramString;
    }
    paramString = new b(paramString);
    AppMethodBeat.o(117630);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aa.h
 * JD-Core Version:    0.7.0.1
 */