package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class a
{
  public static final h atM;
  public static final h atN;
  public static final h atO;
  
  static
  {
    AppMethodBeat.i(70496);
    atM = new c("null");
    atN = new c("true");
    atO = new c("false");
    AppMethodBeat.o(70496);
  }
  
  public static h S(float paramFloat)
  {
    AppMethodBeat.i(70491);
    if ((Float.isInfinite(paramFloat)) || (Float.isNaN(paramFloat)))
    {
      localObject = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
      AppMethodBeat.o(70491);
      throw ((Throwable)localObject);
    }
    Object localObject = new d(ab(Float.toString(paramFloat)));
    AppMethodBeat.o(70491);
    return localObject;
  }
  
  public static h Z(String paramString)
  {
    AppMethodBeat.i(70493);
    if (paramString == null)
    {
      paramString = atM;
      AppMethodBeat.o(70493);
      return paramString;
    }
    paramString = new g(paramString);
    AppMethodBeat.o(70493);
    return paramString;
  }
  
  public static h aa(String paramString)
  {
    AppMethodBeat.i(70494);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(70494);
      throw paramString;
    }
    h localh;
    try
    {
      paramString = new f(paramString);
      paramString.mc();
      paramString.mb();
      localh = paramString.lN();
      paramString.mb();
      if (!paramString.mj())
      {
        paramString = paramString.af("Unexpected character");
        AppMethodBeat.o(70494);
        throw paramString;
      }
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(70494);
      throw paramString;
    }
    AppMethodBeat.o(70494);
    return localh;
  }
  
  private static String ab(String paramString)
  {
    AppMethodBeat.i(70495);
    if (paramString.endsWith(".0"))
    {
      paramString = paramString.substring(0, paramString.length() - 2);
      AppMethodBeat.o(70495);
      return paramString;
    }
    AppMethodBeat.o(70495);
    return paramString;
  }
  
  public static h az(boolean paramBoolean)
  {
    if (paramBoolean) {
      return atN;
    }
    return atO;
  }
  
  public static h cR(int paramInt)
  {
    AppMethodBeat.i(70489);
    d locald = new d(Integer.toString(paramInt, 10));
    AppMethodBeat.o(70489);
    return locald;
  }
  
  public static h l(double paramDouble)
  {
    AppMethodBeat.i(70492);
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble)))
    {
      localObject = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
      AppMethodBeat.o(70492);
      throw ((Throwable)localObject);
    }
    Object localObject = new d(ab(Double.toString(paramDouble)));
    AppMethodBeat.o(70492);
    return localObject;
  }
  
  public static h l(long paramLong)
  {
    AppMethodBeat.i(70490);
    d locald = new d(Long.toString(paramLong, 10));
    AppMethodBeat.o(70490);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.a
 * JD-Core Version:    0.7.0.1
 */