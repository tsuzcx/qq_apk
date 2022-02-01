package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static final <T> T a(JSONObject paramJSONObject, Class<T> paramClass)
  {
    AppMethodBeat.i(163917);
    for (;;)
    {
      int i;
      try
      {
        localObject1 = paramClass.newInstance();
        localIterator = paramJSONObject.keys();
        if (localIterator != null)
        {
          boolean bool = localIterator.hasNext();
          if (!bool) {}
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        Iterator localIterator;
        Object localObject2;
        Field localField;
        AppMethodBeat.o(163917);
        return null;
      }
      try
      {
        localObject2 = (String)localIterator.next();
        localField = paramClass.getField((String)localObject2);
        if (localField == null) {
          continue;
        }
        localObject2 = paramJSONObject.get((String)localObject2);
        if ((localObject2 instanceof JSONObject))
        {
          localField.set(localObject1, a((JSONObject)localObject2, localField.getType()));
          continue;
        }
        if ((localObject2 instanceof JSONArray))
        {
          localObject2 = (JSONArray)localObject2;
          LinkedList localLinkedList = new LinkedList();
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            Object localObject3 = ((JSONArray)localObject2).get(i);
            if ((localObject3 instanceof JSONObject))
            {
              localLinkedList.add(a((JSONObject)localObject3, localObject3.getClass()));
              break label231;
            }
            localLinkedList.add(localObject3);
            break label231;
          }
          localField.set(localObject1, localLinkedList);
          continue;
        }
        localField.set(localObject1, localObject2);
      }
      catch (Exception localException) {}
      AppMethodBeat.o(163917);
      return localObject1;
      continue;
      label231:
      i += 1;
    }
  }
  
  public static final String a(String paramString, int paramInt, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(163913);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("data", paramJSONArray);
      label37:
      paramString = localJSONObject.toString();
      AppMethodBeat.o(163913);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label37;
    }
  }
  
  public static final String a(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(163912);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("data", paramJSONObject);
      label37:
      paramString = localJSONObject.toString();
      AppMethodBeat.o(163912);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label37;
    }
  }
  
  public static final void a(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(163914);
    f.a(paramObject, paramJSONObject);
    AppMethodBeat.o(163914);
  }
  
  private static void b(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(163915);
    Field[] arrayOfField = paramObject.getClass().getFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j) {
        localField = arrayOfField[i];
      }
      try
      {
        Object localObject1 = localField.get(paramObject);
        if (localObject1 == null) {
          break label160;
        }
        if ((localField.getType().isPrimitive()) || ((localObject1 instanceof String)))
        {
          paramJSONObject.put(localField.getName(), localObject1);
        }
        else
        {
          Object localObject2;
          if ((localObject1 instanceof List))
          {
            localObject2 = new JSONArray();
            b((List)localObject1, (JSONArray)localObject2);
            paramJSONObject.put(localField.getName(), localObject2);
          }
          else
          {
            localObject2 = new JSONObject();
            b(localObject1, (JSONObject)localObject2);
            paramJSONObject.put(localField.getName(), localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        label160:
        break label160;
      }
      AppMethodBeat.o(163915);
      return;
      i += 1;
    }
  }
  
  public static final void b(List<? extends Object> paramList, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(163916);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if ((localObject1.getClass().isPrimitive()) || ((localObject1 instanceof String)))
      {
        paramJSONArray.put(localObject1);
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof List))
        {
          localObject2 = new JSONArray();
          b((List)localObject1, (JSONArray)localObject2);
          paramJSONArray.put(localObject2);
        }
        else
        {
          localObject2 = new JSONObject();
          b(localObject1, (JSONObject)localObject2);
          paramJSONArray.put(localObject2);
        }
      }
    }
    AppMethodBeat.o(163916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.a
 * JD-Core Version:    0.7.0.1
 */