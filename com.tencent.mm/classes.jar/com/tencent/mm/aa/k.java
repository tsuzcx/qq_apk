package com.tencent.mm.aa;

import com.eclipsesource.a.b;
import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import junit.framework.Assert;

public final class k
  implements a
{
  private b eGK;
  
  public k()
  {
    AppMethodBeat.i(117694);
    this.eGK = new b();
    AppMethodBeat.o(117694);
  }
  
  k(b paramb)
  {
    AppMethodBeat.i(117696);
    Assert.assertNotNull(paramb);
    this.eGK = paramb;
    AppMethodBeat.o(117696);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(117695);
    this.eGK = com.eclipsesource.a.a.aa(paramString).lH();
    if (this.eGK == null)
    {
      paramString = new g(String.format("JSONArray string(%s) parse error.", new Object[] { paramString }));
      AppMethodBeat.o(117695);
      throw paramString;
    }
    AppMethodBeat.o(117695);
  }
  
  public final a ak(Object paramObject)
  {
    AppMethodBeat.i(117702);
    j.a(this.eGK, paramObject);
    AppMethodBeat.o(117702);
    return this;
  }
  
  public final a cg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117705);
    try
    {
      this.eGK.aQ(paramInt1, paramInt2);
      AppMethodBeat.o(117705);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(117705);
      throw localg;
    }
  }
  
  public final a cs(boolean paramBoolean)
  {
    AppMethodBeat.i(117698);
    this.eGK.aA(paramBoolean);
    AppMethodBeat.o(117698);
    return this;
  }
  
  public final a d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117704);
    try
    {
      this.eGK.b(paramInt, paramDouble);
      AppMethodBeat.o(117704);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(117704);
      throw localg;
    }
  }
  
  public final a e(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(117707);
    for (;;)
    {
      b localb;
      try
      {
        localb = this.eGK;
        if ((paramObject instanceof c))
        {
          localb.a(paramInt, j.a((c)paramObject));
          AppMethodBeat.o(117707);
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
        AppMethodBeat.o(117707);
        throw paramObject;
      }
      localb.aQ(paramInt, ((Integer)paramObject).intValue());
      continue;
      label104:
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        localb.atP.set(paramInt, com.eclipsesource.a.a.Z(paramObject));
      }
      else if ((paramObject instanceof Boolean))
      {
        localb.m(paramInt, ((Boolean)paramObject).booleanValue());
      }
      else if ((paramObject instanceof Long))
      {
        localb.f(paramInt, ((Long)paramObject).longValue());
      }
      else if ((paramObject instanceof Float))
      {
        float f = ((Float)paramObject).floatValue();
        localb.atP.set(paramInt, com.eclipsesource.a.a.S(f));
      }
      else if ((paramObject instanceof Integer))
      {
        localb.aQ(paramInt, ((Integer)paramObject).intValue());
      }
      else if ((paramObject instanceof Double))
      {
        localb.b(paramInt, ((Double)paramObject).doubleValue());
      }
      else if ((paramObject instanceof h))
      {
        localb.a(paramInt, (h)paramObject);
      }
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(117709);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117709);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117709);
      return null;
    }
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(117709);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).lI();
      AppMethodBeat.o(117709);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).lH());
      AppMethodBeat.o(117709);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).lM());
      AppMethodBeat.o(117709);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).mk();
      AppMethodBeat.o(117709);
      return localObject;
    }
    AppMethodBeat.o(117709);
    return null;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(117712);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117712);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getBoolean(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117712);
      throw ((Throwable)localObject);
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).lI();
      AppMethodBeat.o(117712);
      return bool;
    }
    if (((h)localObject).isString())
    {
      String str = ((h)localObject).mk();
      if ("true".equals(str))
      {
        AppMethodBeat.o(117712);
        return true;
      }
      if ("false".equals(str))
      {
        AppMethodBeat.o(117712);
        return false;
      }
    }
    localObject = new g(String.format("getBoolean(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
    AppMethodBeat.o(117712);
    throw ((Throwable)localObject);
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(117715);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117715);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getDouble(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117715);
      throw ((Throwable)localObject);
    }
    try
    {
      double d;
      if (((h)localObject).isNumber())
      {
        d = ((h)localObject).lL();
        AppMethodBeat.o(117715);
        return d;
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).mk());
        AppMethodBeat.o(117715);
        return d;
      }
    }
    catch (Exception localException)
    {
      localObject = new g(String.format("getDouble(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(117715);
      throw ((Throwable)localObject);
    }
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(117718);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117718);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getInteger(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117718);
      throw ((Throwable)localObject);
    }
    try
    {
      boolean bool = ((h)localObject).isNumber();
      double d;
      if (bool) {
        try
        {
          i = ((h)localObject).lJ();
          AppMethodBeat.o(117718);
          return i;
        }
        catch (Exception localException1)
        {
          d = ((h)localObject).lL();
          paramInt = (int)d;
          AppMethodBeat.o(117718);
          return paramInt;
        }
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).mk());
        paramInt = (int)d;
        AppMethodBeat.o(117718);
        return paramInt;
      }
    }
    catch (Exception localException2)
    {
      localObject = new g(String.format("getInt(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(117718);
      throw ((Throwable)localObject);
    }
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(117721);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117721);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getLong(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117721);
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
          l = ((h)localObject).lK();
          AppMethodBeat.o(117721);
          return l;
        }
        catch (Exception localException1)
        {
          d = ((h)localObject).lL();
          l = d;
          AppMethodBeat.o(117721);
          return l;
        }
      }
      if (((h)localObject).isString())
      {
        d = Double.parseDouble(((h)localObject).mk());
        l = d;
        AppMethodBeat.o(117721);
        return l;
      }
    }
    catch (Exception localException2)
    {
      localObject = new g(String.format("getLong(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localObject }));
      AppMethodBeat.o(117721);
      throw ((Throwable)localObject);
    }
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(117724);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117724);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getString(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117724);
      throw ((Throwable)localObject);
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).mk();
      AppMethodBeat.o(117724);
      return localObject;
    }
    localObject = ((h)localObject).toString();
    AppMethodBeat.o(117724);
    return localObject;
  }
  
  public final a gg(long paramLong)
  {
    AppMethodBeat.i(117701);
    this.eGK.m(paramLong);
    AppMethodBeat.o(117701);
    return this;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(117708);
    if ((paramInt < 0) || (paramInt >= length()) || (this.eGK.cT(paramInt) == null))
    {
      AppMethodBeat.o(117708);
      return true;
    }
    AppMethodBeat.o(117708);
    return false;
  }
  
  public final a jA(int paramInt)
  {
    AppMethodBeat.i(117727);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117727);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getJSONArray(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117727);
      throw ((Throwable)localObject);
    }
    localObject = new k(((h)localObject).lH());
    AppMethodBeat.o(117727);
    return localObject;
  }
  
  public final a jB(int paramInt)
  {
    AppMethodBeat.i(117728);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117728);
      return null;
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117728);
      return null;
    }
    localObject = new k(((h)localObject).lH());
    AppMethodBeat.o(117728);
    return localObject;
  }
  
  public final c jC(int paramInt)
  {
    AppMethodBeat.i(117729);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      localObject = new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      AppMethodBeat.o(117729);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      localObject = new g(String.format("getJSONObject(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(117729);
      throw ((Throwable)localObject);
    }
    localObject = new l(((h)localObject).lM());
    AppMethodBeat.o(117729);
    return localObject;
  }
  
  public final c jD(int paramInt)
  {
    AppMethodBeat.i(117730);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117730);
      return null;
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117730);
      return null;
    }
    localObject = new l(((h)localObject).lM());
    AppMethodBeat.o(117730);
    return localObject;
  }
  
  public final a jz(int paramInt)
  {
    AppMethodBeat.i(117700);
    this.eGK.cS(paramInt);
    AppMethodBeat.o(117700);
    return this;
  }
  
  public final int length()
  {
    AppMethodBeat.i(117697);
    int i = this.eGK.atP.size();
    AppMethodBeat.o(117697);
    return i;
  }
  
  public final a n(double paramDouble)
  {
    AppMethodBeat.i(117699);
    this.eGK.m(paramDouble);
    AppMethodBeat.o(117699);
    return this;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(117710);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117710);
      return null;
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117710);
      return null;
    }
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(117710);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).lI();
      AppMethodBeat.o(117710);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).lH());
      AppMethodBeat.o(117710);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).lM());
      AppMethodBeat.o(117710);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).mk();
      AppMethodBeat.o(117710);
      return localObject;
    }
    AppMethodBeat.o(117710);
    return null;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(117713);
    boolean bool = optBoolean(paramInt, false);
    AppMethodBeat.o(117713);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117714);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117714);
      return paramBoolean;
    }
    Object localObject = this.eGK.cT(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117714);
      return paramBoolean;
    }
    if (((h)localObject).isBoolean())
    {
      paramBoolean = ((h)localObject).lI();
      AppMethodBeat.o(117714);
      return paramBoolean;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).mk();
      if ("true".equals(localObject))
      {
        AppMethodBeat.o(117714);
        return true;
      }
      if ("false".equals(localObject))
      {
        AppMethodBeat.o(117714);
        return false;
      }
    }
    AppMethodBeat.o(117714);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(117716);
    double d = optDouble(paramInt, 0.0D);
    AppMethodBeat.o(117716);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117717);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117717);
      return paramDouble;
    }
    h localh = this.eGK.cT(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(117717);
      return paramDouble;
    }
    try
    {
      double d;
      if (localh.isNumber())
      {
        d = localh.lL();
        AppMethodBeat.o(117717);
        return d;
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.mk());
        AppMethodBeat.o(117717);
        return d;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(117717);
    }
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(117719);
    paramInt = optInt(paramInt, 0);
    AppMethodBeat.o(117719);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117720);
    int i = length();
    if ((paramInt1 < 0) || (paramInt1 >= i))
    {
      AppMethodBeat.o(117720);
      return paramInt2;
    }
    h localh = this.eGK.cT(paramInt1);
    if (localh == null)
    {
      AppMethodBeat.o(117720);
      return paramInt2;
    }
    try
    {
      boolean bool = localh.isNumber();
      double d;
      if (bool) {
        try
        {
          paramInt1 = localh.lJ();
          AppMethodBeat.o(117720);
          return paramInt1;
        }
        catch (Exception localException2)
        {
          d = localh.lL();
          paramInt1 = (int)d;
          AppMethodBeat.o(117720);
          return paramInt1;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.mk());
        paramInt1 = (int)d;
        AppMethodBeat.o(117720);
        return paramInt1;
      }
    }
    catch (Exception localException1)
    {
      AppMethodBeat.o(117720);
    }
    return paramInt2;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(117722);
    long l = optLong(paramInt, 0L);
    AppMethodBeat.o(117722);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117723);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117723);
      return paramLong;
    }
    h localh = this.eGK.cT(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(117723);
      return paramLong;
    }
    try
    {
      boolean bool = localh.isNumber();
      double d;
      if (bool) {
        try
        {
          long l = localh.lK();
          AppMethodBeat.o(117723);
          return l;
        }
        catch (Exception localException2)
        {
          d = localh.lL();
          paramLong = d;
          AppMethodBeat.o(117723);
          return paramLong;
        }
      }
      if (localh.isString())
      {
        d = Double.parseDouble(localh.mk());
        paramLong = d;
        AppMethodBeat.o(117723);
        return paramLong;
      }
    }
    catch (Exception localException1)
    {
      AppMethodBeat.o(117723);
    }
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(117725);
    String str = optString(paramInt, null);
    AppMethodBeat.o(117725);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(117726);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117726);
      return paramString;
    }
    h localh = this.eGK.cT(paramInt);
    if (localh == null)
    {
      AppMethodBeat.o(117726);
      return paramString;
    }
    if (localh.isString())
    {
      paramString = localh.mk();
      AppMethodBeat.o(117726);
      return paramString;
    }
    paramString = localh.toString();
    AppMethodBeat.o(117726);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(117711);
    int i = length();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(117711);
      return null;
    }
    Object localObject = this.eGK;
    ((b)localObject).atP.remove(paramInt);
    if (((h)localObject).isNumber())
    {
      localObject = ((h)localObject).toString();
      AppMethodBeat.o(117711);
      return localObject;
    }
    if (((h)localObject).isBoolean())
    {
      boolean bool = ((h)localObject).lI();
      AppMethodBeat.o(117711);
      return Boolean.valueOf(bool);
    }
    if (((h)localObject).isArray())
    {
      localObject = new k(((h)localObject).lH());
      AppMethodBeat.o(117711);
      return localObject;
    }
    if (((h)localObject).isObject())
    {
      localObject = new l(((h)localObject).lM());
      AppMethodBeat.o(117711);
      return localObject;
    }
    if (((h)localObject).isString())
    {
      localObject = ((h)localObject).mk();
      AppMethodBeat.o(117711);
      return localObject;
    }
    AppMethodBeat.o(117711);
    return null;
  }
  
  public final a s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117706);
    try
    {
      this.eGK.f(paramInt, paramLong);
      AppMethodBeat.o(117706);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(117706);
      throw localg;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117731);
    String str = this.eGK.toString();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(117732);
    try
    {
      String str = this.eGK.a(com.eclipsesource.a.k.cU(paramInt));
      AppMethodBeat.o(117732);
      return str;
    }
    catch (Throwable localThrowable)
    {
      g localg = new g(localThrowable);
      AppMethodBeat.o(117732);
      throw localg;
    }
  }
  
  public final a z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117703);
    try
    {
      this.eGK.m(paramInt, paramBoolean);
      AppMethodBeat.o(117703);
      return this;
    }
    catch (Exception localException)
    {
      g localg = new g(localException);
      AppMethodBeat.o(117703);
      throw localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.k
 * JD-Core Version:    0.7.0.1
 */