package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectArguments.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class CameraEffectJSONUtility
{
  private static final Map<Class<?>, Setter> SETTERS;
  
  static
  {
    AppMethodBeat.i(7976);
    HashMap localHashMap = new HashMap();
    SETTERS = localHashMap;
    localHashMap.put(String.class, new Setter()
    {
      public final void setOnArgumentsBuilder(CameraEffectArguments.Builder paramAnonymousBuilder, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7968);
        paramAnonymousBuilder.putArgument(paramAnonymousString, (String)paramAnonymousObject);
        AppMethodBeat.o(7968);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7969);
        paramAnonymousJSONObject.put(paramAnonymousString, paramAnonymousObject);
        AppMethodBeat.o(7969);
      }
    });
    SETTERS.put([Ljava.lang.String.class, new Setter()
    {
      public final void setOnArgumentsBuilder(CameraEffectArguments.Builder paramAnonymousBuilder, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7970);
        paramAnonymousBuilder = new IllegalArgumentException("Unexpected type from JSON");
        AppMethodBeat.o(7970);
        throw paramAnonymousBuilder;
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7971);
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
        AppMethodBeat.o(7971);
      }
    });
    SETTERS.put(JSONArray.class, new Setter()
    {
      public final void setOnArgumentsBuilder(CameraEffectArguments.Builder paramAnonymousBuilder, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7972);
        paramAnonymousObject = (JSONArray)paramAnonymousObject;
        String[] arrayOfString = new String[paramAnonymousObject.length()];
        int i = 0;
        while (i < paramAnonymousObject.length())
        {
          Object localObject = paramAnonymousObject.get(i);
          if ((localObject instanceof String))
          {
            arrayOfString[i] = ((String)localObject);
            i += 1;
          }
          else
          {
            paramAnonymousBuilder = new IllegalArgumentException("Unexpected type in an array: " + localObject.getClass());
            AppMethodBeat.o(7972);
            throw paramAnonymousBuilder;
          }
        }
        paramAnonymousBuilder.putArgument(paramAnonymousString, arrayOfString);
        AppMethodBeat.o(7972);
      }
      
      public final void setOnJSON(JSONObject paramAnonymousJSONObject, String paramAnonymousString, Object paramAnonymousObject)
      {
        AppMethodBeat.i(7973);
        paramAnonymousJSONObject = new IllegalArgumentException("JSONArray's are not supported in bundles.");
        AppMethodBeat.o(7973);
        throw paramAnonymousJSONObject;
      }
    });
    AppMethodBeat.o(7976);
  }
  
  public static CameraEffectArguments convertToCameraEffectArguments(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(7975);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(7975);
      return null;
    }
    CameraEffectArguments.Builder localBuilder = new CameraEffectArguments.Builder();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if ((localObject != null) && (localObject != JSONObject.NULL))
      {
        Setter localSetter = (Setter)SETTERS.get(localObject.getClass());
        if (localSetter == null)
        {
          paramJSONObject = new IllegalArgumentException("Unsupported type: " + localObject.getClass());
          AppMethodBeat.o(7975);
          throw paramJSONObject;
        }
        localSetter.setOnArgumentsBuilder(localBuilder, str, localObject);
      }
    }
    paramJSONObject = localBuilder.build();
    AppMethodBeat.o(7975);
    return paramJSONObject;
  }
  
  public static JSONObject convertToJSON(CameraEffectArguments paramCameraEffectArguments)
  {
    AppMethodBeat.i(7974);
    if (paramCameraEffectArguments == null)
    {
      AppMethodBeat.o(7974);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramCameraEffectArguments.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramCameraEffectArguments.get(str);
      if (localObject != null)
      {
        Setter localSetter = (Setter)SETTERS.get(localObject.getClass());
        if (localSetter == null)
        {
          paramCameraEffectArguments = new IllegalArgumentException("Unsupported type: " + localObject.getClass());
          AppMethodBeat.o(7974);
          throw paramCameraEffectArguments;
        }
        localSetter.setOnJSON(localJSONObject, str, localObject);
      }
    }
    AppMethodBeat.o(7974);
    return localJSONObject;
  }
  
  public static abstract interface Setter
  {
    public abstract void setOnArgumentsBuilder(CameraEffectArguments.Builder paramBuilder, String paramString, Object paramObject);
    
    public abstract void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.CameraEffectJSONUtility
 * JD-Core Version:    0.7.0.1
 */