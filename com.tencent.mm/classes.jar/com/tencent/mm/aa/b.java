package com.tencent.mm.aa;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements a
{
  private JSONArray eGD;
  
  public b()
  {
    AppMethodBeat.i(117484);
    this.eGD = new JSONArray();
    AppMethodBeat.o(117484);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(117485);
    try
    {
      this.eGD = new JSONArray(paramString);
      AppMethodBeat.o(117485);
      return;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117485);
      throw paramString;
    }
  }
  
  b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(117486);
    Assert.assertNotNull(paramJSONArray);
    this.eGD = paramJSONArray;
    AppMethodBeat.o(117486);
  }
  
  public final a ak(Object paramObject)
  {
    AppMethodBeat.i(117492);
    this.eGD.put(paramObject);
    AppMethodBeat.o(117492);
    return this;
  }
  
  public final a cg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117495);
    try
    {
      this.eGD.put(paramInt1, paramInt2);
      AppMethodBeat.o(117495);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117495);
      throw localg;
    }
  }
  
  public final a cs(boolean paramBoolean)
  {
    AppMethodBeat.i(117488);
    this.eGD.put(paramBoolean);
    AppMethodBeat.o(117488);
    return this;
  }
  
  public final a d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117494);
    try
    {
      this.eGD.put(paramInt, paramDouble);
      AppMethodBeat.o(117494);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117494);
      throw localg;
    }
  }
  
  public final a e(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(117497);
    try
    {
      this.eGD.put(paramInt, paramObject);
      AppMethodBeat.o(117497);
      return this;
    }
    catch (JSONException paramObject)
    {
      paramObject = new g(paramObject);
      AppMethodBeat.o(117497);
      throw paramObject;
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(117499);
    try
    {
      Object localObject = this.eGD.get(paramInt);
      if ((localObject instanceof JSONObject))
      {
        localObject = new d((JSONObject)localObject);
        AppMethodBeat.o(117499);
        return localObject;
      }
      if ((localObject instanceof JSONArray))
      {
        localObject = new b((JSONArray)localObject);
        AppMethodBeat.o(117499);
        return localObject;
      }
      AppMethodBeat.o(117499);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117499);
      throw localg;
    }
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(117502);
    try
    {
      boolean bool = this.eGD.getBoolean(paramInt);
      AppMethodBeat.o(117502);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117502);
      throw localg;
    }
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(117505);
    try
    {
      double d = this.eGD.getDouble(paramInt);
      AppMethodBeat.o(117505);
      return d;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117505);
      throw localg;
    }
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(117508);
    try
    {
      paramInt = this.eGD.getInt(paramInt);
      AppMethodBeat.o(117508);
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117508);
      throw localg;
    }
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(117511);
    try
    {
      long l = this.eGD.getLong(paramInt);
      AppMethodBeat.o(117511);
      return l;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117511);
      throw localg;
    }
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(117514);
    try
    {
      String str = this.eGD.getString(paramInt);
      AppMethodBeat.o(117514);
      return str;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117514);
      throw localg;
    }
  }
  
  public final a gg(long paramLong)
  {
    AppMethodBeat.i(117491);
    this.eGD.put(paramLong);
    AppMethodBeat.o(117491);
    return this;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(117498);
    boolean bool = this.eGD.isNull(paramInt);
    AppMethodBeat.o(117498);
    return bool;
  }
  
  public final a jA(int paramInt)
  {
    AppMethodBeat.i(117517);
    try
    {
      Object localObject = this.eGD.getJSONArray(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(117517);
        return null;
      }
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(117517);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117517);
      throw localg;
    }
  }
  
  public final a jB(int paramInt)
  {
    AppMethodBeat.i(117518);
    Object localObject = this.eGD.optJSONArray(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117518);
      return null;
    }
    localObject = new b((JSONArray)localObject);
    AppMethodBeat.o(117518);
    return localObject;
  }
  
  public final c jC(int paramInt)
  {
    AppMethodBeat.i(117519);
    try
    {
      Object localObject = this.eGD.getJSONObject(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(117519);
        return null;
      }
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(117519);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117519);
      throw localg;
    }
  }
  
  public final c jD(int paramInt)
  {
    AppMethodBeat.i(117520);
    Object localObject = this.eGD.optJSONObject(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(117520);
      return null;
    }
    localObject = new d((JSONObject)localObject);
    AppMethodBeat.o(117520);
    return localObject;
  }
  
  public final a jz(int paramInt)
  {
    AppMethodBeat.i(117490);
    this.eGD.put(paramInt);
    AppMethodBeat.o(117490);
    return this;
  }
  
  public final int length()
  {
    AppMethodBeat.i(117487);
    int i = this.eGD.length();
    AppMethodBeat.o(117487);
    return i;
  }
  
  public final a n(double paramDouble)
  {
    AppMethodBeat.i(117489);
    try
    {
      this.eGD.put(paramDouble);
      AppMethodBeat.o(117489);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117489);
      throw localg;
    }
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(117500);
    Object localObject = this.eGD.opt(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(117500);
      return localObject;
    }
    if ((localObject instanceof JSONArray))
    {
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(117500);
      return localObject;
    }
    AppMethodBeat.o(117500);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(117503);
    boolean bool = this.eGD.optBoolean(paramInt);
    AppMethodBeat.o(117503);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117504);
    paramBoolean = this.eGD.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(117504);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(117506);
    double d = this.eGD.optDouble(paramInt);
    AppMethodBeat.o(117506);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117507);
    paramDouble = this.eGD.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(117507);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(117509);
    paramInt = this.eGD.optInt(paramInt);
    AppMethodBeat.o(117509);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117510);
    paramInt1 = this.eGD.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(117510);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(117512);
    long l = this.eGD.optLong(paramInt);
    AppMethodBeat.o(117512);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117513);
    paramLong = this.eGD.optLong(paramInt, paramLong);
    AppMethodBeat.o(117513);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(117515);
    String str = this.eGD.optString(paramInt);
    AppMethodBeat.o(117515);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(117516);
    paramString = this.eGD.optString(paramInt, paramString);
    AppMethodBeat.o(117516);
    return paramString;
  }
  
  @TargetApi(19)
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(117501);
    Object localObject = this.eGD.remove(paramInt);
    if ((localObject instanceof JSONObject))
    {
      localObject = new d((JSONObject)localObject);
      AppMethodBeat.o(117501);
      return localObject;
    }
    if ((localObject instanceof JSONArray))
    {
      localObject = new b((JSONArray)localObject);
      AppMethodBeat.o(117501);
      return localObject;
    }
    AppMethodBeat.o(117501);
    return localObject;
  }
  
  public final a s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117496);
    try
    {
      this.eGD.put(paramInt, paramLong);
      AppMethodBeat.o(117496);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117496);
      throw localg;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117521);
    String str = this.eGD.toString();
    AppMethodBeat.o(117521);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(117522);
    try
    {
      String str = this.eGD.toString(paramInt);
      AppMethodBeat.o(117522);
      return str;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117522);
      throw localg;
    }
  }
  
  public final a z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117493);
    try
    {
      this.eGD.put(paramInt, paramBoolean);
      AppMethodBeat.o(117493);
      return this;
    }
    catch (JSONException localJSONException)
    {
      g localg = new g(localJSONException);
      AppMethodBeat.o(117493);
      throw localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aa.b
 * JD-Core Version:    0.7.0.1
 */