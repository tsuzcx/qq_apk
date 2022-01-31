package com.tencent.mm.ab;

import java.util.Iterator;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements c
{
  private JSONObject dJg;
  
  public d()
  {
    this.dJg = new JSONObject();
  }
  
  public d(String paramString)
  {
    try
    {
      this.dJg = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  d(JSONObject paramJSONObject)
  {
    Assert.assertNotNull(paramJSONObject);
    this.dJg = paramJSONObject;
  }
  
  public final c E(String paramString, int paramInt)
  {
    try
    {
      this.dJg.put(paramString, paramInt);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final c b(String paramString, double paramDouble)
  {
    try
    {
      this.dJg.put(paramString, paramDouble);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final c c(String paramString, Object paramObject)
  {
    try
    {
      this.dJg.put(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final c e(String paramString, Object paramObject)
  {
    try
    {
      this.dJg.put(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
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
    try
    {
      paramString = this.dJg.getJSONArray(paramString);
      if (paramString == null) {
        return null;
      }
      paramString = new b(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final a fR(String paramString)
  {
    paramString = this.dJg.optJSONArray(paramString);
    if (paramString == null) {
      return null;
    }
    return new b(paramString);
  }
  
  public final c fS(String paramString)
  {
    try
    {
      paramString = this.dJg.getJSONObject(paramString);
      if (paramString == null) {
        return null;
      }
      paramString = new d(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final c fT(String paramString)
  {
    paramString = this.dJg.optJSONObject(paramString);
    if (paramString == null) {
      return null;
    }
    return new d(paramString);
  }
  
  public final Object get(String paramString)
  {
    try
    {
      paramString = this.dJg.get(paramString);
      if ((paramString instanceof JSONObject)) {
        return new d((JSONObject)paramString);
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        return paramString;
      }
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
    return paramString;
  }
  
  public final boolean getBoolean(String paramString)
  {
    try
    {
      boolean bool = this.dJg.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final double getDouble(String paramString)
  {
    try
    {
      double d = this.dJg.getDouble(paramString);
      return d;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final int getInt(String paramString)
  {
    try
    {
      int i = this.dJg.getInt(paramString);
      return i;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final long getLong(String paramString)
  {
    try
    {
      long l = this.dJg.getLong(paramString);
      return l;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final String getString(String paramString)
  {
    try
    {
      paramString = this.dJg.getString(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final boolean has(String paramString)
  {
    return this.dJg.has(paramString);
  }
  
  public final boolean isNull(String paramString)
  {
    return this.dJg.isNull(paramString);
  }
  
  public final c j(String paramString, long paramLong)
  {
    try
    {
      this.dJg.put(paramString, paramLong);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final Iterator<String> keys()
  {
    return this.dJg.keys();
  }
  
  public final int length()
  {
    return this.dJg.length();
  }
  
  public final Object opt(String paramString)
  {
    try
    {
      Object localObject = this.dJg.get(paramString);
      if ((localObject instanceof JSONObject)) {
        return new d((JSONObject)localObject);
      }
      paramString = localObject;
      if ((localObject instanceof JSONArray))
      {
        paramString = new b((JSONArray)localObject);
        return paramString;
      }
    }
    catch (JSONException paramString)
    {
      paramString = null;
    }
    return paramString;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    return this.dJg.optBoolean(paramString, paramBoolean);
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    return this.dJg.optDouble(paramString, paramDouble);
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    return this.dJg.optInt(paramString, paramInt);
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    return this.dJg.optLong(paramString, paramLong);
  }
  
  public final String optString(String paramString)
  {
    return this.dJg.optString(paramString);
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    return this.dJg.optString(paramString1, paramString2);
  }
  
  public final c p(String paramString, boolean paramBoolean)
  {
    try
    {
      this.dJg.put(paramString, paramBoolean);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public final Object remove(String paramString)
  {
    return this.dJg.remove(paramString);
  }
  
  public final String toString()
  {
    return this.dJg.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.d
 * JD-Core Version:    0.7.0.1
 */