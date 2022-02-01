package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class i
  extends JSONObject
  implements c
{
  private final c gAg;
  
  public i()
  {
    AppMethodBeat.i(158571);
    this.gAg = h.ain();
    AppMethodBeat.o(158571);
  }
  
  public i(c paramc)
  {
    AppMethodBeat.i(158572);
    Assert.assertNotNull(paramc);
    this.gAg = paramc;
    AppMethodBeat.o(158572);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(158574);
    this.gAg = h.wK(paramString);
    AppMethodBeat.o(158574);
  }
  
  public i(Map paramMap)
  {
    AppMethodBeat.i(158573);
    this.gAg = h.m(paramMap);
    AppMethodBeat.o(158573);
  }
  
  private i c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158577);
    this.gAg.b(wE(paramString), paramDouble);
    AppMethodBeat.o(158577);
    return this;
  }
  
  private i i(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158581);
    this.gAg.g(paramString, paramObject);
    AppMethodBeat.o(158581);
    return this;
  }
  
  public final i R(String paramString, int paramInt)
  {
    AppMethodBeat.i(158578);
    this.gAg.Q(wE(paramString), paramInt);
    AppMethodBeat.o(158578);
    return this;
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(158586);
    paramString = this.gAg.get(paramString);
    AppMethodBeat.o(158586);
    return paramString;
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158588);
    boolean bool = this.gAg.getBoolean(paramString);
    AppMethodBeat.o(158588);
    return bool;
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(158591);
    double d = this.gAg.getDouble(paramString);
    AppMethodBeat.o(158591);
    return d;
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(158594);
    int i = this.gAg.getInt(paramString);
    AppMethodBeat.o(158594);
    return i;
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(158597);
    long l = this.gAg.getLong(paramString);
    AppMethodBeat.o(158597);
    return l;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(158600);
    paramString = this.gAg.getString(paramString);
    AppMethodBeat.o(158600);
    return paramString;
  }
  
  public final i h(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158580);
    while ((paramObject instanceof i)) {
      paramObject = ((i)paramObject).gAg;
    }
    this.gAg.f(paramString, paramObject);
    AppMethodBeat.o(158580);
    return this;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(158585);
    boolean bool = this.gAg.has(paramString);
    AppMethodBeat.o(158585);
    return bool;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(158584);
    boolean bool = this.gAg.isNull(paramString);
    AppMethodBeat.o(158584);
    return bool;
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(158607);
    Iterator localIterator = this.gAg.keys();
    AppMethodBeat.o(158607);
    return localIterator;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158575);
    int i = this.gAg.length();
    AppMethodBeat.o(158575);
    return i;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(158587);
    paramString = this.gAg.opt(paramString);
    AppMethodBeat.o(158587);
    return paramString;
  }
  
  public final boolean optBoolean(String paramString)
  {
    AppMethodBeat.i(158589);
    boolean bool = this.gAg.optBoolean(paramString, false);
    AppMethodBeat.o(158589);
    return bool;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158590);
    paramBoolean = this.gAg.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(158590);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString)
  {
    AppMethodBeat.i(158592);
    double d = this.gAg.optDouble(paramString, (0.0D / 0.0D));
    AppMethodBeat.o(158592);
    return d;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158593);
    paramDouble = this.gAg.optDouble(paramString, paramDouble);
    AppMethodBeat.o(158593);
    return paramDouble;
  }
  
  public final int optInt(String paramString)
  {
    AppMethodBeat.i(158595);
    int i = this.gAg.optInt(paramString, 0);
    AppMethodBeat.o(158595);
    return i;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158596);
    paramInt = this.gAg.optInt(paramString, paramInt);
    AppMethodBeat.o(158596);
    return paramInt;
  }
  
  public final long optLong(String paramString)
  {
    AppMethodBeat.i(158598);
    long l = this.gAg.optLong(paramString, 0L);
    AppMethodBeat.o(158598);
    return l;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158599);
    paramLong = this.gAg.optLong(paramString, paramLong);
    AppMethodBeat.o(158599);
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(158601);
    paramString = this.gAg.optString(paramString, "");
    AppMethodBeat.o(158601);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158602);
    paramString1 = this.gAg.optString(paramString1, paramString2);
    AppMethodBeat.o(158602);
    return paramString1;
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(158583);
    paramString = this.gAg.remove(paramString);
    AppMethodBeat.o(158583);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158608);
    String str = this.gAg.toString();
    AppMethodBeat.o(158608);
    return str;
  }
  
  public final i u(String paramString, long paramLong)
  {
    AppMethodBeat.i(158579);
    this.gAg.t(wE(paramString), paramLong);
    AppMethodBeat.o(158579);
    return this;
  }
  
  public final i v(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158576);
    this.gAg.u(paramString, paramBoolean);
    AppMethodBeat.o(158576);
    return this;
  }
  
  public final String wE(String paramString)
  {
    AppMethodBeat.i(158582);
    paramString = this.gAg.wE(paramString);
    AppMethodBeat.o(158582);
    return paramString;
  }
  
  public final f wM(String paramString)
  {
    AppMethodBeat.i(158603);
    paramString = this.gAg.wF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158603);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158603);
    return paramString;
  }
  
  public final f wN(String paramString)
  {
    AppMethodBeat.i(158604);
    paramString = this.gAg.wG(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158604);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158604);
    return paramString;
  }
  
  public final i wO(String paramString)
  {
    AppMethodBeat.i(158605);
    paramString = this.gAg.wH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158605);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158605);
    return paramString;
  }
  
  public final i wP(String paramString)
  {
    AppMethodBeat.i(158606);
    paramString = this.gAg.wI(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158606);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158606);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ac.i
 * JD-Core Version:    0.7.0.1
 */