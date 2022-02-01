package com.tencent.mm.plugin.lite.b;

import com.tencent.luggage.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONObject;

public final class b
{
  private static Map<String, Integer> KbQ;
  private static Map<String, Integer> KbR;
  
  static
  {
    AppMethodBeat.i(271317);
    KbQ = new b.1();
    KbR = new b.2();
    AppMethodBeat.o(271317);
  }
  
  public static int bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271304);
    if (!paramJSONObject.has("nextAnimIn"))
    {
      i = a.a.slide_right_in;
      AppMethodBeat.o(271304);
      return i;
    }
    paramJSONObject = paramJSONObject.getString("nextAnimIn");
    if (!KbQ.containsKey(paramJSONObject))
    {
      i = a.a.slide_right_in;
      AppMethodBeat.o(271304);
      return i;
    }
    int i = ((Integer)KbQ.get(paramJSONObject)).intValue();
    AppMethodBeat.o(271304);
    return i;
  }
  
  public static int bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271311);
    if (!paramJSONObject.has("currentAnimOut"))
    {
      i = a.a.slide_left_out;
      AppMethodBeat.o(271311);
      return i;
    }
    paramJSONObject = paramJSONObject.getString("currentAnimOut");
    if (!KbQ.containsKey(paramJSONObject))
    {
      i = a.a.slide_left_out;
      AppMethodBeat.o(271311);
      return i;
    }
    int i = ((Integer)KbR.get(paramJSONObject)).intValue();
    AppMethodBeat.o(271311);
    return i;
  }
  
  public static String[] cn(String paramString, boolean paramBoolean)
  {
    String[] arrayOfString1 = null;
    AppMethodBeat.i(271297);
    String[] arrayOfString2 = new String[2];
    Object localObject = paramString;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = URLDecoder.decode(paramString, "UTF-8");
        paramString = ((String)localObject).split("\\?");
        if (paramString.length > 1)
        {
          arrayOfString2[0] = paramString[0];
          paramString = paramString[1];
          localObject = new i();
          if (paramString != null)
          {
            paramString = paramString.split("&");
            int j = paramString.length;
            i = 0;
            if (i < j)
            {
              arrayOfString1 = paramString[i].split("=");
              if ((arrayOfString1 == null) || (arrayOfString1.length < 2)) {
                break label197;
              }
              ((i)localObject).m(arrayOfString1[0].trim(), arrayOfString1[1].trim());
              break label197;
            }
          }
        }
        else
        {
          if (((String)localObject).contains("="))
          {
            arrayOfString2[0] = null;
            paramString = paramString[0];
            continue;
          }
          arrayOfString2[0] = paramString[0];
          paramString = arrayOfString1;
          continue;
        }
        arrayOfString2[1] = ((i)localObject).toString();
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("LiteAppUtils", paramString, "", new Object[0]);
        AppMethodBeat.o(271297);
        return arrayOfString2;
      }
      continue;
      label197:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.b
 * JD-Core Version:    0.7.0.1
 */