package com.tencent.mm.ab;

import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import junit.framework.Assert;

public final class k
  implements a
{
  private b ggx;
  
  public k()
  {
    AppMethodBeat.i(158634);
    this.ggx = new b();
    AppMethodBeat.o(158634);
  }
  
  k(b paramb)
  {
    AppMethodBeat.i(158636);
    Assert.assertNotNull(paramb);
    this.ggx = paramb;
    AppMethodBeat.o(158636);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(158635);
    this.ggx = com.eclipsesource.a.a.Y(paramString).qC();
    if (this.ggx == null)
    {
      paramString = new g(String.format("JSONArray string(%s) parse error.", new Object[] { paramString }));
      AppMethodBeat.o(158635);
      throw paramString;
    }
    AppMethodBeat.o(158635);
  }
  
  public final a bj(Object paramObject)
  {
    AppMethodBeat.i(158642);
    j.a(this.ggx, paramObject);
    AppMethodBeat.o(158642);
    return this;
  }
  
  public final a c(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158644);
    try
    {
      this.ggx.a(paramInt, paramDouble);
      AppMethodBeat.o(158644);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(158644);
      throw localg;
    }
  }
  
  public final a cK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158645);
    try
    {
      this.ggx.aZ(paramInt1, paramInt2);
      AppMethodBeat.o(158645);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(158645);
      throw localg;
    }
  }
  
  public final a dw(boolean paramBoolean)
  {
    AppMethodBeat.i(158638);
    this.ggx.aM(paramBoolean);
    AppMethodBeat.o(158638);
    return this;
  }
  
  public final a f(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158647);
    for (;;)
    {
      b localb;
      try
      {
        localb = this.ggx;
        if ((paramObject instanceof c))
        {
          localb.a(paramInt, j.a((c)paramObject));
          AppMethodBeat.o(158647);
          return this;
        }
        if ((paramObject instanceof a))
        {
          localb.a(paramInt, j.a((a)paramObject));
          continue;
        }
        if (!(paramObject instanceof Integer)) {
          break label104;
        }
      }
      catch (Exception paramObject)
      {
        paramObject = new g(paramObject);
        AppMethodBeat.o(158647);
        throw paramObject;
      }
      localb.aZ(paramInt, ((Integer)paramObject).intValue());
      continue;
      label104:
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        localb.aGG.set(paramInt, com.eclipsesource.a.a.X(paramObject));
      }
      else if ((paramObject instanceof Boolean))
      {
        localb.l(paramInt, ((Boolean)paramObject).booleanValue());
      }
      else if ((paramObject instanceof Long))
      {
        localb.f(paramInt, ((Long)paramObject).longValue());
      }
      else if ((paramObject instanceof Float))
      {
        float f = ((Float)paramObject).floatValue();
        localb.aGG.set(paramInt, com.eclipsesource.a.a.Z(f));
      }
      else if ((paramObject instanceof Integer))
      {
        localb.aZ(paramInt, ((Integer)paramObject).intValue());
      }
      else if ((paramObject instanceof Double))
      {
        localb.a(paramInt, ((Double)paramObject).doubleValue());
      }
      else if ((paramObject instanceof h))
      {
        localb.a(paramInt, (h)paramObject);
      }
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(158649);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158649);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158649);
      return null;
    }
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(158649);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).qD();
      AppMethodBeat.o(158649);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).qC());
      AppMethodBeat.o(158649);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).qH());
      AppMethodBeat.o(158649);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).rf();
      AppMethodBeat.o(158649);
      return localObject;
    }
    AppMethodBeat.o(158649);
    return null;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(158652);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158652);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getBoolean(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158652);
      throw ((Throwable)localObject);
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).qD();
      AppMethodBeat.o(158652);
      return bool;
    }
    if (((h)localObject).isString())
    {
      String str = ((h)localObject).rf();
      if ("true".equals(str))
      {
        AppMethodBeat.o(158652);
        return true;
      }
      if ("false".equals(str))
      {
        AppMethodBeat.o(158652);
        return false;
      }
    }
    localObject = new g(String.format("getBoolean(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
    AppMethodBeat.o(158652);
    throw ((Throwable)localObject);
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(158655);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158655);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getDouble(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158655);
      throw ((Throwable)localObject);
    }
    try
    {
      double d;
      if (((h)localObject).isNumber())
      {
        d = ((h)localObject).qG();
        AppMethodBeat.o(158655);
        return d;
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).rf());
        AppMethodBeat.o(158655);
        return d;
      }
    }
    catch (Exception localException)
    {
      localObject = new g(String.format("getDouble(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(158655);
      throw ((Throwable)localObject);
    }
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(158658);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158658);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getInteger(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158658);
      throw ((Throwable)localObject);
    }
    try
    {
      boolean bool = ((h)localObject).isNumber();
      double d;
      if (bool) {
        try
        {
          i = ((h)localObject).qE();
          AppMethodBeat.o(158658);
          return i;
        }
        catch (Exception localException1)
        {
          d = ((h)localObject).qG();
          paramInt = (int)d;
          AppMethodBeat.o(158658);
          return paramInt;
        }
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).rf());
        paramInt = (int)d;
        AppMethodBeat.o(158658);
        return paramInt;
      }
    }
    catch (Exception localException2)
    {
      localObject = new g(String.format("getInt(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(158658);
      throw ((Throwable)localObject);
    }
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(158661);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158661);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getLong(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158661);
      throw ((Throwable)localObject);
    }
    try
    {
      boolean bool = ((h)localObject).isNumber();
      long l;
      double d;
      if (bool) {
        try
        {
          l = ((h)localObject).qF();
          AppMethodBeat.o(158661);
          return l;
        }
        catch (Exception localException1)
        {
          d = ((h)localObject).qG();
          l = d;
          AppMethodBeat.o(158661);
          return l;
        }
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).rf());
        l = d;
        AppMethodBeat.o(158661);
        return l;
      }
    }
    catch (Exception localException2)
    {
      localObject = new g(String.format("getLong(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(158661);
      throw ((Throwable)localObject);
    }
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(158664);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158664);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getString(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158664);
      throw ((Throwable)localObject);
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).rf();
      AppMethodBeat.o(158664);
      return localObject;
    }
    localObject = ((h)localObject).toString();
    AppMethodBeat.o(158664);
    return localObject;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(158648);
    if ((paramInt < 0) || (paramInt >= length()) || (this.ggx.dD(paramInt) == null))
    {
      AppMethodBeat.o(158648);
      return true;
    }
    AppMethodBeat.o(158648);
    return false;
  }
  
  public final a j(double paramDouble)
  {
    AppMethodBeat.i(158639);
    this.ggx.e(paramDouble);
    AppMethodBeat.o(158639);
    return this;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158637);
    int i = this.ggx.aGG.size();
    AppMethodBeat.o(158637);
    return i;
  }
  
  public final a mb(int paramInt)
  {
    AppMethodBeat.i(158640);
    this.ggx.dC(paramInt);
    AppMethodBeat.o(158640);
    return this;
  }
  
  public final a mc(int paramInt)
  {
    AppMethodBeat.i(158667);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158667);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getJSONArray(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158667);
      throw ((Throwable)localObject);
    }
    localObject = new k(((h)localObject).qC());
    AppMethodBeat.o(158667);
    return localObject;
  }
  
  public final a md(int paramInt)
  {
    AppMethodBeat.i(158668);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158668);
      return null;
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158668);
      return null;
    }
    localObject = new k(((h)localObject).qC());
    AppMethodBeat.o(158668);
    return localObject;
  }
  
  public final c me(int paramInt)
  {
    AppMethodBeat.i(158669);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(158669);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getJSONObject(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(158669);
      throw ((Throwable)localObject);
    }
    localObject = new l(((h)localObject).qH());
    AppMethodBeat.o(158669);
    return localObject;
  }
  
  public final c mf(int paramInt)
  {
    AppMethodBeat.i(158670);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158670);
      return null;
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158670);
      return null;
    }
    localObject = new l(((h)localObject).qH());
    AppMethodBeat.o(158670);
    return localObject;
  }
  
  public final a oY(long paramLong)
  {
    AppMethodBeat.i(158641);
    this.ggx.t(paramLong);
    AppMethodBeat.o(158641);
    return this;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(158650);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158650);
      return null;
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158650);
      return null;
    }
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(158650);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).qD();
      AppMethodBeat.o(158650);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).qC());
      AppMethodBeat.o(158650);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).qH());
      AppMethodBeat.o(158650);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).rf();
      AppMethodBeat.o(158650);
      return localObject;
    }
    AppMethodBeat.o(158650);
    return null;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(158653);
    boolean bool = optBoolean(paramInt, false);
    AppMethodBeat.o(158653);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158654);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158654);
      return paramBoolean;
    }
    Object localObject = this.ggx.dD(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158654);
      return paramBoolean;
    }
    if (((h)localObject).isBoolean())
    {
      paramBoolean = ((h)localObject).qD();
      AppMethodBeat.o(158654);
      return paramBoolean;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).rf();
      if ("true".equals(localObject))
      {
        AppMethodBeat.o(158654);
        return true;
      }
      if ("false".equals(localObject))
      {
        AppMethodBeat.o(158654);
        return false;
      }
    }
    AppMethodBeat.o(158654);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(158656);
    double d = optDouble(paramInt, 0.0D);
    AppMethodBeat.o(158656);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158657);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158657);
      return paramDouble;
    }
    h localh = this.ggx.dD(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(158657);
      return paramDouble;
    }
    try
    {
      double d;
      if (localh.isNumber())
      {
        d = localh.qG();
        AppMethodBeat.o(158657);
        return d;
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.rf());
        AppMethodBeat.o(158657);
        return d;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(158657);
    }
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(158659);
    paramInt = optInt(paramInt, 0);
    AppMethodBeat.o(158659);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158660);
    int i = length();
    if ((paramInt1 < 0) || (paramInt1 >= i))
    {
      AppMethodBeat.o(158660);
      return paramInt2;
    }
    h localh = this.ggx.dD(paramInt1);
    if (localh == null)
    {
      AppMethodBeat.o(158660);
      return paramInt2;
    }
    try
    {
      boolean bool = localh.isNumber();
      double d;
      if (bool) {
        try
        {
          paramInt1 = localh.qE();
          AppMethodBeat.o(158660);
          return paramInt1;
        }
        catch (Exception localException2)
        {
          d = localh.qG();
          paramInt1 = (int)d;
          AppMethodBeat.o(158660);
          return paramInt1;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.rf());
        paramInt1 = (int)d;
        AppMethodBeat.o(158660);
        return paramInt1;
      }
    }
    catch (Exception localException1)
    {
      AppMethodBeat.o(158660);
    }
    return paramInt2;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(158662);
    long l = optLong(paramInt, 0L);
    AppMethodBeat.o(158662);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158663);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158663);
      return paramLong;
    }
    h localh = this.ggx.dD(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(158663);
      return paramLong;
    }
    try
    {
      boolean bool = localh.isNumber();
      double d;
      if (bool) {
        try
        {
          long l = localh.qF();
          AppMethodBeat.o(158663);
          return l;
        }
        catch (Exception localException2)
        {
          d = localh.qG();
          paramLong = d;
          AppMethodBeat.o(158663);
          return paramLong;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.rf());
        paramLong = d;
        AppMethodBeat.o(158663);
        return paramLong;
      }
    }
    catch (Exception localException1)
    {
      AppMethodBeat.o(158663);
    }
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(158665);
    String str = optString(paramInt, null);
    AppMethodBeat.o(158665);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(158666);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158666);
      return paramString;
    }
    h localh = this.ggx.dD(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(158666);
      return paramString;
    }
    if (localh.isString())
    {
      paramString = localh.rf();
      AppMethodBeat.o(158666);
      return paramString;
    }
    paramString = localh.toString();
    AppMethodBeat.o(158666);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(158651);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(158651);
      return null;
    }
    Object localObject = this.ggx;
    ((b)localObject).aGG.remove(paramInt);
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(158651);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).qD();
      AppMethodBeat.o(158651);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).qC());
      AppMethodBeat.o(158651);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).qH());
      AppMethodBeat.o(158651);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).rf();
      AppMethodBeat.o(158651);
      return localObject;
    }
    AppMethodBeat.o(158651);
    return null;
  }
  
  public final a t(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158646);
    try
    {
      this.ggx.f(paramInt, paramLong);
      AppMethodBeat.o(158646);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(158646);
      throw localg;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158671);
    String str = this.ggx.toString();
    AppMethodBeat.o(158671);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(158672);
    try
    {
      String str = this.ggx.a(com.eclipsesource.a.k.dE(paramInt));
      AppMethodBeat.o(158672);
      return str;
    }
    catch (Throwable localThrowable)
    {
      g localg = new g(localThrowable);
      AppMethodBeat.o(158672);
      throw localg;
    }
  }
  
  public final a y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158643);
    try
    {
      this.ggx.l(paramInt, paramBoolean);
      AppMethodBeat.o(158643);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(158643);
      throw localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.k
 * JD-Core Version:    0.7.0.1
 */