package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.etl;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"getKey", "", "originKey", "keyMap", "Ljava/util/HashMap;", "pbToJSON", "Lorg/json/JSONObject;", "originObj", "", "", "jsonObj", "pbToList", "Ljava/util/LinkedList;", "list", "pbToMap", "obj", "clazz", "Ljava/lang/Class;", "putListToJSON", "", "array", "Lorg/json/JSONArray;", "putMapToJSON", "map", "", "safePbToJSON", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "", "libktcomm_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static String a(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168834);
    s.u(paramString, "originKey");
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (String)paramHashMap.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(168834);
        return "";
      }
      AppMethodBeat.o(168834);
      return paramString;
    }
    AppMethodBeat.o(168834);
    return paramString;
  }
  
  private static HashMap<String, Object> a(Object paramObject, Class<?> paramClass, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168833);
    s.u(paramObject, "obj");
    s.u(paramClass, "clazz");
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getFields();
    s.s(paramClass, "fields");
    int i = 0;
    int j = paramClass.length;
    label279:
    for (;;)
    {
      if (i < j)
      {
        String str = paramClass[i];
        i += 1;
        try
        {
          Object localObject1 = str.get(paramObject);
          if (localObject1 == null) {
            break label279;
          }
          if ((str.getType().isPrimitive()) || ((localObject1 instanceof String)))
          {
            localObject2 = (Map)localHashMap;
            str = str.getName();
            s.s(str, "field.name");
            ((Map)localObject2).put(a(str, paramHashMap), localObject1);
            continue;
          }
          if ((localObject1 instanceof a))
          {
            localObject2 = str.getType();
            s.s(localObject2, "field.type");
            localObject1 = a(localObject1, (Class)localObject2, paramHashMap);
            localObject2 = (Map)localHashMap;
            str = str.getName();
            s.s(str, "field.name");
            ((Map)localObject2).put(a(str, paramHashMap), localObject1);
            continue;
          }
          if (!(localObject1 instanceof LinkedList)) {
            break label279;
          }
          localObject1 = a((LinkedList)localObject1, paramHashMap);
          if (localObject1 == null) {
            break label279;
          }
          Object localObject2 = (Map)localHashMap;
          str = str.getName();
          s.s(str, "field.name");
          ((Map)localObject2).put(a(str, paramHashMap), localObject1);
        }
        catch (Exception localException) {}
      }
      else
      {
        AppMethodBeat.o(168833);
        return localHashMap;
      }
    }
  }
  
  private static LinkedList<Object> a(LinkedList<?> paramLinkedList, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168835);
    s.u(paramLinkedList, "list");
    if (paramLinkedList.size() > 0) {}
    for (Object localObject1 = paramLinkedList.get(0);; localObject1 = null)
    {
      s.checkNotNull(localObject1);
      if ((localObject1.getClass().isPrimitive()) || ((localObject1 instanceof String)))
      {
        AppMethodBeat.o(168835);
        return paramLinkedList;
      }
      if ((localObject1 instanceof etl))
      {
        paramHashMap = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext()) {
          paramHashMap.add(paramLinkedList.next().toString());
        }
        AppMethodBeat.o(168835);
        return paramHashMap;
      }
      if ((localObject1 instanceof a))
      {
        localObject1 = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          Object localObject2 = paramLinkedList.next();
          s.s(localObject2, "o");
          ((LinkedList)localObject1).add(a(localObject2, localObject2.getClass(), paramHashMap));
        }
        AppMethodBeat.o(168835);
        return localObject1;
      }
      AppMethodBeat.o(168835);
      return null;
    }
  }
  
  public static final void a(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(168830);
    s.u(paramObject, "originObj");
    s.u(paramJSONObject, "jsonObj");
    a((Map)a(paramObject, paramObject.getClass(), null), paramJSONObject);
    AppMethodBeat.o(168830);
  }
  
  private static void a(List<? extends Object> paramList, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(168832);
    s.u(paramList, "list");
    s.u(paramJSONArray, "array");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      Object localObject2;
      if ((localObject1 instanceof LinkedList))
      {
        localObject2 = new JSONArray();
        a((List)localObject1, (JSONArray)localObject2);
        paramJSONArray.put(localObject2);
      }
      else if ((localObject1 instanceof Map))
      {
        localObject2 = new JSONObject();
        a((Map)localObject1, (JSONObject)localObject2);
        paramJSONArray.put(localObject2);
      }
      else
      {
        paramJSONArray.put(localObject1);
      }
    }
    AppMethodBeat.o(168832);
  }
  
  private static void a(Map<String, ? extends Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(168831);
    s.u(paramMap, "map");
    s.u(paramJSONObject, "obj");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      Object localObject2;
      if ((localObject1 instanceof Map))
      {
        localObject2 = new JSONObject();
        a((Map)localObject1, (JSONObject)localObject2);
        paramJSONObject.put(str, localObject2);
      }
      else if ((localObject1 instanceof LinkedList))
      {
        localObject2 = new JSONArray();
        a((List)localObject1, (JSONArray)localObject2);
        paramJSONObject.put(str, localObject2);
      }
      else if ((localObject1 instanceof Long))
      {
        paramJSONObject.put(str, localObject1.toString());
      }
      else
      {
        paramJSONObject.put(str, localObject1);
      }
    }
    AppMethodBeat.o(168831);
  }
  
  public static final JSONObject dg(Object paramObject)
  {
    AppMethodBeat.i(168829);
    s.u(paramObject, "originObj");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(paramObject, localJSONObject);
      AppMethodBeat.o(168829);
      return localJSONObject;
    }
    catch (Exception paramObject)
    {
      paramObject = new JSONObject();
      AppMethodBeat.o(168829);
    }
    return paramObject;
  }
  
  public static final JSONObject dh(Object paramObject)
  {
    AppMethodBeat.i(233439);
    s.u(paramObject, "originObj");
    JSONObject localJSONObject = new JSONObject();
    a(paramObject, localJSONObject);
    AppMethodBeat.o(233439);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.f
 * JD-Core Version:    0.7.0.1
 */