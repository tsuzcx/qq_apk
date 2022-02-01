package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class i
  extends JSONObject
  implements c
{
  private final c gCN;
  
  public i()
  {
    AppMethodBeat.i(158571);
    this.gCN = h.aiC();
    AppMethodBeat.o(158571);
  }
  
  public i(c paramc)
  {
    AppMethodBeat.i(158572);
    Assert.assertNotNull(paramc);
    this.gCN = paramc;
    AppMethodBeat.o(158572);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(158574);
    this.gCN = h.xt(paramString);
    AppMethodBeat.o(158574);
  }
  
  public i(Map paramMap)
  {
    AppMethodBeat.i(158573);
    this.gCN = h.t(paramMap);
    AppMethodBeat.o(158573);
  }
  
  private i c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158577);
    this.gCN.b(xn(paramString), paramDouble);
    AppMethodBeat.o(158577);
    return this;
  }
  
  private i i(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158581);
    this.gCN.g(paramString, paramObject);
    AppMethodBeat.o(158581);
    return this;
  }
  
  public final i S(String paramString, int paramInt)
  {
    AppMethodBeat.i(158578);
    this.gCN.R(xn(paramString), paramInt);
    AppMethodBeat.o(158578);
    return this;
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(158586);
    paramString = this.gCN.get(paramString);
    AppMethodBeat.o(158586);
    return paramString;
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158588);
    boolean bool = this.gCN.getBoolean(paramString);
    AppMethodBeat.o(158588);
    return bool;
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(158591);
    double d = this.gCN.getDouble(paramString);
    AppMethodBeat.o(158591);
    return d;
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(158594);
    int i = this.gCN.getInt(paramString);
    AppMethodBeat.o(158594);
    return i;
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(158597);
    long l = this.gCN.getLong(paramString);
    AppMethodBeat.o(158597);
    return l;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(158600);
    paramString = this.gCN.getString(paramString);
    AppMethodBeat.o(158600);
    return paramString;
  }
  
  public final i h(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158580);
    while ((paramObject instanceof i)) {
      paramObject = ((i)paramObject).gCN;
    }
    this.gCN.f(paramString, paramObject);
    AppMethodBeat.o(158580);
    return this;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(158585);
    boolean bool = this.gCN.has(paramString);
    AppMethodBeat.o(158585);
    return bool;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(158584);
    boolean bool = this.gCN.isNull(paramString);
    AppMethodBeat.o(158584);
    return bool;
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(158607);
    Iterator localIterator = this.gCN.keys();
    AppMethodBeat.o(158607);
    return localIterator;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158575);
    int i = this.gCN.length();
    AppMethodBeat.o(158575);
    return i;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(158587);
    paramString = this.gCN.opt(paramString);
    AppMethodBeat.o(158587);
    return paramString;
  }
  
  public final boolean optBoolean(String paramString)
  {
    AppMethodBeat.i(158589);
    boolean bool = this.gCN.optBoolean(paramString, false);
    AppMethodBeat.o(158589);
    return bool;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158590);
    paramBoolean = this.gCN.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(158590);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString)
  {
    AppMethodBeat.i(158592);
    double d = this.gCN.optDouble(paramString, (0.0D / 0.0D));
    AppMethodBeat.o(158592);
    return d;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158593);
    paramDouble = this.gCN.optDouble(paramString, paramDouble);
    AppMethodBeat.o(158593);
    return paramDouble;
  }
  
  public final int optInt(String paramString)
  {
    AppMethodBeat.i(158595);
    int i = this.gCN.optInt(paramString, 0);
    AppMethodBeat.o(158595);
    return i;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158596);
    paramInt = this.gCN.optInt(paramString, paramInt);
    AppMethodBeat.o(158596);
    return paramInt;
  }
  
  public final long optLong(String paramString)
  {
    AppMethodBeat.i(158598);
    long l = this.gCN.optLong(paramString, 0L);
    AppMethodBeat.o(158598);
    return l;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158599);
    paramLong = this.gCN.optLong(paramString, paramLong);
    AppMethodBeat.o(158599);
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(158601);
    paramString = this.gCN.optString(paramString, "");
    AppMethodBeat.o(158601);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158602);
    paramString1 = this.gCN.optString(paramString1, paramString2);
    AppMethodBeat.o(158602);
    return paramString1;
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(158583);
    paramString = this.gCN.remove(paramString);
    AppMethodBeat.o(158583);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158608);
    String str = this.gCN.toString();
    AppMethodBeat.o(158608);
    return str;
  }
  
  public final i u(String paramString, long paramLong)
  {
    AppMethodBeat.i(158579);
    this.gCN.t(xn(paramString), paramLong);
    AppMethodBeat.o(158579);
    return this;
  }
  
  public final i v(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158576);
    this.gCN.u(paramString, paramBoolean);
    AppMethodBeat.o(158576);
    return this;
  }
  
  public final String xn(String paramString)
  {
    AppMethodBeat.i(158582);
    paramString = this.gCN.xn(paramString);
    AppMethodBeat.o(158582);
    return paramString;
  }
  
  public final f xv(String paramString)
  {
    AppMethodBeat.i(158603);
    paramString = this.gCN.xo(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158603);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158603);
    return paramString;
  }
  
  public final f xw(String paramString)
  {
    AppMethodBeat.i(158604);
    paramString = this.gCN.xp(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158604);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158604);
    return paramString;
  }
  
  public final i xx(String paramString)
  {
    AppMethodBeat.i(158605);
    paramString = this.gCN.xq(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158605);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158605);
    return paramString;
  }
  
  public final i xy(String paramString)
  {
    AppMethodBeat.i(158606);
    paramString = this.gCN.xr(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.i
 * JD-Core Version:    0.7.0.1
 */