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
  private final c mBx;
  
  public i()
  {
    AppMethodBeat.i(158571);
    this.mBx = h.aZn();
    AppMethodBeat.o(158571);
  }
  
  public i(c paramc)
  {
    AppMethodBeat.i(158572);
    Assert.assertNotNull(paramc);
    this.mBx = paramc;
    AppMethodBeat.o(158572);
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(158574);
    this.mBx = h.Fo(paramString);
    AppMethodBeat.o(158574);
  }
  
  public i(Map paramMap)
  {
    AppMethodBeat.i(158573);
    this.mBx = h.u(paramMap);
    AppMethodBeat.o(158573);
  }
  
  private i d(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158577);
    this.mBx.c(Fi(paramString), paramDouble);
    AppMethodBeat.o(158577);
    return this;
  }
  
  public final i A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158576);
    this.mBx.z(paramString, paramBoolean);
    AppMethodBeat.o(158576);
    return this;
  }
  
  public final String Fi(String paramString)
  {
    AppMethodBeat.i(158582);
    paramString = this.mBx.Fi(paramString);
    AppMethodBeat.o(158582);
    return paramString;
  }
  
  public final f Fq(String paramString)
  {
    AppMethodBeat.i(158603);
    paramString = this.mBx.Fj(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158603);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158603);
    return paramString;
  }
  
  public final f Fr(String paramString)
  {
    AppMethodBeat.i(158604);
    paramString = this.mBx.Fk(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158604);
      return null;
    }
    paramString = new f(paramString);
    AppMethodBeat.o(158604);
    return paramString;
  }
  
  public final i Fs(String paramString)
  {
    AppMethodBeat.i(158605);
    paramString = this.mBx.Fl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158605);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158605);
    return paramString;
  }
  
  public final i Ft(String paramString)
  {
    AppMethodBeat.i(158606);
    paramString = this.mBx.Fm(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158606);
      return null;
    }
    paramString = new i(paramString);
    AppMethodBeat.o(158606);
    return paramString;
  }
  
  public final i au(String paramString, int paramInt)
  {
    AppMethodBeat.i(158578);
    this.mBx.at(Fi(paramString), paramInt);
    AppMethodBeat.o(158578);
    return this;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(158586);
    paramString = this.mBx.get(paramString);
    AppMethodBeat.o(158586);
    return paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158588);
    boolean bool = this.mBx.getBoolean(paramString);
    AppMethodBeat.o(158588);
    return bool;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(158591);
    double d = this.mBx.getDouble(paramString);
    AppMethodBeat.o(158591);
    return d;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(158594);
    int i = this.mBx.getInt(paramString);
    AppMethodBeat.o(158594);
    return i;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(158597);
    long l = this.mBx.getLong(paramString);
    AppMethodBeat.o(158597);
    return l;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(158600);
    paramString = this.mBx.getString(paramString);
    AppMethodBeat.o(158600);
    return paramString;
  }
  
  public boolean has(String paramString)
  {
    AppMethodBeat.i(158585);
    boolean bool = this.mBx.has(paramString);
    AppMethodBeat.o(158585);
    return bool;
  }
  
  public boolean isNull(String paramString)
  {
    AppMethodBeat.i(158584);
    boolean bool = this.mBx.isNull(paramString);
    AppMethodBeat.o(158584);
    return bool;
  }
  
  public Iterator<String> keys()
  {
    AppMethodBeat.i(158607);
    Iterator localIterator = this.mBx.keys();
    AppMethodBeat.o(158607);
    return localIterator;
  }
  
  public int length()
  {
    AppMethodBeat.i(158575);
    int i = this.mBx.length();
    AppMethodBeat.o(158575);
    return i;
  }
  
  public final i m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158580);
    while ((paramObject instanceof i)) {
      paramObject = ((i)paramObject).mBx;
    }
    this.mBx.k(paramString, paramObject);
    AppMethodBeat.o(158580);
    return this;
  }
  
  public final i n(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158581);
    this.mBx.l(paramString, paramObject);
    AppMethodBeat.o(158581);
    return this;
  }
  
  public Object opt(String paramString)
  {
    AppMethodBeat.i(158587);
    paramString = this.mBx.opt(paramString);
    AppMethodBeat.o(158587);
    return paramString;
  }
  
  public boolean optBoolean(String paramString)
  {
    AppMethodBeat.i(158589);
    boolean bool = this.mBx.optBoolean(paramString, false);
    AppMethodBeat.o(158589);
    return bool;
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158590);
    paramBoolean = this.mBx.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(158590);
    return paramBoolean;
  }
  
  public double optDouble(String paramString)
  {
    AppMethodBeat.i(158592);
    double d = this.mBx.optDouble(paramString, (0.0D / 0.0D));
    AppMethodBeat.o(158592);
    return d;
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158593);
    paramDouble = this.mBx.optDouble(paramString, paramDouble);
    AppMethodBeat.o(158593);
    return paramDouble;
  }
  
  public int optInt(String paramString)
  {
    AppMethodBeat.i(158595);
    int i = this.mBx.optInt(paramString, 0);
    AppMethodBeat.o(158595);
    return i;
  }
  
  public int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158596);
    paramInt = this.mBx.optInt(paramString, paramInt);
    AppMethodBeat.o(158596);
    return paramInt;
  }
  
  public long optLong(String paramString)
  {
    AppMethodBeat.i(158598);
    long l = this.mBx.optLong(paramString, 0L);
    AppMethodBeat.o(158598);
    return l;
  }
  
  public long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158599);
    paramLong = this.mBx.optLong(paramString, paramLong);
    AppMethodBeat.o(158599);
    return paramLong;
  }
  
  public String optString(String paramString)
  {
    AppMethodBeat.i(158601);
    paramString = this.mBx.optString(paramString, "");
    AppMethodBeat.o(158601);
    return paramString;
  }
  
  public String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158602);
    paramString1 = this.mBx.optString(paramString1, paramString2);
    AppMethodBeat.o(158602);
    return paramString1;
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(158583);
    paramString = this.mBx.remove(paramString);
    AppMethodBeat.o(158583);
    return paramString;
  }
  
  public final i t(String paramString, long paramLong)
  {
    AppMethodBeat.i(158579);
    this.mBx.s(Fi(paramString), paramLong);
    AppMethodBeat.o(158579);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158608);
    String str = this.mBx.toString();
    AppMethodBeat.o(158608);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ad.i
 * JD-Core Version:    0.7.0.1
 */