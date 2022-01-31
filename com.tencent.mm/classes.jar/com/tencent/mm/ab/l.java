package com.tencent.mm.ab;

import com.eclipsesource.a.e;
import com.eclipsesource.a.e.a;
import com.eclipsesource.a.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class l
  implements c
{
  private e dJn;
  
  public l()
  {
    this.dJn = new e();
  }
  
  l(e parame)
  {
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    this.dJn = locale;
  }
  
  public l(String paramString)
  {
    this.dJn = com.eclipsesource.a.a.W(paramString).jS();
  }
  
  public final c E(String paramString, int paramInt)
  {
    this.dJn.a(paramString, com.eclipsesource.a.a.cy(paramInt));
    return this;
  }
  
  public final c b(String paramString, double paramDouble)
  {
    this.dJn.a(paramString, com.eclipsesource.a.a.l(paramDouble));
    return this;
  }
  
  public final c c(String paramString, Object paramObject)
  {
    j.a(this.dJn, paramString, paramObject);
    return this;
  }
  
  public final c e(String paramString, Object paramObject)
  {
    j.a(this.dJn, paramString, paramObject);
    return this;
  }
  
  public final String fP(String paramString)
  {
    if (paramString == null) {
      throw new g("Names must be non-null");
    }
    return paramString;
  }
  
  public final a fQ(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    return new k(localh.jN());
  }
  
  public final a fR(String paramString)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {
      return null;
    }
    return new k(paramString.jN());
  }
  
  public final c fS(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    return new l(localh.jS());
  }
  
  public final c fT(String paramString)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {
      return null;
    }
    return new l(paramString.jS());
  }
  
  public final Object get(String paramString)
  {
    return opt(paramString);
  }
  
  public final boolean getBoolean(String paramString)
  {
    boolean bool = true;
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    if (localh.isBoolean()) {
      bool = localh.jO();
    }
    String str;
    do
    {
      return bool;
      if (!localh.isString()) {
        break;
      }
      str = localh.toString();
    } while ("true".equals(str));
    if ("false".equals(str)) {
      return false;
    }
    throw new g(String.format("getBoolean by key : %s error, value : %s", new Object[] { paramString, localh }));
  }
  
  public final double getDouble(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    try
    {
      if (localh.isNumber()) {
        return localh.jR();
      }
      if (localh.isString())
      {
        double d = Double.parseDouble(localh.toString());
        return d;
      }
    }
    catch (Exception localException)
    {
      throw new g(String.format("getDouble by key : %s error, value : %s", new Object[] { paramString, localh }));
    }
  }
  
  public final int getInt(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    try
    {
      boolean bool = localh.isNumber();
      if (bool) {
        try
        {
          int i = localh.jP();
          return i;
        }
        catch (Exception localException1)
        {
          return (int)localh.jR();
        }
      }
      if (localh.isString())
      {
        double d = Double.parseDouble(localh.toString());
        return (int)d;
      }
    }
    catch (Exception localException2)
    {
      throw new g(String.format("getInt by key : %s error, value : %s", new Object[] { paramString, localh }));
    }
  }
  
  public final long getLong(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    try
    {
      boolean bool = localh.isNumber();
      if (bool) {
        try
        {
          long l = localh.jQ();
          return l;
        }
        catch (Exception localException1)
        {
          return localh.jR();
        }
      }
      if (localh.isString())
      {
        double d = Double.parseDouble(localh.toString());
        return d;
      }
    }
    catch (Exception localException2)
    {
      throw new g(String.format("getLong by key : %s error, value : %s", new Object[] { paramString, localh }));
    }
  }
  
  public final String getString(String paramString)
  {
    h localh = this.dJn.Y(paramString);
    if (localh == null) {
      throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
    }
    if (localh.isString()) {
      return localh.kb();
    }
    return localh.toString();
  }
  
  public final boolean has(String paramString)
  {
    return this.dJn.Y(paramString) != null;
  }
  
  public final boolean isNull(String paramString)
  {
    return this.dJn.Y(paramString) == null;
  }
  
  public final c j(String paramString, long paramLong)
  {
    this.dJn.a(paramString, com.eclipsesource.a.a.n(paramLong));
    return this;
  }
  
  public final Iterator<String> keys()
  {
    return Collections.unmodifiableList(this.dJn.arD).iterator();
  }
  
  public final int length()
  {
    return this.dJn.arD.size();
  }
  
  public final Object opt(String paramString)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {}
    do
    {
      return null;
      if (paramString.isNumber()) {
        return paramString.toString();
      }
      if (paramString.isBoolean()) {
        return Boolean.valueOf(paramString.jO());
      }
      if (paramString.isArray()) {
        return new k(paramString.jN());
      }
      if (paramString.isObject()) {
        return new l(paramString.jS());
      }
    } while (!paramString.isString());
    return paramString.kb();
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        return paramBoolean;
        if (paramString.isBoolean()) {
          return paramString.jO();
        }
      } while (!paramString.isString());
      paramString = paramString.toString();
      if ("true".equals(paramString)) {
        return true;
      }
    } while (!"false".equals(paramString));
    return false;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return paramDouble;
      try
      {
        if (paramString.isNumber()) {
          return paramString.jR();
        }
        if (paramString.isString())
        {
          double d = Double.parseDouble(paramString.toString());
          return d;
        }
      }
      catch (Exception paramString) {}
    }
    return paramDouble;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return paramInt;
      try
      {
        boolean bool = paramString.isNumber();
        if (bool) {
          try
          {
            int i = paramString.jP();
            return i;
          }
          catch (Exception localException)
          {
            return (int)paramString.jR();
          }
        }
        if (paramString.isString())
        {
          double d = Double.parseDouble(paramString.toString());
          return (int)d;
        }
      }
      catch (Exception paramString) {}
    }
    return paramInt;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    paramString = this.dJn.Y(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return paramLong;
      try
      {
        boolean bool = paramString.isNumber();
        if (bool) {
          try
          {
            long l = paramString.jQ();
            return l;
          }
          catch (Exception localException)
          {
            return paramString.jR();
          }
        }
        if (paramString.isString())
        {
          double d = Double.parseDouble(paramString.toString());
          return d;
        }
      }
      catch (Exception paramString) {}
    }
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    return optString(paramString, null);
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    paramString1 = this.dJn.Y(paramString1);
    if (paramString1 == null) {
      return null;
    }
    if (paramString1.isString()) {
      return paramString1.kb();
    }
    return paramString1.toString();
  }
  
  public final c p(String paramString, boolean paramBoolean)
  {
    this.dJn.a(paramString, com.eclipsesource.a.a.aq(paramBoolean));
    return this;
  }
  
  public final Object remove(String paramString)
  {
    e locale = this.dJn;
    if (paramString == null) {
      throw new NullPointerException("name is null");
    }
    int i = locale.indexOf(paramString);
    if (i != -1)
    {
      locale.arE.remove(i);
      locale.arD.remove(i);
      locale.arx.remove(i);
    }
    if (locale == null) {}
    do
    {
      return null;
      if (locale.isNumber()) {
        return locale.toString();
      }
      if (locale.isBoolean()) {
        return Boolean.valueOf(locale.jO());
      }
      if (locale.isArray()) {
        return new k(locale.jN());
      }
      if (locale.isObject()) {
        return new l(locale.jS());
      }
    } while (!locale.isString());
    return locale.kb();
  }
  
  public final String toString()
  {
    return this.dJn.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ab.l
 * JD-Core Version:    0.7.0.1
 */