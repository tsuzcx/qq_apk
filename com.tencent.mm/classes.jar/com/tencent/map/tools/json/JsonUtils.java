package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.annotation.JsonType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils
{
  public static <T> String collectionToJson(Collection<T> paramCollection)
  {
    AppMethodBeat.i(180918);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(180918);
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if ((localObject instanceof JsonEncoder)) {
        localJSONArray.put(((JsonEncoder)localObject).toJson());
      } else {
        localJSONArray.put(null);
      }
    }
    paramCollection = localJSONArray.toString();
    AppMethodBeat.o(180918);
    return paramCollection;
  }
  
  public static <T> JSONObject modelToJson(T paramT)
  {
    AppMethodBeat.i(180917);
    if ((paramT instanceof JsonEncoder))
    {
      paramT = ((JsonEncoder)paramT).toJson();
      AppMethodBeat.o(180917);
      return paramT;
    }
    AppMethodBeat.o(180917);
    return null;
  }
  
  public static <T> String modelToJsonString(T paramT)
  {
    AppMethodBeat.i(180916);
    paramT = modelToJson(paramT);
    if (paramT != null)
    {
      paramT = paramT.toString();
      AppMethodBeat.o(180916);
      return paramT;
    }
    AppMethodBeat.o(180916);
    return null;
  }
  
  public static <C extends Collection> C parseTo(Class<C> paramClass, JSONArray paramJSONArray, Class paramClass1, Object... paramVarArgs)
  {
    AppMethodBeat.i(180913);
    Collection localCollection = (Collection)Util.newInstance(paramClass, new Object[0]);
    if (paramJSONArray != null)
    {
      int i = 0;
      if (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if ((localObject instanceof JSONArray)) {
          localCollection.add(parseTo(paramClass, (JSONArray)localObject, paramClass1, paramVarArgs));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof JSONObject)) {
            localCollection.add(parseToModel((JSONObject)localObject, paramClass1, paramVarArgs));
          } else if (localObject.getClass() == paramClass1) {
            localCollection.add(localObject);
          } else if ((localObject instanceof Integer))
          {
            if (paramClass1 == Double.class) {
              localCollection.add(Double.valueOf(((Integer)localObject).doubleValue()));
            } else if (paramClass1 == Long.class) {
              localCollection.add(Long.valueOf(((Integer)localObject).longValue()));
            } else if (paramClass1 == Float.class) {
              localCollection.add(Float.valueOf(((Integer)localObject).floatValue()));
            } else if (paramClass1 == String.class) {
              localCollection.add(localObject.toString());
            }
          }
          else if ((localObject instanceof Double))
          {
            if (paramClass1 == Integer.class) {
              localCollection.add(Integer.valueOf(((Double)localObject).intValue()));
            } else if (paramClass1 == Long.class) {
              localCollection.add(Long.valueOf(((Double)localObject).longValue()));
            } else if (paramClass1 == Float.class) {
              localCollection.add(Float.valueOf(((Double)localObject).floatValue()));
            } else if (paramClass1 == String.class) {
              localCollection.add(localObject.toString());
            }
          }
          else if ((localObject instanceof Long)) {
            if (paramClass1 == Integer.class) {
              localCollection.add(Integer.valueOf(((Long)localObject).intValue()));
            } else if (paramClass1 == Double.class) {
              localCollection.add(Double.valueOf(((Long)localObject).doubleValue()));
            } else if (paramClass1 == Float.class) {
              localCollection.add(Float.valueOf(((Long)localObject).floatValue()));
            } else if (paramClass1 == String.class) {
              localCollection.add(localObject.toString());
            }
          }
        }
      }
    }
    AppMethodBeat.o(180913);
    return localCollection;
  }
  
  public static Object parseToArray(JSONArray paramJSONArray, Class paramClass)
  {
    AppMethodBeat.i(180919);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(180919);
      return null;
    }
    int j = paramJSONArray.length();
    paramClass = Array.newInstance(paramClass, j);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        Array.set(paramClass, i, paramJSONArray.get(i));
        label44:
        i += 1;
        continue;
        AppMethodBeat.o(180919);
        return paramClass;
      }
      catch (JSONException localJSONException)
      {
        break label44;
      }
    }
  }
  
  public static <T> List<T> parseToList(JSONArray paramJSONArray, Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(180912);
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(parseToModel(paramJSONArray.optJSONObject(i), paramClass, paramVarArgs));
        i += 1;
      }
    }
    AppMethodBeat.o(180912);
    return localArrayList;
  }
  
  public static <T> T parseToModel(String paramString, Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(180915);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(180915);
      return null;
    }
    try
    {
      paramString = parseToModel(new JSONObject(paramString), paramClass, paramVarArgs);
      AppMethodBeat.o(180915);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(180915);
    }
    return null;
  }
  
  public static <T> T parseToModel(JSONObject paramJSONObject, Class<T> paramClass, Object... paramVarArgs)
  {
    localObject3 = null;
    AppMethodBeat.i(180914);
    Object localObject4 = (JsonType)paramClass.getAnnotation(JsonType.class);
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject4 = ((JsonType)localObject4).deserializer();
      localObject1 = localObject3;
      if (localObject4 != JsonParser.Deserializer.class) {
        localObject1 = (JsonParser.Deserializer)Util.newInstance((Class)localObject4, new Object[0]);
      }
    }
    try
    {
      localObject1 = ((JsonParser.Deserializer)localObject1).deserialize(null, "", paramJSONObject);
      if (localObject1 == null) {
        break label146;
      }
      boolean bool = paramClass.isAssignableFrom(localObject1.getClass());
      if (!bool) {
        break label146;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        continue;
        localObject2 = null;
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = Util.newInstance(paramClass, paramVarArgs);
    }
    if ((localObject3 instanceof JsonParser)) {
      ((JsonParser)localObject3).parse(paramJSONObject);
    }
    AppMethodBeat.o(180914);
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.json.JsonUtils
 * JD-Core Version:    0.7.0.1
 */