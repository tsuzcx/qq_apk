package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter
{
  private static final Map<Class<?>, BundleJSONConverter.Setter> SETTERS;
  
  static
  {
    AppMethodBeat.i(72266);
    HashMap localHashMap = new HashMap();
    SETTERS = localHashMap;
    localHashMap.put(Boolean.class, new BundleJSONConverter.1());
    SETTERS.put(Integer.class, new BundleJSONConverter.2());
    SETTERS.put(Long.class, new BundleJSONConverter.3());
    SETTERS.put(Double.class, new BundleJSONConverter.4());
    SETTERS.put(String.class, new BundleJSONConverter.Setter()
    {
      public final void setOnBundle(Bundle paramAnonymousBundle, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(72258);
        paramAnonymousBundle.putString(paramAnonymousString, (String)paramAnonymousObject);
        AppMethodBeat.o(72258);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(72259);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(72259);
      }
    });
    SETTERS.put([Ljava.lang.String.class, new BundleJSONConverter.6());
    SETTERS.put(JSONArray.class, new BundleJSONConverter.7());
    AppMethodBeat.o(72266);
  }
  
  public static Bundle convertToBundle(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72265);
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
          BundleJSONConverter.Setter localSetter = (BundleJSONConverter.Setter)SETTERS.get(localObject.getClass());
          if (localSetter == null)
          {
            paramJSONObject = new IllegalArgumentException("Unsupported type: " + localObject.getClass());
            AppMethodBeat.o(72265);
            throw paramJSONObject;
          }
          localSetter.setOnBundle(localBundle, str, localObject);
        }
      }
    }
    AppMethodBeat.o(72265);
    return localBundle;
  }
  
  public static JSONObject convertToJSON(Bundle paramBundle)
  {
    AppMethodBeat.i(72264);
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
          localObject2 = (BundleJSONConverter.Setter)SETTERS.get(localObject1.getClass());
          if (localObject2 == null)
          {
            paramBundle = new IllegalArgumentException("Unsupported type: " + localObject1.getClass());
            AppMethodBeat.o(72264);
            throw paramBundle;
          }
          ((BundleJSONConverter.Setter)localObject2).setOnJSON(localJSONObject, str, localObject1);
        }
      }
    }
    AppMethodBeat.o(72264);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.BundleJSONConverter
 * JD-Core Version:    0.7.0.1
 */