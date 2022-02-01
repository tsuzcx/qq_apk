package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class a
{
  public static final h cBJ;
  public static final h cBK;
  public static final h cBL;
  
  static
  {
    AppMethodBeat.i(74683);
    cBJ = new c("null");
    cBK = new c("true");
    cBL = new c("false");
    AppMethodBeat.o(74683);
  }
  
  public static h aO(float paramFloat)
  {
    AppMethodBeat.i(74678);
    if ((Float.isInfinite(paramFloat)) || (Float.isNaN(paramFloat)))
    {
      localObject = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
      AppMethodBeat.o(74678);
      throw ((Throwable)localObject);
    }
    Object localObject = new d(cp(Float.toString(paramFloat)));
    AppMethodBeat.o(74678);
    return localObject;
  }
  
  public static h bH(long paramLong)
  {
    AppMethodBeat.i(74677);
    d locald = new d(Long.toString(paramLong, 10));
    AppMethodBeat.o(74677);
    return locald;
  }
  
  public static h bs(boolean paramBoolean)
  {
    if (paramBoolean) {
      return cBK;
    }
    return cBL;
  }
  
  public static h cn(String paramString)
  {
    AppMethodBeat.i(74680);
    if (paramString == null)
    {
      paramString = cBJ;
      AppMethodBeat.o(74680);
      return paramString;
    }
    paramString = new g(paramString);
    AppMethodBeat.o(74680);
    return paramString;
  }
  
  public static h co(String paramString)
  {
    AppMethodBeat.i(74681);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(74681);
      throw paramString;
    }
    h localh;
    try
    {
      paramString = new f(paramString);
      paramString.Px();
      paramString.Pw();
      localh = paramString.Pi();
      paramString.Pw();
      if (!paramString.PE())
      {
        paramString = paramString.cu("Unexpected character");
        AppMethodBeat.o(74681);
        throw paramString;
      }
    }
    catch (IOException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(74681);
      throw paramString;
    }
    AppMethodBeat.o(74681);
    return localh;
  }
  
  private static String cp(String paramString)
  {
    AppMethodBeat.i(74682);
    if (paramString.endsWith(".0"))
    {
      paramString = paramString.substring(0, paramString.length() - 2);
      AppMethodBeat.o(74682);
      return paramString;
    }
    AppMethodBeat.o(74682);
    return paramString;
  }
  
  public static h he(int paramInt)
  {
    AppMethodBeat.i(74676);
    d locald = new d(Integer.toString(paramInt, 10));
    AppMethodBeat.o(74676);
    return locald;
  }
  
  public static h r(double paramDouble)
  {
    AppMethodBeat.i(74679);
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble)))
    {
      localObject = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
      AppMethodBeat.o(74679);
      throw ((Throwable)localObject);
    }
    Object localObject = new d(cp(Double.toString(paramDouble)));
    AppMethodBeat.o(74679);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.a
 * JD-Core Version:    0.7.0.1
 */