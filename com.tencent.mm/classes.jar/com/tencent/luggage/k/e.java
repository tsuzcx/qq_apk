package com.tencent.luggage.k;

import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public static JSONArray E(List<?> paramList)
  {
    AppMethodBeat.i(209393);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(209393);
      return localJSONArray;
    }
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(209393);
    return localJSONArray;
  }
  
  public static JSONObject a(PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(209399);
    if (paramPersistableBundle == null)
    {
      AppMethodBeat.o(209399);
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
    AppMethodBeat.o(209399);
    return localJSONObject;
  }
  
  public static Boolean aJ(Object paramObject)
  {
    AppMethodBeat.i(209397);
    if ((paramObject instanceof Boolean))
    {
      paramObject = (Boolean)paramObject;
      AppMethodBeat.o(209397);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(209397);
        return paramObject;
      }
      if ("false".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(209397);
        return paramObject;
      }
    }
    AppMethodBeat.o(209397);
    return null;
  }
  
  public static void e(Map paramMap)
  {
    AppMethodBeat.i(209395);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        e((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(209395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.k.e
 * JD-Core Version:    0.7.0.1
 */