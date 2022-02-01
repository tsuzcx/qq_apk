package com.tencent.liteav.basic.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private final Map<String, String> a;
  private JSONObject b;
  
  public b()
  {
    AppMethodBeat.i(14554);
    this.a = new HashMap();
    this.b = null;
    AppMethodBeat.o(14554);
  }
  
  private int a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(235139);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(235139);
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Build.MANUFACTURER, paramJSONObject.optString("MANUFACTURER")));
    localArrayList.add(new Pair(Build.MODEL, paramJSONObject.optString("MODEL")));
    localArrayList.add(new Pair(String.valueOf(Build.VERSION.SDK_INT), paramJSONObject.optString("VERSION")));
    localArrayList.add(new Pair(Build.VERSION.INCREMENTAL, paramJSONObject.optString("VERSION_INCREMENTAL")));
    localArrayList.add(new Pair(Build.DISPLAY, paramJSONObject.optString("DISPLAY")));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramJSONObject = (Pair)localArrayList.get(i);
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.second))
      {
        AppMethodBeat.o(235139);
        return i;
      }
      if (!((String)paramJSONObject.first).equalsIgnoreCase((String)paramJSONObject.second))
      {
        AppMethodBeat.o(235139);
        return 0;
      }
      i += 1;
    }
    i = localArrayList.size();
    AppMethodBeat.o(235139);
    return i;
  }
  
  private void a(Map<String, String> paramMap, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(235142);
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      if ((localObject instanceof JSONObject)) {
        a(paramMap, paramString + "." + str, (JSONObject)localObject);
      } else if (localObject != null) {
        paramMap.put(paramString + "." + str, localObject.toString());
      }
    }
    AppMethodBeat.o(235142);
  }
  
  private JSONObject b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(235136);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(235136);
      return null;
    }
    int j = 0;
    Object localObject = null;
    int i = 0;
    try
    {
      if (j < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
        int k = a(localJSONObject.optJSONObject("deviceinfo"));
        localJSONObject = localJSONObject.optJSONObject("deviceconfig");
        if ((k <= i) || (localJSONObject == null)) {
          break label138;
        }
        i = k;
        localObject = localJSONObject;
      }
      for (;;)
      {
        j += 1;
        break;
      }
    }
    catch (JSONException paramJSONArray)
    {
      TXCLog.e("CompatibleConfig", "Find best match value failed.", paramJSONArray);
      TXCLog.i("CompatibleConfig", "bestMatchLevel: %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(235136);
        return localObject;
      }
      AppMethodBeat.o(235136);
      return null;
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(14557);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append(" : ").append((String)localEntry.getValue()).append("\n");
    }
    TXCLog.i("CompatibleConfig", localStringBuilder.toString());
    AppMethodBeat.o(14557);
  }
  
  public long a(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(235134);
        paramString = (String)this.a.get(paramString);
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          try
          {
            long l = Long.parseLong(paramString);
            paramLong = l;
            AppMethodBeat.o(235134);
          }
          catch (NumberFormatException paramString)
          {
            AppMethodBeat.o(235134);
            continue;
          }
          return paramLong;
        }
      }
      finally {}
      AppMethodBeat.o(235134);
    }
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = this.b;
      return localJSONObject;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(235130);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(235130);
          return;
        }
      }
      finally
      {
        try
        {
          this.a.clear();
          this.b = new JSONObject(paramString);
          a(this.a, "", this.b);
          b();
          AppMethodBeat.o(235130);
        }
        catch (JSONException paramString)
        {
          TXCLog.e("CompatibleConfig", "parse best match value failed.", paramString);
          AppMethodBeat.o(235130);
        }
        paramString = finally;
      }
    }
  }
  
  /* Error */
  public void a(JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 253
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/tencent/liteav/basic/d/b:a	Ljava/util/Map;
    //   11: invokeinterface 243 1 0
    //   16: aload_0
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 255	com/tencent/liteav/basic/d/b:b	(Lorg/json/JSONArray;)Lorg/json/JSONObject;
    //   22: putfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   25: aload_0
    //   26: getfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   29: ifnonnull +19 -> 48
    //   32: ldc 182
    //   34: ldc_w 257
    //   37: invokestatic 224	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 253
    //   42: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 24	com/tencent/liteav/basic/d/b:a	Ljava/util/Map;
    //   53: ldc 247
    //   55: aload_0
    //   56: getfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   59: invokespecial 148	com/tencent/liteav/basic/d/b:a	(Ljava/util/Map;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   62: aload_0
    //   63: invokespecial 249	com/tencent/liteav/basic/d/b:b	()V
    //   66: ldc 253
    //   68: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: goto -26 -> 45
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	b
    //   0	79	1	paramJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   2	45	74	finally
    //   48	71	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.basic.d.b
 * JD-Core Version:    0.7.0.1
 */