package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static volatile int kbq = 0;
  private static e kbr;
  private static volatile boolean sInitialized = false;
  
  public static JSONObject ME(String paramString)
  {
    AppMethodBeat.i(158565);
    if (kbq == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(158565);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(158565);
    return paramString;
  }
  
  public static c MF(String paramString)
  {
    AppMethodBeat.i(158568);
    if (kbq == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(158568);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158568);
    return paramString;
  }
  
  public static a MG(String paramString)
  {
    AppMethodBeat.i(158570);
    if (kbq == 1)
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
    kbr = parame;
  }
  
  public static c aGm()
  {
    AppMethodBeat.i(158566);
    if (kbq == 1)
    {
      localObject = new l();
      AppMethodBeat.o(158566);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(158566);
    return localObject;
  }
  
  public static a aGn()
  {
    AppMethodBeat.i(158569);
    if (kbq == 1)
    {
      localObject = new k();
      AppMethodBeat.o(158569);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(158569);
    return localObject;
  }
  
  public static int aGo()
  {
    return kbq;
  }
  
  public static a d(Collection paramCollection)
  {
    AppMethodBeat.i(202286);
    if (kbq == 1)
    {
      paramCollection = new k(paramCollection);
      AppMethodBeat.o(202286);
      return paramCollection;
    }
    paramCollection = new b(paramCollection);
    AppMethodBeat.o(202286);
    return paramCollection;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(202275);
    if ((kbr != null) && (kbr.isValid())) {
      kbr.aGl();
    }
    AppMethodBeat.o(202275);
  }
  
  public static c n(Map paramMap)
  {
    AppMethodBeat.i(158567);
    if (kbq == 1)
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(158567);
      return paramMap;
    }
    paramMap = new d(paramMap);
    AppMethodBeat.o(158567);
    return paramMap;
  }
  
  public static void sz(int paramInt)
  {
    kbq = paramInt;
    sInitialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ad.h
 * JD-Core Version:    0.7.0.1
 */