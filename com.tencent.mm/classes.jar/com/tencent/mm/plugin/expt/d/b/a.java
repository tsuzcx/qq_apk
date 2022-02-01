package com.tencent.mm.plugin.expt.d.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.plugin.expt.d.e.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static com.tencent.mm.plugin.expt.d.e.a.a aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220295);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(220295);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + paramJSONObject.toString());
    try
    {
      int i = paramJSONObject.optInt("index", 0);
      String str = paramJSONObject.optString("name", "");
      int j = paramJSONObject.optInt("type", 0);
      boolean bool = g.eP(str);
      if (bool)
      {
        AppMethodBeat.o(220295);
        return null;
      }
      com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
      locala.index = i;
      locala.name = str;
      locala.type = j;
      AppMethodBeat.o(220295);
      return locala;
    }
    catch (Exception localException)
    {
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + localException.getMessage() + ", fieldConfigJson : " + paramJSONObject.toString());
      AppMethodBeat.o(220295);
    }
    return null;
  }
  
  public static c gm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220296);
    if ((g.eP(paramString1)) || (g.eP(paramString2)))
    {
      AppMethodBeat.o(220296);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    try
    {
      Object localObject = new JSONObject(paramString2);
      int i = ((JSONObject)localObject).optInt("reportID", 0);
      String str1 = ((JSONObject)localObject).optString("sql", "");
      String str2 = ((JSONObject)localObject).optString("dbPath", "");
      localObject = ((JSONObject)localObject).optString("sqlMD5", "");
      if ((i > 0) && (!g.eP(str1)))
      {
        boolean bool = g.eP((String)localObject);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(220296);
        return null;
      }
      c localc = new c();
      localc.syg = paramString1;
      localc.dbPath = str2;
      localc.sql = str1;
      localc.syt = ((String)localObject);
      localc.syl = i;
      localc.syr = paramString2;
      com.tencent.mm.plugin.expt.d.f.a.lU(true);
      AppMethodBeat.o(220296);
      return localc;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.expt.d.f.a.lU(false);
      Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
      AppMethodBeat.o(220296);
    }
    return null;
  }
  
  public final b gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220294);
    if ((g.eP(paramString1)) || (g.eP(paramString2)))
    {
      AppMethodBeat.o(220294);
      return null;
    }
    Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + paramString1 + ", json : " + paramString2);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString2);
        i = ((JSONObject)localObject).optInt("dataSourceType", 0);
        int j = ((JSONObject)localObject).optInt("dataSourceID", 0);
        int k = ((JSONObject)localObject).optInt("reportID", 0);
        int m = ((JSONObject)localObject).optInt("isInstantReport", 0);
        int n = ((JSONObject)localObject).optInt("isRepeat", 1);
        int i1 = ((JSONObject)localObject).optInt("runPeriod", 0);
        int i2 = ((JSONObject)localObject).optInt("dbExpireTime", 0);
        String str1 = ((JSONObject)localObject).optString("scriptMD5", "");
        String str2 = ((JSONObject)localObject).optString("script", "");
        localObject = ((JSONObject)localObject).optJSONArray("fields");
        if (!g.eP(str2))
        {
          boolean bool = g.eP(str1);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(220294);
          return null;
        }
        b localb = new b();
        localb.syg = paramString1;
        localb.syj = i;
        localb.syk = j;
        localb.syl = k;
        localb.syn = m;
        localb.syo = n;
        localb.syp = i1;
        localb.syq = i2;
        localb.sys = str1;
        localb.script = new String(Base64.decode(str2, 0), "UTF-8");
        localb.syr = paramString2;
        localb.sym = new ArrayList();
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString1 = new com.tencent.mm.plugin.expt.d.e.a.a();
          paramString1.index = 0;
          paramString1.name = "report_time_ec";
          paramString1.type = 2;
          localb.sym.add(paramString1);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramString1 = aL(((JSONArray)localObject).getJSONObject(i));
            if (paramString1 != null) {
              localb.sym.add(paramString1);
            }
          }
          else
          {
            Collections.sort(localb.sym, new Comparator() {});
          }
        }
        else
        {
          com.tencent.mm.plugin.expt.d.f.a.lT(true);
          AppMethodBeat.o(220294);
          return localb;
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.expt.d.f.a.lT(false);
        Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + paramString1.getMessage() + ", json : " + paramString2);
        AppMethodBeat.o(220294);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a
 * JD-Core Version:    0.7.0.1
 */