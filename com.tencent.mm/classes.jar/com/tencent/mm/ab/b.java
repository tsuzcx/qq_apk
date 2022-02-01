package com.tencent.mm.ab;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements a
{
  private JSONArray hpw;
  
  public b()
  {
    AppMethodBeat.i(158424);
    this.hpw = new JSONArray();
    AppMethodBeat.o(158424);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(158425);
    try
    {
      this.hpw = new JSONArray(paramString);
      AppMethodBeat.o(158425);
      return;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158425);
      throw paramString;
    }
  }
  
  b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(158426);
    Assert.assertNotNull(paramJSONArray);
    this.hpw = paramJSONArray;
    AppMethodBeat.o(158426);
  }
  
  public final a C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158433);
    try
    {
      this.hpw.put(paramInt, paramBoolean);
      AppMethodBeat.o(158433);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158433);
      throw localg;
    }
  }
  
  public final a bu(Object paramObject)
  {
    AppMethodBeat.i(158432);
    this.hpw.put(paramObject);
    AppMethodBeat.o(158432);
    return this;
  }
  
  public final a c(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158434);
    try
    {
      this.hpw.put(paramInt, paramDouble);
      AppMethodBeat.o(158434);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158434);
      throw localg;
    }
  }
  
  public final a cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158435);
    try
    {
      this.hpw.put(paramInt1, paramInt2);
      AppMethodBeat.o(158435);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158435);
      throw localg;
    }
  }
  
  public final a ep(boolean paramBoolean)
  {
    AppMethodBeat.i(158428);
    this.hpw.put(paramBoolean);
    AppMethodBeat.o(158428);
    return this;
  }
  
  public final a g(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158437);
    try
    {
      this.hpw.put(paramInt, paramObject);
      AppMethodBeat.o(158437);
      return this;
    }
    catch (JSONException paramObject)
    {
      paramObject = new g(paramObject);
      AppMethodBeat.o(158437);
      throw paramObject;
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(158439);
    try
    {
      Object localObject = this.hpw.get(paramInt);
      if ((localObject instanceof JSONObject))
      {
        localObject = new d((JSONObject)localObject);
        AppMethodBeat.o(158439);
        return localObject;
      }
      if ((localObject instanceof JSONArray))
      {
        localObject = new b((JSONArray)localObject);
        AppMethodBeat.o(158439);
        return localObject;
      }
      AppMethodBeat.o(158439);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158439);
      throw localg;
    }
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(158442);
    try
    {
      boolean bool = this.hpw.getBoolean(paramInt);
      AppMethodBeat.o(158442);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158442);
      throw localg;
    }
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(158445);
    try
    {
      double d = this.hpw.getDouble(paramInt);
      AppMethodBeat.o(158445);
      return d;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158445);
      throw localg;
    }
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(158448);
    try
    {
      paramInt = this.hpw.getInt(paramInt);
      AppMethodBeat.o(158448);
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158448);
      throw localg;
    }
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(158451);
    try
    {
      long l = this.hpw.getLong(paramInt);
      AppMethodBeat.o(158451);
      return l;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158451);
      throw localg;
    }
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(158454);
    try
    {
      String str = this.hpw.getString(paramInt);
      AppMethodBeat.o(158454);
      return str;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158454);
      throw localg;
    }
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(158438);
    boolean bool = this.hpw.isNull(paramInt);
    AppMethodBeat.o(158438);
    return bool;
  }
  
  public final a k(double paramDouble)
  {
    AppMethodBeat.i(158429);
    try
    {
      this.hpw.put(paramDouble);
      AppMethodBeat.o(158429);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158429);
      throw localg;
    }
  }
  
  public final int length()
  {
    AppMethodBeat.i(158427);
    int i = this.hpw.length();
    AppMethodBeat.o(158427);
    return i;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(158440);
    Object localObject = this.hpw.opt(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(158440);
      return localObject;
    }
    if ((localObject instanceof JSONArray))
    {
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(158440);
      return localObject;
    }
    AppMethodBeat.o(158440);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(158443);
    boolean bool = this.hpw.optBoolean(paramInt);
    AppMethodBeat.o(158443);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158444);
    paramBoolean = this.hpw.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(158444);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(158446);
    double d = this.hpw.optDouble(paramInt);
    AppMethodBeat.o(158446);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158447);
    paramDouble = this.hpw.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(158447);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(158449);
    paramInt = this.hpw.optInt(paramInt);
    AppMethodBeat.o(158449);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158450);
    paramInt1 = this.hpw.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(158450);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(158452);
    long l = this.hpw.optLong(paramInt);
    AppMethodBeat.o(158452);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158453);
    paramLong = this.hpw.optLong(paramInt, paramLong);
    AppMethodBeat.o(158453);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(158455);
    String str = this.hpw.optString(paramInt);
    AppMethodBeat.o(158455);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(158456);
    paramString = this.hpw.optString(paramInt, paramString);
    AppMethodBeat.o(158456);
    return paramString;
  }
  
  public final a pQ(int paramInt)
  {
    AppMethodBeat.i(158430);
    this.hpw.put(paramInt);
    AppMethodBeat.o(158430);
    return this;
  }
  
  public final a pR(int paramInt)
  {
    AppMethodBeat.i(158457);
    try
    {
      Object localObject = this.hpw.getJSONArray(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(158457);
        return null;
      }
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(158457);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158457);
      throw localg;
    }
  }
  
  public final a pS(int paramInt)
  {
    AppMethodBeat.i(158458);
    Object localObject = this.hpw.optJSONArray(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158458);
      return null;
    }
    localObject = new b((JSONArray)localObject);
    AppMethodBeat.o(158458);
    return localObject;
  }
  
  public final c pT(int paramInt)
  {
    AppMethodBeat.i(158459);
    try
    {
      Object localObject = this.hpw.getJSONObject(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(158459);
        return null;
      }
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(158459);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158459);
      throw localg;
    }
  }
  
  public final c pU(int paramInt)
  {
    AppMethodBeat.i(158460);
    Object localObject = this.hpw.optJSONObject(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(158460);
      return null;
    }
    localObject = new d((JSONObject)localObject);
    AppMethodBeat.o(158460);
    return localObject;
  }
  
  @TargetApi(19)
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(158441);
    Object localObject = this.hpw.remove(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(158441);
      return localObject;
    }
    if ((localObject instanceof JSONArray))
    {
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(158441);
      return localObject;
    }
    AppMethodBeat.o(158441);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158461);
    String str = this.hpw.toString();
    AppMethodBeat.o(158461);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(158462);
    try
    {
      String str = this.hpw.toString(paramInt);
      AppMethodBeat.o(158462);
      return str;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158462);
      throw localg;
    }
  }
  
  public final a v(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158436);
    try
    {
      this.hpw.put(paramInt, paramLong);
      AppMethodBeat.o(158436);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(158436);
      throw localg;
    }
  }
  
  public final a zp(long paramLong)
  {
    AppMethodBeat.i(158431);
    this.hpw.put(paramLong);
    AppMethodBeat.o(158431);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ab.b
 * JD-Core Version:    0.7.0.1
 */