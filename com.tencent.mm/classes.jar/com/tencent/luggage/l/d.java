package com.tencent.luggage.l;

import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public static JSONObject a(PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(219976);
    if (paramPersistableBundle == null)
    {
      AppMethodBeat.o(219976);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramPersistableBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramPersistableBundle.get(str);
      if ((localObject instanceof PersistableBundle)) {
        localJSONObject.put(str, a((PersistableBundle)localObject));
      } else {
        localJSONObject.put(str, localObject);
      }
    }
    AppMethodBeat.o(219976);
    return localJSONObject;
  }
  
  public static JSONArray bc(List<?> paramList)
  {
    AppMethodBeat.i(219961);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(219961);
      return localJSONArray;
    }
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(219961);
    return localJSONArray;
  }
  
  public static Boolean cf(Object paramObject)
  {
    AppMethodBeat.i(219972);
    if ((paramObject instanceof Boolean))
    {
      paramObject = (Boolean)paramObject;
      AppMethodBeat.o(219972);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(219972);
        return paramObject;
      }
      if ("false".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(219972);
        return paramObject;
      }
    }
    AppMethodBeat.o(219972);
    return null;
  }
  
  public static void k(Map paramMap)
  {
    AppMethodBeat.i(219966);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        k((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(219966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.l.d
 * JD-Core Version:    0.7.0.1
 */