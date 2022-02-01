package com.tencent.liteav.basic.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
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
    AppMethodBeat.i(229966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(229966);
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(TXCBuild.Manufacturer(), paramJSONObject.optString("MANUFACTURER")));
    localArrayList.add(new Pair(TXCBuild.Model(), paramJSONObject.optString("MODEL")));
    localArrayList.add(new Pair(String.valueOf(TXCBuild.VersionInt()), paramJSONObject.optString("VERSION")));
    localArrayList.add(new Pair(Build.VERSION.INCREMENTAL, paramJSONObject.optString("VERSION_INCREMENTAL")));
    localArrayList.add(new Pair(Build.DISPLAY, paramJSONObject.optString("DISPLAY")));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramJSONObject = (Pair)localArrayList.get(i);
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.second))
      {
        AppMethodBeat.o(229966);
        return i;
      }
      if (!((String)paramJSONObject.first).equalsIgnoreCase((String)paramJSONObject.second))
      {
        AppMethodBeat.o(229966);
        return 0;
      }
      i += 1;
    }
    i = localArrayList.size();
    AppMethodBeat.o(229966);
    return i;
  }
  
  private void a(Map<String, String> paramMap, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229974);
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
    AppMethodBeat.o(229974);
  }
  
  private JSONObject b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(229958);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(229958);
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
        AppMethodBeat.o(229958);
        return localObject;
      }
      AppMethodBeat.o(229958);
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
        AppMethodBeat.i(229990);
        paramString = (String)this.a.get(paramString);
        boolean bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          try
          {
            long l = Long.parseLong(paramString);
            paramLong = l;
            AppMethodBeat.o(229990);
          }
          catch (NumberFormatException paramString)
          {
            AppMethodBeat.o(229990);
            continue;
          }
          return paramLong;
        }
      }
      finally {}
      AppMethodBeat.o(229990);
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
        AppMethodBeat.i(229983);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(229983);
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
          AppMethodBeat.o(229983);
        }
        catch (JSONException paramString)
        {
          TXCLog.e("CompatibleConfig", "parse best match value failed.", paramString);
          AppMethodBeat.o(229983);
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
    //   2: ldc_w 256
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 24	com/tencent/liteav/basic/d/b:a	Ljava/util/Map;
    //   12: invokeinterface 246 1 0
    //   17: aload_0
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 258	com/tencent/liteav/basic/d/b:b	(Lorg/json/JSONArray;)Lorg/json/JSONObject;
    //   23: putfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   26: aload_0
    //   27: getfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   30: ifnonnull +20 -> 50
    //   33: ldc 185
    //   35: ldc_w 260
    //   38: invokestatic 227	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc_w 256
    //   44: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 24	com/tencent/liteav/basic/d/b:a	Ljava/util/Map;
    //   55: ldc 250
    //   57: aload_0
    //   58: getfield 26	com/tencent/liteav/basic/d/b:b	Lorg/json/JSONObject;
    //   61: invokespecial 151	com/tencent/liteav/basic/d/b:a	(Ljava/util/Map;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   64: aload_0
    //   65: invokespecial 252	com/tencent/liteav/basic/d/b:b	()V
    //   68: ldc_w 256
    //   71: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -27 -> 47
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	b
    //   0	82	1	paramJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   50	74	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.b
 * JD-Core Version:    0.7.0.1
 */