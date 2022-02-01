package com.tencent.mm.plugin.datareport.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.i;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.datareport.a.a
{
  private com.tencent.mm.plugin.datareport.i.a xgU;
  
  public b()
  {
    AppMethodBeat.i(262866);
    this.xgU = new com.tencent.mm.plugin.datareport.i.b();
    AppMethodBeat.o(262866);
  }
  
  private Object eI(Object paramObject)
  {
    AppMethodBeat.i(262875);
    if (paramObject == null)
    {
      AppMethodBeat.o(262875);
      return null;
    }
    Object localObject2;
    if ((paramObject instanceof List))
    {
      localObject1 = (List)paramObject;
      try
      {
        JSONArray localJSONArray1 = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = eI(((Iterator)localObject1).next());
          if (localObject2 != null) {
            localJSONArray1.put(localObject2);
          }
        }
        if (!(paramObject instanceof Map)) {
          break label167;
        }
      }
      catch (Exception localException1) {}
    }
    else
    {
      Map localMap = (Map)paramObject;
      try
      {
        localObject1 = new JSONObject();
        localObject2 = localMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          Object localObject4 = eI(localMap.get(localObject3));
          if (localObject4 != null) {
            ((JSONObject)localObject1).put(String.valueOf(localObject3), localObject4);
          }
        }
        if (!(paramObject instanceof Set)) {
          break label231;
        }
      }
      catch (Exception localException2) {}
    }
    label167:
    Object localObject1 = (Set)paramObject;
    try
    {
      JSONArray localJSONArray2 = new JSONArray();
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = eI(((Iterator)localObject1).next());
        if (localObject2 != null) {
          localJSONArray2.put(localObject2);
        }
      }
      AppMethodBeat.o(262875);
    }
    catch (Exception localException3) {}
    label231:
    return paramObject;
    AppMethodBeat.o(262875);
    return localException3;
    AppMethodBeat.o(262875);
    return localObject1;
    AppMethodBeat.o(262875);
    return localException3;
  }
  
  public final boolean a(long paramLong, Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262887);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262887);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localArrayList.add(String.valueOf(paramLong));
    Object localObject1;
    try
    {
      localObject1 = new JSONObject();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject2 = eI(paramMap.get(str));
          if (localObject2 != null)
          {
            ((JSONObject)localObject1).put(str, localObject2);
            continue;
            this.xgU.a(paramObject, paramString, localArrayList);
          }
        }
      }
    }
    catch (Exception paramMap)
    {
      Log.e("DefaultDataReportCallback", "[onDataReport] throw Exception e : " + paramMap.getMessage());
    }
    for (;;)
    {
      AppMethodBeat.o(262887);
      return false;
      localObject1 = ((JSONObject)localObject1).toString();
      paramMap = "";
      if (localObject1 != null) {
        paramMap = ((String)localObject1).replace(",", ";");
      }
      localArrayList.add(paramMap);
      Log.d("DefaultDataReportCallback", "[onDataReport] eventId : " + paramString + ", paramsJson : " + (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.c.b
 * JD-Core Version:    0.7.0.1
 */