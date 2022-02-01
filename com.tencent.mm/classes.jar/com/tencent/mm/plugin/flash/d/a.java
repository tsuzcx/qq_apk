package com.tencent.mm.plugin.flash.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(186697);
    try
    {
      if (paramHashMap.containsKey("message"))
      {
        JSONObject localJSONObject = new JSONObject(String.valueOf(paramHashMap.get("message")));
        String str = localJSONObject.getString("errormsg");
        if (!TextUtils.isEmpty(str))
        {
          localJSONObject.put("errormsg", aH(paramContext, str));
          paramHashMap.put("message", localJSONObject.toString());
        }
      }
      AppMethodBeat.o(186697);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186697);
    }
  }
  
  public static boolean a(HashMap<String, Object> paramHashMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(186692);
    if ((paramHashMap.containsKey(paramString)) && (((Integer)paramHashMap.get(paramString)).intValue() == paramInt))
    {
      AppMethodBeat.o(186692);
      return true;
    }
    AppMethodBeat.o(186692);
    return false;
  }
  
  public static String aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186695);
    String str = MMApplicationContext.getPackageName();
    int i = paramContext.getResources().getIdentifier(paramString, "string", str);
    paramContext = paramContext.getResources().getString(i);
    AppMethodBeat.o(186695);
    return paramContext;
  }
  
  public static Bundle aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186694);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = localIterator.next().toString();
      Object localObject = paramJSONObject.opt(str);
      if ((localObject instanceof Integer)) {
        localBundle.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof String)) {
        localBundle.putString(str, (String)localObject);
      } else if ((localObject instanceof Long)) {
        localBundle.putLong(str, ((Long)localObject).longValue());
      }
    }
    AppMethodBeat.o(186694);
    return localBundle;
  }
  
  public static JSONObject al(Bundle paramBundle)
  {
    AppMethodBeat.i(186693);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, paramBundle.get(str));
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(186693);
    return localJSONObject;
  }
  
  public static String k(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(186696);
    paramJSONObject = paramJSONObject.optString("err_msg", paramJSONObject.optString("message", paramJSONObject.optString("errormsg", paramString)));
    if (TextUtils.isEmpty(paramJSONObject))
    {
      b.s("msgVerify", paramString);
      AppMethodBeat.o(186696);
      return paramString;
    }
    b.s("msgVerify", paramJSONObject);
    AppMethodBeat.o(186696);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.d.a
 * JD-Core Version:    0.7.0.1
 */