package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  private static volatile int mBv = 0;
  private static e mBw;
  private static volatile boolean sInitialized = false;
  
  public static JSONObject Fn(String paramString)
  {
    AppMethodBeat.i(158565);
    if (mBv == 1)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(158565);
      return paramString;
    }
    paramString = new JSONObject(paramString);
    AppMethodBeat.o(158565);
    return paramString;
  }
  
  public static c Fo(String paramString)
  {
    AppMethodBeat.i(158568);
    if (mBv == 1)
    {
      paramString = new l(paramString);
      AppMethodBeat.o(158568);
      return paramString;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158568);
    return paramString;
  }
  
  public static a Fp(String paramString)
  {
    AppMethodBeat.i(158570);
    if (mBv == 1)
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
    mBw = parame;
  }
  
  public static c aZn()
  {
    AppMethodBeat.i(158566);
    if (mBv == 1)
    {
      localObject = new l();
      AppMethodBeat.o(158566);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(158566);
    return localObject;
  }
  
  public static a aZo()
  {
    AppMethodBeat.i(158569);
    if (mBv == 1)
    {
      localObject = new k();
      AppMethodBeat.o(158569);
      return localObject;
    }
    Object localObject = new b();
    AppMethodBeat.o(158569);
    return localObject;
  }
  
  public static int aZp()
  {
    return mBv;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(230943);
    if ((mBw != null) && (mBw.isValid())) {
      mBw.aZm();
    }
    AppMethodBeat.o(230943);
  }
  
  public static a s(Collection paramCollection)
  {
    AppMethodBeat.i(230952);
    if (mBv == 1)
    {
      paramCollection = new k(paramCollection);
      AppMethodBeat.o(230952);
      return paramCollection;
    }
    paramCollection = new b(paramCollection);
    AppMethodBeat.o(230952);
    return paramCollection;
  }
  
  public static void sv(int paramInt)
  {
    mBv = paramInt;
    sInitialized = true;
  }
  
  public static c u(Map paramMap)
  {
    AppMethodBeat.i(158567);
    if (mBv == 1)
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
 * Qualified Name:     com.tencent.mm.ad.h
 * JD-Core Version:    0.7.0.1
 */