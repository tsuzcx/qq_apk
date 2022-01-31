package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
public final class JsonUtils
{
  private static final Pattern zzaae;
  private static final Pattern zzaaf;
  
  static
  {
    AppMethodBeat.i(90246);
    zzaae = Pattern.compile("\\\\.");
    zzaaf = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    AppMethodBeat.o(90246);
  }
  
  public static boolean areJsonStringsEquivalent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90244);
    if ((paramString1 == null) && (paramString2 == null))
    {
      AppMethodBeat.o(90244);
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(90244);
      return false;
    }
    try
    {
      bool = areJsonValuesEquivalent(new JSONObject(paramString1), new JSONObject(paramString2));
      AppMethodBeat.o(90244);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        boolean bool = areJsonValuesEquivalent(new JSONArray(paramString1), new JSONArray(paramString2));
        AppMethodBeat.o(90244);
        return bool;
      }
      catch (JSONException paramString1)
      {
        AppMethodBeat.o(90244);
      }
    }
    return false;
  }
  
  public static boolean areJsonValuesEquivalent(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(90245);
    if ((paramObject1 == null) && (paramObject2 == null))
    {
      AppMethodBeat.o(90245);
      return true;
    }
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      AppMethodBeat.o(90245);
      return false;
    }
    if (((paramObject1 instanceof JSONObject)) && ((paramObject2 instanceof JSONObject)))
    {
      paramObject1 = (JSONObject)paramObject1;
      paramObject2 = (JSONObject)paramObject2;
      if (paramObject1.length() != paramObject2.length())
      {
        AppMethodBeat.o(90245);
        return false;
      }
      Iterator localIterator = paramObject1.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!paramObject2.has(str))
        {
          AppMethodBeat.o(90245);
          return false;
        }
        try
        {
          bool = areJsonValuesEquivalent(paramObject1.get(str), paramObject2.get(str));
          if (!bool)
          {
            AppMethodBeat.o(90245);
            return false;
          }
        }
        catch (JSONException paramObject1)
        {
          AppMethodBeat.o(90245);
          return false;
        }
      }
      AppMethodBeat.o(90245);
      return true;
    }
    if (((paramObject1 instanceof JSONArray)) && ((paramObject2 instanceof JSONArray)))
    {
      paramObject1 = (JSONArray)paramObject1;
      paramObject2 = (JSONArray)paramObject2;
      if (paramObject1.length() != paramObject2.length())
      {
        AppMethodBeat.o(90245);
        return false;
      }
      int i = 0;
      while (i < paramObject1.length())
      {
        try
        {
          bool = areJsonValuesEquivalent(paramObject1.get(i), paramObject2.get(i));
          if (!bool)
          {
            AppMethodBeat.o(90245);
            return false;
          }
        }
        catch (JSONException paramObject1)
        {
          AppMethodBeat.o(90245);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(90245);
      return true;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(90245);
    return bool;
  }
  
  public static String escapeString(String paramString)
  {
    AppMethodBeat.i(90243);
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = zzaaf.matcher(paramString);
      Object localObject1 = null;
      while (localMatcher.find())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuffer();
        }
        switch (localMatcher.group().charAt(0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case '\b': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\b");
          localObject1 = localObject2;
          break;
        case '"': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\"");
          localObject1 = localObject2;
          break;
        case '\\': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\\\\\");
          localObject1 = localObject2;
          break;
        case '/': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\/");
          localObject1 = localObject2;
          break;
        case '\f': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\f");
          localObject1 = localObject2;
          break;
        case '\n': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\n");
          localObject1 = localObject2;
          break;
        case '\r': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\r");
          localObject1 = localObject2;
          break;
        case '\t': 
          localMatcher.appendReplacement((StringBuffer)localObject2, "\\\\t");
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(90243);
        return paramString;
      }
      localMatcher.appendTail(localObject1);
      paramString = localObject1.toString();
      AppMethodBeat.o(90243);
      return paramString;
    }
    AppMethodBeat.o(90243);
    return paramString;
  }
  
  public static String unescapeString(String paramString)
  {
    AppMethodBeat.i(90242);
    if (!TextUtils.isEmpty(paramString))
    {
      String str = UnicodeUtils.unescape(paramString);
      Matcher localMatcher = zzaae.matcher(str);
      paramString = null;
      while (localMatcher.find())
      {
        Object localObject = paramString;
        if (paramString == null) {
          localObject = new StringBuffer();
        }
        switch (localMatcher.group().charAt(1))
        {
        default: 
          paramString = new IllegalStateException("Found an escaped character that should never be.");
          AppMethodBeat.o(90242);
          throw paramString;
        case '"': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\"");
          paramString = (String)localObject;
          break;
        case '\\': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\\\\");
          paramString = (String)localObject;
          break;
        case '/': 
          localMatcher.appendReplacement((StringBuffer)localObject, "/");
          paramString = (String)localObject;
          break;
        case 'b': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\b");
          paramString = (String)localObject;
          break;
        case 'f': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\f");
          paramString = (String)localObject;
          break;
        case 'n': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\n");
          paramString = (String)localObject;
          break;
        case 'r': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\r");
          paramString = (String)localObject;
          break;
        case 't': 
          localMatcher.appendReplacement((StringBuffer)localObject, "\t");
          paramString = (String)localObject;
        }
      }
      if (paramString == null)
      {
        AppMethodBeat.o(90242);
        return str;
      }
      localMatcher.appendTail(paramString);
      paramString = paramString.toString();
      AppMethodBeat.o(90242);
      return paramString;
    }
    AppMethodBeat.o(90242);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.JsonUtils
 * JD-Core Version:    0.7.0.1
 */