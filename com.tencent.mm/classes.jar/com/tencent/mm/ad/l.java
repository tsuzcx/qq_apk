package com.tencent.mm.ad;

import com.eclipsesource.a.e;
import com.eclipsesource.a.e.a;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
  implements c
{
  private e mBz;
  
  public l()
  {
    AppMethodBeat.i(158673);
    this.mBz = new e();
    AppMethodBeat.o(158673);
  }
  
  l(e parame)
  {
    AppMethodBeat.i(158674);
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    this.mBz = locale;
    AppMethodBeat.o(158674);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(158676);
    this.mBz = com.eclipsesource.a.a.co(paramString).Ph();
    AppMethodBeat.o(158676);
  }
  
  public l(Map paramMap)
  {
    AppMethodBeat.i(158675);
    this.mBz = j.v(paramMap);
    AppMethodBeat.o(158675);
  }
  
  public final String Fi(String paramString)
  {
    AppMethodBeat.i(158684);
    if (paramString == null)
    {
      paramString = new g("Names must be non-null");
      AppMethodBeat.o(158684);
      throw paramString;
    }
    AppMethodBeat.o(158684);
    return paramString;
  }
  
  public final a Fj(String paramString)
  {
    AppMethodBeat.i(158701);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158701);
      throw paramString;
    }
    paramString = new k(localh.Pc());
    AppMethodBeat.o(158701);
    return paramString;
  }
  
  public final a Fk(String paramString)
  {
    AppMethodBeat.i(158702);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158702);
      return null;
    }
    paramString = new k(paramString.Pc());
    AppMethodBeat.o(158702);
    return paramString;
  }
  
  public final c Fl(String paramString)
  {
    AppMethodBeat.i(158703);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158703);
      throw paramString;
    }
    paramString = new l(localh.Ph());
    AppMethodBeat.o(158703);
    return paramString;
  }
  
  public final c Fm(String paramString)
  {
    AppMethodBeat.i(158704);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158704);
      return null;
    }
    paramString = new l(paramString.Ph());
    AppMethodBeat.o(158704);
    return paramString;
  }
  
  public final c at(String paramString, int paramInt)
  {
    AppMethodBeat.i(158680);
    this.mBz.a(paramString, com.eclipsesource.a.a.he(paramInt));
    AppMethodBeat.o(158680);
    return this;
  }
  
  public final c c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158679);
    this.mBz.a(paramString, com.eclipsesource.a.a.r(paramDouble));
    AppMethodBeat.o(158679);
    return this;
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(158688);
    paramString = opt(paramString);
    AppMethodBeat.o(158688);
    return paramString;
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158690);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158690);
      throw paramString;
    }
    if (localh.isBoolean())
    {
      boolean bool = localh.Pd();
      AppMethodBeat.o(158690);
      return bool;
    }
    if (localh.isString())
    {
      String str = localh.toString();
      if ("true".equals(str))
      {
        AppMethodBeat.o(158690);
        return true;
      }
      if ("false".equals(str))
      {
        AppMethodBeat.o(158690);
        return false;
      }
    }
    paramString = new g(String.format("getBoolean by key : %s error, value : %s", new Object[] { paramString, localh }));
    AppMethodBeat.o(158690);
    throw paramString;
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(158692);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158692);
      throw paramString;
    }
    try
    {
      double d;
      if (localh.isNumber())
      {
        d = localh.Pg();
        AppMethodBeat.o(158692);
        return d;
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        AppMethodBeat.o(158692);
        return d;
      }
    }
    catch (Exception localException)
    {
      paramString = new g(String.format("getDouble by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(158692);
      throw paramString;
    }
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(158694);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158694);
      throw paramString;
    }
    try
    {
      boolean bool = localh.isNumber();
      int i;
      double d;
      if (bool) {
        try
        {
          i = localh.Pe();
          AppMethodBeat.o(158694);
          return i;
        }
        catch (Exception localException1)
        {
          d = localh.Pg();
          i = (int)d;
          AppMethodBeat.o(158694);
          return i;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        i = (int)d;
        AppMethodBeat.o(158694);
        return i;
      }
    }
    catch (Exception localException2)
    {
      paramString = new g(String.format("getInt by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(158694);
      throw paramString;
    }
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(158696);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158696);
      throw paramString;
    }
    try
    {
      boolean bool = localh.isNumber();
      long l;
      double d;
      if (bool) {
        try
        {
          l = localh.Pf();
          AppMethodBeat.o(158696);
          return l;
        }
        catch (Exception localException1)
        {
          d = localh.Pg();
          l = d;
          AppMethodBeat.o(158696);
          return l;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        l = d;
        AppMethodBeat.o(158696);
        return l;
      }
    }
    catch (Exception localException2)
    {
      paramString = new g(String.format("getLong by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(158696);
      throw paramString;
    }
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(158698);
    h localh = this.mBz.cr(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(158698);
      throw paramString;
    }
    if (localh.isString())
    {
      paramString = localh.PF();
      AppMethodBeat.o(158698);
      return paramString;
    }
    paramString = localh.toString();
    AppMethodBeat.o(158698);
    return paramString;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(158687);
    if (this.mBz.cr(paramString) != null)
    {
      AppMethodBeat.o(158687);
      return true;
    }
    AppMethodBeat.o(158687);
    return false;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(158686);
    if (this.mBz.cr(paramString) == null)
    {
      AppMethodBeat.o(158686);
      return true;
    }
    AppMethodBeat.o(158686);
    return false;
  }
  
  public final c k(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158682);
    j.a(this.mBz, paramString, paramObject);
    AppMethodBeat.o(158682);
    return this;
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(158705);
    Iterator localIterator = Collections.unmodifiableList(this.mBz.cBS).iterator();
    AppMethodBeat.o(158705);
    return localIterator;
  }
  
  public final c l(String paramString, Object paramObject)
  {
    AppMethodBeat.i(158683);
    j.a(this.mBz, paramString, paramObject);
    AppMethodBeat.o(158683);
    return this;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158677);
    int i = this.mBz.cBS.size();
    AppMethodBeat.o(158677);
    return i;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(158689);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158689);
      return null;
    }
    if (paramString.isNumber())
    {
      paramString = paramString.toString();
      AppMethodBeat.o(158689);
      return paramString;
    }
    if (paramString.isBoolean())
    {
      boolean bool = paramString.Pd();
      AppMethodBeat.o(158689);
      return Boolean.valueOf(bool);
    }
    if (paramString.isArray())
    {
      paramString = new k(paramString.Pc());
      AppMethodBeat.o(158689);
      return paramString;
    }
    if (paramString.isObject())
    {
      paramString = new l(paramString.Ph());
      AppMethodBeat.o(158689);
      return paramString;
    }
    if (paramString.isString())
    {
      paramString = paramString.PF();
      AppMethodBeat.o(158689);
      return paramString;
    }
    AppMethodBeat.o(158689);
    return null;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158691);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158691);
      return paramBoolean;
    }
    if (paramString.isBoolean())
    {
      paramBoolean = paramString.Pd();
      AppMethodBeat.o(158691);
      return paramBoolean;
    }
    if (paramString.isString())
    {
      paramString = paramString.toString();
      if ("true".equals(paramString))
      {
        AppMethodBeat.o(158691);
        return true;
      }
      if ("false".equals(paramString))
      {
        AppMethodBeat.o(158691);
        return false;
      }
    }
    AppMethodBeat.o(158691);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158693);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158693);
      return paramDouble;
    }
    try
    {
      double d;
      if (paramString.isNumber())
      {
        d = paramString.Pg();
        AppMethodBeat.o(158693);
        return d;
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        AppMethodBeat.o(158693);
        return d;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(158693);
    }
    return paramDouble;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158695);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158695);
      return paramInt;
    }
    try
    {
      boolean bool = paramString.isNumber();
      double d;
      if (bool) {
        try
        {
          int i = paramString.Pe();
          AppMethodBeat.o(158695);
          return i;
        }
        catch (Exception localException)
        {
          d = paramString.Pg();
          paramInt = (int)d;
          AppMethodBeat.o(158695);
          return paramInt;
        }
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        paramInt = (int)d;
        AppMethodBeat.o(158695);
        return paramInt;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(158695);
    }
    return paramInt;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158697);
    paramString = this.mBz.cr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158697);
      return paramLong;
    }
    try
    {
      boolean bool = paramString.isNumber();
      double d;
      if (bool) {
        try
        {
          long l = paramString.Pf();
          AppMethodBeat.o(158697);
          return l;
        }
        catch (Exception localException)
        {
          d = paramString.Pg();
          paramLong = d;
          AppMethodBeat.o(158697);
          return paramLong;
        }
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        paramLong = d;
        AppMethodBeat.o(158697);
        return paramLong;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(158697);
    }
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(158699);
    paramString = optString(paramString, null);
    AppMethodBeat.o(158699);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158700);
    paramString1 = this.mBz.cr(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(158700);
      return null;
    }
    if (paramString1.isString())
    {
      paramString1 = paramString1.PF();
      AppMethodBeat.o(158700);
      return paramString1;
    }
    paramString1 = paramString1.toString();
    AppMethodBeat.o(158700);
    return paramString1;
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(158685);
    e locale = this.mBz;
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(158685);
      throw paramString;
    }
    int i = locale.cs(paramString);
    if (i != -1)
    {
      locale.cBT.remove(i);
      locale.cBS.remove(i);
      locale.values.remove(i);
    }
    if (locale == null)
    {
      AppMethodBeat.o(158685);
      return null;
    }
    if (locale.isNumber())
    {
      paramString = locale.toString();
      AppMethodBeat.o(158685);
      return paramString;
    }
    if (locale.isBoolean())
    {
      boolean bool = locale.Pd();
      AppMethodBeat.o(158685);
      return Boolean.valueOf(bool);
    }
    if (locale.isArray())
    {
      paramString = new k(locale.Pc());
      AppMethodBeat.o(158685);
      return paramString;
    }
    if (locale.isObject())
    {
      paramString = new l(locale.Ph());
      AppMethodBeat.o(158685);
      return paramString;
    }
    if (locale.isString())
    {
      paramString = locale.PF();
      AppMethodBeat.o(158685);
      return paramString;
    }
    AppMethodBeat.o(158685);
    return null;
  }
  
  public final c s(String paramString, long paramLong)
  {
    AppMethodBeat.i(158681);
    this.mBz.a(paramString, com.eclipsesource.a.a.bH(paramLong));
    AppMethodBeat.o(158681);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158706);
    String str = this.mBz.toString();
    AppMethodBeat.o(158706);
    return str;
  }
  
  public final c z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158678);
    this.mBz.a(paramString, com.eclipsesource.a.a.bs(paramBoolean));
    AppMethodBeat.o(158678);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ad.l
 * JD-Core Version:    0.7.0.1
 */