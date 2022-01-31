package com.tencent.mm.ab;

import android.annotation.TargetApi;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements a
{
  private JSONArray dJf;
  
  public b()
  {
    this.dJf = new JSONArray();
  }
  
  public b(String paramString)
  {
    try
    {
      this.dJf = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  b(JSONArray paramJSONArray)
  {
    Assert.assertNotNull(paramJSONArray);
    this.dJf = paramJSONArray;
  }
  
  public final a ac(Object paramObject)
  {
    this.dJf.put(paramObject);
    return this;
  }
  
  public final a bC(boolean paramBoolean)
  {
    this.dJf.put(paramBoolean);
    return this;
  }
  
  public final a bw(long paramLong)
  {
    this.dJf.put(paramLong);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    try
    {
      Object localObject = this.dJf.get(paramInt);
      if ((localObject instanceof JSONObject)) {
        return new d((JSONObject)localObject);
      }
      if ((localObject instanceof JSONArray))
      {
        localObject = new b((JSONArray)localObject);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
    return localJSONException;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    try
    {
      boolean bool = this.dJf.getBoolean(paramInt);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final double getDouble(int paramInt)
  {
    try
    {
      double d = this.dJf.getDouble(paramInt);
      return d;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final int getInt(int paramInt)
  {
    try
    {
      paramInt = this.dJf.getInt(paramInt);
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final long getLong(int paramInt)
  {
    try
    {
      long l = this.dJf.getLong(paramInt);
      return l;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final String getString(int paramInt)
  {
    try
    {
      String str = this.dJf.getString(paramInt);
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final a hj(int paramInt)
  {
    this.dJf.put(paramInt);
    return this;
  }
  
  public final a hk(int paramInt)
  {
    try
    {
      Object localObject = this.dJf.getJSONArray(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new b((JSONArray)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final a hl(int paramInt)
  {
    JSONArray localJSONArray = this.dJf.optJSONArray(paramInt);
    if (localJSONArray == null) {
      return null;
    }
    return new b(localJSONArray);
  }
  
  public final c hm(int paramInt)
  {
    try
    {
      Object localObject = this.dJf.getJSONObject(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new d((JSONObject)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final c hn(int paramInt)
  {
    JSONObject localJSONObject = this.dJf.optJSONObject(paramInt);
    if (localJSONObject == null) {
      return null;
    }
    return new d(localJSONObject);
  }
  
  public final boolean isNull(int paramInt)
  {
    return this.dJf.isNull(paramInt);
  }
  
  public final int length()
  {
    return this.dJf.length();
  }
  
  public final a n(double paramDouble)
  {
    try
    {
      this.dJf.put(paramDouble);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public final Object opt(int paramInt)
  {
    Object localObject2 = this.dJf.opt(paramInt);
    Object localObject1;
    if ((localObject2 instanceof JSONObject)) {
      localObject1 = new d((JSONObject)localObject2);
    }
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!(localObject2 instanceof JSONArray));
    return new b((JSONArray)localObject2);
  }
  
  public final boolean optBoolean(int paramInt)
  {
    return this.dJf.optBoolean(paramInt);
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    return this.dJf.optBoolean(paramInt, paramBoolean);
  }
  
  public final double optDouble(int paramInt)
  {
    return this.dJf.optDouble(paramInt);
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    return this.dJf.optDouble(paramInt, paramDouble);
  }
  
  public final int optInt(int paramInt)
  {
    return this.dJf.optInt(paramInt);
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    return this.dJf.optInt(paramInt1, paramInt2);
  }
  
  public final long optLong(int paramInt)
  {
    return this.dJf.optLong(paramInt);
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    return this.dJf.optLong(paramInt, paramLong);
  }
  
  public final String optString(int paramInt)
  {
    return this.dJf.optString(paramInt);
  }
  
  public final String optString(int paramInt, String paramString)
  {
    return this.dJf.optString(paramInt, paramString);
  }
  
  @TargetApi(19)
  public final Object remove(int paramInt)
  {
    Object localObject2 = this.dJf.remove(paramInt);
    Object localObject1;
    if ((localObject2 instanceof JSONObject)) {
      localObject1 = new d((JSONObject)localObject2);
    }
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!(localObject2 instanceof JSONArray));
    return new b((JSONArray)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.b
 * JD-Core Version:    0.7.0.1
 */