package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements c
{
  private JSONObject mBt;
  
  public d()
  {
    AppMethodBeat.i(158463);
    this.mBt = new JSONObject();
    AppMethodBeat.o(158463);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(158465);
    try
    {
      this.mBt = new JSONObject(paramString);
      AppMethodBeat.o(158465);
      return;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158465);
      throw paramString;
    }
  }
  
  public d(Map paramMap)
  {
    AppMethodBeat.i(158464);
    this.mBt = new JSONObject(paramMap);
    AppMethodBeat.o(158464);
  }
  
  d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(158466);
    Assert.assertNotNull(paramJSONObject);
    this.mBt = paramJSONObject;
    AppMethodBeat.o(158466);
  }
  
  public final String Fi(String paramString)
  {
    AppMethodBeat.i(158474);
    if (paramString == null)
    {
      paramString = new g("Names must be non-null");
      AppMethodBeat.o(158474);
      throw paramString;
    }
    AppMethodBeat.o(158474);
    return paramString;
  }
  
  public final a Fj(String paramString)
  {
    AppMethodBeat.i(158491);
    try
    {
      paramString = this.mBt.getJSONArray(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(158491);
        return null;
      }
      paramString = new b(paramString);
      AppMethodBeat.o(158491);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158491);
      throw paramString;
    }
  }
  
  public final a Fk(String paramString)
  {
    AppMethodBeat.i(158492);
    paramString = this.mBt.optJSONArray(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158492);
      return null;
    }
    paramString = new b(paramString);
    AppMethodBeat.o(158492);
    return paramString;
  }
  
  public final c Fl(String paramString)
  {
    AppMethodBeat.i(158493);
    try
    {
      paramString = this.mBt.getJSONObject(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(158493);
        return null;
      }
      paramString = new d(paramString);
      AppMethodBeat.o(158493);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158493);
      throw paramString;
    }
  }
  
  public final c Fm(String paramString)
  {
    AppMethodBeat.i(158494);
    paramString = this.mBt.optJSONObject(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158494);
      return null;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(158494);
    return paramString;
  }
  
  public final c at(String paramString, int paramInt)
  {
    AppMethodBeat.i(158470);
    try
    {
      this.mBt.put(paramString, paramInt);
      AppMethodBeat.o(158470);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158470);
      throw paramString;
    }
  }
  
  public final c c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158469);
    try
    {
      this.mBt.put(paramString, paramDouble);
      AppMethodBeat.o(158469);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158469);
      throw paramString;
    }
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(158478);
    try
    {
      paramString = this.mBt.get(paramString);
      if ((paramString instanceof JSONObject))
      {
        paramString = new d((JSONObject)paramString);
        AppMethodBeat.o(158478);
        return paramString;
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        AppMethodBeat.o(158478);
        return paramString;
      }
      AppMethodBeat.o(158478);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158478);
      throw paramString;
    }
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(158480);
    try
    {
      boolean bool = this.mBt.getBoolean(paramString);
      AppMethodBeat.o(158480);
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158480);
      throw paramString;
    }
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(158482);
    try
    {
      double d = this.mBt.getDouble(paramString);
      AppMethodBeat.o(158482);
      return d;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158482);
      throw paramString;
    }
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(158484);
    try
    {
      int i = this.mBt.getInt(paramString);
      AppMethodBeat.o(158484);
      return i;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158484);
      throw paramString;
    }
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(158486);
    try
    {
      long l = this.mBt.getLong(paramString);
      AppMethodBeat.o(158486);
      return l;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158486);
      throw paramString;
    }
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(158488);
    try
    {
      paramString = this.mBt.getString(paramString);
      AppMethodBeat.o(158488);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158488);
      throw paramString;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(158477);
    boolean bool = this.mBt.has(paramString);
    AppMethodBeat.o(158477);
    return bool;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(158476);
    boolean bool = this.mBt.isNull(paramString);
    AppMethodBeat.o(158476);
    return bool;
  }
  
  /* Error */
  public final c k(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 143
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: instanceof 2
    //   9: ifeq +26 -> 35
    //   12: aload_0
    //   13: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: aload_2
    //   18: checkcast 2	com/tencent/mm/ad/d
    //   21: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   24: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: ldc 143
    //   30: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: goto -17 -> 28
    //   48: astore_1
    //   49: new 36	com/tencent/mm/ad/g
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 39	com/tencent/mm/ad/g:<init>	(Ljava/lang/Throwable;)V
    //   57: astore_1
    //   58: ldc 143
    //   60: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	d
    //   0	65	1	paramString	String
    //   0	65	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	28	48	org/json/JSONException
    //   35	45	48	org/json/JSONException
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(158495);
    Iterator localIterator = this.mBt.keys();
    AppMethodBeat.o(158495);
    return localIterator;
  }
  
  /* Error */
  public final c l(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 155
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: instanceof 2
    //   9: ifeq +26 -> 35
    //   12: aload_0
    //   13: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: aload_2
    //   18: checkcast 2	com/tencent/mm/ad/d
    //   21: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   24: invokevirtual 158	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: ldc 155
    //   30: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: getfield 24	com/tencent/mm/ad/d:mBt	Lorg/json/JSONObject;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 158	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: goto -17 -> 28
    //   48: astore_1
    //   49: new 36	com/tencent/mm/ad/g
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 39	com/tencent/mm/ad/g:<init>	(Ljava/lang/Throwable;)V
    //   57: astore_1
    //   58: ldc 155
    //   60: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	d
    //   0	65	1	paramString	String
    //   0	65	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	28	48	org/json/JSONException
    //   35	45	48	org/json/JSONException
  }
  
  public final int length()
  {
    AppMethodBeat.i(158467);
    int i = this.mBt.length();
    AppMethodBeat.o(158467);
    return i;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(158479);
    try
    {
      paramString = this.mBt.get(paramString);
      if ((paramString instanceof JSONObject))
      {
        paramString = new d((JSONObject)paramString);
        AppMethodBeat.o(158479);
        return paramString;
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        AppMethodBeat.o(158479);
        return paramString;
      }
      AppMethodBeat.o(158479);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(158479);
    }
    return null;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158481);
    paramBoolean = this.mBt.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(158481);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(158483);
    paramDouble = this.mBt.optDouble(paramString, paramDouble);
    AppMethodBeat.o(158483);
    return paramDouble;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(158485);
    paramInt = this.mBt.optInt(paramString, paramInt);
    AppMethodBeat.o(158485);
    return paramInt;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(158487);
    paramLong = this.mBt.optLong(paramString, paramLong);
    AppMethodBeat.o(158487);
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(158489);
    paramString = this.mBt.optString(paramString);
    AppMethodBeat.o(158489);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158490);
    paramString1 = this.mBt.optString(paramString1, paramString2);
    AppMethodBeat.o(158490);
    return paramString1;
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(158475);
    paramString = this.mBt.remove(paramString);
    AppMethodBeat.o(158475);
    return paramString;
  }
  
  public final c s(String paramString, long paramLong)
  {
    AppMethodBeat.i(158471);
    try
    {
      this.mBt.put(paramString, paramLong);
      AppMethodBeat.o(158471);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158471);
      throw paramString;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158496);
    String str = this.mBt.toString();
    AppMethodBeat.o(158496);
    return str;
  }
  
  public final c z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(158468);
    try
    {
      this.mBt.put(paramString, paramBoolean);
      AppMethodBeat.o(158468);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(158468);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ad.d
 * JD-Core Version:    0.7.0.1
 */