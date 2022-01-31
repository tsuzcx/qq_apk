package com.eclipsesource.a;

import java.io.IOException;

public final class a
{
  public static final h aru = new c("null");
  public static final h arv = new c("true");
  public static final h arw = new c("false");
  
  public static h T(float paramFloat)
  {
    if ((Float.isInfinite(paramFloat)) || (Float.isNaN(paramFloat))) {
      throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }
    return new d(X(Float.toString(paramFloat)));
  }
  
  public static h V(String paramString)
  {
    if (paramString == null) {
      return aru;
    }
    return new g(paramString);
  }
  
  public static h W(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("string is null");
    }
    h localh;
    try
    {
      paramString = new f(paramString);
      paramString.jX();
      paramString.jW();
      localh = paramString.jT();
      paramString.jW();
      if (!paramString.ka()) {
        throw paramString.aa("Unexpected character");
      }
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
    return localh;
  }
  
  private static String X(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".0")) {
      str = paramString.substring(0, paramString.length() - 2);
    }
    return str;
  }
  
  public static h aq(boolean paramBoolean)
  {
    if (paramBoolean) {
      return arv;
    }
    return arw;
  }
  
  public static h cy(int paramInt)
  {
    return new d(Integer.toString(paramInt, 10));
  }
  
  public static h l(double paramDouble)
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }
    return new d(X(Double.toString(paramDouble)));
  }
  
  public static h n(long paramLong)
  {
    return new d(Long.toString(paramLong, 10));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.a
 * JD-Core Version:    0.7.0.1
 */