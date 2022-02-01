package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public class i
  extends JSONObject
  implements c
{
  private final c kbs;
  
  public i()
  {
    AppMethodBeat.i(158571);
    this.kbs = h.aGm();
    AppMethodBeat.o(158571);
  }
  
  public i(c paramc)
  {
    AppMethodBeat.i(158572);
    Assert.assertNotNull(paramc);
    this.kbs = paramc;
    AppMethodBeat.o(158572);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(158574);
    this.kbs = h.MF(paramString);
    AppMethodBeat.o(158574);
  }
  
  public i(Map paramMap)
  {
    AppMethodBeat.i(158573);
    this.kbs = h.n(paramMap);
    AppMethodBeat.o(158573);
  }
  
  private i d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158577);
    this.kbs.c(Mz(paramString), paramDouble);
    AppMethodBeat.o(158577);
    return this;
  }
  
  public final f MH(String paramString)
  {
    AppMethodBeat.i(158603);
    paramString = this.kbs.MA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158603);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158603);
    return paramString;
  }
  
  public final f MI(String paramString)
  {
    AppMethodBeat.i(158604);
    paramString = this.kbs.MB(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158604);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158604);
    return paramString;
  }
  
  public final i MJ(String paramString)
  {
    AppMethodBeat.i(158605);
    paramString = this.kbs.MC(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158605);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158605);
    return paramString;
  }
  
  public final i MK(String paramString)
  {
    AppMethodBeat.i(158606);
    paramString = this.kbs.MD(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158606);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158606);
    return paramString;
  }
  
  public final String Mz(String paramString)
  {
    AppMethodBeat.i(158582);
    paramString = this.kbs.Mz(paramString);
    AppMethodBeat.o(158582);
    return paramString;
  }
  
  public final i al(String paramString, int paramInt)
  {
    AppMethodBeat.i(158578);
    this.kbs.ak(Mz(paramString), paramInt);
    AppMethodBeat.o(158578);
    return this;
  }
  
  public final i g(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158580);
    while ((paramObject instanceof i)) {
      paramObject = ((i)paramObject).kbs;
    }
    this.kbs.e(paramString, paramObject);
    AppMethodBeat.o(158580);
    return this;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(158586);
    paramString = this.kbs.get(paramString);
    AppMethodBeat.o(158586);
    return paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158588);
    boolean bool = this.kbs.getBoolean(paramString);
    AppMethodBeat.o(158588);
    return bool;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(158591);
    double d = this.kbs.getDouble(paramString);
    AppMethodBeat.o(158591);
    return d;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(158594);
    int i = this.kbs.getInt(paramString);
    AppMethodBeat.o(158594);
    return i;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(158597);
    long l = this.kbs.getLong(paramString);
    AppMethodBeat.o(158597);
    return l;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(158600);
    paramString = this.kbs.getString(paramString);
    AppMethodBeat.o(158600);
    return paramString;
  }
  
  public final i h(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158581);
    this.kbs.f(paramString, paramObject);
    AppMethodBeat.o(158581);
    return this;
  }
  
  public boolean has(String paramString)
  {
    AppMethodBeat.i(158585);
    boolean bool = this.kbs.has(paramString);
    AppMethodBeat.o(158585);
    return bool;
  }
  
  public boolean isNull(String paramString)
  {
    AppMethodBeat.i(158584);
    boolean bool = this.kbs.isNull(paramString);
    AppMethodBeat.o(158584);
    return bool;
  }
  
  public Iterator<String> keys()
  {
    AppMethodBeat.i(158607);
    Iterator localIterator = this.kbs.keys();
    AppMethodBeat.o(158607);
    return localIterator;
  }
  
  public int length()
  {
    AppMethodBeat.i(158575);
    int i = this.kbs.length();
    AppMethodBeat.o(158575);
    return i;
  }
  
  public Object opt(String paramString)
  {
    AppMethodBeat.i(158587);
    paramString = this.kbs.opt(paramString);
    AppMethodBeat.o(158587);
    return paramString;
  }
  
  public boolean optBoolean(String paramString)
  {
    AppMethodBeat.i(158589);
    boolean bool = this.kbs.optBoolean(paramString, false);
    AppMethodBeat.o(158589);
    return bool;
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158590);
    paramBoolean = this.kbs.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(158590);
    return paramBoolean;
  }
  
  public double optDouble(String paramString)
  {
    AppMethodBeat.i(158592);
    double d = this.kbs.optDouble(paramString, (0.0D / 0.0D));
    AppMethodBeat.o(158592);
    return d;
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158593);
    paramDouble = this.kbs.optDouble(paramString, paramDouble);
    AppMethodBeat.o(158593);
    return paramDouble;
  }
  
  public int optInt(String paramString)
  {
    AppMethodBeat.i(158595);
    int i = this.kbs.optInt(paramString, 0);
    AppMethodBeat.o(158595);
    return i;
  }
  
  public int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158596);
    paramInt = this.kbs.optInt(paramString, paramInt);
    AppMethodBeat.o(158596);
    return paramInt;
  }
  
  public long optLong(String paramString)
  {
    AppMethodBeat.i(158598);
    long l = this.kbs.optLong(paramString, 0L);
    AppMethodBeat.o(158598);
    return l;
  }
  
  public long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158599);
    paramLong = this.kbs.optLong(paramString, paramLong);
    AppMethodBeat.o(158599);
    return paramLong;
  }
  
  public String optString(String paramString)
  {
    AppMethodBeat.i(158601);
    paramString = this.kbs.optString(paramString, "");
    AppMethodBeat.o(158601);
    return paramString;
  }
  
  public String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158602);
    paramString1 = this.kbs.optString(paramString1, paramString2);
    AppMethodBeat.o(158602);
    return paramString1;
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(158583);
    paramString = this.kbs.remove(paramString);
    AppMethodBeat.o(158583);
    return paramString;
  }
  
  public final i s(String paramString, long paramLong)
  {
    AppMethodBeat.i(158579);
    this.kbs.r(Mz(paramString), paramLong);
    AppMethodBeat.o(158579);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158608);
    String str = this.kbs.toString();
    AppMethodBeat.o(158608);
    return str;
  }
  
  public final i y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158576);
    this.kbs.x(paramString, paramBoolean);
    AppMethodBeat.o(158576);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ad.i
 * JD-Core Version:    0.7.0.1
 */