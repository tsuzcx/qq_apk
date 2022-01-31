package com.tencent.mm.aa;

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
  private e eGL;
  
  public l()
  {
    AppMethodBeat.i(117733);
    this.eGL = new e();
    AppMethodBeat.o(117733);
  }
  
  l(e parame)
  {
    AppMethodBeat.i(117734);
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    this.eGL = locale;
    AppMethodBeat.o(117734);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(117736);
    this.eGL = com.eclipsesource.a.a.aa(paramString).lM();
    AppMethodBeat.o(117736);
  }
  
  public l(Map paramMap)
  {
    AppMethodBeat.i(117735);
    this.eGL = j.l(paramMap);
    AppMethodBeat.o(117735);
  }
  
  public final c J(String paramString, int paramInt)
  {
    AppMethodBeat.i(117740);
    this.eGL.a(paramString, com.eclipsesource.a.a.cR(paramInt));
    AppMethodBeat.o(117740);
    return this;
  }
  
  public final c c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(117739);
    this.eGL.a(paramString, com.eclipsesource.a.a.l(paramDouble));
    AppMethodBeat.o(117739);
    return this;
  }
  
  public final c c(String paramString, Object paramObject)
  {
    AppMethodBeat.i(117742);
    j.a(this.eGL, paramString, paramObject);
    AppMethodBeat.o(117742);
    return this;
  }
  
  public final c e(String paramString, Object paramObject)
  {
    AppMethodBeat.i(117743);
    j.a(this.eGL, paramString, paramObject);
    AppMethodBeat.o(117743);
    return this;
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(117748);
    paramString = opt(paramString);
    AppMethodBeat.o(117748);
    return paramString;
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(117750);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117750);
      throw paramString;
    }
    if (localh.isBoolean())
    {
      boolean bool = localh.lI();
      AppMethodBeat.o(117750);
      return bool;
    }
    if (localh.isString())
    {
      String str = localh.toString();
      if ("true".equals(str))
      {
        AppMethodBeat.o(117750);
        return true;
      }
      if ("false".equals(str))
      {
        AppMethodBeat.o(117750);
        return false;
      }
    }
    paramString = new g(String.format("getBoolean by key : %s error, value : %s", new Object[] { paramString, localh }));
    AppMethodBeat.o(117750);
    throw paramString;
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(117752);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117752);
      throw paramString;
    }
    try
    {
      double d;
      if (localh.isNumber())
      {
        d = localh.lL();
        AppMethodBeat.o(117752);
        return d;
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        AppMethodBeat.o(117752);
        return d;
      }
    }
    catch (Exception localException)
    {
      paramString = new g(String.format("getDouble by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(117752);
      throw paramString;
    }
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(117754);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117754);
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
          i = localh.lJ();
          AppMethodBeat.o(117754);
          return i;
        }
        catch (Exception localException1)
        {
          d = localh.lL();
          i = (int)d;
          AppMethodBeat.o(117754);
          return i;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        i = (int)d;
        AppMethodBeat.o(117754);
        return i;
      }
    }
    catch (Exception localException2)
    {
      paramString = new g(String.format("getInt by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(117754);
      throw paramString;
    }
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(117756);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117756);
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
          l = localh.lK();
          AppMethodBeat.o(117756);
          return l;
        }
        catch (Exception localException1)
        {
          d = localh.lL();
          l = d;
          AppMethodBeat.o(117756);
          return l;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.toString());
        l = d;
        AppMethodBeat.o(117756);
        return l;
      }
    }
    catch (Exception localException2)
    {
      paramString = new g(String.format("getLong by key : %s error, value : %s", new Object[] { paramString, localh }));
      AppMethodBeat.o(117756);
      throw paramString;
    }
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(117758);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117758);
      throw paramString;
    }
    if (localh.isString())
    {
      paramString = localh.mk();
      AppMethodBeat.o(117758);
      return paramString;
    }
    paramString = localh.toString();
    AppMethodBeat.o(117758);
    return paramString;
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(117747);
    if (this.eGL.ad(paramString) != null)
    {
      AppMethodBeat.o(117747);
      return true;
    }
    AppMethodBeat.o(117747);
    return false;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(117746);
    if (this.eGL.ad(paramString) == null)
    {
      AppMethodBeat.o(117746);
      return true;
    }
    AppMethodBeat.o(117746);
    return false;
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(117765);
    Iterator localIterator = Collections.unmodifiableList(this.eGL.atV).iterator();
    AppMethodBeat.o(117765);
    return localIterator;
  }
  
  public final int length()
  {
    AppMethodBeat.i(117737);
    int i = this.eGL.atV.size();
    AppMethodBeat.o(117737);
    return i;
  }
  
  public final String mj(String paramString)
  {
    AppMethodBeat.i(117744);
    if (paramString == null)
    {
      paramString = new g("Names must be non-null");
      AppMethodBeat.o(117744);
      throw paramString;
    }
    AppMethodBeat.o(117744);
    return paramString;
  }
  
  public final a mk(String paramString)
  {
    AppMethodBeat.i(117761);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117761);
      throw paramString;
    }
    paramString = new k(localh.lH());
    AppMethodBeat.o(117761);
    return paramString;
  }
  
  public final a ml(String paramString)
  {
    AppMethodBeat.i(117762);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117762);
      return null;
    }
    paramString = new k(paramString.lH());
    AppMethodBeat.o(117762);
    return paramString;
  }
  
  public final c mm(String paramString)
  {
    AppMethodBeat.i(117763);
    h localh = this.eGL.ad(paramString);
    if (localh == null)
    {
      paramString = new g(String.format("key %s do not exist.", new Object[] { paramString }));
      AppMethodBeat.o(117763);
      throw paramString;
    }
    paramString = new l(localh.lM());
    AppMethodBeat.o(117763);
    return paramString;
  }
  
  public final c mn(String paramString)
  {
    AppMethodBeat.i(117764);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117764);
      return null;
    }
    paramString = new l(paramString.lM());
    AppMethodBeat.o(117764);
    return paramString;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(117749);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117749);
      return null;
    }
    if (paramString.isNumber())
    {
      paramString = paramString.toString();
      AppMethodBeat.o(117749);
      return paramString;
    }
    if (paramString.isBoolean())
    {
      boolean bool = paramString.lI();
      AppMethodBeat.o(117749);
      return Boolean.valueOf(bool);
    }
    if (paramString.isArray())
    {
      paramString = new k(paramString.lH());
      AppMethodBeat.o(117749);
      return paramString;
    }
    if (paramString.isObject())
    {
      paramString = new l(paramString.lM());
      AppMethodBeat.o(117749);
      return paramString;
    }
    if (paramString.isString())
    {
      paramString = paramString.mk();
      AppMethodBeat.o(117749);
      return paramString;
    }
    AppMethodBeat.o(117749);
    return null;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117751);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117751);
      return paramBoolean;
    }
    if (paramString.isBoolean())
    {
      paramBoolean = paramString.lI();
      AppMethodBeat.o(117751);
      return paramBoolean;
    }
    if (paramString.isString())
    {
      paramString = paramString.toString();
      if ("true".equals(paramString))
      {
        AppMethodBeat.o(117751);
        return true;
      }
      if ("false".equals(paramString))
      {
        AppMethodBeat.o(117751);
        return false;
      }
    }
    AppMethodBeat.o(117751);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(117753);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117753);
      return paramDouble;
    }
    try
    {
      double d;
      if (paramString.isNumber())
      {
        d = paramString.lL();
        AppMethodBeat.o(117753);
        return d;
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        AppMethodBeat.o(117753);
        return d;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(117753);
    }
    return paramDouble;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(117755);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117755);
      return paramInt;
    }
    try
    {
      boolean bool = paramString.isNumber();
      double d;
      if (bool) {
        try
        {
          int i = paramString.lJ();
          AppMethodBeat.o(117755);
          return i;
        }
        catch (Exception localException)
        {
          d = paramString.lL();
          paramInt = (int)d;
          AppMethodBeat.o(117755);
          return paramInt;
        }
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        paramInt = (int)d;
        AppMethodBeat.o(117755);
        return paramInt;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(117755);
    }
    return paramInt;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(117757);
    paramString = this.eGL.ad(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117757);
      return paramLong;
    }
    try
    {
      boolean bool = paramString.isNumber();
      double d;
      if (bool) {
        try
        {
          long l = paramString.lK();
          AppMethodBeat.o(117757);
          return l;
        }
        catch (Exception localException)
        {
          d = paramString.lL();
          paramLong = d;
          AppMethodBeat.o(117757);
          return paramLong;
        }
      }
      if (paramString.isString())
      {
        d = Double.parseDouble(paramString.toString());
        paramLong = d;
        AppMethodBeat.o(117757);
        return paramLong;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(117757);
    }
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(117759);
    paramString = optString(paramString, null);
    AppMethodBeat.o(117759);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117760);
    paramString1 = this.eGL.ad(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(117760);
      return null;
    }
    if (paramString1.isString())
    {
      paramString1 = paramString1.mk();
      AppMethodBeat.o(117760);
      return paramString1;
    }
    paramString1 = paramString1.toString();
    AppMethodBeat.o(117760);
    return paramString1;
  }
  
  public final c r(String paramString, long paramLong)
  {
    AppMethodBeat.i(117741);
    this.eGL.a(paramString, com.eclipsesource.a.a.l(paramLong));
    AppMethodBeat.o(117741);
    return this;
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(117745);
    e locale = this.eGL;
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(117745);
      throw paramString;
    }
    int i = locale.indexOf(paramString);
    if (i != -1)
    {
      locale.atW.remove(i);
      locale.atV.remove(i);
      locale.atP.remove(i);
    }
    if (locale.isNumber())
    {
      paramString = locale.toString();
      AppMethodBeat.o(117745);
      return paramString;
    }
    if (locale.isBoolean())
    {
      boolean bool = locale.lI();
      AppMethodBeat.o(117745);
      return Boolean.valueOf(bool);
    }
    if (locale.isArray())
    {
      paramString = new k(locale.lH());
      AppMethodBeat.o(117745);
      return paramString;
    }
    if (locale.isObject())
    {
      paramString = new l(locale.lM());
      AppMethodBeat.o(117745);
      return paramString;
    }
    if (locale.isString())
    {
      paramString = locale.mk();
      AppMethodBeat.o(117745);
      return paramString;
    }
    AppMethodBeat.o(117745);
    return null;
  }
  
  public final c t(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117738);
    this.eGL.a(paramString, com.eclipsesource.a.a.az(paramBoolean));
    AppMethodBeat.o(117738);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117766);
    String str = this.eGL.toString();
    AppMethodBeat.o(117766);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aa.l
 * JD-Core Version:    0.7.0.1
 */