package com.tencent.mm.ab;

import java.util.Iterator;
import junit.framework.Assert;
import org.json.JSONObject;

public final class i
  extends JSONObject
  implements c
{
  private final c dJl;
  
  public i()
  {
    this.dJl = h.CH();
  }
  
  public i(c paramc)
  {
    Assert.assertNotNull(paramc);
    this.dJl = paramc;
  }
  
  public i(String paramString)
  {
    this.dJl = h.fV(paramString);
  }
  
  private i F(String paramString, int paramInt)
  {
    this.dJl.E(fP(paramString), paramInt);
    return this;
  }
  
  private i c(String paramString, double paramDouble)
  {
    this.dJl.b(fP(paramString), paramDouble);
    return this;
  }
  
  private i f(String paramString, Object paramObject)
  {
    this.dJl.c(paramString, paramObject);
    return this;
  }
  
  private f fX(String paramString)
  {
    paramString = this.dJl.fQ(paramString);
    if (paramString == null) {
      return null;
    }
    return new f(paramString);
  }
  
  private f fY(String paramString)
  {
    paramString = this.dJl.fR(paramString);
    if (paramString == null) {
      return null;
    }
    return new f(paramString);
  }
  
  private i fZ(String paramString)
  {
    paramString = this.dJl.fS(paramString);
    if (paramString == null) {
      return null;
    }
    return new i(paramString);
  }
  
  private i g(String paramString, Object paramObject)
  {
    this.dJl.e(paramString, paramObject);
    return this;
  }
  
  private i ga(String paramString)
  {
    paramString = this.dJl.fT(paramString);
    if (paramString == null) {
      return null;
    }
    return new i(paramString);
  }
  
  private i k(String paramString, long paramLong)
  {
    this.dJl.j(fP(paramString), paramLong);
    return this;
  }
  
  private i q(String paramString, boolean paramBoolean)
  {
    this.dJl.p(paramString, paramBoolean);
    return this;
  }
  
  public final String fP(String paramString)
  {
    return this.dJl.fP(paramString);
  }
  
  public final Object get(String paramString)
  {
    return this.dJl.get(paramString);
  }
  
  public final boolean getBoolean(String paramString)
  {
    return this.dJl.getBoolean(paramString);
  }
  
  public final double getDouble(String paramString)
  {
    return this.dJl.getDouble(paramString);
  }
  
  public final int getInt(String paramString)
  {
    return this.dJl.getInt(paramString);
  }
  
  public final long getLong(String paramString)
  {
    return this.dJl.getLong(paramString);
  }
  
  public final String getString(String paramString)
  {
    return this.dJl.getString(paramString);
  }
  
  public final boolean has(String paramString)
  {
    return this.dJl.has(paramString);
  }
  
  public final boolean isNull(String paramString)
  {
    return this.dJl.isNull(paramString);
  }
  
  public final Iterator<String> keys()
  {
    return this.dJl.keys();
  }
  
  public final int length()
  {
    return this.dJl.length();
  }
  
  public final Object opt(String paramString)
  {
    return this.dJl.opt(paramString);
  }
  
  public final boolean optBoolean(String paramString)
  {
    return this.dJl.optBoolean(paramString, false);
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    return this.dJl.optBoolean(paramString, paramBoolean);
  }
  
  public final double optDouble(String paramString)
  {
    return this.dJl.optDouble(paramString, (0.0D / 0.0D));
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    return this.dJl.optDouble(paramString, paramDouble);
  }
  
  public final int optInt(String paramString)
  {
    return this.dJl.optInt(paramString, 0);
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    return this.dJl.optInt(paramString, paramInt);
  }
  
  public final long optLong(String paramString)
  {
    return this.dJl.optLong(paramString, 0L);
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    return this.dJl.optLong(paramString, paramLong);
  }
  
  public final String optString(String paramString)
  {
    return this.dJl.optString(paramString, "");
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    return this.dJl.optString(paramString1);
  }
  
  public final Object remove(String paramString)
  {
    return this.dJl.remove(paramString);
  }
  
  public final String toString()
  {
    return this.dJl.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ab.i
 * JD-Core Version:    0.7.0.1
 */