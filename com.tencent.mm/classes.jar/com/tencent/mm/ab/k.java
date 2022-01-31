package com.tencent.mm.ab;

import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import java.util.List;
import junit.framework.Assert;

public final class k
  implements a
{
  private b dJm;
  
  public k()
  {
    this.dJm = new b();
  }
  
  k(b paramb)
  {
    Assert.assertNotNull(paramb);
    this.dJm = paramb;
  }
  
  public k(String paramString)
  {
    this.dJm = com.eclipsesource.a.a.W(paramString).jN();
    if (this.dJm == null) {
      throw new g(String.format("JSONArray string(%s) parse error.", new Object[] { paramString }));
    }
  }
  
  public final a ac(Object paramObject)
  {
    j.a(this.dJm, paramObject);
    return this;
  }
  
  public final a bC(boolean paramBoolean)
  {
    this.dJm.ar(paramBoolean);
    return this;
  }
  
  public final a bw(long paramLong)
  {
    this.dJm.o(paramLong);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {}
    do
    {
      return null;
      if (localh.isNumber()) {
        return localh.toString();
      }
      if (localh.isBoolean()) {
        return Boolean.valueOf(localh.jO());
      }
      if (localh.isArray()) {
        return new k(localh.jN());
      }
      if (localh.isObject()) {
        return new l(localh.jS());
      }
    } while (!localh.isString());
    return localh.kb();
  }
  
  public final boolean getBoolean(int paramInt)
  {
    boolean bool = true;
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getBoolean(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
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
      str = localh.kb();
    } while ("true".equals(str));
    if ("false".equals(str)) {
      return false;
    }
    throw new g(String.format("getBoolean(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
  }
  
  public final double getDouble(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getDouble(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    try
    {
      if (localh.isNumber()) {
        return localh.jR();
      }
      if (localh.isString())
      {
        double d = Double.parseDouble(localh.kb());
        return d;
      }
    }
    catch (Exception localException)
    {
      throw new g(String.format("getDouble(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    }
  }
  
  public final int getInt(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getInteger(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    try
    {
      boolean bool = localh.isNumber();
      if (bool) {
        try
        {
          i = localh.jP();
          return i;
        }
        catch (Exception localException1)
        {
          return (int)localh.jR();
        }
      }
      if (localh.isString())
      {
        double d = Double.parseDouble(localh.kb());
        return (int)d;
      }
    }
    catch (Exception localException2)
    {
      throw new g(String.format("getInt(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    }
  }
  
  public final long getLong(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getLong(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
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
        double d = Double.parseDouble(localh.kb());
        return d;
      }
    }
    catch (Exception localException2)
    {
      throw new g(String.format("getLong(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    }
  }
  
  public final String getString(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getString(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (localh.isString()) {
      return localh.kb();
    }
    return localh.toString();
  }
  
  public final a hj(int paramInt)
  {
    this.dJm.cz(paramInt);
    return this;
  }
  
  public final a hk(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getJSONArray(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    return new k(localh.jN());
  }
  
  public final a hl(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    h localh;
    do
    {
      return null;
      localh = this.dJm.cA(paramInt);
    } while (localh == null);
    return new k(localh.jN());
  }
  
  public final c hm(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    h localh = this.dJm.cA(paramInt);
    if (localh == null) {
      throw new g(String.format("getJSONObject(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    return new l(localh.jS());
  }
  
  public final c hn(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    h localh;
    do
    {
      return null;
      localh = this.dJm.cA(paramInt);
    } while (localh == null);
    return new l(localh.jS());
  }
  
  public final boolean isNull(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= length()) || (this.dJm.cA(paramInt) == null);
  }
  
  public final int length()
  {
    return this.dJm.arx.size();
  }
  
  public final a n(double paramDouble)
  {
    this.dJm.m(paramDouble);
    return this;
  }
  
  public final Object opt(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    h localh;
    do
    {
      do
      {
        return null;
        localh = this.dJm.cA(paramInt);
      } while (localh == null);
      if (localh.isNumber()) {
        return localh.toString();
      }
      if (localh.isBoolean()) {
        return Boolean.valueOf(localh.jO());
      }
      if (localh.isArray()) {
        return new k(localh.jN());
      }
      if (localh.isObject()) {
        return new l(localh.jS());
      }
    } while (!localh.isString());
    return localh.kb();
  }
  
  public final boolean optBoolean(int paramInt)
  {
    return optBoolean(paramInt, false);
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return paramBoolean;
          localObject = this.dJm.cA(paramInt);
        } while (localObject == null);
        if (((h)localObject).isBoolean()) {
          return ((h)localObject).jO();
        }
      } while (!((h)localObject).isString());
      localObject = ((h)localObject).kb();
      if ("true".equals(localObject)) {
        return true;
      }
    } while (!"false".equals(localObject));
    return false;
  }
  
  public final double optDouble(int paramInt)
  {
    return optDouble(paramInt, 0.0D);
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    for (;;)
    {
      return paramDouble;
      h localh = this.dJm.cA(paramInt);
      if (localh != null) {
        try
        {
          if (localh.isNumber()) {
            return localh.jR();
          }
          if (localh.isString())
          {
            double d = Double.parseDouble(localh.kb());
            return d;
          }
        }
        catch (Exception localException) {}
      }
    }
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    return optInt(paramInt, 0);
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    int i = length();
    if ((paramInt1 < 0) || (paramInt1 >= i)) {}
    for (;;)
    {
      return paramInt2;
      h localh = this.dJm.cA(paramInt1);
      if (localh != null) {
        try
        {
          boolean bool = localh.isNumber();
          if (bool) {
            try
            {
              paramInt1 = localh.jP();
              return paramInt1;
            }
            catch (Exception localException2)
            {
              return (int)localh.jR();
            }
          }
          if (localh.isString())
          {
            double d = Double.parseDouble(localh.kb());
            return (int)d;
          }
        }
        catch (Exception localException1) {}
      }
    }
    return paramInt2;
  }
  
  public final long optLong(int paramInt)
  {
    return optLong(paramInt, 0L);
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    for (;;)
    {
      return paramLong;
      h localh = this.dJm.cA(paramInt);
      if (localh != null) {
        try
        {
          boolean bool = localh.isNumber();
          if (bool) {
            try
            {
              long l = localh.jQ();
              return l;
            }
            catch (Exception localException2)
            {
              return localh.jR();
            }
          }
          if (localh.isString())
          {
            double d = Double.parseDouble(localh.kb());
            return d;
          }
        }
        catch (Exception localException1) {}
      }
    }
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    return optString(paramInt, null);
  }
  
  public final String optString(int paramInt, String paramString)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    h localh;
    do
    {
      return paramString;
      localh = this.dJm.cA(paramInt);
    } while (localh == null);
    if (localh.isString()) {
      return localh.kb();
    }
    return localh.toString();
  }
  
  public final Object remove(int paramInt)
  {
    int i = length();
    if ((paramInt < 0) || (paramInt >= i)) {}
    b localb;
    do
    {
      do
      {
        return null;
        localb = this.dJm;
        localb.arx.remove(paramInt);
      } while (localb == null);
      if (localb.isNumber()) {
        return localb.toString();
      }
      if (localb.isBoolean()) {
        return Boolean.valueOf(localb.jO());
      }
      if (localb.isArray()) {
        return new k(localb.jN());
      }
      if (localb.isObject()) {
        return new l(localb.jS());
      }
    } while (!localb.isString());
    return localb.kb();
  }
  
  public final String toString()
  {
    return this.dJm.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ab.k
 * JD-Core Version:    0.7.0.1
 */