package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter
{
  private static final Map<Class<?>, Setter> SETTERS;
  
  static
  {
    AppMethodBeat.i(17702);
    HashMap localHashMap = new HashMap();
    SETTERS = localHashMap;
    localHashMap.put(Boolean.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17686);
        paramAnonymousBundle.putBoolean(paramAnonymousString, ((Boolean)paramAnonymousObject).booleanValue());
        AppMethodBeat.o(17686);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17687);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(17687);
      }
    });
    SETTERS.put(Integer.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17688);
        paramAnonymousBundle.putInt(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
        AppMethodBeat.o(17688);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17689);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(17689);
      }
    });
    SETTERS.put(Long.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17690);
        paramAnonymousBundle.putLong(paramAnonymousString, ((Long)paramAnonymousObject).longValue());
        AppMethodBeat.o(17690);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17691);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(17691);
      }
    });
    SETTERS.put(Double.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17692);
        paramAnonymousBundle.putDouble(paramAnonymousString, ((Double)paramAnonymousObject).doubleValue());
        AppMethodBeat.o(17692);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17693);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(17693);
      }
    });
    SETTERS.put(String.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17694);
        paramAnonymousBundle.putString(paramAnonymousString, (String)paramAnonymousObject);
        AppMethodBeat.o(17694);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17695);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(17695);
      }
    });
    SETTERS.put([Ljava.lang.String.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17696);
        paramAnonymousBundle = new IllegalArgumentException("Unexpected type from JSON");
        AppMethodBeat.o(17696);
        throw paramAnonymousBundle;
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17697);
        JSONArray localJSONArray = new JSONArray();
        paramAnonymousObject = (String[])paramAnonymousObject;
        int j = paramAnonymousObject.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(paramAnonymousObject[i]);
          i += 1;
        }
        paramAnonymousJSONObject.put(paramAnonymousString, localJSONArray);
        AppMethodBeat.o(17697);
      }
    });
    SETTERS.put(JSONArray.class, new Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17698);
        paramAnonymousObject = (JSONArray)paramAnonymousObject;
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousObject.length() == 0)
        {
          paramAnonymousBundle.putStringArrayList(paramAnonymousString, localArrayList);
          AppMethodBeat.o(17698);
          return;
        }
        int i = 0;
        while (i < paramAnonymousObject.length())
        {
          Object localObject = paramAnonymousObject.get(i);
          if ((localObject instanceof String))
          {
            localArrayList.add((String)localObject);
            i += 1;
          }
          else
          {
            paramAnonymousBundle = new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
            AppMethodBeat.o(17698);
            throw paramAnonymousBundle;
          }
        }
        paramAnonymousBundle.putStringArrayList(paramAnonymousString, localArrayList);
        AppMethodBeat.o(17698);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(17699);
        paramAnonymousJSONObject = new IllegalArgumentException("JSONArray's are not supported in bundles.");
        AppMethodBeat.o(17699);
        throw paramAnonymousJSONObject;
      }
    });
    AppMethodBeat.o(17702);
  }
  
  public static Bundle convertToBundle(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17701);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        if ((localObject instanceof JSONObject))
        {
          localBundle.putBundle(str, convertToBundle((JSONObject)localObject));
        }
        else
        {
          Setter localSetter = (Setter)SETTERS.get(localObject.getClass());
          if (localSetter == null)
          {
            paramJSONObject = new IllegalArgumentException("Unsupported type: " + localObject.getClass());
            AppMethodBeat.o(17701);
            throw paramJSONObject;
          }
          localSetter.setOnBundle(localBundle, str, localObject);
        }
      }
    }
    AppMethodBeat.o(17701);
    return localBundle;
  }
  
  public static JSONObject convertToJSON(Bundle paramBundle)
  {
    AppMethodBeat.i(17700);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramBundle.get(str);
      if (localObject1 != null)
      {
        Object localObject2;
        if ((localObject1 instanceof List))
        {
          localObject2 = new JSONArray();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((JSONArray)localObject2).put((String)((Iterator)localObject1).next());
          }
          localJSONObject.put(str, localObject2);
        }
        else if ((localObject1 instanceof Bundle))
        {
          localJSONObject.put(str, convertToJSON((Bundle)localObject1));
        }
        else
        {
          localObject2 = (Setter)SETTERS.get(localObject1.getClass());
          if (localObject2 == null)
          {
            paramBundle = new IllegalArgumentException("Unsupported type: " + localObject1.getClass());
            AppMethodBeat.o(17700);
            throw paramBundle;
          }
          ((Setter)localObject2).setOnJSON(localJSONObject, str, localObject1);
        }
      }
    }
    AppMethodBeat.o(17700);
    return localJSONObject;
  }
  
  public static abstract interface Setter
  {
    public abstract void setOnBundle(Bundle paramBundle, String paramString, Object paramObject);
    
    public abstract void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter
 * JD-Core Version:    0.7.0.1
 */