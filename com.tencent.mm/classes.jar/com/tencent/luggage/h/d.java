package com.tencent.luggage.h;

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
  public static JSONArray D(List<?> paramList)
  {
    AppMethodBeat.i(200924);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(200924);
      return localJSONArray;
    }
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(200924);
    return localJSONArray;
  }
  
  public static JSONObject a(PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(200927);
    if (paramPersistableBundle == null)
    {
      AppMethodBeat.o(200927);
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
    AppMethodBeat.o(200927);
    return localJSONObject;
  }
  
  public static Boolean aB(Object paramObject)
  {
    AppMethodBeat.i(200926);
    if ((paramObject instanceof Boolean))
    {
      paramObject = (Boolean)paramObject;
      AppMethodBeat.o(200926);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(200926);
        return paramObject;
      }
      if ("false".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(200926);
        return paramObject;
      }
    }
    AppMethodBeat.o(200926);
    return null;
  }
  
  public static void d(Map paramMap)
  {
    AppMethodBeat.i(200925);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        d((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(200925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */