package com.tencent.mm.aa;

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
  private JSONObject eGE;
  
  public d()
  {
    AppMethodBeat.i(117523);
    this.eGE = new JSONObject();
    AppMethodBeat.o(117523);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(117525);
    try
    {
      this.eGE = new JSONObject(paramString);
      AppMethodBeat.o(117525);
      return;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117525);
      throw paramString;
    }
  }
  
  public d(Map paramMap)
  {
    AppMethodBeat.i(117524);
    this.eGE = new JSONObject(paramMap);
    AppMethodBeat.o(117524);
  }
  
  d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117526);
    Assert.assertNotNull(paramJSONObject);
    this.eGE = paramJSONObject;
    AppMethodBeat.o(117526);
  }
  
  public final c J(String paramString, int paramInt)
  {
    AppMethodBeat.i(117530);
    try
    {
      this.eGE.put(paramString, paramInt);
      AppMethodBeat.o(117530);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117530);
      throw paramString;
    }
  }
  
  public final c c(String paramString, double paramDouble)
  {
    AppMethodBeat.i(117529);
    try
    {
      this.eGE.put(paramString, paramDouble);
      AppMethodBeat.o(117529);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117529);
      throw paramString;
    }
  }
  
  /* Error */
  public final c c(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: instanceof 2
    //   9: ifeq +26 -> 35
    //   12: aload_0
    //   13: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: aload_2
    //   18: checkcast 2	com/tencent/mm/aa/d
    //   21: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   24: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: ldc 66
    //   30: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: goto -17 -> 28
    //   48: astore_1
    //   49: new 36	com/tencent/mm/aa/g
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 39	com/tencent/mm/aa/g:<init>	(Ljava/lang/Throwable;)V
    //   57: astore_1
    //   58: ldc 66
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
  
  /* Error */
  public final c e(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: instanceof 2
    //   9: ifeq +26 -> 35
    //   12: aload_0
    //   13: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   16: aload_1
    //   17: aload_2
    //   18: checkcast 2	com/tencent/mm/aa/d
    //   21: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   24: invokevirtual 74	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: ldc 71
    //   30: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: getfield 24	com/tencent/mm/aa/d:eGE	Lorg/json/JSONObject;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 74	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: goto -17 -> 28
    //   48: astore_1
    //   49: new 36	com/tencent/mm/aa/g
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 39	com/tencent/mm/aa/g:<init>	(Ljava/lang/Throwable;)V
    //   57: astore_1
    //   58: ldc 71
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
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(117538);
    try
    {
      paramString = this.eGE.get(paramString);
      if ((paramString instanceof JSONObject))
      {
        paramString = new d((JSONObject)paramString);
        AppMethodBeat.o(117538);
        return paramString;
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        AppMethodBeat.o(117538);
        return paramString;
      }
      AppMethodBeat.o(117538);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117538);
      throw paramString;
    }
  }
  
  public final boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(117540);
    try
    {
      boolean bool = this.eGE.getBoolean(paramString);
      AppMethodBeat.o(117540);
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117540);
      throw paramString;
    }
  }
  
  public final double getDouble(String paramString)
  {
    AppMethodBeat.i(117542);
    try
    {
      double d = this.eGE.getDouble(paramString);
      AppMethodBeat.o(117542);
      return d;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117542);
      throw paramString;
    }
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(117544);
    try
    {
      int i = this.eGE.getInt(paramString);
      AppMethodBeat.o(117544);
      return i;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117544);
      throw paramString;
    }
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(117546);
    try
    {
      long l = this.eGE.getLong(paramString);
      AppMethodBeat.o(117546);
      return l;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117546);
      throw paramString;
    }
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(117548);
    try
    {
      paramString = this.eGE.getString(paramString);
      AppMethodBeat.o(117548);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117548);
      throw paramString;
    }
  }
  
  public final boolean has(String paramString)
  {
    AppMethodBeat.i(117537);
    boolean bool = this.eGE.has(paramString);
    AppMethodBeat.o(117537);
    return bool;
  }
  
  public final boolean isNull(String paramString)
  {
    AppMethodBeat.i(117536);
    boolean bool = this.eGE.isNull(paramString);
    AppMethodBeat.o(117536);
    return bool;
  }
  
  public final Iterator<String> keys()
  {
    AppMethodBeat.i(117555);
    Iterator localIterator = this.eGE.keys();
    AppMethodBeat.o(117555);
    return localIterator;
  }
  
  public final int length()
  {
    AppMethodBeat.i(117527);
    int i = this.eGE.length();
    AppMethodBeat.o(117527);
    return i;
  }
  
  public final String mj(String paramString)
  {
    AppMethodBeat.i(117534);
    if (paramString == null)
    {
      paramString = new g("Names must be non-null");
      AppMethodBeat.o(117534);
      throw paramString;
    }
    AppMethodBeat.o(117534);
    return paramString;
  }
  
  public final a mk(String paramString)
  {
    AppMethodBeat.i(117551);
    try
    {
      paramString = this.eGE.getJSONArray(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(117551);
        return null;
      }
      paramString = new b(paramString);
      AppMethodBeat.o(117551);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117551);
      throw paramString;
    }
  }
  
  public final a ml(String paramString)
  {
    AppMethodBeat.i(117552);
    paramString = this.eGE.optJSONArray(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117552);
      return null;
    }
    paramString = new b(paramString);
    AppMethodBeat.o(117552);
    return paramString;
  }
  
  public final c mm(String paramString)
  {
    AppMethodBeat.i(117553);
    try
    {
      paramString = this.eGE.getJSONObject(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(117553);
        return null;
      }
      paramString = new d(paramString);
      AppMethodBeat.o(117553);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117553);
      throw paramString;
    }
  }
  
  public final c mn(String paramString)
  {
    AppMethodBeat.i(117554);
    paramString = this.eGE.optJSONObject(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(117554);
      return null;
    }
    paramString = new d(paramString);
    AppMethodBeat.o(117554);
    return paramString;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(117539);
    try
    {
      paramString = this.eGE.get(paramString);
      if ((paramString instanceof JSONObject))
      {
        paramString = new d((JSONObject)paramString);
        AppMethodBeat.o(117539);
        return paramString;
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        AppMethodBeat.o(117539);
        return paramString;
      }
      AppMethodBeat.o(117539);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(117539);
    }
    return null;
  }
  
  public final boolean optBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117541);
    paramBoolean = this.eGE.optBoolean(paramString, paramBoolean);
    AppMethodBeat.o(117541);
    return paramBoolean;
  }
  
  public final double optDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(117543);
    paramDouble = this.eGE.optDouble(paramString, paramDouble);
    AppMethodBeat.o(117543);
    return paramDouble;
  }
  
  public final int optInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(117545);
    paramInt = this.eGE.optInt(paramString, paramInt);
    AppMethodBeat.o(117545);
    return paramInt;
  }
  
  public final long optLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(117547);
    paramLong = this.eGE.optLong(paramString, paramLong);
    AppMethodBeat.o(117547);
    return paramLong;
  }
  
  public final String optString(String paramString)
  {
    AppMethodBeat.i(117549);
    paramString = this.eGE.optString(paramString);
    AppMethodBeat.o(117549);
    return paramString;
  }
  
  public final String optString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117550);
    paramString1 = this.eGE.optString(paramString1, paramString2);
    AppMethodBeat.o(117550);
    return paramString1;
  }
  
  public final c r(String paramString, long paramLong)
  {
    AppMethodBeat.i(117531);
    try
    {
      this.eGE.put(paramString, paramLong);
      AppMethodBeat.o(117531);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117531);
      throw paramString;
    }
  }
  
  public final Object remove(String paramString)
  {
    AppMethodBeat.i(117535);
    paramString = this.eGE.remove(paramString);
    AppMethodBeat.o(117535);
    return paramString;
  }
  
  public final c t(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117528);
    try
    {
      this.eGE.put(paramString, paramBoolean);
      AppMethodBeat.o(117528);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString = new g(paramString);
      AppMethodBeat.o(117528);
      throw paramString;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117556);
    String str = this.eGE.toString();
    AppMethodBeat.o(117556);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.d
 * JD-Core Version:    0.7.0.1
 */