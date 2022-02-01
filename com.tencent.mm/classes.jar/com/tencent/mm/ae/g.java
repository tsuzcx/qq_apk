package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.eaf;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getKey", "", "originKey", "keyMap", "Ljava/util/HashMap;", "pbToJSON", "Lorg/json/JSONObject;", "originObj", "", "", "jsonObj", "pbToList", "Ljava/util/LinkedList;", "list", "pbToMap", "obj", "clazz", "Ljava/lang/Class;", "putListToJSON", "", "array", "Lorg/json/JSONArray;", "putMapToJSON", "map", "", "safePbToJSON", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "", "libktcomm_release"})
public final class g
{
  private static String a(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168834);
    p.k(paramString, "originKey");
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramHashMap = (String)paramHashMap.get(paramString);
      paramString = paramHashMap;
      if (paramHashMap == null)
      {
        AppMethodBeat.o(168834);
        return "";
      }
    }
    AppMethodBeat.o(168834);
    return paramString;
  }
  
  private static HashMap<String, Object> a(Object paramObject, Class<?> paramClass, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168833);
    p.k(paramObject, "obj");
    p.k(paramClass, "clazz");
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getFields();
    p.j(paramClass, "clazz.fields");
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < j) {
        localObject1 = paramClass[i];
      }
      try
      {
        Object localObject2 = ((Field)localObject1).get(paramObject);
        if (localObject2 == null) {
          break label291;
        }
        p.j(localObject1, "field");
        Object localObject3 = ((Field)localObject1).getType();
        p.j(localObject3, "field.type");
        if ((((Class)localObject3).isPrimitive()) || ((localObject2 instanceof String)))
        {
          localObject3 = (Map)localHashMap;
          localObject1 = ((Field)localObject1).getName();
          p.j(localObject1, "field.name");
          ((Map)localObject3).put(a((String)localObject1, paramHashMap), localObject2);
        }
        else if ((localObject2 instanceof a))
        {
          localObject3 = ((Field)localObject1).getType();
          p.j(localObject3, "field.type");
          localObject2 = a(localObject2, (Class)localObject3, paramHashMap);
          localObject3 = (Map)localHashMap;
          localObject1 = ((Field)localObject1).getName();
          p.j(localObject1, "field.name");
          ((Map)localObject3).put(a((String)localObject1, paramHashMap), localObject2);
        }
        else if ((localObject2 instanceof LinkedList))
        {
          localObject2 = a((LinkedList)localObject2, paramHashMap);
          if (localObject2 != null)
          {
            localObject3 = (Map)localHashMap;
            localObject1 = ((Field)localObject1).getName();
            p.j(localObject1, "field.name");
            ((Map)localObject3).put(a((String)localObject1, paramHashMap), localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        label291:
        break label291;
      }
      AppMethodBeat.o(168833);
      return localHashMap;
      i += 1;
    }
  }
  
  private static LinkedList<Object> a(LinkedList<?> paramLinkedList, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(168835);
    p.k(paramLinkedList, "list");
    if (paramLinkedList.size() > 0) {}
    for (Object localObject1 = paramLinkedList.get(0);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      if ((localObject1.getClass().isPrimitive()) || ((localObject1 instanceof String)))
      {
        AppMethodBeat.o(168835);
        return paramLinkedList;
      }
      if ((localObject1 instanceof eaf))
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
          p.j(localObject2, "o");
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
    p.k(paramObject, "originObj");
    p.k(paramJSONObject, "jsonObj");
    a((Map)a(paramObject, paramObject.getClass(), null), paramJSONObject);
    AppMethodBeat.o(168830);
  }
  
  private static void a(List<? extends Object> paramList, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(168832);
    p.k(paramList, "list");
    p.k(paramJSONArray, "array");
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
    p.k(paramMap, "map");
    p.k(paramJSONObject, "obj");
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
  
  public static final JSONObject bN(Object paramObject)
  {
    AppMethodBeat.i(168829);
    p.k(paramObject, "originObj");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.g
 * JD-Core Version:    0.7.0.1
 */