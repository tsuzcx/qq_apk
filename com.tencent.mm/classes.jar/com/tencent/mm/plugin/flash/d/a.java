package com.tencent.mm.plugin.flash.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static int a(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(190953);
    if (paramHashMap.containsKey(paramString))
    {
      int i = ((Integer)paramHashMap.get(paramString)).intValue();
      AppMethodBeat.o(190953);
      return i;
    }
    AppMethodBeat.o(190953);
    return -1;
  }
  
  public static void a(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(190968);
    try
    {
      if (paramHashMap.containsKey("message"))
      {
        JSONObject localJSONObject = new JSONObject(String.valueOf(paramHashMap.get("message")));
        String str = localJSONObject.getString("errormsg");
        if (!TextUtils.isEmpty(str))
        {
          localJSONObject.put("errormsg", aO(paramContext, str));
          paramHashMap.put("message", localJSONObject.toString());
        }
      }
      AppMethodBeat.o(190968);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashUtils", paramContext, "replaceErrorMsg", new Object[0]);
      AppMethodBeat.o(190968);
    }
  }
  
  public static boolean a(HashMap<String, Object> paramHashMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(190951);
    if ((paramHashMap.containsKey(paramString)) && (((Integer)paramHashMap.get(paramString)).intValue() == paramInt))
    {
      AppMethodBeat.o(190951);
      return true;
    }
    AppMethodBeat.o(190951);
    return false;
  }
  
  public static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190966);
    String str = MMApplicationContext.getPackageName();
    int i = paramContext.getResources().getIdentifier(paramString, "string", str);
    paramContext = paramContext.getResources().getString(i);
    AppMethodBeat.o(190966);
    return paramContext;
  }
  
  public static Bundle aU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190963);
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
    AppMethodBeat.o(190963);
    return localBundle;
  }
  
  public static boolean aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190975);
    if (paramJSONObject.optInt("errorcode", 0) == 271449101)
    {
      AppMethodBeat.o(190975);
      return true;
    }
    AppMethodBeat.o(190975);
    return false;
  }
  
  public static JSONObject af(Bundle paramBundle)
  {
    AppMethodBeat.i(190957);
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
    AppMethodBeat.o(190957);
    return localJSONObject;
  }
  
  public static void b(HashMap<String, Object> paramHashMap, String paramString)
  {
    AppMethodBeat.i(190973);
    try
    {
      if (paramHashMap.containsKey("message"))
      {
        paramHashMap = new JSONObject(String.valueOf(paramHashMap.get("message")));
        if (!TextUtils.isEmpty(paramString)) {
          paramHashMap.put("err_msg", paramString);
        }
      }
      AppMethodBeat.o(190973);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashUtils", paramHashMap, "setErrorMsg", new Object[0]);
      AppMethodBeat.o(190973);
    }
  }
  
  public static void d(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(190974);
    paramTextView.setText("");
    paramTextView.setTextSize(0, com.tencent.mm.ci.a.aY(paramTextView.getContext(), a.c.HugeTextSize));
    paramTextView.setText(paramString);
    AppMethodBeat.o(190974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.d.a
 * JD-Core Version:    0.7.0.1
 */